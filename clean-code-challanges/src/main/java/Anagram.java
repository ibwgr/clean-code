import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Given a word and a list of possible anagrams, select the correct sublist.
 *
 * Given "listen" and a list of candidates like "enlists" "google" "inlets" "banana" the program should return a list containing "inlets".
 */
public class Anagram {
  private final String word;
  private final char[] wordChars;

  public Anagram(String word) {
    this.word = word;
    this.wordChars = word.toLowerCase().toCharArray();
    Arrays.sort(wordChars);
  }

  public List<String> match(List<String> candidates) {
    List<String> anagrams;
    anagrams = candidates.stream()
      .filter(this::isAnagram)
      .collect(Collectors.toList());
    return anagrams;
  }

  private boolean isAnagram(String candidate){
    char[] candidateChars = candidate.toLowerCase().toCharArray();
    Arrays.sort(candidateChars);

    return !word.equalsIgnoreCase(candidate) && Arrays.equals(candidateChars, wordChars);
  }
}
