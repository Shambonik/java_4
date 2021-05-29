import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        Executor myExecutor = new Executor(3);
        myExecutor.submit(() -> {
            try {

                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Wow");
        });
        myExecutor.submit(() -> {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("We run it");
        });
        myExecutor.submit(() -> System.out.println("Start"));
    }
}
