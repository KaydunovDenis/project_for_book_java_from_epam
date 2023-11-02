package g12.thread.task_2_library.model;

import java.util.Random;

public class Book {

    private static int count = 0;
    private int id;
    private boolean isOnlyInLibrary;

    private int countOfReading = 0;

    public Book() {
        Random random = new Random();
        this.isOnlyInLibrary = random.nextBoolean();
        count++;
        id = count;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Book.count = count;
    }

    public int getId() {
        return id;
    }

    public boolean isOnlyInLibrary() {
        return isOnlyInLibrary;
    }

    public void readThisBook() {
        countOfReading++;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", isOnlyInLibrary=" + isOnlyInLibrary +
                ", countOfReading=" + countOfReading +
                '}';
    }

}
