package array;

public class T {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5};
        
        for(int i=4;i>0;i--){
            int temp = arr[i];
            arr[i] = arr[i-1];
            arr[i-1] = temp;
        }

        for (int i = 0; i <5 ; i++) {
            System.out.println("arr[i] = " + arr[i]);
        }
        

    }
}
