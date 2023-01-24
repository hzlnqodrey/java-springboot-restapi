# java-springboot-restapi
Java Springboot Basic REST API with MySQL Driver Connector and Hibernate ORM JPA [or you just use JDBA]

- Todo:
  + Implement Auth
  + Implement Association
  + Implement Database Migration
  + Connect to Cloud SQL and Cloud Run
  
## Table of Contents
<details open>
<summary><b>(click to expand or hide)</b></summary>
<!-- MarkdownTOC -->

1. [About](#about)
1. [Running the application](#running)
1. [API Endpoints](#api-endpoints)
1. [Building for Production](#prod)

<a id="about"></a>
## About the Application 

This is a simple web application that exposes a REST API. This application uses Maven as the build tool and the current 
LTS version of Java, 1.8/8. I hope to add more functionality to this application in the future but 
for now this project uses the following dependencies: 

- Spring Web
- Spring Data JDBC
- PostgreSQL Database
- Spring Actuator
- Testcontainers
 
<a id="running"></a>
## Running the application

You can run this application from your favorite IDE or by running the following command:
  
```bash
./mvnw spring-boot:run
```
  
<a id="api-endpoints"></a>
## API Endpoints

### [POST] Create Product
#### /api/products
#### header: [Content-Type: application/json]
```
http://localhost:8080/api/products
```

### [GET] Find All Products 
#### /api/products
```
http://localhost:8080/api/products
```

### [GET] Find One Product by Id
#### /api/products/{id}
```
http://localhost:8080/api/products/{id}
```

### [PUT] Update One Product
#### /api/products/
#### header: [Content-Type: application/json]
```
http://localhost:8080/api/products
```

### [DELETE] Update One Product
#### /api/products/{id}
```
http://localhost:8080/api/products/{id}
```

<a id="prod"></a>
## Building for Production 

If you want to build an artifact that can be used in production you have 2 options. This application uses `JAR` as the 
packaging type. This means that you can run the following command to create something that is ready to be used in production.

```bash
./mvnw clean package
```

If you would like to create a Docker Image which can be used on a variety of platforms you can run the following command: 

```bash
./mvnw spring-boot:build-image
```
  
### Railway
Bring your code, we'll handle the rest. Made for any language, for projects big and small. [Railway](https://railway.app/) 
is the cloud that takes the complexity out of shipping software.

Create a new empty project in Railway and start by creating a PostgreSQL database. Once you have that created you can create
a new project from GitHub. You can use the following environment variables based on the database you just created. 

```properties
spring_profiles_active=prod
PROD_DB_HOST=HOST_HERE
PROD_DB_PORT=POST_HERE
PROD_DB_NAME=railway
PROD_DB_PASSWORD=PASSWORD_HERE
PROD_DB_USERNAME=postgres
``` 
 

### Azure Spring Apps

Azure Spring Apps is a platform as a service (PaaS) for Spring developers. Manage the lifecycle of your Spring Boot applications with 
comprehensive monitoring and diagnostics, configuration management, service discovery, CI/CD integration, and blue-green deployments.

[https://azure.microsoft.com/en-us/products/spring-apps](https://azure.microsoft.com/en-us/products/spring-apps)

#### GitHub Actions 

You could create a new artifact each time and deploy it to Azure Spring Apps using the Azure CLI. This can be tedious though and if you want to deploy a new version of your application each time a commit is made or merged into the master branch you can use GitHub actions. The following is a workflow that I am currently using to do that. 

```yaml
name: AzureSpringCloud
on: push
env:
  ASC_PACKAGE_PATH: ${{ github.workspace }}
  JAVA_VERSION: 17
  AZURE_SUBSCRIPTION: YOUR_SUBSCRIPTION_ID_HERE

jobs:
  deploy_to_production:
    runs-on: ubuntu-latest
    name: deploy to production with artifact
    steps:
      - name: Checkout Github Action
        uses: actions/checkout@v2
        
      - name: Set up JDK ${{ env.JAVA_VERSION }}
        uses: actions/setup-java@v1
        with:
          java-version: ${{ env.JAVA_VERSION }}

      - name: maven build, clean
        run: |
          mvn clean package -DskipTests

      - name: Login via Azure CLI
        uses: azure/login@v1
        with:
          creds: ${{ secrets.AZURE_CREDENTIALS }}

      - name: deploy to production with artifact
        uses: azure/spring-cloud-deploy@v1
        with:
          azure-subscription: ${{ env.AZURE_SUBSCRIPTION }}
          action: Deploy
          service-name: spring-blog
          app-name: spring-blog
          use-staging-deployment: false
          package: ${{ env.ASC_PACKAGE_PATH }}/**/*.jar
```

ref: [link](https://www.youtube.com/watch?v=Z0JfmObjKRw)
