package com.salihpolat.soru3;

public class MyArrayList<T> {
    private static final int KAPASITE = 10;
    private Object[] elemanlar;
    private int diziUzunlugu;

    public MyArrayList() {
        elemanlar = new Object[KAPASITE];
        diziUzunlugu = 0;
    }

    public void add(T element) {
        if (diziUzunlugu == elemanlar.length) {
            increaseCapacity();
        }
        elemanlar[diziUzunlugu++] = element;
    }

    public void add(int index, T element) {
        if (index < 0 || index > diziUzunlugu) {
            throw new IndexOutOfBoundsException();
        }
        if (diziUzunlugu == elemanlar.length) {
            increaseCapacity();
        }
        for (int i = diziUzunlugu; i > index; i--) {
            elemanlar[i] = elemanlar[i - 1];
        }
        elemanlar[index] = element;
        diziUzunlugu++;
    }

    public T get(int index) {
        if (index < 0 || index >= diziUzunlugu) {
            throw new IndexOutOfBoundsException();
        }
        return (T) elemanlar[index];
    }

    public void set(int index, T element) {
        if (index < 0 || index >= diziUzunlugu) {
            throw new IndexOutOfBoundsException();
        }
        elemanlar[index] = element;
    }

    public void remove(int index) {
        if (index < 0 || index >= diziUzunlugu) {
            throw new IndexOutOfBoundsException();
        }
        for (int i = index; i < diziUzunlugu - 1; i++) {
            elemanlar[i] = elemanlar[i + 1];
        }
        elemanlar[diziUzunlugu - 1] = null;
        diziUzunlugu--;
    }

    public boolean contains(T element) {
        for (int i = 0; i < diziUzunlugu; i++) {
            if (elemanlar[i].equals(element)) {
                return true;
            }
        }
        return false;
    }

    public int size() {
        return diziUzunlugu;
    }

    public boolean isEmpty() {
        return diziUzunlugu == 0;
    }

    private void increaseCapacity() {
        int newCapacity = elemanlar.length * 2;
        Object[] newElements = new Object[newCapacity];
        System.arraycopy(elemanlar, 0, newElements, 0, diziUzunlugu);
        elemanlar = newElements;
    }
}