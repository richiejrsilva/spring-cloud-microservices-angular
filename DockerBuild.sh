#!/bin/bash​

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
