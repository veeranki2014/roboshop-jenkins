def call(){

    pipeline {
        agent {
            node { label 'workstation'}
        }

        stages {
            stage ('Build code') {
                steps {
                    sh 'mvn package'
                }
            }

            stage ('Unit Testing') {
                steps {
                    echo "Unit Testing"
                }
            }


            stage ('Code Analysis') {
                steps {
                    //sh 'sudo sonar-scanner -Dsonar.host.url=http://172.31.88.214:9000 -Dsonar.login=admin -Dsonar.password=admin123 -Dsonar.projectKey=shipping -Dsonar.java.binaries=target'
                    echo "Code Analysis"
                }
            }

            stage ('Security checks') {
                steps {
                    echo "Security checks"
                }
            }

            stage ('Code Publish') {
                steps {
                    echo "Code Publish"
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