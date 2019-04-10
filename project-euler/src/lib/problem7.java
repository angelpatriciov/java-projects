package lib;

public class problem7 {

    private int value;

    public problem7(int value){
        this.value = value;
    }

    public static void main(String args[]){
        int prime_num = 2;
        int prime_pos = 1;
        while(prime_pos < 10001){
            prime_num = find_next_prime_after(prime_num);
            prime_pos += 1;
        }
        System.out.println(prime_num);
    }

    public boolean is_prime(){
        if (this.value == 0 | this.value ==1){
            return false;
        }else if(this.value == 2){
            return true;
        }else{
            for(int i = 2; i < Math.round(Math.sqrt(this.value)) + 1; i++){
                if(this.value % i == 0){
                    return false;
                }
            }
        }
        return true;
    }

    public static int find_next_prime_after(int num){
        boolean condition_not_met = true;
        int k;
        if(num % 2 == 0){
            k = num / 2;
        }else{
            k  = (num / 2) + 1;
        }
        num = 2 * k + 1;
        while(condition_not_met){
            problem7 number = new problem7(num);
            if(number.is_prime()){
                condition_not_met = false;
            }else{
                k++;
                num = 2 * k + 1;
            }
        }
        return num;
    }
}
