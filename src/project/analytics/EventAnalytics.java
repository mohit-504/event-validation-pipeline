package project.analytics;

import java.util.List;
import java.util.Map;
import project.model.Event;
import project.model.EventType;;

public interface EventAnalytics {
    public Map<String, Long> getEventCountPerTopic(Map<String, List<Event>> topicMap);
    public Map<EventType, Long> getEventCountPerType(List<Event> events);
    public Map<String, Long> getTopUsers(List<Event> events, int limit);
}
