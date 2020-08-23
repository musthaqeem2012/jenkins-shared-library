import java.io.File.*
import java.sql.SQLException;
import java.sql.*
import groovy.sql.Sql
import java.sql.Driver
//import com.microsoft.sqlserver.jdbc.SQLServerDriver;
import jenkins.model.Jenkins


def GetDBDetails(){
	/* JENKINS_HOME environment variable is not reliable */
//def jenkinsHome = Jenkins.instance.getRootDir().absolutePath
def props = new Properties()
def rootDir = pwd()
def propertiesFile = new File("${rootDir}/resources/dbprop.properties")
String sEnvType="QA"
String sDBURL
String sDBUname
String sDBPwd
String sDBDriver	
	
	
if (propertiesFile.exists()) {
    props.load(propertiesFile.newDataInputStream())
	if(sEnvType=="QA")
	{
		println("QAENV")
	 sDBURL=props.getProperty('db.QADBURL')
	 sDBUname=props.getProperty('db.QADBUname')
	 sDBPwd=props.getProperty('db.QADBPwd')
	 sDBDriver=props.getProperty('db.QADBDriver') 
	}
	else
	{
		println("DevENV")
	 sDBURL=props.getProperty('db.DevDBURL')
	 sDBUname=props.getProperty('db.DevDBUname')
	 sDBPwd=props.getProperty('db.DevDBPwd')
	 sDBDriver=props.getProperty('db.DevDBDriver')  
	}
}
	println(sDBURL)
	println(sDBUname)
	
	def dbUrl      = "jdbc:sqlserver://localhost:1433;databasename=Test;integratedSecurity=true"
	//def dbUrl      = "jdbc:sqlserver://localhost:1433;DatabaseName=Test"
def dbUser     = "DESKTOP-PLD86VN\\DELL"
def dbPassword = ""
//def dbDriver   = "com.microsoft.sqlserver.jdbc.SQLServerDriver"
//Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	try
	{
def driver = Class.forName("com.microsoft.jdbc.sqlserver.SQLServerDriver").newInstance() as Driver
	/*  try {

            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

        } catch (ClassNotFoundException e) {

            println("Where is your SQLServer JDBC Driver? "
                    + "Include in your library path!");
            println(e.printStackTrace());
            return;

        }*/
	
      // Creating a connection to the database
       Connection conn=null
	Statement stmt = null;
	
	def dbprops = new Properties()

//database connection credentials

dbprops.setProperty("database", "Test")
dbprops.setProperty("user", "DESKTOP-PLD86VN\\DELL")
dbprops.setProperty("password", "")
	
	//conn = DriverManager.getConnection(sDBURL, sDBUname, sDBPwd);
	//conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
	conn=driver.connect("jdbc:sqlserver://localhost:1433", props);
	def sql = new Sql(conn);
          println("Connected to the SQLServer successfully.");	
	stmt = conn.createStatement();
	
		
      ResultSet rs = stmt.executeQuery( "select * from dbo.Department" )
		println("query executed")
		
	while ( rs.next() ) {

		 println(rs.getString("country"));
	}
		 rs.close();
	}
	catch(Exception e)
	{
		println("Exception")
	}

     

      stmt.close();

      conn.close();

  
      	

   }
return this
