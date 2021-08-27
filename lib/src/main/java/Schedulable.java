import java.time.Duration;
import java.time.LocalDateTime;

public interface Schedulable {
    boolean schedule(LocalDateTime deadline, Duration estimatedDuration);
    boolean unschedule();
}
