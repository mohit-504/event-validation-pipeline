// MissingFieldException.java 

package project.exception;

// used for userId missing or eventId missing
public class MissingFieldException extends Exception {
    
    public MissingFieldException(String message){
        super(message);
    }
}
