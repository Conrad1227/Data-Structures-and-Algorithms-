/**
 * Interface for simulation that makes objects act each hour and log their state.
 *
 * @author Conrad Hahn
 * @version 5/18/2025
 */
public interface Schedule {
    /**
     * Called each hour, allowing the object to perform an action. 
     */
    void action();
    /**
     * Will store the object’s current information into a log file. 
     */
    int log_status();
}
