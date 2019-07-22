# microservice
An e-wallet system for restaurant ticket based on Microservice Architecture 


#  Requirements :
  - Kubernetes cluster with more then 25 GB Ram prefareble with version less then 14.0
  - private docker hub registry to push and pull image to
  - don't forget to install istio so you are able to use grafana and zipkin

# docker 
  - you can use the maven docker plugin that is already configured to build and push images 
  - don't forget to create a kubrentes secrets that contains the docker hub credential to kubernetes is able to create pull the images

# Tree 
 
 - Angular : contains the web portal that is used by the company 
 
 - jsf : contains the backoffice used by the provider
 
 - kubrentes : contains the deployments for kubernetes 
 
 - serverless : contains the functions check openfaas to understant how to deploy them 
 
 - ReqNResp : contains the structure of the api response 
  
  
  
 
 # Contribuation 
 
 I accept any kind of contribuation .
