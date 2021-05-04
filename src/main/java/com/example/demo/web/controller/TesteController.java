package com.example.demo.web.controller;

import com.example.demo.web.dto.request.ParamRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/teste")
public class TesteController {

    @GetMapping
    public ResponseEntity<?> teste(@Validated ParamRequest paramRequest) {

        return ResponseEntity.ok(paramRequest);

    }

}
