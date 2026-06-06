// EventGenerator.java

package project.generate;

import java.util.List;

import project.model.Event;

public interface EventGenerator {
    List<Event> generateEvents(int count);
}
