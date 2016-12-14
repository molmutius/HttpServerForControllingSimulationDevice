package com.github.molmutius;

/**
 * @author Molmu on 14.12.2016.
 */
public class ResponseBodyModel
{
    private String message;

    public ResponseBodyModel(String message)
    {
        this.message = message;
    }

    public String getMessage()
    {
        return message;
    }
}
