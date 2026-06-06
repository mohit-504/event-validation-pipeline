//Main.java

package project;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import project.analytics.DefaultEventAnalytics;
import project.analytics.EventAnalytics;
import project.exception.InvalidEventException;
import project.exception.MissingFieldException;
import project.generate.DefaultEventGenerator;
import project.generate.EventGenerator;
import project.model.Event;
import project.model.EventType;
import project.pipeline.DefaultEventPipeline;
import project.pipeline.EventPipeline;
import project.route.DefaultEventRouter;
import project.route.EventRouter;
import project.transform.EventTransformer;
import project.validate.DefaultEventValidator;
import project.validate.EventValidator;

public class Main {
    public static void main(String[] args) throws MissingFieldException, InvalidEventException{
        // milestone1();
        // milestone2();
        // milestone3();
        // milestone4();
        // milestone5();
        // milestone6();
        milestone7();
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

    public static void milestone5() throws InvalidEventException{
        EventGenerator generator = new DefaultEventGenerator();
        EventRouter router = new DefaultEventRouter();

        List<Event> events = generator.generateEvents(15);
        System.out.println(events.size());

        for(Event e : events){
            System.out.println(router.route(e));
        }
    }

    public static void milestone6(){
        EventGenerator generator = new DefaultEventGenerator();
        List<Event> events = generator.generateEvents(10_000);

        EventTransformer trimTransformer = event -> event.toBuilder().payload(event.getPayload().trim()).build();
        EventTransformer upperCaseTransformer = event -> event.toBuilder().payload(event.getPayload().toUpperCase()).build();

        List<EventTransformer> transformers = new ArrayList<>();
        transformers.add(trimTransformer);
        transformers.add(upperCaseTransformer);

        EventPipeline pipeline = new DefaultEventPipeline(new DefaultEventRouter(), transformers, new DefaultEventValidator());

        Map<String, List<Event>> topicMap;
        topicMap = pipeline.process(events);
        System.out.println("size: "+topicMap.size());
        // System.out.println("key set: "+topicMap.keySet());
        for(String key : topicMap.keySet()){
            System.out.println(key + " : " + topicMap.get(key).size());
        }
    }

    public static void milestone7(){
        EventGenerator generator = new DefaultEventGenerator();
        List<Event> events = generator.generateEvents(10_000);

        EventTransformer trimTransformer = event -> event.toBuilder().payload(event.getPayload().trim()).build();
        EventTransformer upperCaseTransformer = event -> event.toBuilder().payload(event.getPayload().toUpperCase()).build();

        List<EventTransformer> transformers = new ArrayList<>();
        transformers.add(trimTransformer);
        transformers.add(upperCaseTransformer);

        EventPipeline pipeline = new DefaultEventPipeline(new DefaultEventRouter(), transformers, new DefaultEventValidator());

        Map<String, List<Event>> topicMap;
        topicMap = pipeline.process(events);
        System.out.println("size: "+topicMap.size());

        EventAnalytics analytics = new DefaultEventAnalytics();
        System.out.println(analytics.getEventCountPerTopic(topicMap));

        List<Event> allEvents = new ArrayList<>(topicMap.values().stream().flatMap(List::stream).collect(Collectors.toList()));
        System.out.println(analytics.getEventCountPerType(allEvents));

        System.out.println(analytics.getTopUsers(allEvents, 5));
    }
}

