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

    char[] ArrayWord = wordToCompare.toLowerCase().toCharArray();
    Arrays.sort(ArrayWord);
    String sortedWord = new String(ArrayWord).toLowerCase();


    try {
      for (String candidate : candidates) {

        char[] Anagrams = candidate.toLowerCase().toCharArray();
        Arrays.sort(Anagrams);

        String sortedAnagrams = new String(Anagrams).toLowerCase();

        Map<String, String> stringMap = Arrays.stream(candidate.split(" "))
          .map(s -> s.split("="))
          .collect(Collectors.toMap(

            a -> candidate,
            a -> sortedAnagrams

          ));

        boolean word = isUpperCase(this.word);
        boolean anagram = isUpperCase(candidate);

        if (word != anagram){
          listOfAnagrams.isEmpty();
        }

        else if (sortedWord.equals(sortedAnagrams) && !this.word.equals(candidate.toLowerCase()))  {

          listOfAnagrams.addAll(stringMap.keySet());
        }
      }
    }
    catch (IllegalStateException e){
      listOfAnagrams.isEmpty();
    }

    return listOfAnagrams;
  }


  private static boolean isUpperCase(String s){
    for (int i=0; i<s.length(); i++)
    {
      if (!Character.isUpperCase(s.charAt(i)))
      {
        return false;
      }
    }
    return true;
  }
}


