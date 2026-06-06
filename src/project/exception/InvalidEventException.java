// InvalidEventException.java

package project.exception;

// used for timestamp in future or unknown event type or invalid format
public class InvalidEventException extends Exception {
    public InvalidEventException(String message){
        super(message);
    }
}
