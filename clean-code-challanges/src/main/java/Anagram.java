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

  public List<String> match(List<String> candidates) {

    List <String> anagrams = new ArrayList<>();
    String sortedWord = getSortedWord(word);

    if (candidates == null || candidates.size() == 0) {
      return null;
    }

    for (String candidate : candidates) {
      if (word.toLowerCase().equals(candidate.toLowerCase())) {
        continue;
      }
      String sortedCandidate = getSortedWord(candidate);
      if (sortedWord.equals(sortedCandidate)) {
        anagrams.add(candidate);
      }
    }
    return anagrams;
  }

  public String getSortedWord(String word) {
    char [] letters = word.toLowerCase().toCharArray();
    Arrays.sort(letters);
    return new String(letters);
  }
}
