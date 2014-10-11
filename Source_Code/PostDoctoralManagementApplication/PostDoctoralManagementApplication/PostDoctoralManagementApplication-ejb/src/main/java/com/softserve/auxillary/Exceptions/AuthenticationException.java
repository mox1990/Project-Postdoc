/*
 * This file is copyrighted to the authors stated below.
 * Any duplication or modifications or usage of the file's contents               
 * that is not approved by the stated authors is prohibited.
 */

package com.softserve.auxillary.Exceptions;

/**
 *
 * @author SoftServe Group [ Mathys Ellis (12019837) Kgothatso Phatedi Alfred
 * Ngako (12236731) Tokologo Machaba (12078027) ]
 */
public class AuthenticationException extends Exception{

    public AuthenticationException(String message, Throwable cause) 
    {
        super(message, cause);
    }
    
    public AuthenticationException(String message) 
    {
        super(message);
    }  
    
    
    
}