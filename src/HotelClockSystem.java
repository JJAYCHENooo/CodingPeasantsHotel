import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class HotelClockSystem {
    private Map<String, Clock> cityClocks = new HashMap<>();

    public void addClock(String name, Clock clock) {
        cityClocks.put(name, clock);
    }

    public void updateCityClocksWithUTCZeroTime(LocalDateTime localDateTime) {
        for (Clock clock : cityClocks.values()) {
            clock.setLocalDateTime(localDateTime.plusHours(clock.UTCOffset));
        }
    }
}
