package com.matheuscarv69.poc_chain_of_responsibility.domain.service;

public interface ValidatorAccess {

    void setNext();
    void execute();

}
