
import java.util.Map.Entry;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.map.IMap;
public class Hazelcast {
    static HazelcastInstance hz = HazelcastClient.newHazelcastClient();
    static IMap<Integer, Integer> map = hz.getMap("TEST");
    public static void insert20kHazel(){
        long startTime = System.currentTimeMillis();
        for (int i = 1; i <= 20000; i++) {
            int randommNumber = (int)Math.ceil(Math.random()*10);
            map.put(i,randommNumber);
        }
        long finishTime = System.currentTimeMillis();
        long totalTime = finishTime - startTime;
        System.out.println("Total time for 20k data Hazelcast insert : "+totalTime+"ms");
    }
    public static void insert100kHazel(){
        long startTime = System.currentTimeMillis();
        for (int i = 1; i <= 100000; i++) {
            int randommNumber = (int)Math.ceil(Math.random()*10);
            map.put(i,randommNumber);
        }
        long finishTime = System.currentTimeMillis();
        long totalTime = finishTime - startTime;
        System.out.println("Total time for 100k data Hazelcast insert : "+totalTime+"ms");
    }

    public static void get20kHazel(){
        long startTime = System.currentTimeMillis();
        for (Entry<Integer,Integer> entry : map.entrySet()) {
            int i = 1 ;
            if (i==20000){
                break;
            }
            entry.getKey();
            entry.getValue();
            i++;
            entry.getKey();
            entry.getValue();
        }
        long finishTime = System.currentTimeMillis();
        long totalTime = finishTime - startTime;
        System.out.println("Total time for 20k data Hazelcast select : "+totalTime+"ms");
    }
    public static void get100kHazel(){
        long startTime = System.currentTimeMillis();
        for (Entry<Integer,Integer> entry : map.entrySet()) {
            int i = 1 ;
            if (i==100000){
                break;
            }
            entry.getKey();
            entry.getValue();
            i++;
        }
        long finishTime = System.currentTimeMillis();
        long totalTime = finishTime - startTime;
        System.out.println("Total time for 100k data Hazelcast select : "+totalTime+"ms");
    }



}
