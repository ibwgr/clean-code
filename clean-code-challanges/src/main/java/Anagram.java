import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/**
 * Given a word and a list of possible anagrams, select the correct sublist.
 * Wählen Sie aus einem gegebenen Wort und einer Liste möglicher Anagramme die richtige Teilliste aus.
 *
 * Given "listen" and a list of candidates like "enlists" "google" "inlets" "banana" the program should return a list containing "inlets".
 * Bei "listen" und einer Liste von Kandidaten wie "enlists" "google" "inlets" "banana" sollte das Programm eine Liste mit "inlets" zurückgeben.
 */
public class Anagram {
  private final String word;

  public Anagram(String word) {
    this.word = word;
  }

  String sortLetters(String word) {
    char[] letterArray = word.toLowerCase(Locale.ROOT).toCharArray();
    Arrays.sort(letterArray);
    return new String(letterArray);
  }

  public List<String> match(List<String> candidates) {
    List<String> matchingWords = new ArrayList<>();
    String sortedWords = sortLetters(this.word);
    for(String word : candidates) {
      String sortedWordToMatch = sortLetters(word);
      if(sortedWords.equals(sortedWordToMatch) && !this.word.toLowerCase(Locale.ROOT).equals(word.toLowerCase(Locale.ROOT))) {
        matchingWords.add(word);
      }
    }
    return matchingWords;
  }
}
