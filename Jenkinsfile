			stage('Clone Git repository') {
				steps {
					echo "checkout scm"
					checkout scm
				}
			}
			stage('Push image to Docker Hub') {
				steps {
					sh 'echo Push image to a Docker Hub'
						script {

						
							docker.withRegistry('https://registry.hub.docker.com', 'roundkubik/test_secure') {
								app.push("latest") 
							}
						}		
				}		
			}

	

