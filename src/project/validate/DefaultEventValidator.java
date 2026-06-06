// DefaultEventValidator.java

package project.validate;

// import java.util.Arrays;

import project.exception.InvalidEventException;
import project.exception.MissingFieldException;
import project.model.Event;
// import project.model.EventType;

public class DefaultEventValidator implements EventValidator {

    @Override
    public void validate(Event event) throws MissingFieldException, InvalidEventException {
        if(event.getEventId()==null || event.getEventId().isBlank()){
            throw new MissingFieldException("Event contains one or more blank fields.");
        }

        if(event.getUserId()==null || event.getUserId().isBlank()){
            throw new MissingFieldException("Event contains one or more blank fields.");
        }

        if(event.getPayload()==null || event.getPayload().isBlank()){
            throw new MissingFieldException("Event contains one or more blank fields.");
        }

        if(event.getEventType()==null){
            throw new MissingFieldException("Event contains one or more blank fields.");
        }

        if(event.getTimestamp() > System.currentTimeMillis()){
            throw new InvalidEventException("Event timestamp invalid. ");
        }
    }
    
}
