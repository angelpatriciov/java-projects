package lib;
import java.util.*;

public class problem19 {

    public static void main(String args[]){
        Map<Integer, Integer> month_day_dict = new HashMap<Integer, Integer>()
        {{
           put(1, 31);
           put(2, 28);
           put(3, 31);
           put(4, 30);
           put(5, 31);
           put(6, 30);
           put(7, 31);
           put(8, 31);
           put(9, 30);
           put(10, 31);
           put(11, 30);
           put(12, 31);
        }};

        ArrayList<Integer> sunday_month_list = new ArrayList<>();
        ArrayList<ArrayList<Integer>> all_sunday_list = new ArrayList<ArrayList<Integer>>();
        int num_days;
        int first_sunday = 6;
        int next_sunday = first_sunday + 7;
        sunday_month_list.addAll(Arrays.asList(first_sunday, next_sunday));
        for(int year = 1901; year < 2001; year++){
            for(int i = 1; i < 13; i++){
                if(is_leap_year(year) & i ==2){
                    num_days = 29;
                }else{
                    num_days = month_day_dict.get(i);
                }
                while(next_sunday+7 <= num_days){
                    next_sunday += 7;
                    sunday_month_list.add(next_sunday);
                }
                ArrayList<Integer> sunday_list = new ArrayList<Integer>(sunday_month_list);
                all_sunday_list.add(sunday_list);
                sunday_month_list.clear();
                first_sunday = 7 - (num_days - next_sunday);
                next_sunday = first_sunday + 7;
                sunday_month_list.addAll(Arrays.asList(first_sunday, next_sunday));
            }
        }

        int sunday_count = 0;
        for(int i = 0; i < all_sunday_list.size(); i++){
            for(int j = 0; j < all_sunday_list.get(i).size(); j++){
                if(all_sunday_list.get(i).get(j) == 1){
                    sunday_count += 1;
                }
            }
        }
        System.out.println(sunday_count);
    }

    public static boolean is_leap_year(int year){
        String year_str = Integer.toString(year);
        String last_two_digits = year_str.substring(2,4);
        if(last_two_digits == "00"){
            if(year % 400 == 0){
                return true;
            }else{
                return false;
            }
        }else if(year % 4 == 0){
            return true;
        }else{
            return false;
        }
    }
}
