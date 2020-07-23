def call(String msg = 'deploy_dev') {
echo "${msg}"
 deploy adapters: [tomcat8(credentialsId: 'tomcat_cred', path: '', url: 'http://18.216.64.65:8080')], contextPath: 'shared_library', onFailure: false, war: '**/*.war'
            }
