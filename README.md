### Ejercicios Sesiones 4, 5 y 6


Crear un proyecto Spring Boot con las dependencias:

*H2
*Spring Data JPA
*Spring Web
*Spring Boot dev tools

Ejercicio 1:

    Crear una clase HelloController que sea un controlador REST.
    Dentro de la clase crear un metodo que retome el saludo.
    Probar que retoma el saludo desde el navegador y desde Postman.

Ejercicio 2:

    Crear las clases necesarias para trabajar con ordenadores
    -Laptop(entidad)
    -LaptopRepository(repositorio)
    -LaptopController(controlador)

    Desde LaptopController crear un metodo que devuelva una lista de objetos Laptop
    Probar que funciona en Postman
    Los objetos Laptop se pueden insertar desde el metodo main de la clase principal

Ejercicio 3:

    Crear un metodo en LaptopController que reciba un objeto Laptop enviado en formato JSON desde
    Postman y persistirlo en la base de datos
    Comprobar que al obtener de nuevo los laptops aparece el ordenador creado

### Ejercicios Sesiones 7, 8 y 9

Ejercicio 1

    Implementar los métodos CRUD en el API REST de Laptop creada en ejercicios anteriores.

    Los métodos CRUD:

    findAll(),findOneById(),create(),update(),delete(),deleteAll()

Ejercicio 2

    Implementar swagger sobre el API REST de Laptop y verificar que funciona en la URL:

    http://localhost:8082/swagger-ui/

    Recordar añadir la dependencia de Springfox-boot-strater desde mvnrepository.com para ejecutar Swagger 

Ejercicio 3

    Crear casos de test para el controlador de Laptop desde Spring Boot.

    Con click derecho dentro del código de la clase LaptopController utilizar la opción Generate > Test 
    para crear la clase con todos los tests unitarios e implementarlos siguiente el proceso visto en clase.