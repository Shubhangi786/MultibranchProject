pipeline {
  agent any
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
      steps {
        echo 'Running test...'
        bat 'mvn test'
      }
    }

    stage('Reporting') {
      steps {
        echo 'Started reporting process...'
        publishHTML(allowMissing: true, alwaysLinkToLastBuild: true, includes: '**/*.html', keepAll: true, reportDir: '\\reports', reportFiles: '/*.html', reportName: 'Extent Report', useWrapperFileDirectly: true)
      }
    }

    stage('Packaging project') {
      steps {
        echo 'Packaging project using maven...'
        bat 'mvn package'
      }
    }

  }
}