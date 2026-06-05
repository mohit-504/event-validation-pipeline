// Event.java

package project.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
// import lombok.Setter;
// import lombok.Getter;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Event {
    private String eventId;
    private String userId;
    private EventType eventType;
    private long timestamp;
    private String payload;
}