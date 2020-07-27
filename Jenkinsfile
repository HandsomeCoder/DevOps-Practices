pipeline {
    agent any

    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "M3"
    }

    stages {
        stage('Get Project') {
            steps {
                // Get some code from a GitHub repository
                git 'https://github.com/HandsomeCoder/DevOps-Practices.git'

            }
        }
        
        stage('Build & Test') {
            steps {
                
                // Run Maven on a Unix agent.
                sh "mvn clean package"

            }
        }
        
        stage('Build Image') {
            steps {

                // Build Docker image
                sh "docker build -t handsomecoder/application:7.0 ."
            }

        }
        
        stage('Push Image') {
            steps {
                withCredentials([string(credentialsId: 'dockerHubCreds', variable: 'dockerHubCreds')]) {
                     sh "docker login -u handsomecoder -p ${dockerHubCreds}"
                }
                
                sh "docker push handsomecoder/application:7.0"
            }

        }
        
        stage('Deployment'){
            steps{
                withCredentials([string(credentialsId: 'pcfcCreds', variable: 'pcfCreds')]) {
                    sh 'cf login -a https://api.run.pivotal.io -u harshshah1295@gmail.com -p $pcfCreds'
                }
                
                sh 'cf push application-7.0 --docker-image handsomecoder/application:7.0' 
            }
        }
    }
}
