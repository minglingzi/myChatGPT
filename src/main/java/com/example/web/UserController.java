package com.example.web;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.validation.Validated;
import io.micronaut.views.View;

@Controller("/user")
@Validated
public class UserController {

    private static final int MAX_FILE_SIZE = 5 * 1024 * 1024; // 5MB

    @Get("/")
    @View("upload")
    public HttpResponse index() {
        return (HttpResponse) HttpResponse.ok().body();
    }



}
