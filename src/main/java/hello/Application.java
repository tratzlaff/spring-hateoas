package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Although it is possible to package this service as a traditional web application archive or WAR file for
 * deployment to an external application server, the simpler approach demonstrated below creates a standalone
 * application. You package everything in a single, executable JAR file, driven by a good old Java main() method.
 * And along the way, you use Spring's support for embedding the Tomcat servlet container as the HTTP runtime,
 * instead of deploying to an external instance.
 *
 * The @SpringBootApplication is a convenience annotation that adds the following:
 *  - @Configuration tags the class as a source of bean definitions for the application context.
 *  - @EnableAutoConfiguration tells Spring Boot to start adding beans based on classpath settings, other beans,
 *    and various property settings.
 *  - Normally you would add @EnableWebMvc for a Spring MVC app, but Spring Boot adds it automatically when it
 *    sees spring-webmvc on the classpath. This flags the application as a web application and activates key
 *    behaviors such as setting up a DispatcherServlet.
 *  - @ComponentScan tells Spring to look for other components, configurations, and services in the hello package,
 *    allowing it to find the GreetingController.
 *
 *  The main() method uses Spring Boot's SpringApplication.run() method to launch an application.
 *
 *  You can run the application using ./gradlew bootRun or do the following:
 *  1) ./gradlew build
 *  2) java -jar build/libs/gs-rest-hateoas-0.1.0.jar
 *
 *  Now that the service is up, visit http://localhost:8080/greeting
 *
 *  To create a WAR file instead, see http://spring.io/guides/gs/convert-jar-to-war/.
 */
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
