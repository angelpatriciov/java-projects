package lib;
import java.util.*;

public class problem14 {

    public static void main(String args[]){
        Map<Integer, Integer> coll_pair = new HashMap<>();
        for(int i = 2; i < 1000000; i++){
            ArrayList<Long> coll_list = new ArrayList<>(compute_collatz_starting_at(i));
            coll_pair.put(i, coll_list.size());
        }
        System.out.println(get_key_with_max_value(coll_pair));
    }

    public static ArrayList<Long> compute_collatz_starting_at(long n){
        ArrayList<Long> collatz_list = new ArrayList<>();
        while(n != 1){
            if(n%2 == 0){
                n = n / 2;
            }else{
                n = 3 * n + 1;
            }
            collatz_list.add(n);
        }
        return collatz_list;
    }

    public static int get_key_with_max_value(Map<Integer, Integer> map){
        int maxEntryValue = 0;
        int maxEntryKey = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (maxEntryValue == 0 || entry.getValue() > maxEntryValue) {
                maxEntryValue = entry.getValue();
                maxEntryKey = entry.getKey();
            }
        }
        return maxEntryKey;
    }

}
