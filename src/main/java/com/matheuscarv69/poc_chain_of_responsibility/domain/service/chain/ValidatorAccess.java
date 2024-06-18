package com.matheuscarv69.poc_chain_of_responsibility.domain.service.chain;

import com.matheuscarv69.poc_chain_of_responsibility.application.request.AccessRequest;

public interface ValidatorAccess {

    void setNext(ValidatorAccess next);
    boolean execute(AccessRequest request);

}
