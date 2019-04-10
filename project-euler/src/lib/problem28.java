package lib;

public class problem28 {

    public static void main(String args[]){
        int size = 1001;
        int test [][] = build_spiral_matrix(size);
        int suma = 0;
        for(int i = 0; i < size; i++){
            for(int j=0; j < size; j++){
                if(i == j || i + j == size - 1) suma += test[i][j];
            }
        }
        System.out.println(suma);
    }

    public static int[][] build_spiral_matrix(int size){
        if(size % 2 == 0){
            System.out.println("Can't build odd size matrix");
            return null;
        }else{
            boolean not_done = true;
            int[][] spiral = new int[size][size];
            int value = 2;
            int i = size / 2;
            int j = size / 2;
            int right = 1;
            int down = 1;
            int left = 2;
            int up = 2;
            spiral[i][j] = 1;
            while(not_done){
                for(int k = 0; k < right; k++){
                    if((i == 0) && (j == size - 1)) break;
                    spiral[i][j+1] = value;
                    j++;
                    value++;
                }

                if((i == 0) && (j == size - 1)) break;

                for(int k = 0; k < down; k++){
                    spiral[i+1][j] = value;
                    value++;
                    i++;
                }
                for(int k = 0; k < left; k++){
                    spiral[i][j-1] = value;
                    value++;
                    j--;
                }
                for(int k = 0; k < up; k++){
                    spiral[i-1][j] = value;
                    value++;
                    i--;
                }
                right += 2;
                down += 2;
                left += 2;
                up += 2;
            }
            return spiral;
        }
    }
}
