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
        stage('Vérifier et nettoyer docker-compose existant') {
            steps {
                script {
                    def isRunning = sh(script: "docker-compose -f compose.yml ps -q | xargs docker inspect -f '{{.State.Running}}' 2>/dev/null | grep true || true", returnStdout: true).trim()
                    if (isRunning) {
                       echo 'Un environnement docker-compose est déjà actif. Suppression en cours...'
                       sh 'docker-compose -f compose.yml down'
                    } else {
                       echo 'Aucun docker-compose actif.'
                    }
                }
            }
        }
        stage('Lancer docker-compose') {
            steps {
              echo 'Lancement du docker-compose...'
              sh 'docker-compose -f compose.yml up -d'
            }
        }
    }
}