
def basePath ='iot_backend'

folder(basePath)
def repo= 'bhagirathgudi/iot-backend'

pipeline {
      environment {
            registry = "bhagirath93/iot-backend"
            regsitryCredential = 'dockerhub'
            dockerImage=''
      }
      agent any
      stages {
            stage('Cloning git') {
                  steps {
                        github repo
                  }
            }
            stage('Bulding project') {
                  steps {
                        gradle{
                            makeExecutable(true)
                            tasks('clean build')      
                        } 
                       // artifacts
                  }
            }
            
      }
}
