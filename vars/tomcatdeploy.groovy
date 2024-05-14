def call()
sshagent(['tomcat9jenkins']) {
     sh "scp -o StrictHostKeyChecking=no target/mavenjenkins.war ec2-user@172.31.36.0:/opt/tomcat9/webapps"
     sh "ssh ec2-user@172.31.36.0 /opt/tomcat9/bin/shutdown.sh"
     sh "ssh ec2-user@172.31.36.0 /opt/tomcat9/bin/startup.sh"
}
