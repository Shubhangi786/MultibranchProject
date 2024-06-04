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
		publishHTML([allowMissing: true, alwaysLinkToLastBuild: true, includes: '**/*.html', keepAll: true, reportDir: '\\reports', reportFiles: '/*.html', reportName: 'Extent Report', reportTitles: '', useWrapperFileDirectly: true])
            }
        }
	stage('Notify') {
	   steps{
        	emailext attachmentsPattern: '$WORKSPACE\\reports\\**/*.html', body:  'Please go to ${BUILD_URL} and verify the build', subject: "Jenkins-${JOB_NAME}-${BUILD_NUMBER}", to: 'shubhangimsable@gmail.com'
    		}
	}
        stage('Packaging project'){
            steps{
		echo 'Packaging project using maven...'
		bat 'mvn package'
            }
        }
    }
}