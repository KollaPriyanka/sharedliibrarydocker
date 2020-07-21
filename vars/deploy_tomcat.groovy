def call(tomcaturl) {
def urll = tomcaturl
//sh 'curl ${urll} -u tomcat:secret'
//sh 'curl -v -u tomcat:secret -T target/BMI-0.war ${urll}'
deploy adapters: [tomcat8(credentialsId: 'tomcat_cred', path: '', url: '${urll}')], contextPath: 'shared_library', onFailure: false, war: '**/*.war'
            }
