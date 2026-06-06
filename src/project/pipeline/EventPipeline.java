// EventPipeline.java 

package project.pipeline;

import java.util.List;
import java.util.Map;

import project.model.Event;

public interface EventPipeline {
    public Map<String, List<Event>> process(List<Event> events);
}
