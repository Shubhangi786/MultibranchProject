pipeline {
  agent any
  triggers {
       	    pollSCM('* * * * *')
    	   }
  stages {
    stage('Checkout....') {
      steps {
        echo 'Checkout'
        checkout scmGit(branches: [[name: 'DemoBranch']], extensions: [], userRemoteConfigs: [[credentialsId: '0750d1be-9e00-48ea-972d-7daee18190c4', url: 'https://github.com/Shubhangi786/MultibranchProject.git']])
      }
    }

    stage('Build') {
      steps {
        echo 'Building project...'
        bat 'mvn clean install'
      }
    }

    stage('Test') {
      parallel {
        stage('Test') {
          steps {
            echo 'Running test...'
            bat 'mvn test'
          }
        }

        stage('ParallelMessage') {
          steps {
            echo 'Printing message parallel to Test stage '
          }
        }

      }
    }

  }
}