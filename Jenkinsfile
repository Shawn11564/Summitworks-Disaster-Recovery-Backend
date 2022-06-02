pipeline {
  agent { docker { image 'maven:3.8.5' } }
  stages {
    stage ( 'log version info') {
      steps {
        bat 'mvn --version'
        bat 'mvn clean intall'
      }
    }
  }
}
