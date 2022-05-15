# CurrencyMicroservices
Its a Java Microservices project which demonstrates the use of Microservices Architecture over conventional REST APIs. This project has 2 Microservices which are being registered over the Eureka Discovery Service Server and using the Spring API gateway to load balance all the requests coming in. In order to trace the distributed systems it has been registered with zipkin server to trace each and every request going through the API Gateway Service.


URL for Exchange Microservice : http://localhost:8000/currency-exchange/...
URL for Conversion Microservice: http://localhost:8100/currency-conversion/....
URL for Eureka Discovery Client : http://localhost:8761/
URL for Spring API gateway : http://localhost:8765

URL for zipkin server :http://localhost:9411/zipkin
URL for rabbitmq : http://localhost:15672

All the microservices have been deployed to docker and configurations are set inside the docker-compose.yaml file
