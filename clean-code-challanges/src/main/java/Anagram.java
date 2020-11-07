package main.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * Given a word and a list of possible anagrams, select the correct sublist.
 *
 * Given "listen" and a list of candidates like "enlists" "google" "inlets" "banana" the program should return a list containing "inlets".
 */
public class Anagram {

  private String word;

  public Anagram(String word) {
    this.word = word;

  }
  public String sortLetters(String word){
    char[] letterArray = word.toLowerCase().toCharArray();
    Arrays.sort(letterArray);
    String sorted = new String (letterArray);
    return sorted;
  }

  public List<String> match(List<String> candidates) {
    List<String> matchingWords = new ArrayList<>();

    String sortedWord = sortLetters(this.word);

    for (String word: candidates){
      String sortedWordMatchingList = sortLetters(word);
      if (sortedWord.equals(sortedWordMatchingList) && !this.word.toLowerCase().equals(word.toLowerCase())){
        matchingWords.add(word);
      }
    }
    return matchingWords;
  }
}


