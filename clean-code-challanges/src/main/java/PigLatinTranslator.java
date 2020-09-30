package main.java;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

  public static String translate (String englishPhrase){
    char ch = englishPhrase.charAt(0);

    Pattern startWithSqu = Pattern.compile("^squ");
    Pattern startWithTh = Pattern.compile("^th");
    Pattern startWithThr = Pattern.compile("^thr");
    Pattern startWithSch = Pattern.compile("^sch");
    Pattern startWithYt = Pattern.compile("^yt");
    Pattern startWithXr = Pattern.compile("^xr");

    String s;
    if (ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u') {
      s = englishPhrase + "ay";
    } else if (ch=='c') {
      s = englishPhrase.substring(2) + "chay";

    } else if (ch=='q') {
      s = englishPhrase.substring(2) + "quay";

    } else if (startWithSqu.matcher(englishPhrase).find()) {
      s = englishPhrase.substring(3) + "squay";

    } else if (startWithThr.matcher(englishPhrase).find()) {
      s = englishPhrase.substring(3) + "thray";

    } else if (startWithTh.matcher(englishPhrase).find()) {
      s = englishPhrase.substring(2) + "thay";

    } else if (startWithSch.matcher(englishPhrase).find()) {
      s = englishPhrase.substring(3) + "schay";

    } else if (startWithYt.matcher(englishPhrase).find()) {
      s = englishPhrase + "ay";

    } else if (startWithXr.matcher(englishPhrase).find()) {
      s = englishPhrase + "ay";

    } else {
      s = englishPhrase.substring(1) + englishPhrase.charAt(0) + "ay";
    }
    return s;
  }
}
