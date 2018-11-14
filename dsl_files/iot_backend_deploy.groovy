
def basePath ='iot_backend'

folder(basePath)
def repo= 'bhagirathgudi/iot-backend'

job(basePath+"/defaultjob") {
  
  node {
   def repo = 'bhagirathgudi/iot-backend'
   stage('Cloning git') { // for display purposes
      steps{
			github repo
	  }
   }
   stage('Build') {
      steps{
			gradle {
				makeExecutable(true)
				tasks('clean build')
			}
	  }
   }
}
}
