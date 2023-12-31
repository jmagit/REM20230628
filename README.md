# Curso de Java 17-20

## Instalación

- [JDK](https://www.oracle.com/java/technologies/downloads/)
- [Eclipse](https://www.eclipse.org/downloads/download.php?file=/technology/epp/downloads/release/2023-06/R/eclipse-java-2023-06-R-win32-x86_64.zip)

## Ejercicios

- Juego de “Adivina el número que estoy pensando”, un número del 1 al 100, ya te diré si es mayor o menor que el mío, pero tienes 10 intentos como mucho.

        Scanner teclado = new Scanner(System.in); cad = teclado.nextLine();  
        var rnd = new Random(); num = rnd.nextInt(10);  
        num = Integer.parseInt(cad);

- *Opcional:* Decodificar las cadenas con el siguiente formato:  

        3+4+3,4-7*1=

    en los siguientes componentes:  

        3 +  
        4 +  
        3,4 -  
        7 *  
        1 =  
    mostrando el resultado en la consola.

- Convertir el juego “Adivina el número que estoy pensando” en la clase JuegoDelNumero sin interfaz de usuario. Debe contar con los métodos inicializar y jugada, así como informar del número de intentos y el resultado de la última jugada. No debe dejar continuar si el juego ha terminado. Para probar el juego se debe implementar el interfaz de usuario.

- *Opcional:* Crear la clase Calculadora que acumule y permita obtener los resultados parciales de las operaciones obtenidas en la decodificación anterior.

- Crear las clases para implementar juegos que utilizan una baraja de naipes. Los naipes tienen dos propiedades distintivas: valor y palo. Probar la funcionalidad de barajar, repartir, comparar, … (Utilizar Enumeraciones, genéricos, colecciones …)

### Validaciones

Crear la clase de utilidad Valid que permita la validación de cadenas. Todos los métodos deben ser de clase, recibir como primer parámetro la cadena a validar y devolver true es válido. Debe contar al menos con los siguientes métodos:

    public static boolean isEmpty(String value);
    public static boolean isNumeric(String value);
    public static boolean isLenMax(String value, int len); //Inferior a la longitud máxima.
    public static boolean isLenMin(String value, int len); //Superior a la longitud mínima.
    public static boolean isPositive(String value);
    public static boolean isPositive(double value);

Adicionales:

    public static boolean isEMail(String value);
    public static boolean isURL(String value);
    public static boolean isNIF(String value);

### Máquina expendedora

Características:

- Solo los usuarios registrados pueden usar la máquina
- El sistema funciona sin dinero real, en su lugar se usa un sistema de puntos
- Los usuarios disponen de unos puntos para gastar en la máquina que el departamento de personal asigna.
- La maquina no concederá créditos, solo trabaja en base a los puntos disponibles.
- Para agilizar la reposición de lo consumido... la maquina debe controlar en stock

## Ejercicios de refuerzo

- Iniciación:
    1. <http://puntocomnoesunlenguaje.blogspot.com/p/ejercicios.html>
    2. <https://tutobasico.com/basicos-java/>
    3. <https://tutobasico.com/basicos2-java/>
    4. <https://www.discoduroderoer.es/ejercicios-propuestos-y-resueltos-basicos-java/>
    5. <https://www.discoduroderoer.es/ejercicios-propuestos-y-resueltos-metodos-y-funciones-de-java/>
- Intermedio:
    1. <https://tutobasico.com/basicos3-java/>
    2. <http://ejerciciosresueltosprogramacion.blogspot.com/>
    3. <https://www.discoduroderoer.es/ejercicios-propuestos-y-resueltos-programacion-orientado-a-objetos-java/>

# Curso de Spring

## Documentación

- https://docs.spring.io/spring-boot/docs/current/reference/html/
- https://docs.spring.io/spring-data/commons/docs/current/reference/html/
- https://docs.spring.io/spring-data/jpa/docs/current/reference/html/
- https://docs.spring.io/spring-data/mongodb/docs/current/reference/html/
- https://docs.spring.io/spring-data/redis/docs/current/reference/html/
- https://docs.spring.io/spring-framework/docs/current/reference/html/web.html#spring-web
- https://docs.spring.io/spring-data/rest/docs/current/reference/html/
- https://docs.spring.io/spring-cloud-commons/docs/current/reference/html/#spring-cloud-loadbalancer
- https://docs.spring.io/spring-cloud-config/docs/current/reference/html/
- https://docs.spring.io/spring-security/reference/index.html

## Ejemplos

- https://github.com/spring-projects/spring-data-examples
- https://github.com/spring-projects/spring-data-rest-webmvc
- https://github.com/spring-projects/spring-hateoas-examples

## Base de datos de ejemplos

- [Página principal Sakila](https://dev.mysql.com/doc/sakila/en/)
- [Diagrama de la BD Sakila](http://trifulcas.com/wp-content/uploads/2018/03/sakila-er.png)

## Paquetes Java

- https://downloads.mysql.com/archives/get/p/3/file/mysql-connector-java-5.1.49.zip  
- https://sourceforge.net/projects/hibernate/files/hibernate-orm/5.6.5.Final/hibernate-release-5.6.5.Final.zip/download

## Servidores en Docker

### Bases de datos

- docker run -d --name mysql-sakila -e MYSQL_ROOT_PASSWORD=root -p 3306:3306 jamarton/mysql-sakila

