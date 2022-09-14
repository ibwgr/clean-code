import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/**
 * Given a word and a list of possible anagrams, select the correct sublist.
 * <p>
 * Given "listen" and a list of candidates like "enlists" "google" "inlets" "banana" the program should return a list containing "inlets".
 */
public class Anagram {

  private final String word;

  public Anagram(String word) {
    this.word = word;
  }

  public List<String> match(List<String> candidates) {
    List<String> matches = new ArrayList<>();
    String sortedAnagram = sortLetters(this.word);
    for (String candidate : candidates){
      String sortedCandidate = sortLetters(candidate);
      if (sortedAnagram.equals(sortedCandidate) && !this.word.toLowerCase(Locale.ROOT).equals(candidate.toLowerCase(Locale.ROOT))){
        matches.add(candidate);
      }
    }
    return matches;
  }

  private String sortLetters(String word){
    char [] letters = word.toLowerCase(Locale.ROOT).toCharArray();
    Arrays.sort(letters);
    return new String(letters);
  }
}
