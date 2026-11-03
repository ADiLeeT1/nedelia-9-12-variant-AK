/**
 * Task that sends several notifications to one bank client.
 * Implements Runnable, so it can be passed to a Thread.
 */
public class NotificationTask implements Runnable {

    private final String clientName;
    private final int messageCount;

    public NotificationTask(String clientName, int messageCount) {
        this.clientName = clientName;
        this.messageCount = messageCount;
    }

    // This code runs inside a NEW thread after thread.start() is called
    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + ": started sending notifications to " + clientName);

        for (int i = 1; i <= messageCount; i++) {
            System.out.println(threadName + ": notification " + i + "/" + messageCount + " sent to " + clientName);
            try {
                Thread.sleep(500); // pause to imitate sending time
            } catch (InterruptedException e) {
                System.out.println(threadName + ": sending to " + clientName + " was interrupted");
                return;
            }
        }

        System.out.println(threadName + ": all notifications sent to " + clientName);
    }
}
