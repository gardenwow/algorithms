package org.example;

import org.example.Exception.EllementNotFoundExceptions;
import org.example.Exception.IndexErrorException;
import org.example.Exception.NullItemException;
import org.example.Exception.StringFullException;
import org.example.interf.StringList;

import java.util.Arrays;

public class IntegerList {
    private final Integer[] integers;
    private int size;

    public IntegerList() {
        integers = new Integer[20];
    }

    public IntegerList(int sizeList) {
        integers = new Integer[sizeList];
    }


    public Integer add(Integer item) {
        validateItem(item);
        validateSize();
        integers[size++] = item;
        return item;
    }


    public Integer add(int index, Integer item) {
        validateItem(item);
        validateIndex(index);
        validateSize();
        if (index == size) {
            integers[size++] = item;
        } else {
            System.arraycopy(integers, index, integers, index + 1, size - index);
            integers[index] = item;
            size++;
        }
        return item;
    }


    public Integer set(int index, Integer item) {
        validateIndex(index);
        validateItem(item);
        integers[index] = item;
        return item;
    }


    public Integer remove(Integer item) {
        validateItem(item);
        validateSize();
        int index = indexOf(item);
        if (index == -1) {
            throw new EllementNotFoundExceptions("элемент не найден");
        }
        if (index != size) {
            System.arraycopy(integers, index + 1, integers, index, size - index);
        }
        size--;
        return item;
    }


    public Integer remove(int index) {
        validateIndex(index);
        if (index == -1) {
            throw new EllementNotFoundExceptions("элемент не найден");
        }
        Integer item = integers[index];
        if (index != size) {
            System.arraycopy(integers, index + 1, integers, index, size - index);
        }
        size--;
        return item;
    }


    public boolean contains(Integer item) {
        return indexOf(item) != -1;
    }


    public int indexOf(Integer item) {
        for (int i = 0; i < size; i++) {
            Integer s = integers[i];
            if (s.equals(item)) {
                return i;
            }
        }
        return -1;

    }

    public int lastIndexOf(Integer item) {
        for (int i = size - 1; i >= 0; i--) {
            Integer s = integers[i];
            if (s.equals(item)) {
                return i;
            }

        }
        return -1;
    }


    public Integer get(int index) {
        validateIndex(index);
        return integers[index];

    }


    public boolean equals(StringList otherList) {
        return Arrays.equals(this.toArray(), otherList.toArray());
    }


    public int size() {
        return size;
    }


    public boolean isEmpty() {
        return size == 0;
    }


    public void clear() {
        size = 0;

    }


    public Integer[] toArray() {
        return Arrays.copyOf(integers, size);
    }

    private void validateItem(Integer item) {
        if (item == null) {
            throw new NullItemException("пустая строка");
        }
    }

    private void validateSize() {
        if (size == integers.length) {
            throw new StringFullException("вы заполнили размер");

        }
    }

    private void validateIndex(int index) {
        if (index < 0 || index > size) {
            throw new IndexErrorException("вы ввели не корректный индекс");
        }
    }

    @Override
    public String toString() {
        return "IntegerList{" +
                "integers=" + Arrays.toString(integers) +
                '}';
    }

    public static void bublesSort(Integer[] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length -1 -i; j++) {
                if (arr[j]> arr[j+1]){
                    swapElements(arr, j, j+1);

                }
            }
        }

    }
    private static void swapElements(Integer[] arr, int indexA, int indexB) {
        int tmp = arr[indexA];
        arr[indexA] = arr[indexB];
        arr[indexB] = tmp;
    }
    public static boolean biSort(Integer[] arr, int element) {
        int min = 0;
        int max = arr.length - 1;

        while (min <= max) {
            int mid = (min + max) / 2;

            if (element == arr[mid]) {
                return true;
            }

            if (element < arr[mid]) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return false;
    }

}
