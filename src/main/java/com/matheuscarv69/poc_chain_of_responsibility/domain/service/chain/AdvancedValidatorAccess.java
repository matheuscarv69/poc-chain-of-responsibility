package com.matheuscarv69.poc_chain_of_responsibility.domain.service.chain;

import com.matheuscarv69.poc_chain_of_responsibility.application.request.AccessRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

public class AdvancedValidatorAccess implements ValidatorAccess {

    private static final Logger log = LoggerFactory.getLogger(AdvancedValidatorAccess.class);
    private ValidatorAccess next;

    @Override
    public void setNext(ValidatorAccess next) {
        this.next = next;
    }

    @Override
    public boolean execute(AccessRequest request) {

        if (request.profile().equalsIgnoreCase("Advanced")) {

            log.info("Advanced Profile is Approved");

            return true;

        }

        if (Objects.nonNull(next)) {
            next.execute(request);
        }

        log.info("Profile is Not Approved or Unknown");

        return false;

    }

}
