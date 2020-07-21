def call(mavenBuild) 
{
         echo mavenBuild
         def mBuild = mavenBuild
         sh "${mBuild}"
 }
            
