package lib;
import java.util.*;

public class problem10 {

    private int number;

    public problem10(int number){
        this.number = number;
    }

    public static long sum_list(List<Integer> list) {
        int sum = 0;
        for (int i: list) {
            sum += i;
        }
        return sum;
    }

    public long get_sum_of_primes_below_number(){
        boolean[] prime_array = new boolean[this.number];
        Arrays.fill(prime_array, true);
        boolean condition_not_met = true;
        int p = 2;
        int nums_crossed = 0;
        while(condition_not_met){
            if(prime_array[p]){
                nums_crossed = 0;
                for(int i = p*2; i < this.number; i += p){
                    if(prime_array[i]){
                        prime_array[i] = false;
                        nums_crossed++;
                    }
                }
            }
            if(nums_crossed < 1){
                condition_not_met = false;
            }else{
                p++;
            }
        }

        long sum_of_primes = 0;
        for(int i = 2; i < this.number; i++){
            if(prime_array[i]){
                sum_of_primes += i;
            }
        }
        return sum_of_primes;
    }
}
