package g12.thread.task_1_port.util;

public class CapacityProgressBar {
    public static String getProgressBar(int currentCapacity, int maxCapacity) {
        StringBuilder progressBar = new StringBuilder("[");
        int progressLength = currentCapacity;
        for (int i = 0; i < maxCapacity; i++) {
            if (i < progressLength) {
                progressBar.append("=");
            } else {
                progressBar.append("_");
            }
        }
        progressBar.append("]");
        return progressBar.toString();
    }
}
