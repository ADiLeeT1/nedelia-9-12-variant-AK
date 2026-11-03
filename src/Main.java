public class Main {

    public static void main(String[] args) {
        int messagesPerClient = 3;
        System.out.println("Main: starting to send bank notifications to 3 clients");

        // One Runnable task per client (fictional names)
        NotificationTask task1 = new NotificationTask("Client Aliya", messagesPerClient);
        NotificationTask task2 = new NotificationTask("Client Daniyar", messagesPerClient);
        NotificationTask task3 = new NotificationTask("Client Madina", messagesPerClient);

        // One Thread per client
        Thread thread1 = new Thread(task1, "Thread-1");
        Thread thread2 = new Thread(task2, "Thread-2");
        Thread thread3 = new Thread(task3, "Thread-3");

        // start() creates a new thread and calls run() in it - all 3 work at the same time
        thread1.start();
        thread2.start();
        thread3.start();

        // join() makes the main thread wait until each thread finishes
        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            System.out.println("Main: waiting was interrupted");
        }

        // Summary after all threads are finished
        int totalSent = 3 * messagesPerClient;
        System.out.println("Main: all threads have finished.");
        System.out.println("Main: total notifications sent: " + totalSent);
    }
}
