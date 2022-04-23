# Rest API Application

Build Restful CRUD API for an application using Spring Boot, H2, JPA.

## Requirements

1. Java - 1.8.x

2. Maven - 3.x.x


## Steps to Setup

**1. Clone the application**

```bash
git clone https://github.com/bahramian-98/bank-service.git
```

**2. Build and run the app using maven**

you can run the app using -

```bash
mvn spring-boot:run
```

The app will start running at <http://localhost:8088>.

## Explore Rest APIs

The app defines following CRUD APIs.

    POST /user/save                             (create a user)
	GET  /user                                  (get a list of users)
	
	POST /customer/save                         (create a customer)
    GET /customer                               (get a list of customer)
    GET /customer/byNationalCode                (get customer by nationalCode)
	
    POST /bankAccount/save                      (create a bankAccount for a customer)
    GET  /bankAccount                           (get a list of bankAccounts)
    GET /bankAccount/findByCustomerId           (get bankAccounts of a customer)
    
	
    
  
You can test them using postman or any other rest client.

## Rest API Documentation

You can find the APIs documentation for this application on 

<http://localhost:8088/swagger-ui.html/>


