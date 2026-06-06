// DefaultEventPipeline.java 

package project.pipeline;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.AllArgsConstructor;
import project.exception.InvalidEventException;
import project.exception.MissingFieldException;
import project.model.Event;
import project.route.EventRouter;
import project.transform.EventTransformer;
import project.validate.EventValidator;

@AllArgsConstructor
public class DefaultEventPipeline implements EventPipeline {
    private final EventRouter router;
    private final List<EventTransformer> transformers;
    private final EventValidator validator;

    @Override
    public Map<String, List<Event>> process(List<Event> events) {
        Map<String, List<Event>> topicMap = new HashMap<>();
        for(Event event : events){
            try {
                validator.validate(event);
                Event transformedEvent = transformEvent(event);
                String route = router.route(transformedEvent);
                topicMap.computeIfAbsent(route, k -> new ArrayList<Event>())
                        .add(transformedEvent);
            }
            catch(MissingFieldException | InvalidEventException e) {
                System.err.println("Skipping malformed event " + event.getEventId() + ": " + e.getMessage());
            }
        }
        return topicMap;
    }

    public Event transformEvent(Event e){
        Event currentEvent = e;
        for(EventTransformer transformer : transformers){
            currentEvent = transformer.transform(currentEvent);
        }
        return currentEvent;
    }
    
}
