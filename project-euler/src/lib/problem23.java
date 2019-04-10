package lib;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class problem23 {

    private int n;

    public problem23(int n) {
        this.n = n;
    }

    public static void main(String args[]){
        List<Integer> ab_list = new ArrayList<>();
        for(int i = 12; i < 28123-12; i++){
            problem23 number = new problem23(i);
            if(number.is_abundant()){
                ab_list.add(number.n);
            }
        }
        List<Integer> all_sums = get_all_cross_product_sums_lst(ab_list);
        Set<Integer> all_sums_set = new HashSet<>(all_sums);
        List<Integer> nums = IntStream.range(1, 28123).boxed().collect(Collectors.toList());
        Set<Integer> nums_set = new HashSet<>(nums);
        nums_set.removeAll(all_sums_set);
        int non_abundant_sum = nums_set.stream().mapToInt(Integer::intValue).sum();
        System.out.println(non_abundant_sum);
    }

    public List<Integer> get_proper_divisors() {
        List<Integer> all_divisors = new ArrayList<>();
        all_divisors.add(1);
        for (int i = 2; i < Math.floor(Math.sqrt(this.n) + 1); i++) {
            if (this.n % i == 0) {
                if (i == n / i) {
                    all_divisors.add(i);
                } else {
                    all_divisors.addAll(Arrays.asList(i, n / i));
                }
            }
        }
        return all_divisors;
    }

    public boolean is_abundant(){
        boolean flag = true;
        List<Integer> proper_divisors = get_proper_divisors();
        int sum_of_divisors = proper_divisors.stream().mapToInt(i -> i).sum();
        if(sum_of_divisors <= this.n){
            flag = false;
        }
        return flag;
    }

    public static List<Integer> get_all_cross_product_sums_lst(List<Integer> lst){
        int list_length = lst.size();
        List<Integer> sum_vec = new ArrayList<>();
        for(int i = 0; i < list_length; i++){
            for(int j = 0; j < list_length; j++){
                int suma = lst.get(i) + lst.get(j);
                sum_vec.add(suma);
            }
        }
        return sum_vec;
    }
}