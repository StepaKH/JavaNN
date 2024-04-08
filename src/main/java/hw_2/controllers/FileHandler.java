package hw_2.controllers;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class FileHandler {

    public static int BUFFER_SIZE = 1024;
    private File inputFile = null;
    private Map<Character, Integer> letters;

    public void setFile(File file){
        inputFile = file;
    }

    public String getPath(){
        return inputFile.getAbsolutePath();
    }

    public void countSymbols(){
        letters = new HashMap<>();
        for (char p = 'a'; p <= 'z'; p++){
            letters.put(p,0);
        }
        for (char p = 'A'; p <= 'Z'; p++){
            letters.put(p,0);
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))){
            char[] buffer = new char[BUFFER_SIZE];
            while ((reader.read(buffer,0, buffer.length)) != -1){
                for (char c : buffer) {
                    if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
                        letters.put(c, letters.get(c) + 1);
                    }
                }
            }
        }catch (IOException IoException){
            System.out.println("File reading error");
            IoException.printStackTrace();
        }
    }

    public void writeSymbols(File file){
        if (!file.exists()){
            try{
                file.createNewFile();
            }catch (IOException IoException){
                System.out.println("Error when creating a file to write");
                IoException.printStackTrace();
            }
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))){
            for (char p : letters.keySet()) {
                writer.write(p + " " + letters.get(p) + "\n");
            }
        } catch (IOException IoException){
            System.out.println("Error writing to file");
            IoException.printStackTrace();
        }
    }
}
