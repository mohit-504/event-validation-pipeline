//Main.java

package project;

import java.util.List;

import project.exception.InvalidEventException;
import project.exception.MissingFieldException;
import project.generate.DefaultEventGenerator;
import project.generate.EventGenerator;
import project.model.Event;
import project.model.EventType;
import project.transform.EventTransformer;
import project.validate.DefaultEventValidator;
import project.validate.EventValidator;

public class Main {
    public static void main(String[] args) throws MissingFieldException, InvalidEventException{
        // milestone1();
        // milestone2();
        // milestone3();
        milestone4();
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

    public static void milestone3() throws MissingFieldException, InvalidEventException {
        EventValidator validator = new DefaultEventValidator();
        Event e1 = Event.builder()
                        .eventId("E1")
                        .userId("U1")
                        .eventType(EventType.APP_OPEN)
                        .timestamp(System.currentTimeMillis())
                        .payload("sample")
                        .build();

        System.out.println(e1);
        validator.validate(e1);

        Event e2 = Event.builder()
                        .eventId("E2")
                        .userId("")
                        .eventType(null)
                        .timestamp(System.currentTimeMillis())
                        .payload("sample")
                        .build();

        System.out.println(e2);
        validator.validate(e2);
    }

    public static void milestone4(){
        Event originalEvent = Event.builder()
                        .eventId("E1")
                        .userId("U1")
                        .eventType(EventType.APP_OPEN)
                        .timestamp(System.currentTimeMillis())
                        .payload("   sample     ")
                        .build();

        System.out.println(originalEvent);

        Event newEvent = originalEvent.toBuilder()
                            .eventId("E2")
                            .eventType(EventType.USER_LOGIN)
                            .timestamp(System.currentTimeMillis())
                            .build();

        System.out.println(newEvent);

        EventTransformer trimTransformer = event -> event.toBuilder().payload(event.getPayload().trim()).build();
        EventTransformer upperCaseTransformer = event -> event.toBuilder().payload(event.getPayload().toUpperCase()).build();
        Event trimmedEvent = trimTransformer.transform(newEvent);
        Event upperCaseEvent =  upperCaseTransformer.transform(trimmedEvent);

        System.out.println(upperCaseEvent);

    }
}
