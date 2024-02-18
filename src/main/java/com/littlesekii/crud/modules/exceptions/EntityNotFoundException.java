package com.littlesekii.crud.modules.exceptions;

import java.io.Serial;

public class EntityNotFoundException extends RuntimeException{

    @Serial
    private static final long serialVersionUID = 8773106835386818382L;

    public EntityNotFoundException(String msg) {
        super(msg);
    }


}
