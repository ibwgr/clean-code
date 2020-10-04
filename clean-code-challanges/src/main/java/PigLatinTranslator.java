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


    String translation = "";

    String[] word = englishPhrase.split(" ");

    for (int w = 0; w < word.length; w++) {

      translation += " ";

      boolean isVowel = PigLatinTranslator.findFirstVowel(word[w].charAt(0));


      String quCluster = word[w].substring(1, 3);


      if (isVowel) {

        translation = translation + word[w] + "ay";

      } else if (word[w].substring(0, 2).equals("xr") || word[w].substring(0, 2).equals("yt")) {

        translation = translation + word[w] + "ay";

      } else if (quCluster.equals("qu")) {

        translation = word[w].substring(3) + word[w].substring(0, 1) + quCluster + "ay";

      } else if (word[w].substring(0, 2).equals("qu")) {

        translation = word[w].substring(2) + word[w].substring(0, 2) + "ay";
      } else {

        String cluster = PigLatinTranslator.findConsonantCluster(word[w]);
        translation += word[w].substring(word[w].indexOf(cluster) + cluster.length()) + cluster + "ay";
      }
    }
    return translation.trim();
  }


  private static boolean findFirstVowel(char firstLetter) {

    String vowels = "aeiou";

    boolean isVowel = false;

    for (int i = 0; i < vowels.length(); i++) {

      char vowel = vowels.charAt(i);

      if (vowel == firstLetter) {

        isVowel = true;

        break;
      }
    }

    return isVowel;
  }

  private static String findConsonantCluster(String cluster) {

    String consCluster = "";

    for (int i = 0; i < cluster.length(); i++) {

      if (PigLatinTranslator.findFirstVowel(cluster.charAt(i))) {

        break;
      } else {

        consCluster += cluster.charAt(i);
      }
    }

    return consCluster;
  }
}
