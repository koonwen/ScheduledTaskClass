import java.time.Duration;
import java.time.LocalDateTime;


public class ScheduledTask extends Task implements Schedulable {

    private LocalDateTime startingTime;
    private Duration expectedDuration;
    private boolean isScheduled;

    public ScheduledTask(String name,
                         String description,
                         LocalDateTime deadline,
                         Duration estimatedDuration) {
        super(name, description, deadline, estimatedDuration);
    }

    @Override
    public String toString() {
        if (this.isScheduled)
            return "ScheduledTask{" +
                    "name='" + super.getName() +
                    ", startingTime=" + startingTime +
                    ", expectedDuration=" + expectedDuration +
                    '}';
        else
            return super.toString();
    }

    @Override
    public boolean schedule(LocalDateTime startingTime, Duration expectedDuration) {
        try {
            if (this.isScheduled)
                throw new Exception("Task already scheduled");
            else {
                this.startingTime = startingTime;
                this.expectedDuration = expectedDuration;
                this.isScheduled = true;
                return true;
            }
        } catch (Exception e) {
            System.out.println("[ERROR]:" + e);
            return false;
        }
    }

    @Override
    public boolean unschedule() {
        try {
            if (!this.isScheduled)
                throw new Exception("Task not scheduled");
            else {
                this.isScheduled = false;
                return true;
            }
        } catch (Exception e) {
            System.out.println("[ERROR]:" + e);
            return false;
        }
    }

    public static void main(String[] args) {
        // Create instances of ScheduledTask objects that are not initialized with startingTime and expectedDuration.
        // They are effectively inherited tasks with uninitialized starting and expectedDurations
        ScheduledTask test1 = new ScheduledTask("test1", "test description1,", LocalDateTime.of(2021, 1, 2, 12, 12), Duration.ofHours(2));
        ScheduledTask test2 = new ScheduledTask("test2", "test description2,", LocalDateTime.of(2030, 12, 12, 12, 12), Duration.ofHours(5));

        // Visualize unscheduled tasks
        System.out.println("============UnscheduledTasks============");
        System.out.println(test1 + "\n" + test2 + "\n");

        // call <ScheduledTask>.schedule(...) method to schedule the tasks
        test1.schedule(LocalDateTime.of(2020, 10, 12, 5, 5), Duration.ofHours(40));
        test2.schedule(LocalDateTime.of(2019, 5, 4, 5, 5), Duration.ofHours(50));

        // Visualize scheduled tasks
        System.out.println("============ScheduledTasks============");
        System.out.println(test1 + "\n" + test2 + "\n");

        // Remove both scheduled tasks from the schedule with ScheduledTask.unschedule() method
        test1.unschedule();
        test2.unschedule();

        // Test unscheduling task that is not schedule
        test1.unschedule();

        // Test that a scheduled task cannot be scheduled
        test1.schedule(LocalDateTime.of(2020, 10, 12, 5, 5), Duration.ofHours(40));
        test1.schedule(LocalDateTime.of(2020, 10, 12, 5, 5), Duration.ofHours(40));
    }
}
