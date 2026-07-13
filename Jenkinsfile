pipeline {

    agent any

    tools {
        jdk 'JDK25'
        maven 'Maven3'
    }

    stages {

        stage('Checkout Code') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/gautam2021/ParaBank-Automation-Framework.git'
            }
        }

        stage('Verify Java') {
            steps {
                bat 'java -version'
            }
        }

        stage('Verify Maven') {
            steps {
                bat 'mvn -version'
            }
        }

        stage('Build Project') {
            steps {
                bat 'mvn clean compile'
            }
        }

        stage('Run Selenium Tests') {
            steps {
                bat 'mvn test'
            }
        }
    }

    post {

        always {

            echo 'Publishing Test Results...'

            junit 'target/surefire-reports/*.xml'

            archiveArtifacts artifacts: 'report/**', allowEmptyArchive: true

            archiveArtifacts artifacts: 'screenshots/**', allowEmptyArchive: true

            archiveArtifacts artifacts: 'logs/**', allowEmptyArchive: true

        }

        success {
            echo 'Build completed successfully.'
        }

        failure {
            echo 'Build failed.'
        }
    }
}