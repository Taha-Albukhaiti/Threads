package derWegZumJavaProfi;

public final class ThreadUtils {
    public static void dumpThreads(){
        final ThreadGroup group = Thread.currentThread().getThreadGroup();
        final int activeCount = group.activeCount();
        final Thread[] threads = new Thread[activeCount];
        group.enumerate(threads);
        System.out.println("Thread-Group " + group + " contains " + activeCount + " Threads");
        for (final Thread thread: threads)
            System.out.println("Thread " + thread);
    }
    public static void main(String[] args) {
        dumpThreads();
    }
}
