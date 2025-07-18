pipeline {
    agent { label 'agent-linux' }
    tools {
        maven 'MVN-3.9.10'
    }
    environment {
        PORT = "8080"
        CONTAINER = "pgdp-container"
        IMAGE = "pgdp-image"
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
                    sh '''
                        mvn clean verify sonar:sonar \
                          -Dsonar.projectKey=pgdp \
                          -Dsonar.projectName='pgdp' \
                          -Dsonar.host.url=http://192.168.1.55:9000 \
                          -Dsonar.token=sqp_4cead2ddeb9cca7019dade62ff7b29cd6ee0dee7
                         '''
                }
            }
        }
        stage('Lancer docker-compose') {
            steps {
                withCredentials([file(credentialsId: 'PGDP_ENV_FILE', variable: 'ENV_FILE_PATH')]) {
                  sh '''
                    cp $ENV_FILE_PATH .env
                    docker compose -f compose.yml --env-file .env up -d --build
                  '''
                }
            }
        }
    }
}