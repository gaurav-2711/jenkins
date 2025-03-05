pipeline {
    agent any
    environment {
       IMAGE_NAME = "spring-boot-app"
    }
    stages {
        stage('Clone Repository') {
            steps {
                git branch: 'master', url: 'https://github.com/gaurav-2711/jenkins'
            }
        }
        stage('Build with Maven') {
            steps {
                bat 'mvn clean package -DskipTests'  // Using 'bat' for Windows
            }
        }
        stage('Deploy to Staging') {
            when {
                branch 'staging'
            }
            steps {
                bat '''
                docker stop staging-container || true
                docker rm staging-container || true
                docker build -t %IMAGE_NAME%:staging --build-arg PROFILE=staging .
                docker run -d -p 8081:8081 --name staging-container -e "SPRING_PROFILES_ACTIVE=staging" %IMAGE_NAME%:staging
                '''
            }
        }
        stage('Deploy to Production') {
            when {
                branch 'master'
            }
            steps {
                bat '''
                docker stop prod-container || true
                docker rm prod-container || true
                docker build -t %IMAGE_NAME%:prod --build-arg PROFILE=prod .
                docker run -d -p 8082:8082 --name prod-container -e "SPRING_PROFILES_ACTIVE=prod" %IMAGE_NAME%:prod
                '''
            }
        }
    }
}