package com.matheuscarv69.poc_chain_of_responsibility.domain.service.chain;

import com.matheuscarv69.poc_chain_of_responsibility.application.request.AccessRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

public class StarterValidatorAccess implements ValidatorAccess {

    private static final Logger log = LoggerFactory.getLogger(StarterValidatorAccess.class);
    private ValidatorAccess next;

    @Override
    public void setNext(ValidatorAccess next) {
        this.next = next;
    }

    @Override
    public boolean execute(AccessRequest request) {

        if (request.profile().equalsIgnoreCase("Starter")) {

            log.info("Starter Profile is Approved");

            return true;

        }

        // verify if this class is last in the chain
        if (Objects.nonNull(next)) {
           return next.execute(request);
        }

        log.info("Starter Profile is Not Approved");

        return false;

    }

}
