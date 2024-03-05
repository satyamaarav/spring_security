package array.Sort012;

import java.util.ArrayList;
import java.util.Scanner;

public class BetterApprSort012 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the list: ");
        int num = sc.nextInt();
        System.out.print("Enter the value of the list: ");
        for (int i = 0; i < num; i++) {
            int val = sc.nextInt();
            list.add(val);
        }

        System.out.println("list = " + list);

        var sortedList = sortList(list, num);

        System.out.println("sortedList = " + sortedList);
    }

    private static ArrayList<Integer> sortList(ArrayList<Integer> list, int num) {
        int c_0 = 0;
        int c_1 = 0;
        int c_2 = 0;

        ArrayList<Integer> sortedList = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            if(list.get(i)==0){
                c_0 = c_0 +1;
            } else if (list.get(i)==1) {
                c_1 = c_1 + 1;
            }else {
                c_2 = c_2 + 1;
            }
        }

        for(int i=0;i<c_0;i++){
            sortedList.add(0);
        }

        for(int i=0;i<c_1;i++){
            sortedList.add(1);
        }

        for(int i=0;i<c_2;i++){
            sortedList.add(2);
        }

        return sortedList;
    }
}
