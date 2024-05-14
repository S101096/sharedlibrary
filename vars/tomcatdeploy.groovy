def call(tomcatIP)
sshagent(['tomcat9jenkins']) {
     sh "scp -o StrictHostKeyChecking=no target/mavenjenkins.war ec2-user@${tomcatIP}:/opt/tomcat9/webapps"
     sh "ssh ec2-user@${tomcatIP} /opt/tomcat9/bin/shutdown.sh"
     sh "ssh ec2-user@${tomcatIP} /opt/tomcat9/bin/startup.sh"
}
