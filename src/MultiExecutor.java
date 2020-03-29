import java.util.List;

public class MultiExecutor {

   private List<Runnable> tasks;
    /*
     * @param tasks to executed concurrently
     */
    public MultiExecutor(List<Runnable> tasks) {
        this.tasks=tasks;
    }

    /**
     * Starts and executes all the tasks concurrently
     */
    public void executeAll() {
       tasks.forEach(runnable -> new Thread(runnable).start());
    }
}