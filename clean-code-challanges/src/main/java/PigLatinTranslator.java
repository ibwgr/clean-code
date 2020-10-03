/**
 * Implement a program that translates from English to Pig Latin.
 *
 * Pig Latin is a made-up children's language that's intended to be confusing. It obeys a few simple rules (below),
 * but when it's spoken quickly it's really difficult for non-children (and non-native speakers) to understand.
 *
 * Rule 1: If a word begins with a vowel sound, add an "ay" sound to the end of the word.
 *  Please note that "xr" and "yt" at the beginning of a word make vowel sounds (e.g. "xray"    -> "xrayay", "yttria" -> "yttriaay").
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
    String[] words = englishPhrase.split(" ");
    String pigLatinPhrase = "";
    for (String word: words) {
      if (pigLatinPhrase != "") {
        pigLatinPhrase += " ";
      }
      pigLatinPhrase += translateWord(word);
    }
    return pigLatinPhrase;
  }

  public String translateWord(String word) {

    // If word begins with a vowel, add an "ay" to the end of the word
    if(word.startsWith("a") || word.startsWith("e") || word.startsWith("i") || word.startsWith("o")
      || word.startsWith("u") || word.startsWith("xr") || word.startsWith("yt")) {
      return word + "ay";
    }

    // If word starts with a consonant followed by "qu",
    // move it to the end of the word, and then add an "ay" sound to the end of the word (e.g. "square" -> "aresquay")
    else if(word.indexOf("qu") == 1) {
      word = word.substring(3) + word.substring(0, 1) + "quay";
    }
    // word starting with "sch" or "thr" or "th" or "qu" or "ch" --> take first substring and move it to the end, then add "ay"
    else if(word.startsWith("sch") || word.startsWith("thr")) {
      word = word.substring(3) + word.substring(0, 3) + "ay";
    }
    // word starting with "th" or "qu" or "ch" --> take first substring and move it to the end, then add "ay"
    else if(word.startsWith("th") || word.startsWith("qu") || word.startsWith("ch")) {
      word = word.substring(2) + word.substring(0, 2) + "ay";
    }

    // If word contains a "y" after a consonant cluster or as the second letter in a two letter word
    // it makes a vowel sound (e.g. "rhythm" -> "ythmrhay", "my" -> "ymay").
    else if(!(word.startsWith("a") || word.startsWith("e") || word.startsWith("i") || word.startsWith("o")  || word.startsWith("u")) &&
      !(word.startsWith("a") || word.startsWith("e") || word.startsWith("i") || word.startsWith("o") || word.startsWith("u")) &&
      word.indexOf("y") == 2) {
      word = word.substring(2) + word.substring(0, 2) + "ay";
    }

    // If word begins with consonant, move it to the end of the word and then add "ay" to the end of the word
    else if(word.substring(0, 1) != "a" || word.substring(0, 1) != "e" || word.substring(0, 1) != "i"
      || word.substring(0, 1) != "o" || word.substring(0, 1) != "u") {
      word = word.substring(1) + word.substring(0, 1) + "ay";
    }

    return word;
  }
}
