import java.util.ArrayList;
import java.util.List;

/**
 * Given a word and a list of possible anagrams, select the correct sublist.
 *
 * Given "listen" and a list of candidates like "enlists" "google" "inlets" "banana" the program should return a list containing "inlets".
 */
public class Anagram {

  public String word;

  public Anagram(String word) {
    this.word = word;
  }



  public List<String> match(List<String> candidates) {

    ArrayList<String> liste1 = new ArrayList<String>();
    liste1.add("enlist");
    liste1.add("google");
    liste1.add("inlets");
    liste1.add("banana");


    return null;
  }
}
