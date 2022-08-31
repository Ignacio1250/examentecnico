Para levantar el proyecto se deberá compilar con java 8 y maven.
Ingresar al directorio del proyecto y ejecutar el siguiente comando en cmd.
"mvn clean package"
El comando creará una version Snapshot de proyecto.
Para ejecutar el proyecto se deberá ingresar al directorio "target" el cual es donde se almacena la version
snapshot una vez construido, y ejecutar el siguiente comando.
"java -jar <<Nombre del jar>>"

Se procederá a hacer un levantamiento del proyecto,El proyecto tendrá una base de datos H2, 
con los scripts de creacion de esquema de base de datos y creacion de tablas, asi como con 
insercion de catalogos para ocupaciones y generos.

Probar los servicios de postman o swagger.
host: http://localhost:8080
basePath: /employee

ejercicio 1: /register
ejercicio 2: /working-hours
ejercicio 3: /search/job
ejercicio 4: /hours-worked
ejercicio 5: /total-payment