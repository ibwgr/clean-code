import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * Given a word and a list of possible anagrams, select the correct sublist.
 *
 * Given "listen" and a list of candidates like "enlists" "google" "inlets" "banana" the program should return a list containing "inlets".
 */
public class Anagram {

  private final String word;

  public Anagram(String word) {
    this.word = word;
  }

  public List<String> match(List<String> candidates) {
    List<String> foundAnagrams = new ArrayList<>();
    char[] wordChars = this.word.toLowerCase().toCharArray();

    Arrays.sort(wordChars);

    for (String candidate : candidates) {
      char[] candidateChars = candidate.toLowerCase().toCharArray();
      Arrays.sort(candidateChars);
      if(Arrays.equals(wordChars,candidateChars) && !this.word.equalsIgnoreCase(candidate)){
        foundAnagrams.add(candidate);
      }
    }

    return foundAnagrams;

  }
}
