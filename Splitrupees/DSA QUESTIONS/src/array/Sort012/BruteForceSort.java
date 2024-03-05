package array.Sort012;

import java.util.ArrayList;
import java.util.Scanner;

public class BruteForceSort {
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
        for (int i = 0; i < num - 1; i++) {
            for (int j = i + 1; j < num; j++) {
                if (list.get(i) > list.get(j)) {
                    int n = list.get(i);
                    int m = list.get(j);
                    list.set(i,m);
                    list.set(j,n);
                }
            }
        }
        
        return list;
    }
}
