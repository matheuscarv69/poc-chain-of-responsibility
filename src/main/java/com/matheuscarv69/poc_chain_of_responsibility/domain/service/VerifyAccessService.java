package com.matheuscarv69.poc_chain_of_responsibility.domain.service;

import com.matheuscarv69.poc_chain_of_responsibility.application.request.AccessRequest;
import com.matheuscarv69.poc_chain_of_responsibility.domain.service.chain.AdvancedValidatorAccess;
import com.matheuscarv69.poc_chain_of_responsibility.domain.service.chain.IntermediateValidatorAccess;
import com.matheuscarv69.poc_chain_of_responsibility.domain.service.chain.StarterValidatorAccess;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class VerifyAccessService {

    private static final Logger log = LoggerFactory.getLogger(VerifyAccessService.class);

    public boolean verify(AccessRequest request) {

        final StarterValidatorAccess starterValidator = new StarterValidatorAccess();
        final IntermediateValidatorAccess intermediateValidator = new IntermediateValidatorAccess();
        final AdvancedValidatorAccess advancedValidator = new AdvancedValidatorAccess();

        starterValidator.setNext(intermediateValidator);
        intermediateValidator.setNext(advancedValidator);

        final boolean isApproved = starterValidator.execute(request);

        if (isApproved) {
            log.info("{} with {} Profile is Approved", request.name(), request.profile());
            return true;
        }

        log.info("{} with {} Profile is Not Approved", request.name(), request.profile());

        return false;

    }

}
