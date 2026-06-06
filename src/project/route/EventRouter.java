// EventRouter.java 

package project.route;

import project.exception.InvalidEventException;
import project.model.Event;

public interface EventRouter {
    public String route(Event event) throws InvalidEventException;
}
