package org.example;

public class Main {
    public static void main(String[] args) {
        Integer[] arr = {90, 91, 93, 92, 85, 87, 84, 83, 0, 0, 0, 0};
        Integer[] arr1 = new Integer[100];
        System.out.println(arr.length);
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = (int) (Math.random() * 100);
        }



        IntegerList integerList = new IntegerList();

        Long start = System.currentTimeMillis();
        integerList.bublesSort(arr1);
        System.out.println(System.currentTimeMillis() - start);
        for (int s : arr1) {
            System.out.println(s);

        }
        System.out.println(integerList.biSort(arr1, 8));
    }
}
