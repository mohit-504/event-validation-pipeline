// EventValidator.java

package project.validator;

import project.exception.InvalidEventException;
import project.exception.MissingFieldException;
import project.model.Event;

public interface EventValidator {
    void validate(Event event) throws MissingFieldException, InvalidEventException;
}
