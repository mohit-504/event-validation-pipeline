//Main.java

package project;

import java.util.List;

import project.generator.DefaultEventGenerator;
import project.generator.EventGenerator;
import project.model.Event;
import project.model.EventType;

public class Main {
    public static void main(String[] args) {
        // milestone1();
        milestone2();
    }

    public static void milestone1(){
        Event event = Event.builder()
                        .eventId("E1")
                        .userId("U1")
                        .eventType(EventType.APP_OPEN)
                        .timestamp(System.currentTimeMillis())
                        .payload("sample")
                        .build();

        System.out.println(event);
    }

    public static void milestone2(){
        EventGenerator generator = new DefaultEventGenerator();
        List<Event> events = generator.generateEvents(10_000);

        System.out.println(events.size());
        System.out.println(events.subList(0, 3)); //testing
    }
}
