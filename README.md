# cloud-microservices

Mis en pratique des connaissances de l'ecosysteme d'une architecture micro-services

#ordre de demarrage

- mq 
- zipkin
- eureka
- exchange
- conversion
- zuul api gateway


#zipkin
set RABBIT_URI=amqp://localhost
java -jar zipkin-server-2.7.0-exec.jar


#request Test
http://localhost:8000/currency-exchange/from/CAD/to/EUR

http://localhost:8001/currency-exchange/from/USD/to/EUR

http://localhost:8100/currency-conversion-feign/from/CAD/to/EUR/quantity/2

http://localhost:8888/limits-service/default

http://localhost:8761/

http://localhost:8765/currency-exchange-service/currency-exchange/from/USD/to/EUR

http://localhost:8765/currency-conversion-service/currency-conversion-feign/from/CAD/to/EUR/quantity/2

http://localhost:9411/zipkin/



#Points principaux
Connect Spring Cloud Config Server to Local Git Repository
Connect Service to Spring Cloud Config Server
Using Feign REST Client for Service Invocation
load balancing with Ribbon
Eureka Naming Server
Zuul API Gateway
Zuul Logging Filter
Spring Cloud Sleuth
Rabbit MQ
Distributed Tracing with Zipkin
Spring Cloud Bus
Fault Tolerance with Hystrix



