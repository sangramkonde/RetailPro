# Spring Boot "Retail Manager" Project

This is a simple Java / Gradle / Spring Boot application that can be used to develop a working prototype which satisfies 
a Retail Manager that wanting to keep track of their shops.

# About the Service

The service is for retail manager to keep track of their shops, does a RESTful POST to /shops with a JSON of shopName, shopAddress.number and 
shopAddress.postCode 
to the Shops API (microservice) where shops are stored in memory. Permanent persistence of the data is not required.

The application can be used by multiple users at a time (no login functionality is required). Shops are identified by their unique names.

If user A adds a shop that was already added by user B, the service should replace previous version and REST response to user A should contain 
information about the version that was replaced. If two users submit a shop at the same time, exactly one of them should get 
information about replacing another version of the shop. Whenever a shop is added the service calls the Google Maps API.

The Google Maps API responds with the longitude and latitude, which allows the shop data to be updates with longitude and latitude. 
A customer, using their geolocation on their phone, wants to find the store that is closest to them. 
The Shops API will have the customer’s longitude and latitude, but also the longitude and latitude of each shop to do the calculation. 
The customer does a RESTful GET to the Shops API, providing their current longitude and latitude (e.g. URL request params), and gets back the address, 
longitude and latitude of the shop nearest to them.

# How to Run 

This application is packaged as a jar. You run it using the ```java -jar``` command.

* Clone this repository 
* Make sure you are using JDK 1.8 and Gradle 3.x
* You can build the project and run the tests by running ```gradle build```
* Once successfully built, you can run the service by below commands :
		
		java -jar <path>\retail-manager\build\libs\retail-manager-1.0.jar
	OR 
	    gradle run

Once the application runs you should see something like this

````````
2017-06-25 23:18:12.384  INFO 11324 --- [           main] s.b.c.e.t.TomcatEmbeddedServletContainer : Tomcat started on port(s): 8080 (http)
2017-06-25 23:18:12.390  INFO 11324 --- [           main] shop.retail.main.ApplicationLauncher     : Started ApplicationLauncher in 5.991 seconds (JVM running for 6.919)
````````

Here are some endpoints you can call:

Swagger URL :

http://localhost:8080/swagger-ui.html

================================================
API 1       : Add shop information to in-memory.
================================================

URI         : /shop
Method      : POST
Request     : 
		    {
				 "shopName": "DMART, Pune",
				 "shopAddress": {
					"number": "Pune-Banglure Hwy, Pune",
					"postCode": 411009
			 }
		    }
Response    : 201 Created
			{
				 "success": true,
				 "shopStatus": "New shop has been added successfully"
			}

================================================
API 2       : To get the nearest shop
================================================

URI         : /shop/find
Query Param : 
              customerLatitude=18.57
			  customerLongitude=73.76
Method      : GET
Response    : 200 OK
			{
				"shopName": "DMART, Pune",
				"shopAddress": {
					"number": "Pune-Banglure Hwy, Pune",
					"postCode": 411009
				},
				"shopLatitude": 18.4865732,
				"shopLongitude": 73.85747620000001
			}

# About Spring Boot

Spring Boot is an "opinionated" application bootstrapping framework that makes it easy to create new RESTful services (among other types of applications). 
It provides many of the usual Spring facilities that can be configured easily usually without any XML. 
In addition to easy set up of Spring Controllers, Spring Data, etc. Spring Boot comes with the Actuator module that gives the application 
the following endpoints helpful in monitoring and operating the service: