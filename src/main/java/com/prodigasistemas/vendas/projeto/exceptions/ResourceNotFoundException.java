package com.prodigasistemas.vendas.projeto.exceptions;

import static com.prodigasistemas.vendas.projeto.utils.Constants.NOT_FOUND;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(Object name) {
        super(NOT_FOUND + name);
    }
}
