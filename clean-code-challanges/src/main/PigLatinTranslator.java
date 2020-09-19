package main;


import java.util.ArrayList;
import java.util.List;

/**
 * Implement a program that translates from English to Pig Latin.
 *
 * Pig Latin is a made-up children's language that's intended to be confusing. It obeys a few simple rules (below),
 * but when it's spoken quickly it's really difficult for non-children (and non-native speakers) to understand.
 *
 * Rule 1: If a word begins with a vowel sound, add an "ay" sound to the end of the word.
 *  Please note that "xr" and "yt" at the beginning of a word make vowel sounds (e.g. "xray" -> "xrayay", "yttria" -> "yttriaay").
 * Rule 2: If a word begins with a consonant sound, move it to the end of the word and then add an "ay" sound to the end of the word.
 *  Consonant sounds can be made up of multiple consonants, a.k.a. a consonant cluster (e.g. "chair" -> "airchay").
 * Rule 3: If a word starts with a consonant sound followed by "qu", move it to the end of the word, and then add an "ay" sound to the end of the word (e.g. "square" -> "aresquay").
 * Rule 4: If a word contains a "y" after a consonant cluster or as the second letter in a two letter word it makes a vowel sound (e.g. "rhythm" -> "ythmrhay", "my" -> "ymay").
 *
 * There are a few more rules for edge cases, and there are regional variants too.
 *
 * See http://en.wikipedia.org/wiki/Pig_latin for more details.
 */

public class PigLatinTranslator {




  public static String translate(String englishPhrase) {


    String[] sentence = englishPhrase.split(" ");


    for (String value : sentence) {

      char s = value.charAt(0);


      if (findFirstVokal(s)) {

        System.out.println(value + "ay");
      }

      if (findKonsonantenCluster(value).equals("xr") || findKonsonantenCluster(value).equals("yt")){

        System.out.println(value + "ay");

      }




      else {

        int wordLenght = findKonsonantenCluster(value).length();

        System.out.println(value.substring(wordLenght) + findKonsonantenCluster(value));

      }
    }

    return null;
  }



  private static boolean findFirstVokal(char firstVokal){

    String vokale = "aeiou";

    boolean istVokal = false;

    for (int i = 0; i < vokale.length(); i++){

      char letter = vokale.charAt(i);

      if (letter == firstVokal){

        istVokal = true;

        break;
      }
    }

    return istVokal;
  }

  private static String findKonsonantenCluster(String cluster){


    String konsCluster = "";


    for (int i = 0; i < cluster.length(); i++){

      if (PigLatinTranslator.findFirstVokal(cluster.charAt(i)) ) {

        break;
      }

      else {

        konsCluster = konsCluster + cluster.charAt(i);
      }
    }
    return konsCluster;
  }




  public static void main(String[] args){

    translate("das ist ein brotes gelbes auto xray yttio");

  }
}
