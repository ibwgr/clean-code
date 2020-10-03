import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a word and a list of possible anagrams, select the correct sublist.
 *
 * Given "listen" and a list of candidates like "enlists" "google" "inlets" "banana" the program should return a list containing "inlets".
 */
public class Anagram {

  private String anagramWord;

  public Anagram(String word) {
    this.anagramWord = word.toLowerCase();
  }

  public List<String> match(List<String> candidates) {

    List<String> matchedWords = new ArrayList<>();

    for (String candidateWord : candidates){
      if(matcher(candidateWord)){
        matchedWords.add(candidateWord);
      }
    }
    return matchedWords;
  }

  private boolean matcher (String candidateWord){
    char[] anagramWordChars = anagramWord.toCharArray();
    char[] candidateChars = candidateWord.toCharArray();

    Arrays.sort(anagramWordChars);
    Arrays.sort(candidateChars);

    return Arrays.equals(anagramWordChars, candidateChars);
  }

}
