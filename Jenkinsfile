pipeline {
    agent any

    stages {
        stage('Checkout....') {
            steps {
                echo 'Checkout'
                checkout scmGit(branches: [[name: 'master']], extensions: [], userRemoteConfigs: [[credentialsId: '0750d1be-9e00-48ea-972d-7daee18190c4', url: 'https://github.com/Shubhangi786/MultibranchProject.git']])                
            }
        }
        stage('Build'){
            steps {
               	echo 'Building project...'
                bat 'mvn clean install' 
            }
        }
        stage('Test'){
            steps {

		echo 'Running test...'
                bat 'mvn test'
                    
            }
        }
        stage('Reporting'){
            steps {
		echo 'Started reporting process...'
		publishHTML([allowMissing: false, alwaysLinkToLastBuild: false, keepAll: false, reportDir: '//reports', reportFiles: '/*.html', reportName: 'Extent Report', reportTitles: '', useWrapperFileDirectly: true])
            }
        }
        stage('Notify'){
            steps{
		echo 'Sending notification emails...'
		emailext attachmentsPattern: 'C:\\Users\\shubhangimadhukar_sa\\.jenkins\\workspace\\Test_MutibranchBlueOcean_master\\reports\\/*.html', body: '', subject: 'Jenkins-${JOB_NAME}-${BUILD_NUMBER}', to: 'shubhangimsable@gmail.com'
            }
        }
    }
}