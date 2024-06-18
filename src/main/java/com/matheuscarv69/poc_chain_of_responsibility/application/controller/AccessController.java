package com.matheuscarv69.poc_chain_of_responsibility.application.controller;

import com.matheuscarv69.poc_chain_of_responsibility.application.request.AccessRequest;
import com.matheuscarv69.poc_chain_of_responsibility.domain.service.VerifyAccessService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/access")
public class AccessController {

    private static final Logger log = LoggerFactory.getLogger(AccessController.class);

    @Autowired
    private VerifyAccessService verifyAccessService;

    @PostMapping
    public ResponseEntity<?> verifyAccess(@RequestBody final AccessRequest request) {

        log.info("Receiving request: {} - {}", request.name(), request.profile());

        final boolean isApproved = verifyAccessService.verify(request);

        return ResponseEntity.ok(isApproved);
    }

}
