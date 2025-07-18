pipeline {
    agent { label 'agent-linux' }
    tools {
        maven 'MVN-3.9.10'
    }
    environment {
        PORT = "8081"
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
        stage('Vérification Quality Gate') {
            steps {
                script {
                    timeout(time: 2, unit: 'MINUTES') {
                        def qualityGate = waitForQualityGate('SonarQube')
                        if (qualityGate.status != 'OK') {
                            error "Échec du Quality Gate SonarQube : statut = ${qualityGate.status}.\nConsultez : http://192.168.1.55:9000/dashboard?id=pgdp"
                        } else {
                            echo "Quality Gate réussi : ${qualityGate.status}"
                        }
                    }
                }
            }
        }
        stage('Lancer docker-compose') {
            steps {
                withCredentials([file(credentialsId: 'PGDP_ENV_FILE', variable: 'ENV_FILE_PATH')]) {
                  sh '''
                    rm -rf .env
                    cp $ENV_FILE_PATH .env
                    docker compose --env-file .env up -d --build
                  '''
                }
            }
        }
    }
    post {
        success {
            echo "L'api est déployer sur l'adresse http://192.168.1.55:${PORT}"
        }
        failure {
            echo "L'api n'a pas pu être déployée."
        }
        always {
            echo "Fin d'exécution"
        }
    }
}