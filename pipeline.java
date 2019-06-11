pipeline{
    agent any
     stages{
       stage('one'){
         steps{
              echo 'Hi,this Zulaikha form edureka'
              }
                    }
       stage('two'){
        steps{
              input('Do you want to proceed?')
             }
                   }
       stage('three'){
         when{
             not{
                  branch "master"
                }
             }
        steps{
               echo  "hello"
             }
                     }
        stage('four'){
               parallel{
                stage('unit test'){
                  steps{
                      echo "Running the unit test..."
                       }
                            }
        stage('integration test'){
            agent{
               docker{
                      reuseNode false
                        image 'ubuntu'
                      }
                     }
            steps{
                  echo'Running the integration test..'
                }
             }}
         }
      }
 }