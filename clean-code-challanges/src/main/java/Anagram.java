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


    List<String> listOfAnagrams = new ArrayList<>();

    String wordToCompare = this.word;
    String sortedAnagrams = "";
    String sortedWord = "";

    char[] ArrayWord = wordToCompare.toLowerCase().toCharArray();
    sortedWord = new String(ArrayWord);


    for (String candidate : candidates) {

      char[] Anagrams = candidate.toCharArray();

      Arrays.sort(Anagrams);
      Arrays.sort(ArrayWord);

      sortedAnagrams = new String(Anagrams);

      String finalAnagrams = sortedAnagrams;


      Map<String, String> stringMap = Arrays.stream(candidate.split(" "))
          .map(s -> s.split("="))
          .collect(Collectors.toMap(

        a -> a[0],
        a -> finalAnagrams
      ));

      if (sortedWord.equals(finalAnagrams)) {

        listOfAnagrams.addAll(stringMap.keySet());

      }
    }

    return listOfAnagrams;
  }
}


