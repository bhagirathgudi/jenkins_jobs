
def basePath ='iot_backend'
def repo= 'bhagirathgudi/iot-backent'
folder(basePath)
job("$basePath/build") {
      scm {
        github repo
      }
      
      triggers{
        githubPush()
      }
      
      steps {
        gradle 'clean build'
      }
}
