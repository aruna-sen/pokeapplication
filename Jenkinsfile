/*pipeline{
      agent any
      tools{
        jdk 'jdk17'
        maven 'maven3'
      }

      stages{
       stage('Checkout Source Code & Compile'){
         steps{
          git branch: 'master', url: 'https://github.com/aruna-sen/pokeapplication.git'
         }
       }
         stage('Build & Test') {
                   steps {
                       script {
                           sh 'mvn clean install'
                       }
                   }
               }

               stage('Build Docker Image') {
                   steps {
                       script {
                           sh "docker build -t ${DOCKER_IMAGE}:${DOCKER_TAG} ."
                       }
                   }
               }

               stage('Push Docker Image to Docker Hub') {
                   steps {
                       script {
                           sh docker login -u $DOCKER_HUB_USERNAME --password $DOCKER_HUB_PWD'
                           sh "docker push ${DOCKER_IMAGE}:${DOCKER_TAG}"
                       }
                   }
               }

               stage('Deploy to EC2') {
                   steps {
                       script {
                           sh """
                           ssh -o StrictHostKeyChecking=no ${EC2_USER}@${EC2_HOST} << EOF
                               docker pull ${DOCKER_IMAGE}:${DOCKER_TAG}
                               docker stop pokeapp || true
                               docker rm pokeapp || true
                               docker run -d -p 8080:8080 --name pokeapp ${DOCKER_IMAGE}:${DOCKER_TAG}
                           EOF
                           """
                       }
                   }
               }
      }
*/

}