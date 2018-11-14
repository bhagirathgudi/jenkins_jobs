
def basePath ='iot_backend'

folder(basePath)
def repo= 'bhagirathgudi/iot-backend'

job(basePath+"/defaultjob") {
  
    stage('Cloning git') { // for display purposes
			github repo
   }
   stage('Build') {
			gradle {
				makeExecutable(true)
				tasks('clean build')
			}
   }
}
