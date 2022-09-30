package lib;
import java.util.*;

public class problem26 {

    public static void main(String args[]){
        Map<Integer, Integer> recurring_cycles = new HashMap<>();
        for(int i = 2; i < 1000; i++){
            int cycle_length = get_division_recurring_cycle(i, 1);
            recurring_cycles.put(i, cycle_length);
        }
        int number_with_max_cycle = get_key_with_max_value(recurring_cycles);
        System.out.println(number_with_max_cycle);
    }

    public static int get_division_recurring_cycle(int divisor, int dividend){
        boolean not_done = true;
        int cycle_length = 0;
        List<Integer> remainders = new ArrayList<>();
        while(not_done){
            while(dividend < divisor){
                dividend = dividend * 10;
                remainders.add(0);
            }
            int remainder = dividend % divisor;
            dividend = remainder * 10;
            if(remainders.contains(remainder)){
                not_done = false;
                int idx = remainders.indexOf(remainder);
                cycle_length = remainders.size() - idx;
            }else{
                remainders.add(remainder);
            }
        }
        return cycle_length;
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
