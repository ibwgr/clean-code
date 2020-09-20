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
    String[] words = englishPhrase.split(" ");
    String newStr = "";
    for (String word: words) {
      if (newStr != "") {
        newStr += " ";
      }
      newStr += translateWord(word);
    }
    return newStr;
  }

  public String translateWord(String word) {

    // Rule 1: If a word begins with a vowel sound, add an "ay" sound to the end of the word.
    // Please note that "xr" and "yt" at the beginning of a word make vowel sounds (e.g. "xray" -> "xrayay", "yttria" -> "yttriaay").
    if(word.indexOf("a") == 0 || word.indexOf("e") == 0 || word.indexOf("i") == 0 || word.indexOf("o") == 0
      || word.indexOf("u") == 0 || word.indexOf("xr") == 0 || word.indexOf("yt") == 0) {
      return word + "ay";
    }

    // Rule 3: If a word starts with a consonant sound followed by "qu",
    // move it to the end of the word, and then add an "ay" sound to the end of the word (e.g. "square" -> "aresquay").
    else if(word.indexOf("qu") == 1) {
      word = word.substring(3) + word.substring(0, 1) + "quay";
    }
    // word starting with "sch" or "thr" or "th" or "qu" or "ch" --> take first substring and move it to the end, then add "ay"
    else if(word.indexOf("sch") == 0 || word.indexOf("thr") == 0) {
      word = word.substring(3) + word.substring(0, 3) + "ay";
    }
    // word starting with "th" or "qu" or "ch" --> take first substring and move it to the end, then add "ay"
    else if(word.indexOf("th") == 0 || word.indexOf("qu") == 0 || word.indexOf("ch") == 0) {
      word = word.substring(2) + word.substring(0, 2) + "ay";
    }

    // Rule 4: If a word contains a "y" after a consonant cluster or as the second letter in a two letter word
    // it makes a vowel sound (e.g. "rhythm" -> "ythmrhay", "my" -> "ymay").
    else if(!(word.indexOf("a") == 0 || word.indexOf("e") == 0 || word.indexOf("i") == 0 || word.indexOf("o") == 0 || word.indexOf("u") == 0) &&
      !(word.indexOf("a") == 1 || word.indexOf("e") == 1 || word.indexOf("i") == 1 || word.indexOf("o") == 1 || word.indexOf("u") == 1) &&
      word.indexOf("y") == 2) {
      word = word.substring(2) + word.substring(0, 2) + "ay";
    }

    // Rule 2: If a word begins with a consonant sound, move it to the end of the word and then add an "ay" sound to the end of the word.
    // Consonant sounds can be made up of multiple consonants, a.k.a. a consonant cluster (e.g. "chair" -> "airchay").
    else if(word.substring(0, 1) != "a" || word.substring(0, 1) != "e" || word.substring(0, 1) != "i"
      || word.substring(0, 1) != "o" || word.substring(0, 1) != "u") {
      word = word.substring(1) + word.substring(0, 1) + "ay";
    }

    return word;
  }
}
