
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
            shell('ssh bhagirath93@40.121.143.10 "mkdir ~/JavaApp"')
            shell('scp ./build/libs/iot-backend-0.0.1-SNAPSHOT.jar bhagirath93@40.121.143.10:~/JavaApp')
            shell('ssh bhagirath93@40.121.143.10 "cd ~/JavaApp && java -jar iot-backend-0.0.1-SNAPSHOT.jar -p 8080" ')
            
      }
}
