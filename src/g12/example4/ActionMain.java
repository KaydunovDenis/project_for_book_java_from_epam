package g12.example4;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ActionMain {
    public static void main(String[] args) {
        List<Integer> list = IntStream.range(0, 100_000_000)
                .boxed()
                .collect(Collectors.toList());
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<Integer> future = executor.submit(new ActionCallable(list));
//        executor.shutdown();// stops service but not thread
//         executor.submit(new Thread());/* attempt to start will throw an exception */
         executor.shutdownNow(); // stops service and all running threads
        Stream.of(new ArrayList<>()).parallel().collect(Collectors.toList());
        try {
            System.out.println(future.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
