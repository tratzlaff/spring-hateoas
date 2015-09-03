package hello;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * In Spring’s approach to building RESTful web services, HTTP requests are handled by a controller.
 * The components are easily identified by the @Controller annotation, and this GreetingController
 * handles GET requests for /greeting by returning a new instance of the Greeting class.
 *
 * The @RequestMapping annotation ensures that HTTP requests to /greeting are mapped to the greeting() method.
 * We are not specifying GET vs. PUT, POST, and so forth, because @RequestMapping maps all HTTP operations by default.
 * Use @RequestMapping(method=GET) to narrow this mapping.
 *
 * @RequestParam binds the value of the query string parameter name into the name parameter of the greeting() method.
 * This query string parameter is not required; if it is absent in the request, the defaultValue of "World" is used.
 *
 * The @ResponseBody annotation on the greeting method will cause Spring MVC to render the returned HttpEntity and
 * its payload, the Greeting, directly to the response.
 *
 * The most interesting part of the method implementation is how you create the link pointing to the controller method
 * and how you add it to the representation model. Both linkTo(…) and methodOn(…) are static methods on
 * ControllerLinkBuilder that allow you to fake a method invocation on the controller.
 * The LinkBuilder returned will have inspected the controller method’s mapping annotation to build up exactly
 * the URI the method is mapped to.
 *
 * The call to withSelfRel() creates a Link instance that you add to the Greeting representation model.
 */
@Controller
public class GreetingController {

    private static final String TEMPLATE = "Hello, %s!";

    @RequestMapping("/greeting")
    @ResponseBody
    public HttpEntity<Greeting> greeting(
            @RequestParam(value = "name", required = false, defaultValue = "World") String name) {

        Greeting greeting = new Greeting(String.format(TEMPLATE, name));
        greeting.add(linkTo(methodOn(GreetingController.class).greeting(name)).withSelfRel());

        return new ResponseEntity<Greeting>(greeting, HttpStatus.OK);
    }
}
