def call(){

    pipeline {
        agent {
            node { label 'workstation'}
        }

        stages {
            stage ('Build code') {
                steps {
                    sh 'npm install'
                }
            }

            stage ('Unit Testing') {
                steps {
                    echo "Unit Testing"
                }
            }


            stage ('Code Analysis') {
                steps {
                    //sh 'sudo sonar-scanner -Dsonar.host.url=http://172.31.88.214:9000 -Dsonar.login=admin -Dsonar.password=admin123 -Dsonar.projectKey=cart'
                    echo "Code Analysis"
                }
            }

            stage ('Security checks') {
                steps {
                    echo "Security checks"
                }
            }

            stage ('Code Publish') {
                when {
                    expression { env.TAG_NAME ==~ ".*" }

                }
                steps {
                    echo "Code Publish"
                    sh 'env'
                }
            }
        }

//   post {
//     always {
//
//     }
//   }





    }
}