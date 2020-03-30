# TheaterPlaysManagementApplication
## Starting the application
Before running the application, you have to start PostgreSQL.
The easiest way is by running the following commands:
```
docker pull postgres
mkdir -p PATH_TO_BE_REPLACED\postgres
docker run --rm --name pg-docker -e POSTGRES_PASSWORD=password -e POSTGRES_USER=user -e POSTGRES_DB=theater_db -d -p 5432:5432 -v PATH_TO_BE_REPLACED\postgres:\var\lib\postgresql\data postgres
```
You need docker installed. Also, you should replace "PATH_TO_BE_REPLACED" with your desired path.  
To make sure your postgres container is running, you can execute the following command:
```
docker ps
```
## Application requirements
Documentation available [here](https://docs.google.com/document/d/1RZwr8hjpY6JaBuiy4ww0YYtd9ua8_FYodb93aFrmStg).

## Rest documentation
After starting the application, you can get familiar with the API by opening swagger available [here](http://localhost:8080/swagger-ui.html).

## Database
![Database Diagram](https://github.com/1Mihail/theater-plays/blob/master/others/databaseDiagram.png)
