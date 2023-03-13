package com.example.web;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Error;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Produces;
import io.micronaut.validation.Validated;
import io.micronaut.views.View;

import javax.validation.ConstraintViolationException;

@Controller("/user")
@Validated
public class UserController {

    private static final int MAX_FILE_SIZE = 5 * 1024 * 1024; // 5MB

    @Get("/")
    @View("upload")
    public HttpResponse index() {
        return (HttpResponse) HttpResponse.ok().body();
    }

    @Error(exception = ConstraintViolationException.class)
    @Produces(MediaType.TEXT_PLAIN)
    public HttpResponse<String> handleValidationError(ConstraintViolationException e) {
        // 在这里处理表单数据校验失败的情况，并返回HTTP响应
        String errorMessage = "Validation error: " + e.getMessage();
        return HttpResponse.status(HttpStatus.BAD_REQUEST).body(errorMessage);
    }


}
