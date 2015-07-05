package com.gmail.miv.repeatability_of_letters;


import java.io.*;
import java.util.*;

//        Считайте из файла текст на английском языке, вычислите
//        относительную частоту повторения каждой буквы и выведите на
//        экран результат в порядке убывания относительной частоты
//        повторения

public class Main {

    public static void main(String[] args) {

        Map<Character, Integer> charFreq = new HashMap<Character, Integer>();

        try (FileReader reader = new FileReader("src/com/gmail/miv/repeatability_of_letters/MobyDick.txt")) {
            int c;
            while ((c = reader.read()) != -1) {
                Integer count = charFreq.get((char) c);
                int newCount = (count == null ? 1 : count + 1);
                charFreq.put((char) c, newCount);
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("src/com/gmail/miv/repeatability_of_letters/MobyDick_result.txt"));
            PrintWriter printWriter = new PrintWriter(writer);
            charFreq.entrySet().stream()
                    .sorted((e1, e2) -> -Integer.compare(e1.getValue(), e2.getValue()))
                    .forEach(e -> printWriter.println("Char = " + e.getKey() + " freq = " + e.getValue()));
            printWriter.flush();
            printWriter.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

}
