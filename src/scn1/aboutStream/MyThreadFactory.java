package scn1.aboutStream;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class MyThreadFactory implements ThreadFactory {
    private final AtomicInteger count = new AtomicInteger(1);
    private final String namePrefix;
    private final int priority;
    private final Boolean daemon;

    public MyThreadFactory(String namePrefix, int priority, Boolean daemon) {
        this.namePrefix = namePrefix;
        this.priority = priority;
        this.daemon = daemon;
    }

    @Override
    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r, namePrefix + "-thread-" + count.getAndIncrement());
        thread.setDaemon(daemon);
        thread.setPriority(priority);
        return thread;
    }
}
