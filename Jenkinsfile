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
                sh "mvn -Dmaven.test.failure.ignore=true clean package"

            }

            post {
                // If Maven was able to run the tests, even if some of the test
                // failed, record the test results and archive the jar file.
                success {
                    junit '**/target/surefire-reports/TEST-*.xml'
                    archiveArtifacts 'target/*.jar'
                }
            }
        }
        
        stage('Build Image') {
            steps {

                // Build Docker image
                sh "docker build -t handsomecoder/application:4.0 ."
            }

        }
        
        stage('Push Image') {
            steps {
                withCredentials([string(credentialsId: 'dockerHubCreds', variable: 'dockerHubCreds')]) {
                     sh "docker login -u handsomecoder -p ${dockerHubCreds}"
                }
                
                sh "docker push handsomecoder/application:4.0"
            }

        }
        
        stage('Run Container') {
            steps {
                sh "docker run -p 9000:9000 -d handsomecoder/application:4.0"
            }

        }
    }
}

