pipeline {
    agent { label 'vm-linux-agent' }
    tools {
        maven 'mvn-3.9.10'
    }
    environment {
        PORT = "8080"
        CONTAINER = "test"
        IMAGE = "test"
    }
    stages {
        stage('Build') {
            steps {
                sh 'mvn clean package -DskipTests'
            }
        }
        stage('Test') {
            steps {
                sh 'mvn test jacoco:report'
            }
        }
        stage('Analyse SonarQube') {
            steps {
                withSonarQubeEnv('SonarQube') {
                    sh 'mvn clean verify sonar:sonar \
                          -Dsonar.projectKey=deploy-website \
                          -Dsonar.projectName='deploy-website' \
                          -Dsonar.host.url=http://192.168.59.128:9000 \
                          -Dsonar.token=sqp_f936eee75318a73a900f4b8bb679a9f4eccf78f5'
                }
            }
        }
        stage("deploy") {
            steps {
                sh "docker run -d -p ${PORT}:80 --name ${CONTAINER} ${IMAGE}"
            }
        }
    }
}