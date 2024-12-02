package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            File myFile = new File("src/main/resources/input.txt");
            Scanner myReader = new Scanner(myFile);
            List<Integer> lhs = new ArrayList<>();
            List<Integer> rhs = new ArrayList<>();
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] words = data.split("   ");
                lhs.add(Integer.parseInt(words[0]));
                rhs.add(Integer.parseInt(words[1]));
            }

            lhs.sort(null);
            rhs.sort(null);
            int myResult = 0;
            for (int i = 0; i < lhs.size(); i++) {
                int tmp = 0;
                for (int j = 0; j < rhs.size(); j++) {
                    if (Integer.compare(lhs.get(i), rhs.get(j)) == 0) {
                        tmp++;
                    }
                }
                myResult += lhs.get(i) * tmp;
            }

            System.out.println(myResult);

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }

    }
}
