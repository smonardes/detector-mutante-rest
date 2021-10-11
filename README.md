# detector-mutante-rest
Aplicacion JAVA8 diseñada para la verificacion de ADN correspondiente a mutantes, 
asi mismo sus estadisticas.

### Link Swagger
http://ec2-3-144-108-51.us-east-2.compute.amazonaws.com:8080/detector-mutante-rest/swagger-ui.html#/

### Git Repository
https://github.com/smonardes/detector-mutante-rest

### Requerimientos
* maven 3+
* jdk 8


### Despliegue
```mvn spring-boot:run```

### Postman
* Importar collection postman *mutante.postman_collection.json*
* Para consultar por un ADN si es mutante usar request /mutant
  * Ingresar en el body la estructura ADN
  * Ejecutar request
  * Si es mutante obtendra un Http Status Code 200
  * Si es humano obtendra un Http Status Code 403
* Para consultar las estadísticas usar request /stats
  * Se obtiene como resultado la cantidad de mutantes, la cantidad de humanos y su proporción