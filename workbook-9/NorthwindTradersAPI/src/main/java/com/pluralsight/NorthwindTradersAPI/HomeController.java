package com.pluralsight.NorthwindTradersAPI;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// rest controller marks a class to be used to http requests

@RestController
public class HomeController {
        // this method will respond to http://localhost:8080/
    // request mapping registers the path the function will respond to.
        // path is the resource path and method specifics the verb the method will respond to
        @RequestMapping(path="/", method= RequestMethod.GET)
        public String index(
                @RequestParam(defaultValue="World") String country
        ) {
            return "Hello " + country + "!";
        }
    }

/*
http://localhost:8080 -> Hello World!
http://localhost:8080?name=Bob -> Hello Bob!
http://localhost:8080?name=Cindy -> Hello Cindy!
*/
