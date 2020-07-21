def call(tomcaturl) {
def urll = tomcaturl
sh 'curl ${urll} -u tomcat:secret'
sh 'curl -v -u tomcat:secret -T target/BMI-0.war ${urll}'
            }
