package com.BootcampApi.openApi

import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/airports")
class openApiController{
    @GetMapping("/hello")

    fun sayHello(): String? {
        return "{\"message\":\"hello from Spring Boot!\"}"
    }


}

