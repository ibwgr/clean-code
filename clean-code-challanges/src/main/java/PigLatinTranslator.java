import java.util.Arrays;
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

  public String translate(String englishPhrase) {
    String[] words = splitAndReplace(englishPhrase);

    for (int i = 0; i < words.length; i++) {
      while (!beginsWithVowelSound(words[i]) && !words[i].substring(0, 2).contains("qu") || words[i].substring(1,2).contains("y")) {
        words[i] = moveCharsSetToEnd(words[i], 1);
      }

      if (words[i].substring(0, 2).contains("qu")) {
        words[i] = moveCharsSetToEnd(words[i], 2);
      }

      words[i] = words[i] + "ay";
    }

    return String.join(" ", words);
  }

  private String[] splitAndReplace(String englishPhrase) {
    String[] words = englishPhrase.split(" ");
    for (int i = 0; i < words.length; i++) {
      words[i] = words[i].replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
    }

    return words;
  }

  public boolean beginsWithVowelSound(String word) {
    List<Character> vowelChars = Arrays.asList('a', 'i', 'e', 'o', 'u');
    List<String> vowelSounds = Arrays.asList("xr", "yt");
    return vowelChars.contains(word.charAt(0)) || vowelSounds.contains(word.substring(0, 2));
  }

  public String moveCharsSetToEnd(String word, int numberOfChar) {
    return word.substring(numberOfChar) + word.substring(0, numberOfChar);
  }
}
