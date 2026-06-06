package project.analytics;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import project.model.Event;
import project.model.EventType;

public class DefaultEventAnalytics implements EventAnalytics {

    @Override
    public Map<String, Long> getEventCountPerTopic(Map<String, List<Event>> topicMap) {
        return topicMap.entrySet()
                    .stream()
                    .collect(Collectors.toMap(entry -> entry.getKey(), entry -> (long) entry.getValue().size()));
    }

    @Override
    public Map<EventType, Long> getEventCountPerType(List<Event> events) {
        return events.stream()
            .collect(Collectors.groupingBy(Event::getEventType, Collectors.counting()));
    }

    @Override
    public Map<String, Long> getTopUsers(List<Event> events, int limit) {
        Map<String,Long> userCounts = events.stream()
                    .collect(Collectors.groupingBy(Event::getUserId, Collectors.counting()));
        
        return userCounts.entrySet()
                .stream()
                .sorted(Map.Entry.<String,Long>comparingByValue().reversed())
                .limit(limit)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a,b) -> a, LinkedHashMap::new));
    }
}
