pipeline {
  agent any
  stages {
    stage('Build back-end and front-end') {
      steps {
        sh 'mvn clean install -DskipTests'
      }
    }
    stage('Build and publish Docker images') {
      steps {
        sh '''#!/bin/bash
            mvn clean install -DskipTests

            
            tag="latest"

			appNames=(
			"config-service"
			"apigateway-service"
			"discovery-service"
			"item-service"
			"user-service"
			"shopping-list-service"
			)
			
			appPath=(
			"config-service"
			"apigateway-service"
			"discovery-service"
			"item-service"
			"user-service"
			"shopping-list-service"
			)
			i=0
			
			for appName in ${appNames[@]}
			do
			    echo "------------------------- Build/tag/Push project $appName on path ${appPath[i]}  -------------------------"
			    docker build -t $appName ./${appPath[i++]}
			    docker tag $appName:$tag
			    docker push TO COMPLETE with registry name
			    echo "-------------------------------------------------------------------------------------------------------------"
			done
        '''
      }
    }
  }
}
