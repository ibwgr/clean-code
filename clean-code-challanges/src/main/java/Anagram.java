import java.util.*;
import java.util.stream.Collectors;

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



  public List<String> match(List<String> candidates)  {

    List<String> anagrams = new ArrayList<>();

    String wordToCompare = this.word;
    String str = "";
    String w = "";

    char[] ArrayWord = wordToCompare.toLowerCase().toCharArray();
    w = new String(ArrayWord);

    for ( int i = 0; i < candidates.size(); i++){

      char[] Anagrams = candidates.get(i).toCharArray();

      Arrays.sort(Anagrams);
      Arrays.sort(ArrayWord);
      str = new String(Anagrams);


      String finalStr = str;
      Map<String, String> result = Arrays.stream(candidates.get(i).split(" ")).map(s -> s.split("=")).collect(Collectors.toMap(
        a -> a[0],
        a -> finalStr
      ));

     if (w.equals(finalStr)){

     anagrams.add(result.keySet().toString());

     }
    }




    return anagrams;
  }
}


