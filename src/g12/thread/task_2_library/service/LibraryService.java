package g12.thread.task_2_library.service;

import g12.thread.task_2_library.model.Book;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class LibraryService {

    public static final int HOME_READING_TIME = 10000;
    public static final int LIBRARY_READING_TIME = 2000;
    public static final int MAX_COUNT_OF_BOOKS_FOR_READER = 10;

    private static BlockingQueue<Book> libraryBooks;
    private final static Random random = new Random();

    public LibraryService(int countOfBooks, int countOfReaders) {
        initLibrary(countOfBooks);
        initReaders(countOfReaders);

    }

    private void initLibrary(int count) {
        libraryBooks = new ArrayBlockingQueue<>(count);
        for (int i = 0; i < count; i++) {
            libraryBooks.add(new Book());
        }
    }

    private void initReaders(int count) {
        List<Reader> readers = new ArrayList<>(count);
        createAndStartReaders(count, readers);
        waitFinishingAllReaders(readers);
        printInfoAboutLibrary();
    }

    private static void createAndStartReaders(int count, List<Reader> readers) {
        for (int i = 0; i < count; i++) {
            Reader reader = new Reader();
            reader.setName("Thread-" + i);
            readers.add(reader);
            reader.start();
        }
    }

    private static void waitFinishingAllReaders(List<Reader> readers) {
        readers.forEach(reader -> {
            try {
                reader.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }

    private static void printInfoAboutLibrary() {
        libraryBooks.stream()
                .sorted(Comparator.comparingInt(Book::getId))
                .forEach(System.out::println);
    }


    public static class Reader extends Thread {
        private static int count = 0;
        private final int readerId;
        private LinkedList<Book> books = new LinkedList<>();

        public Reader() {
            count++;
            readerId = count;
        }

        @Override
        public void run() {
            super.run();
            try {
                getNewBooks();
                getBackBooks();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }

        private void getNewBooks() throws InterruptedException {
            int countBooks = random.nextInt(1, MAX_COUNT_OF_BOOKS_FOR_READER);
            for (int i = 0; i < countBooks; i++) {
                Book book = getBookInLibrary();
                readBookInLibrary(book);
            }
            System.out.printf("Reader-%d get %d from %d books.\n", readerId, books.size(), countBooks);
        }


        private Book getBookInLibrary() throws InterruptedException {
            Book book = libraryBooks.take();
            if (!book.isOnlyInLibrary()) {
                books.add(book);
            }
            System.out.printf("Reader-%d get a book-%d from library.\n", readerId, book.getId());
            return book;
        }

        private void readBookInLibrary(Book book) throws InterruptedException {
            if (book.isOnlyInLibrary()) {
                Thread.sleep(LIBRARY_READING_TIME);
                book.readThisBook();
                System.out.printf("Reader-%d has read a book-%d in library.\n", readerId, book.getId());
                returnBook(book);
            }
        }

        private void returnBook(Book book) {
            books.remove(book);
            libraryBooks.add(book);
            System.out.printf("Reader-%d return a book-%d to library\n", readerId, book.getId());
        }

        private void getBackBooks() throws InterruptedException {
            System.out.printf("Reader-%d started to read books at home.\n", readerId);
            books.forEach(Book::readThisBook);
            Thread.sleep(HOME_READING_TIME);
            List<Book> tempBooks = new ArrayList<Book>(books);
            tempBooks.forEach(this::returnBook);
            System.out.printf("Reader-%d has finished.\n", readerId);
        }

    }
}
