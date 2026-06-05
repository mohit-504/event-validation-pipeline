// DefaultEventGenerator.java

package project.generator;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import lombok.NoArgsConstructor;
import project.model.EventType;
import project.model.Event;

@NoArgsConstructor
public class DefaultEventGenerator implements EventGenerator {
    private final Random random = new Random();
    @Override
    public List<Event> generateEvents(int count) {
        EventType[] eventTypes = EventType.values();

        return IntStream.rangeClosed(1, count)
                        .mapToObj(i -> Event.builder()
                                                .eventId("E"+i)
                                                .userId("U"+random.nextInt(1000)) //for ~10k events, ~10 events per user
                                                .eventType(eventTypes[random.nextInt(eventTypes.length)])
                                                .timestamp(System.currentTimeMillis())
                                                .payload("payload-" + i)
                                                .build()
                        )
                        .toList();
                                            
    }
    
}
