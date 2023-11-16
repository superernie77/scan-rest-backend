# scan-rest-backend

Backend REST-Service and GUI for the [android scan app](https://github.com/superernie77/scan-android-app). Exposes an Endpoint to add scan result and retrieve a list of scan results.


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
# Configuration

The apppplication can be started in two profiles:
- default: uses H2 database to persist messages
- heroku : uses the database connection parameters defined in application-heroku.properties to connect to an MySql DB.

The connetion parameters are read from the following system / environment variables_
- ${DATASOURCE_URL}
- ${DATASOURCE_USERNAME}
- ${DATASOURCE_PWD}

# Used Technologies

+ Spring Web
+ Thymeleaf
+ Spring Data JPA
+ Heroku 
+ JawsDB (MySql)
