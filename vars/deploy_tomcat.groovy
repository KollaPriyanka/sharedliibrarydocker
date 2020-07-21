/*def call(tomcaturl) {
def tomcat_url = tomcaturl
sh 'curl ${tomcat_url}/manager/text/undeploy?path=/BMI -u tomcat:secret'
sh 'curl -v -u tomcat:secret -T target/BMI-0.war ${tomcat_url}/manager/text/deploy?path=/BMI'
deploy adapters: [tomcat8(credentialsId: 'tomcat_cred', path: '', url: '${urll}')], contextPath: 'shared_library', onFailure: false, war: '**/*.war'
            }*/
def call(String msg = 'deploy_dev') {
echo "${msg}"
 deploy adapters: [tomcat8(credentialsId: 'tomcat_cred', path: '', url: 'http://3.133.100.227:8080')], contextPath: 'shared_library', onFailure: false, war: '**/*.war'
            }
