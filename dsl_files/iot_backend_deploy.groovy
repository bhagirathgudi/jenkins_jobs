
def basePath ='iot_backend'

folder(basePath)
def repo= 'bhagirathgudi/iot-backend'

job(basePath+"/defaultjob") {
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
