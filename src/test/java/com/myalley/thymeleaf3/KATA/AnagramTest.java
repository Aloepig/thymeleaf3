package com.myalley.thymeleaf3.KATA;

import com.myalley.thymeleaf3.kata.anagram.Anagram;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;
import java.util.stream.Stream;


// Code Kata 1번
public class AnagramTest {

    static Anagram anagram;

    @BeforeAll
    static public void 파일읽기() {
        anagram = new Anagram("/src/main/resources/kata/word_list.txt", "documenting");
    }

    private List<String> getAnagramList() {
        FileReader fileReader;
        try {
            fileReader = new FileReader(System.getProperty("user.dir") + "/src/main/resources/kata/word_list.txt");
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

        System.out.println(anagramList.size());

        for (int a = 0; a < anagramList.size(); a++) {
            String word1 = anagramList.get(a);
            String[] anagramWord1 = word1.split("");

            for (String word2 : anagramList) {
                // anagramWord2 선택
                String[] anagramWord2 = word2.split("");
                // anagramWord1 + anagramWord2 = wordArray
                String[] sumWord = Stream.concat(Arrays.stream(anagramWord1), Arrays.stream(anagramWord2)).toArray(String[]::new);
                Arrays.sort(sumWord);

                if (Arrays.equals(wordArray, sumWord)) {
                    anagramWord.put(word1, word2);
                }
            }
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
    public void 파일읽기확인() {
        Assertions.assertNotNull(anagram.words);
        Assertions.assertEquals(1633, anagram.words.size());
    }

    @Test
    public void 소스단어정렬() {
        Assertions.assertEquals("cdegimnnotu", anagram.sortedSourceText);
    }

    @Test
    public void 일치하는단어목록() {
        List<String> words = new ArrayList<>();
        words.add("cdegi");
        words.add("mnnotu");

//        Assertions.assertEquals("cdegimnnotu", Anagram.run(words));
    }

}
