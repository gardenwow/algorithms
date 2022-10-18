package org.example;

import org.example.Exception.EllementNotFoundExceptions;
import org.example.Exception.IndexErrorException;
import org.example.Exception.NullItemException;
import org.example.Exception.StringFullException;
import org.example.interf.StringList;

import java.util.Arrays;


public class IntegerList {
    private Integer[] integers;
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
        Integer[] itemCopy = toArray();
        bublesSort(itemCopy);
        return biSort(itemCopy, item);

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
            grow();
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

    public void bublesSort(Integer[] arr) {
        quickSort(arr, 0, arr.length-1);
    }

    private void quickSort(Integer[] arr, int begin, int end){
        if (begin < end) {
            int partitionIndex = partition(arr, begin, end);

            quickSort(arr, begin, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, end);
        }
    }
    private Integer partition(Integer[] arr, int begin, int end) {
        int pivot = arr[end];
        int i = (begin - 1);

        for (int j = begin; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;

                swapElements(arr, i, j);
            }
        }

        swapElements(arr, i + 1, end);
        return i + 1;
    }
    private void swapElements(Integer[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

    public boolean biSort(Integer[] arr, int element) {
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
    public void grow(){
        integers = Arrays.copyOf(integers, size + size / 2);
    }

}
