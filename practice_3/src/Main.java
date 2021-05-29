import java.util.TreeMap;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws Exception{
        TreeSet set = new TreeSet();
        ThreadSafeSet safeSet = new ThreadSafeSet();
        TreeMap map = new TreeMap();
        ThreadSafeMap safeMap = new ThreadSafeMap();
        Thread one = new Thread(()->{
            for (int i = 0; i < 1000000; i++) {
                safeSet.add(i/2);
                safeMap.put(i, i + 2);
                try {
                    map.put(i, i + 2);
                    set.add(i / 2);
                }catch (Exception e){}
            }
        });
        Thread two = new Thread(()->{
            for (int i = 0; i < 1000000; i++) {
                safeSet.add(i*4);
                safeMap.put(i*2, i + 2);
                try {
                    map.put(i*2, i + 2);
                    set.add(i*4);
                }catch (Exception e){}
            }
            for (int i = 0; i < 2000000; i++) {
                safeSet.remove(i/8);
                safeMap.remove(i/2);
                try {
                    set.remove(i / 8);
                    map.remove(i / 2);
                }catch (Exception e){}
            }
        });
        one.start();
        two.start();
        Thread.sleep(5000);
        System.out.println("set " + set.size());
        System.out.println("safeSet " + safeSet.size());
        System.out.println("map " + map.size());
        System.out.println("safeMap " + safeMap.size());
    }
}
