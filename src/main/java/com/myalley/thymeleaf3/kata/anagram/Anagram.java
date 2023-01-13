package com.myalley.thymeleaf3.kata.anagram;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Anagram {

    public final List<String> words;
    public final String sourceText;
    public final String sortedSourceText;

    public Anagram(String fileUrl, String sourceText) {
        this.words = readFile(fileUrl);
        this.sourceText = sourceText;
        this.sortedSourceText = sorted(sourceText);
    }

    private List<String> readFile(String url) {
        FileReader fileReader;
        try {
            fileReader = new FileReader(System.getProperty("user.dir") + url);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        Scanner scanner = new Scanner(fileReader);
        List<String> words = new ArrayList<>();
        while (scanner.hasNext()) {
            words.add(scanner.next());
        }
        return words;
    }

    private String sorted(String sourceText) {
        return (Arrays.stream((sourceText.split(""))).sorted()).collect(Collectors.joining());
    }
}
