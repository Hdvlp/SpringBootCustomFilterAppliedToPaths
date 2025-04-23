package com.springbootcustomfilterappliedtopaths.demo.controller;

import org.springframework.web.bind.annotation.RestController;

import jakarta.websocket.server.PathParam;

import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class WebController {

    @GetMapping("/")
    public String getIndex() {
        return 
            String.format("<div><a href=\"%1$s\">%1$s</div>", "/api/v1/") +
            String.format("<div><a href=\"%1$s\">%1$s</div>", "/api/v2") +
            String.format("<div><a href=\"%1$s\">%1$s</div>", "/api/v2/page/3") +
            String.format("<div><a href=\"%1$s\">%1$s</div>", "/profile/users/alexander/page/5") +
            String.format("<div><a href=\"%1$s\">%1$s</div>", "/custom/users/elizabeth/page/7") +
            String.format("<div><a href=\"%1$s\">%1$s</div>", "/custom/long/path/users/felix/page/9") +
            String.format("<div><a href=\"%1$s\">%1$s</div>", "/login");
    }

    @GetMapping("/api/v1/")
    public String getApiV1() {
        return new String("/api/v1/");
    }

    @GetMapping("/api/*")
    public String getApiAsterisks() {
        return new String("/api/*");
    }
    
    @GetMapping("/*/users/{userId}/**")
    public String getUsersUserId() {

        return new String("/*/users/{userId}/**");
    }


    @GetMapping("/login")
    public String getLogin(@PathParam("userId") String userId) {
        return new String("/login");
    }


}
