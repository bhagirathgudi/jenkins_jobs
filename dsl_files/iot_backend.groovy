def basePath ='iot_backend'
def repo= 'bhagirathgudi/iot-backent'

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
