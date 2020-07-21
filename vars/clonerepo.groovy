def call(urllink) {
	echo urllink
	def url = urllink
     
	sh 'rm -rf BMIbeta-Priya' 
	sh "git clone ${url}"
          
  }
