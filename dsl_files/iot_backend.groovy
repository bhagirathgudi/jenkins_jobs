
def basePath ='iot_backend'
def repo= 'bhagirathgudi/iot-backend'
folder(basePath)
job("$basePath/build") {
      scm {
        github repo
      }
      
      triggers{
        githubPush()
      }
      
      steps {
            gradle{
                  makeExecutable(true)
                  tasks('clean build')      
            }
            def app
            app = docker.build("iot-backend")
            docker.withRegistry('https://registry.hub.docker.com', 'docker-hub-credentials') {
                  app.push("${env.BUILD_NUMBER}")
                  app.push("latest")
            }
      }
}

