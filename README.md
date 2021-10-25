# mcq-service
As template code of implementing hexagonal with DDD in event Driven manner

Command Gateway - build on Apache camel
Event Gateway - build on camel with Kafka
Micro stream as Storage engine
Spring Boot Application
Mongo as Database storage server
Command , Event , Query 
Query Gateway - build on reactive 
Saga Builder and Manager - build on spring state machine



Command Gateway -
 Decouple the command from its handler , you dont have to 
 autowire or inject the depedencie. 
 Provide async way to execute a command according to need.
 Its distrubeted by nature , with retry and failover policy
 You have to just send the command and the command gateway routes 
 To the correct serive (bean or microservice)






 
