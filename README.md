# mutantAPI

##Precondiciones para compilar el proyecto
- Tener intalado Java 17, MongoDB y Maven

##Correr test
- Se pueden ejecutar los test con mvn test

##Compilar proyecto
- Se debe ejecutar mvn clean install

##Aclaraciones
- Para levantar localmente la aplicación el puerto por default es 8080

- Se valida que el ADN sea de tamaño NxN
- Para calcular el RATIO, al ser todos los ingresados MUTANTES y 0 HUMANOS, se decide tomar como RATIO 1 (es decir 100% de MUTANTES)
 
- Se usó Lombok y luego se eliminó para simplifar ver el código fuente desde cualquier IDE.
- Se podría haber usado Swagger

 
 
#CURLs de EJEMPLO:
-MUTANTE:
curl --location --request POST 'http://localhost:8080/mutant' \
--header 'Content-Type: application/json' \
--data-raw '{  "adn": ["TTTTGA","CAGTGC","TTATGT","AGACTG","AAGCCA","TCACTG"]}

- NO MUTANTE:
curl --location --request POST 'http://localhost:8080/mutant' \
--header 'Content-Type: application/json' \
--data-raw '{  "adn": ["ATTGGA","CAGTGC","TTATGT","AGACTG","AAGCCA","TCACTG"]}

- MUTANTES INVÁLIDOS:
curl --location --request POST 'http://localhost:8080/mutant' \
--header 'Content-Type: application/json' \
--data-raw '{  "adn": ["PPPPPP","CAGTGC","TTATGT","AGACTG","AAGCCA","TCACTG"]}

