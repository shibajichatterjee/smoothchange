package com.rest.framework.exception;

import com.rest.framework.bean.MessageBean;

public class SystemException extends Exception {

    private static final long serialVersionUID = 1L;

    private String errorMessage;

  

    public String getErrorMessage() {

        return errorMessage;

    }

    public SystemException(String errorMessage)
    {

       super(errorMessage);

        this.errorMessage = errorMessage;

    }


}

