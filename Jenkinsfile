#!/usr/bin/env groovy

@Library('jenkins-shared-library@master') _ //master or wherever branch

pipeline {
    
    parameters {
  extendedChoice bindings: '', description: '', groovyClasspath: '', groovyScript: '''import groovy.json.*
import groovy.json.JsonSlurper;


    def jsonSlurper = new JsonSlurper()

//def data= readJSON file: \'myjson.json\'
   // def data = jsonSlurper.parseText(new File("myjson.json").text)
    return "AAA"
     //data.TESTS.each{ return it["$item"] }  



''', multiSelectDelimiter: ',', name: 'mychoice', quoteValue: false, saveJSONParameterToFile: false, type: 'PT_JSON', visibleItemCount: 5
}

    agent any
    stages {
        stage('connect') {
            steps {
               
                script{
                        def workspace = pwd()
                        def prop = load "${workspace}/vars/dbconsql.groovy"
                        prop.GetDBDetails()
                        println("inside load")
                    }
            }
        }
    }
}

