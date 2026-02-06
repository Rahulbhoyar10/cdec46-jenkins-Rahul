// pipeline {
//     agent any
//     stages {
//         stage('git-pull') {
//             steps {
//                 echo "pull-sucess"
//             }
//         }
//         stage('Build') {
//             steps {
//                 echo "build-sucess"
//             }
//         }
//         stage('Test') {
//             steps {
//                 echo "test sucess"
//             }
//         }
//         stage('Deploy') {
//             steps {
//                 echo "deploy sucess"
//             }
//         }
//     }
// }


pipeline {
    agent {label 'slave'}
    stages {
        stage('git-pull') {
            steps {
                git branch: 'main', url: 'https://github.com/Anilbamnote/student-ui-app.git'
            }
        }
        stage('Build') {
            steps {
                sh '/opt/maven/bin/mvn clean package'
            }
        }
        stage('Test') {
            steps {
                  sh '''/opt/maven/bin/mvn sonar:sonar \\
  -Dsonar.projectKey=new-student-app2 \\
  -Dsonar.host.url=http://52.65.212.121:9000 \\
  -Dsonar.login=424e3ba7723df9681a520c3035c3a4bdf94366f2'''
            }
        }
        stage('Deploy') {
            steps {
                echo "deploy sucess"
            }
        }
    }
}


