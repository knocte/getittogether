/*
 * Created on Aug 10, 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package org.git.client.daap.request;

/**
 * @author Greg
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class BadResponseCodeException extends Exception {
    public int response_code;
    public String response_message;
    
    public BadResponseCodeException(int cde, String msg) {
        super(cde+": "+msg);
        response_code = cde;
        response_message = msg;
        
    }
    
    public int getResponseCode() {
        return response_code;
    }
    
    public String getResponseMessage() {
        return response_message;
    }
    
}
