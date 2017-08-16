# testol
Test OL

Herramientas utilizadas
+ Spring Boot
+ Spring Data
+ Jersey
+ Angular
+ Bootstrap
+ Maven
+ H2

Para utilizar el proyecto se debera de compilar con el comando

mvn install

Esto genera un jar "testol-0.0.1-SNAPSHOT.jar" dentro de target el cual debera ejecutarse con 

java -jar testol-0.0.1-SNAPSHOT.jar

Al utilizar spring boot levantara un tomcat en localhost en el puerto 8080 para ingresar a la aplicación se deberá ingresar mediante un explorador web a la url

http://localhost:8080/start

Utiliza la base de datos H2 embebida por lo que no se necesita configurar alguna base de datos.
