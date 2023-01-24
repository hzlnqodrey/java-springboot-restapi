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

1. [API Endpoints for Android](#api-endpoints)

<a id="api-endpoints"></a>
# API Endpoints

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



ref: [link](https://www.youtube.com/watch?v=Z0JfmObjKRw)
