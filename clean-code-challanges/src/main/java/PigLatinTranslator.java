import java.util.Arrays;

/**
 * Implement a program that translates from English to Pig Latin.
 *
 * Pig Latin is a made-up children's language that's intended to be confusing. It obeys a few simple rules (below),
 * but when it's spoken quickly it's really difficult for non-children (and non-native speakers) to understand.
 *
 * Rule 1: If a word begins with a vowel sound (selbstlaut), add an "ay" sound to the end of the word.
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
    char[] vowels = {'a','e','i','o','u'};
    String vowelsString = "aeiou";
    String consonants = "bcdfghjklmnpqrstvwxyz";
    String specConsonants = "xy";
    String[] consonantClusters = {"rh", "bl", "br", "ch", "ck", "cl", "cr", "dr", "fl", "fr", "gh", "gl", "gr", "ng", "ph", "pl", "pr", "qu", "sc", "sh", "sk", "sl", "sm", "sn", "sp", "st", "sw", "th", "tr", "tw", "wh", "wr"};
    String[] words = englishPhrase.split("\\s+");
    StringBuilder translated = new StringBuilder();

    int i = 0;
    for (String word:words) {
      i++;
      // Fullfill rule #1
      if( vowelsString.indexOf(word.charAt(0)) > -1 ){
        word = word + "ay";
      }

      // Fullfill rule #2 && #3 consonants
      if( consonants.indexOf(word.charAt(0)) > -1 ){
        word = consonantChecks(0, word, consonants, specConsonants, consonantClusters);
        word += "ay";
      }

      translated.append(word);
      if(words.length > 1 && i < words.length){
        translated.append(" ");
      }
    }

    // Build translated String
    return translated.toString();
  }

  private String consonantChecks(int level, String word, String consonants, String specConsonants, String[] cluster){
    level++;
    if(level > 3){
      return word;
    }
    if(Arrays.asList(cluster).contains(word.substring(0,2).toLowerCase())) {
      String clusterToMove = word.substring(0, 2);
      word = word.substring(2) + clusterToMove;
    } else if (word.length() > 2) {
      // rule #4
      if(consonants.indexOf(word.charAt(1)) > -1 && !Arrays.asList(cluster).contains(word.substring(1,3).toLowerCase())) {
        return word;
      }
    }

    if(consonants.indexOf(word.charAt(0)) > -1){
      String charToMove = word.substring(0, 1);
      word = word.substring(1) + charToMove;
    }

    if(Arrays.asList(cluster).contains(word.substring(0,2).toLowerCase()) || consonants.indexOf(word.charAt(0)) > -1){
      word = consonantChecks(level, word, consonants, specConsonants, cluster);
    }

    return word;
  }
}
