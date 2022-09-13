import java.util.*;

/**
 * Given a word and a list of possible anagrams, select the correct sublist.
 *
 * Given "listen" and a list of candidates like "enlists" "google" "inlets" "banana" the program should return a list containing "inlets".
 */
public class Anagram {
  private final String word;

  public Anagram(String word) {
    this.word = word.toLowerCase();

  }

  public List<String> match(List<String> candidates) {
    String sortedWord = stringSortAlphabet(word);
    List<String> result = new ArrayList<String>();
    for (String text:candidates) {
      if (!word.equals(text.toLowerCase())){
        if (sortedWord.equals(stringSortAlphabet(text.toLowerCase()))){
          result.add(text);
        }
      }
    }
    return result;
  }

  private String stringSortAlphabet(String word){
    char[] stringToChar = word.toCharArray();
    Arrays.sort(stringToChar);
    return new String(stringToChar);
  }

}
