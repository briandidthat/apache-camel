package com.templates.producer.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class FileRouter extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("file:files/input")
                // define route id for this route
                .routeId("Input-Files-Route")
                .transform().body(String.class)
                // start conditional logic block
                .choice()
                    .when(simple("${file:ext} ends with 'xml'"))
                        .log("XML FILE, SENDING TO /XML.")
                        .to("file:files/xml")
                    .when(simple("${file:ext} ends with 'json'"))
                        .log("JSON FILE, SENDING TO /JSON.")
                        .to("file:files/json")
                    .when(simple("${file:ext} ends with 'csv'"))
                        .log("CSV FILE, SENDING TO /CSV.")
                        .to("file:files/csv")
                    .otherwise()
                        .log("DIFFERENT FILE. SENDING TO OTHER")
                        .to("file:files/other")
                .end();

    }
}
