import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import sun.security.util.ArrayUtil;

import java.util.Arrays;
import java.util.List;

/**
 * Implement a program that translates from English to Pig Latin.
 * <p>
 * Pig Latin is a made-up children's language that's intended to be confusing. It obeys a few simple rules (below),
 * but when it's spoken quickly it's really difficult for non-children (and non-native speakers) to understand.
 * <p>
 * Rule 1: If a word begins with a vowel sound, add an "ay" sound to the end of the word.
 * Please note that "xr" and "yt" at the beginning of a word make vowel sounds (e.g. "xray" -> "xrayay", "yttria" -> "yttriaay").
 * Rule 2: If a word begins with a consonant sound, move it to the end of the word and then add an "ay" sound to the end of the word.
 * Consonant sounds can be made up of multiple consonants, a.k.a. a consonant cluster (e.g. "chair" -> "airchay").
 * Rule 3: If a word starts with a consonant sound followed by "qu", move it to the end of the word, and then add an "ay" sound to the end of the word (e.g. "square" -> "aresquay").
 * Rule 4: If a word contains a "y" after a consonant cluster or as the second letter in a two letter word it makes a vowel sound (e.g. "rhythm" -> "ythmrhay", "my" -> "ymay").
 * <p>
 * There are a few more rules for edge cases, and there are regional variants too.
 * <p>
 * See http://en.wikipedia.org/wiki/Pig_latin for more details.
 */
public class PigLatinTranslator {

  public String translate(String englishPhrase) {
    String[] words = spiltAndReplace(englishPhrase);

    System.out.println(followedByQu(words[0]));

    for (int i = 0; i < words.length; i++) {
      while (!beginsWithVowel(words[i]) && !followedByQu(words[i]) && !followedByY(words[i])) {
        words[i] = moveNCharToEnd(words[i], 1);
      }

      if (followedByQu(words[i])) {
        words[i] = moveNCharToEnd(words[i], 3);
      }

      if (followedByY(words[i])){
        words[i] = moveNCharToEnd(words[i], 1);
      }

      words[i] = addAy(words[i]);
    }

    return String.join(" ", words);
  }

  private String[] spiltAndReplace(String englishPhrase) {
    String[] words = englishPhrase.split(" ");
    for (int i = 0; i < words.length; i++) {
      words[i] = words[i].replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
    }
    return words;
  }

  public boolean beginsWithVowel(String word) {
    List<Character> vowelChars = Arrays.asList('a', 'i', 'e', 'o', 'u');
    String[] vowelStrings = {"xr", "yt"};
    return vowelChars.contains(word.charAt(0)) || Arrays.asList(vowelStrings).contains(word.substring(0, 2));
  }

  public boolean followedByQu(String word) {
    return word.substring(1, 3).contains("qu");
  }

  public boolean followedByY(String word) {
    return word.substring(1,2).contains("y");
  }

  public String moveNCharToEnd(String word, int numberOfChar) {
    return word.substring(numberOfChar) + word.substring(0, numberOfChar);
  }

  public String addAy(String word) {
    return word + "ay";
  }
}
