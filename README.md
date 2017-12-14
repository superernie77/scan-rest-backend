# scan-rest-backend

Backend REST-Service and GUI for the [android scan app](https://github.com/superernie77/scan-android-app). Exposes an Endpoint to add scan result and retrieve a list of scan results.

An overview of the past scans can be displayed by the following URL:

### https://scan-rest-backend.herokuapp.com/


The rest endpoint listens under the following URL and accepts POST and GET requests.

```
https://scan-rest-backend.herokuapp.com/message
```

The REST service consumes the following message Json in a POST request:

```
{
    "createdBy": "ENE",
    "barcode": "1223",
    "format": "String",
    "message": "fourth demo message"
}
```
# Used Technologies

+ Spring Web
+ Thymeleaf
+ Spring Data JPA
+ Heroku 
+ JawsDB (MySql)
