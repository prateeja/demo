pipeline {
  agent any
  stages {
    stage('Git Clone & Setup') {
      steps {
        slackSend(sendAsText: true, message: 'Pipeline Started', token: 'wJL6PXfMMkDcqRiPoRstGcGu', channel: 'jenkins_builds', teamDomain: 'milvikbima')
        git(url: 'https://github.com/prateekjain-test/demo.git', branch: 'master')
      }
    }

    stage('Build & Test') {
      parallel {
        stage('Build & Unit Test') {
          steps {
            sh 'mvn clean install'
          }
        }

        stage('Unit Test') {
          steps {
            echo 'Unit Test'
          }
        }

        stage('Static Code Coverage') {
          steps {
            echo 'Static Code Coverage'
          }
        }

        stage('Archive Artifact') {
          steps {
            echo 'Archive Artifact'
            archiveArtifacts(artifacts: 'build/*.jar', onlyIfSuccessful: true)
          }
        }

        stage('Security Scan') {
          steps {
            echo 'Security Scan'
          }
        }

      }
    }

    stage('Notify & Deploy to Stage') {
      steps {
        echo 'Notify & Staging Deploy'
      }
    }

    stage('Staging tests') {
      parallel {
        stage('Staging tests') {
          steps {
            echo 'Staging tests'
          }
        }

        stage('Integration Testing') {
          steps {
            echo 'Integration Testing'
          }
        }

        stage('Smoke Testing') {
          steps {
            echo 'Smoke Testing'
          }
        }

        stage('Load Testing') {
          steps {
            echo 'Load Testing'
          }
        }

        stage('Manual Testing') {
          steps {
            echo 'Manual Testing'
          }
        }

        stage('Promote to UAT') {
          steps {
            input(message: 'Promote to UAT?', ok: 'Proceed')
          }
        }

      }
    }

    stage('Notify & Deploy to UAT') {
      steps {
        echo 'Notify & Deploy to UAT'
      }
    }

    stage('UAT Tests') {
      parallel {
        stage('UAT Tests') {
          steps {
            echo 'UAT Tests'
          }
        }

        stage('Integration Testing') {
          steps {
            echo 'Integration Testing'
          }
        }

        stage('Promote to Prod?') {
          steps {
            input(message: 'Promote to Prod?', ok: 'Promote to Prod?')
          }
        }

      }
    }

    stage('Notify & Deploy to Prod') {
      parallel {
        stage('Notify & Deploy to Prod') {
          steps {
            echo 'Notify & Deploy to Prod'
          }
        }

        stage('Smoke Testing') {
          steps {
            echo 'Smoke Testing'
          }
        }

        stage('Rollback?') {
          steps {
            input(message: 'Rollback?', ok: 'Rollback?')
          }
        }

      }
    }

    stage('Rollback') {
      parallel {
        stage('Rollback') {
          steps {
            echo 'Rollback'
          }
        }

        stage('Deploy Old Jar') {
          steps {
            echo 'Deploy Old Jar'
          }
        }

      }
    }

  }
}