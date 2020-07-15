@NonCPS
def call(Map config=[:]){
node {
    stage('SCM') {
    	echo 'Gathering code from version control'
	git branch: '${branch}', url: 'https://github.com/MehediZaman/JenkinsGroovy.git'
    }
    stage('Build') {
	try{
        echo 'Building....'
        echo 'Building New Feature'
		releasenotes(changes:"true")
	}catch(ex){
        	echo 'Something went wrong'
        	echo ex.toString();
        	currentBuild.result = 'Failure'
	}
	finally{
		// cleanup
	}	
    }
    stage('Test') {
        echo 'Testing....'
    }
    stage('Deploy') {
        echo 'Deploying....'
    }
}
}