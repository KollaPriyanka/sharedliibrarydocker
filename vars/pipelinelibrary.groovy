def call(body) {    
    def config = [:]
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = config
    body()
//def call(urllink,dockerimage,mavenBuild,sonarorganization,sonarprojectKey,sonarprojectName){
def urllink = config.urllink ?: ''
//def dockerimage = config.dockerimage ?: ''
def mavenBuild = config.mavenBuild ?: ''
def sonarorganization = config.sonarorganization ?: ''
def sonarprojectKey = config.sonarprojectKey ?: ''
def sonarprojectName = config.sonarprojectName ?: ''
def sonarHostUrl = config.sonarHostUrl ?: ''
def sonarprojectVersion = config.sonarprojectVersion ?: ''
def sonarSources = config.sonarSources ?: ''
def sonarLanguage = config.sonarLanguage ?: ''
def sonarBinaries = config.sonarBinaries ?: ''
def sonarjavacoveragePlugin = config.sonarjavacoveragePlugin ?: ''
def sonarcoveragejacocoxmlReportPaths = config.sonarcoveragejacocoxmlReportPaths ?: ''
def sonarExclusions = config.sonarExclusions ?: ''
def sonarsourceEncoding = config.sonarsourceEncoding ?: ''

    

        pipeline {
            agent any
            
            stages {
               
                stage('Code Checkout'){
                    steps{
                           clonerepo(urllink)
                    }
                }
               
                stage('Build'){
                    steps{
                            build(mavenBuild)
                    }
                }
                stage('SonarStage'){
                    steps{
                       sonarqube(sonarorganization,sonarprojectKey,sonarprojectName,sonarHostUrl,sonarprojectVersion,sonarSources,sonarLanguage,sonarBinaries,sonarjavacoveragePlugin,sonarcoveragejacocoxmlReportPaths,sonarExclusions,sonarsourceEncoding)
                    }
                }
                stage('QualityGate'){
                    steps{
                       qualitygate()
                    }
                }
            }
      }
}
