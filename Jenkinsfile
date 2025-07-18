pipeline {
    agent { label 'agent-linux' }
    tools {
        maven 'MVN-3.9.10'
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
                    sh '''
                        mvn clean verify sonar:sonar \
                          -Dsonar.projectKey=pgdp \
                          -Dsonar.projectName='pgdp' \
                          -Dsonar.host.url=http://localhost:9000 \
                          -Dsonar.token=sqp_fedb9e1f1db6a47d846fa3cb501e456cdb378795
                         '''
                }
            }
        }
        stage('Vérifier et  nettoyer docker-compose existant') {
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