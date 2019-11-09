pipeline{

    agent any
	tools {
        maven 'Maven 3.5.0' 
    }

    stages {

        stage ('Compile Stage') {

            steps {

                
                    sh 'mvn clean install'

                

            }
        }
    stage ('Test Stage') {

            steps {

                
                    sh 'mvn test'

                

            }
        }


    stage ('Cucumber Reports') {

            steps {
                cucumber buildStatus: "UNSTABLE",
                    fileIncludePattern: "**/cucumber.json",
                    jsonReportDirectory: 'target',
					trendsLimit: 10,
                    classifications: [
                        [
                        'key': 'Browser',
                        'value': 'Firefox'
                        ]
                   ]

            }
			

        }
	

    }
	post {
    always {
        cucumber buildStatus: 'UNSTABLE',
                failedFeaturesNumber: 1,
                failedScenariosNumber: 1,
                skippedStepsNumber: 1,
                failedStepsNumber: 1,
                fileIncludePattern: '**/*cucumber-report.json',
                sortingMethod: 'ALPHABETICAL',
                trendsLimit: 100
    }
}

    configure { project ->
  project / 'publishers' << 'net.masterthought.jenkins.CucumberReportPublisher' {
    fileIncludePattern '**/*.json'
    fileExcludePattern ''
    jsonReportDirectory ''
    failedStepsNumber '0'
    skippedStepsNumber '0'
    pendingStepsNumber '0'
    undefinedStepsNumber '0'
    failedScenariosNumber '0'
    failedFeaturesNumber '0'
    buildStatus 'FAILURE'  //other option is 'UNSTABLE' - if you'd like it left unchanged, don't provide a value
    trendsLimit '0'
    sortingMethod 'ALPHABETICAL'
  }
}

}