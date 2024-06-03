pipeline {
    agent any

    stages {
	stage("Cleaning up browser support for reports'){
		steps{
		withGroovy {
    			System.clearProperty("hudson.model.DirectoryBrowserSupport.CSP"); 
System.setProperty("hudson.model.DirectoryBrowserSupport.CSP", "sandbox allow-scripts; default-src' self'; script-src* 'unsafe-eval'; img-src*; style-src* 'unsafe-inline'; font-src*"); 			
			}
		}		
	}
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
		publishHTML([allowMissing: true, alwaysLinkToLastBuild: true, includes: '**/*.html', keepAll: true, reportDir: 'C:\\Users\\shubhangimadhukar_sa\\.jenkins\\workspace\\Test_MutibranchBlueOcean_master\\reports', reportFiles: '/*.html', reportName: 'Extent Report', reportTitles: '', useWrapperFileDirectly: true])
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