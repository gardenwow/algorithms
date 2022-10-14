package org.example;

import org.example.Exception.EllementNotFoundExceptions;
import org.example.Exception.IndexErrorException;
import org.example.Exception.NullItemException;
import org.example.Exception.StringFullException;
import org.example.interf.StringList;

import java.lang.reflect.Array;
import java.util.Arrays;

public class StringListImpl implements StringList {
    private final String[] strings;
    private int size;

    public StringListImpl() {
        strings = new String[20];
    }

    public StringListImpl(int sizeList) {
        strings = new String[sizeList];
    }

    @Override
    public String add(String item) {
        validateItem(item);
        validateSize();
        strings[size++] = item;
        return item;
    }

    @Override
    public String add(int index, String item) {
        validateItem(item);
        validateIndex(index);
        validateSize();
        if (index == size) {
            strings[size++] = item;
        } else {
            System.arraycopy(strings, index, strings, index + 1, size - index);
            strings[index] = item;
            size++;
        }
        return item;
    }

    @Override
    public String set(int index, String item) {
        validateIndex(index);
        validateItem(item);
        strings[index] = item;
        return item;
    }

    @Override
    public String remove(String item) {
        validateItem(item);
        validateSize();
        int index = indexOf(item);
        if (index == -1) {
            throw new EllementNotFoundExceptions("элемент не найден");
        }
        if (index != size) {
            System.arraycopy(strings, index + 1, strings, index, size - index);
        }
        size--;
        return item;
    }

    @Override
    public String remove(int index) {
        validateIndex(index);
        if (index == -1) {
            throw new EllementNotFoundExceptions("элемент не найден");
        }
        String item = strings[index];
        if (index != size) {
            System.arraycopy(strings, index + 1, strings, index, size - index);
        }
        size--;
        return item;
    }

    @Override
    public boolean contains(String item) {
        return indexOf(item) != -1;
    }

    @Override
    public int indexOf(String item) {
        for (int i = 0; i < size; i++) {
            String s = strings[i];
            if (s.equals(item)) {
                return i;
            }
        }
        return -1;

    }

    @Override
    public int lastIndexOf(String item) {
        for (int i = size - 1; i >= 0; i--) {
            String s = strings[i];
            if (s.equals(item)) {
                return i;
            }

        }
        return -1;
    }

    @Override
    public String get(int index) {
        validateIndex(index);
        return strings[index];

    }

    @Override
    public boolean equals(StringList otherList) {
        return Arrays.equals(this.toArray(), otherList.toArray());
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        size = 0;

    }

    @Override
    public String[] toArray() {
        return Arrays.copyOf(strings, size);
    }

    private void validateItem(String item) {
        if (item == null) {
            throw new NullItemException("пустая строка");
        }
    }

    private void validateSize() {
        if (size == strings.length) {
            throw new StringFullException("вы заполнили размер");

        }
    }

    private void validateIndex(int index) {
        if (index < 0 || index > size) {
            throw new IndexErrorException("вы ввели не корректный индекс");
        }
    }
}
