import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Given a word and a list of possible anagrams, select the correct sublist.
 *
 * Given "listen" and a list of candidates like "enlists" "google" "inlets" "banana" the program should return a list containing "inlets".
 */
public class Anagram {
  private final String templateWord;

  public Anagram(String word) {
    templateWord = word.toLowerCase();
  }

  public List<String> match(List<String> candidates) {
    List<String> anagrams;

    anagrams = candidates
      .stream()
      .filter(this::isAnagram)
      .collect(Collectors.toList());

    return anagrams;
  }


  private boolean isAnagram(String word){
    char[] candidate = word.toLowerCase().toCharArray();
    Arrays.sort(candidate);

    char[] template = templateWord.toCharArray();
    Arrays.sort(template);

    return !word.equalsIgnoreCase(templateWord) && Arrays.equals(candidate, template);
  }
}
