def call(String msg = 'clean') {
echo "${msg}"
   sh 'mvn clean package'
}
