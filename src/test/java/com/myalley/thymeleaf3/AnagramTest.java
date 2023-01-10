package com.myalley.thymeleaf3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;
import java.util.stream.Stream;


// Code Kata 1번
public class AnagramTest {

    private List<String> getAnagramList() {
        FileReader fileReader;
        try {
            fileReader = new FileReader(System.getProperty("user.dir") + "/src/main/resources/word_list.txt");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        Scanner scanner = new Scanner(fileReader);
        List<String> anagramList = new ArrayList<>();
        while (scanner.hasNext()) {
            anagramList.add(scanner.next());
        }

        // 파일읽기
        Assertions.assertNotNull(scanner);
        // anagram 목록
        Assertions.assertEquals(1633, anagramList.size());

        return anagramList;
    }

    // 정렬된 단어
    private String[] getSortedWord() {
        String[] wordArray = "documenting".split("");
        Arrays.sort(wordArray);
        Assertions.assertEquals("cdegimnnotu", String.join("", wordArray));
        return wordArray;
    }

    private Map<String, String> getSelectedWord(String[] wordArray, List<String> anagramList) {
        Map<String, String> anagramWord = new HashMap<>();

        for (String word1 : anagramList) {
            String[] anagramWord1 = word1.split("");

            anagramList.forEach(word2 -> {
                if ((word1 + word2).length() != 11) {
                    return;
                }
                // anagramWord2 선택
                String[] anagramWord2 = word2.split("");
                // anagramWord1 + anagramWord2 = wordArray
                String[] sumWord = Stream.concat(Arrays.stream(anagramWord1), Arrays.stream(anagramWord2)).toArray(String[]::new);
                Arrays.sort(sumWord);

                if (!Objects.equals(sumWord[0], "c")) {
                    return;
                }

                if (Arrays.equals(wordArray, sumWord)) {
                    anagramWord.put(word1, word2);
                }

            });
        }
        return anagramWord;
    }

    @Test
    public void getText() {
        // 파일읽기
        List<String> anagramList = getAnagramList();
        // 단어정렬
        String[] wordArray = getSortedWord();
        // 단어선택
        Map<String, String> anagramWord = getSelectedWord(wordArray, anagramList);

        System.out.println(anagramWord);
    }

    @Test
    public void TTT() {
        int[] a = {1, 4, 2};
        int[] b = {1, 2, 4};
        Arrays.sort(a);
        Arrays.sort(b);
        if (Arrays.equals(a, b)) {
            System.out.println("ok");
        }
    }
}