package com.gmail.miv.deque;


import java.util.ArrayDeque;
import java.util.Random;


//        Написать метод, который создаст список, положит в него 10
//        элементов, затем удалит первые два и последний, а затем выведет
//        результат на экран
public class Main {

    public static void main(String[] args) {

        Random random = new Random();

        ArrayDeque<Integer> arrayDeque = new ArrayDeque<Integer>();

        int length = 10 + random.nextInt(10);
        for (int i = 0; i < length; i++) {
            arrayDeque.add(random.nextInt(100));
        }

        System.out.println(arrayDeque);

        arrayDeque.pollFirst();
        arrayDeque.pollFirst();

        arrayDeque.pollLast();

        System.out.println(arrayDeque);

    }
}
