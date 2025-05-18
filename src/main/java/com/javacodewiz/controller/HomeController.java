package com.javacodewiz.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @Operation(summary = "Home endpoint",description = "Message For home Screen")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Message For home Sceen")
    })
    @GetMapping()
    public String home(){
        return "Welcome to Product Service";
    }
}
