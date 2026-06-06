// DefaultEventRouter.java 

package project.route;

import project.exception.InvalidEventException;
import project.model.Event;

public class DefaultEventRouter implements EventRouter {

    @Override
    public String route(Event event) throws InvalidEventException{
        String route=null;
        switch (event.getEventType()) {
            case USER_LOGIN:
                route = "user-topic";
                break;
            
            case PURCHASE:
                route = "purchase-topic";
                break;
            
            case APP_OPEN:
                route = "analytics-topic";
                break;

            case PUSH_CLICK:
                route = "behavior-topic";
                break;

            default:
                throw new InvalidEventException("An issue occured.");
        }
        return route;
    }
    
}
