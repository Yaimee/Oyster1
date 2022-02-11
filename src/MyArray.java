import java.util.Arrays;
import java.util.Scanner;
public class MyArray<T> {
    private int size = 0;
    private Object[] list;

    public MyArray()
    {
        list = new Object[2];
    }

    public void add(T element)
    {
        list[size] = element;
        size++;
        if (size == list.length)
        {
            expandArray();
        }
    }
    //shifts all elements 1 step to the right and inserts an element at the specified index
    public void insert(T element, int index)
    {
        if (index > size) {
            System.out.println("Index out of bounds");
        } else {
            size++;
            Object[] listBuffer = new Object[list.length];
            for (int i = 0; i < list.length; i++) {
                listBuffer[i] = list[i];
            }
            for (int i = index; i < size; i++) {
                if (i + 1 == list.length - 1) {
                    expandArray();
                }
                list[i + 1] = listBuffer[i];
            }
            list[index] = element;
        }
    }
    //insert "-k" as an argument, for rotating the list anticlockwise, or "k" for rotating clockwise
    public void rotateList(int k)
    {
        Object[] listBuffer = new Object[size];

        for (int i = 0; i < size; i++)
        {
            listBuffer[i] = list[i];
        }
        if (k > 0) {
            for (int i = 0; i < size; i++) {
                list[(i + k) % size] = listBuffer[i];
            }
        } else {
            for (int i = 0; i < size; i++) {
                list[i] = listBuffer[(i - k) % size];
            }
        }
    }

    public T get(int index)
    {
        return (T) list[index];
    }

    public void remove(int index)
    {
        if (index < 0 || index >=size) return;
        for (int i = index; i < size; i++)
        {
            list[i] = list[i + 1];
        }
        shrinkArray();
        size--;

    }

    public void clear()
    {
        size = 0;
        list = null;
    }

    public int size()
    {
        return size;
    }

    private void expandArray()
    {
        Object[] listBuffer = list;
        list = new Object[list.length * 2];
        for (int i = 0; i < listBuffer.length; i++)
        {
            list[i] = listBuffer[i];
        }
    }

    private void shrinkArray()
    {
        if (size == list.length / 2 && list.length != 2)
        {
            Object[] arrBuffer = list;
            list = new Object[list.length / 2];
            for (int i = 0; i < list.length; i++)
            {
                list[i] = arrBuffer[i];
            }
        }
    }

    @Override
    public String toString() {
        return "MyArray{" +
                "list=" + Arrays.toString(list) +
                '}';
    }
}
