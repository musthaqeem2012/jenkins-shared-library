#!/usr/bin/env groovy

pipeline {
    agent any
    stages {
        stage('connect') {
            steps {
               
                script{
                        def workspace = pwd()
                        def prop = load "dbconnection.groovy"
                        prop.GetDBDetails()
                        println("inside load")
                    }
            }
        }
    }
}

