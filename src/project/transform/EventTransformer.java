// EventTransformer.java 

package project.transform;

import project.model.Event;

//Anything calling itself an EventTransformer must know how to convert Event -> Event.
//How and what to convert is left upto the individual instance

@FunctionalInterface
public interface EventTransformer {
    public Event transform(Event event);
}
