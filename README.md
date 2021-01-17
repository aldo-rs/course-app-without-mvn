# CourseApp

## Introducción

El objetivo de la App es mostrar el uso de las APIs básicas de java (Servlets, JDBC, Generic, etc.), no se ha utilizado ningún framework para su desarrollo. Otro objetivo es mostrar la implementación de algunos patrones de diseño, tanto [GoF](https://en.wikipedia.org/wiki/Software_design_pattern) como del catálogo [J2EE](https://www.oracle.com/java/technologies/design-patterns-catalog.html), además se ha implementado un contenedor de beans sencillo. 

La App en sí lo que hace es gestionar un catálogo de cursos. Las dos funcionalidades que se han implementado son el listado y el alta de cursos.


## Herramientas y librerías

Las librerías son:

* Java 8
* JSTL 1.2
* IDE: Eclipse 2020-12 (4.18.0)
* Servidor de aplicación: Tomcat 9
* Base de datos: H2 version 1.4.196


## Patrones de diseño implementados

Los patrones implementados son:

* [FrontController](https://en.wikipedia.org/wiki/Front_controller): Servlet que recibe todas las peticiones y delega en una factoría la creación del comando específico que va a procesar la petición.
* [Factory](https://en.wikipedia.org/wiki/Factory_method_pattern): El la App el componente que implementa este patrón es el CommandFactory. Su responsabilidad es crear los comandos específicos a partir del path de la petición. Para crear los comandos se apoya en el componente BeanFactory.
* [Command](https://en.wikipedia.org/wiki/Command_pattern): Cada petición recibida es manejada por un commando que es el encargado de realizar una acción.
* [Data access Object (DAO)](https://es.wikipedia.org/wiki/Objeto_de_acceso_a_datos): Son los objetos que se encargan de realizar las consultas a la base de datos.
* [Inyección de dependencia](https://es.wikipedia.org/wiki/Inyecci%C3%B3n_de_dependencias): A partir de un fichero (bean-defs.json) donde se definen todos los beans y sus dependencias, el componente BeanFactory carga los beans ya ensamblados, es decir, con los componente de los que depende ya *seteados*.


## Base de datos

La base de datos utilizada es H2. Un vez arranca la App el componente *com.codetodo.courseapp.web.CourseDBInitializer* crea las tablas e inserta los datos mestros necesarios.

Para consultar la BBDD, una vez desplegado el proyecto, acceder a la url http://localhost:8080/course-app/console.











