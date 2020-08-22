#!/usr/bin/env groovy

@Library('jenkins-shared-library@master') _ //master or wherever branch

pipeline {
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

