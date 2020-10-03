import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Given a word and a list of possible anagrams, select the correct sublist.
 *
 * Given "listen" and a list of candidates like "enlists" "google" "inlets" "banana" the program should return a list containing "inlets".
 */
public class Anagram {

  private final String anagramWord;

  public Anagram(String word) {
    this.anagramWord = word.toLowerCase();
  }

  public List<String> match(List<String> candidates) {
    return candidates.stream()
      .filter(this::matcher)
      .filter(this::isNotSameWord)
      .collect(Collectors.toList());
  }

  private boolean matcher(String candidateWord){
    char[] anagramWordChars = anagramWord.toLowerCase().toCharArray();
    Arrays.sort(anagramWordChars);

    char[] candidateWordChars = candidateWord.toLowerCase().toCharArray();
    Arrays.sort(candidateWordChars);

    return Arrays.equals(anagramWordChars, candidateWordChars);
  }

  private boolean isNotSameWord(String candidateWord){
    return !anagramWord.equals(candidateWord.toLowerCase());
  }

}
