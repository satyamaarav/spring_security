package array.Matrix;

import java.util.ArrayList;
import java.util.Scanner;

public class Try {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter row size: ");
        int row = sc.nextInt();

        System.out.println("Enter col size: ");
        int col = sc.nextInt();

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        for (int i = 0; i < row; i++) {
            ArrayList<Integer> list1 = new ArrayList<>();
            for (int j = 0; j < col; j++) {
                int num = sc.nextInt();
                list1.add(num);
            }
            list.add(list1);
        }

        System.out.println("list = " + list);

        var arrayLists = checkZero(list, row, col);
        System.out.println("arrayLists = " + arrayLists);
    }

   /* private static ArrayList<ArrayList<Integer>> checkZero(ArrayList<ArrayList<Integer>> list, int row, int col) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (list.get(i).get(j) == 0) {
                    setRow(list, col, i);
                    setCol(list, row, j);
                }
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (list.get(i).get(j) == -1) {
                    list.get(i).set(j, 0);
                }
            }
        }

        return list;
    }
    */
    private static ArrayList<ArrayList<Integer>> checkZero(ArrayList<ArrayList<Integer>> list, int row, int col) {
        int[] r = new int[row];
        int[] c = new int[col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (list.get(i).get(j) == 0) {
                   r[i] = -1;
                   c[j] = -1;
                }
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (r[i] == -1 || c[j] == -1 ) {
                    list.get(i).set(j, 0);
                }
            }
        }

        return list;
    }

    private static void setCol(ArrayList<ArrayList<Integer>> list, int row, int j) {
        for (int i = 0; i < row; i++) {
            if (list.get(i).get(j) != 0) {
                list.get(i).set(j, -1);
            }
        }
    }

    private static void setRow(ArrayList<ArrayList<Integer>> list, int col, int i) {
        for (int j = 0; j < col; j++) {
            if (list.get(i).get(j) != 0) {
                list.get(i).set(j, -1);
            }
        }
    }
}
