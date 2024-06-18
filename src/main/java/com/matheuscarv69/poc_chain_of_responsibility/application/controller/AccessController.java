package com.matheuscarv69.poc_chain_of_responsibility.application.controller;

import com.matheuscarv69.poc_chain_of_responsibility.application.request.AccessRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/access")
public class AccessController {

    private static final Logger log = LoggerFactory.getLogger(AccessController.class);

    @PostMapping
    public ResponseEntity<?> verifyAccess(@RequestBody final AccessRequest request) {

        log.info(request.toString());

        return ResponseEntity.ok().build();
    }

}
