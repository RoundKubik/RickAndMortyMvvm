pipeline {
	agent any
		stages {
			stage('Clone Git repository') {
				steps {
					echo "checkout scm"
					checkout scm
				}
			}
			stage('Push image to Docker Hub') {
				stes {
					sh 'echo Push image to a Docker Hub'
					docker.withRegistry('https://registry.hub.docker.com', 'roundkubik/test_secure') {
						app.push("latest") 
					}
				}		
			}
		}
}

