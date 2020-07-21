def call(String msg = 'deploy_dev') {
echo "${msg}"
 deploy adapters: [tomcat8(credentialsId: 'tomcat_cred', path: '', url: 'http://3.133.100.227:8080')], contextPath: 'shared_library', onFailure: false, war: '**/*.war'
            }
