package asciimirror;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Input the file path:");
            String pathToFile = scanner.nextLine();
            File file = new File(pathToFile);
            Scanner fileScanner = new Scanner(file);
            List<String> list = new ArrayList<>();
            while (fileScanner.hasNextLine()) {
                list.add(fileScanner.nextLine());
            }
            int maxLengthLine = list.get(0).length();
            for (String s : list) {
                if (maxLengthLine < s.length()) {
                    maxLengthLine = s.length();
                }
            }
            for (int i = 0; i < list.size(); i++) {
                String s = list.get(i);
                int count = maxLengthLine - (s.length());
                for (int j = 0; j < count; j++) {
                    s += " ";
                }
                list.set(i, s);
            }
            for (String s : list) {
                System.out.println(s + " | " + reverseString(s));
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }

    public static String reverseString(String str) {
        str = new StringBuilder(str).reverse().toString();
        String[] arrayOfStr = str.split("");
        for (int i = 0; i < arrayOfStr.length; i++) {
            switch (arrayOfStr[i]) {
                case "<" -> arrayOfStr[i] = ">";
                case ">" -> arrayOfStr[i] = "<";
                case "[" -> arrayOfStr[i] = "]";
                case "]" -> arrayOfStr[i] = "[";
                case "{" -> arrayOfStr[i] = "}";
                case "}" -> arrayOfStr[i] = "{";
                case "(" -> arrayOfStr[i] = ")";
                case ")" -> arrayOfStr[i] = "(";
                case "/" -> arrayOfStr[i] = "\\";
                case "\\" -> arrayOfStr[i] = "/";
            }
        }
        String result = "";
        for (String s : arrayOfStr) {
            result += s;
        }
        return result;
    }
}