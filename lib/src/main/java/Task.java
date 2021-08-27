import java.time.LocalDateTime;
import java.time.Duration;

public class Task {
    private String name;
    private String description;
    private LocalDateTime deadline;
    private Duration estimatedDuration;

    public Task(String name, String description, LocalDateTime deadline, Duration estimatedDuration) {
        this.name = name;
        this.description = description;
        this.deadline = deadline;
        this.estimatedDuration = estimatedDuration;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Task{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", deadline=" + deadline +
                ", estimatedDuration=" + estimatedDuration +
                '}';
    }

    public static void main(String[] args) {
        Task test = new Task("test task", "test description",
                LocalDateTime.of(2030, 12, 12, 12, 12),
                Duration.ofHours(10));
        System.out.println(test);
    }

}
