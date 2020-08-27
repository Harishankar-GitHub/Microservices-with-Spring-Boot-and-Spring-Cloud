# Microservices with Spring Boot and Spring Cloud

##  :sparkles: RESTful Web Services :sparkles:

##### Spring Boot Application
##### Various request methods
##### Exception Handling
##### Validation API
##### HATEOAS
##### Internationalization for Restful Web Services
##### Content negotiation - Implementing support for XML
##### Swagger Documentation - URL for SWAGGER UI
	* http://localhost:8080/swagger-ui/ or http://localhost:8080/swagger-ui/index.html
	* http://localhost:8080/v2/api-docs
##### Enhancing Swagger Documentation with Custom Annotations
##### Monitoring APIs with Spring Boot Actuator
##### URLs for Actuator
	* http://localhost:8080/actuator/
	* http://localhost:8080/explorer/index.html#uri=/
##### Filtering for RESTful Web Services
	* Static Filtering
	* Dynamic Filtering
##### Versioning RESTful Services
##### Connecting RESTful Web Service to JPA
##### Richardson Maturity Model
##### RESTful Web Services - Best Practices

## :sparkles: Microservices :sparkles:

##### Limits Service
	* Using the values from application.properties file using @ConfigurationProperties annotation.
	* Fetching the values from Spring Cloud Config Server & Git Repository
	* Port : 8080, 8081, ...
#####  Spring Cloud Config Server
	* Port : 8888
	* With a local Git Repository
		* Open Command Prompt -> Navigate to the project folder and execute the below commands
		* mkdir git-localconfig-repo
		* cd git-localconfig-repo
		* git init
	* After this, open IDE -> Right Click project -> Build Path -> Configure Build Path -> Source -> Link Source -> Browse to the local git repository -> Apply -> Close
	* Git Repository folder will be linked to the project in IDE.
	* Create a file in that Git Repository folder from IDE.
	* After this, open Command Prompt and execute the below commands to add files that are created/modified and commit.
		* git add -A
		* git status
		* git commit -m "first commit"
##### Currency Exchange Service
	* Port : 8000, 8001, 8002, ...
##### Currency Conversion Service
	* Port : 8100, 8101, 8102, ...
##### RestTemplate & Feign REST Client for Service Invocation
##### Setting up client side load balancing with Ribbon
##### Eureka Naming Server
	* Port : 8761
##### API Gateways - Zuul API Gateway
	* Netflix Zuul Api Gateway Server
	* Port : 8765
##### Distributed Tracing
	* Implementing Spring Cloud Sleuth
		* To enable logging across all services with a common id
	* RabbitMQ & Erlang
		* Erlang 	: https://www.erlang.org/downloads
		* RabbitMQ 	: https://www.rabbitmq.com/install-windows.html
	* Zipkin
		* https://zipkin.io/pages/quickstart -> Java -> Copy paste the URL in browser
		* .sh file will be downloaded
		* Place it in the project folder and double click
		* A .jar is downloaded
		* Open cmd and navigate to the project folder
		* Execute the following commands
			* set RABBIT_URI=amqp://localhost
			* java -jar zipkin.jar
		* After this, Zipkin Server will be up and running
		* URL for Zipkin UI : http://localhost:9411/zipkin
##### Spring Cloud Bus
##### Fault Tolerance with Hystrix

## :sparkles: Running all applications :sparkles:

##### Open command prompt and navigate to the project folder
##### Execute the following commands
		* set RABBIT_URI=amqp://localhost
		* java -jar zipkin.jar
##### After this, Zipkin Server will be up and running
##### URL for Zipkin UI : http://localhost:9411/zipkin
##### Order of executing services :
		* Zipkin Server
		* Eureka Naming Server
		* Netflix Zuul Api Gateway Server
		* Currency Exchange Service
		* Currency Conversion Service
