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

    String translation = "";
    String [] englishWords = englishPhrase.toLowerCase().split(" ");

    for (String word : englishWords){
      translation += translateWord(word);
      translation += " ";
    }
    return translation.trim();
  }

  private String translateWord (String word){
    String translatedWord = "";

    if(startsWithVowel(word) || startsWithVowelEdgeCase(word)){
      translatedWord = word + "ay";
    } else if (consonantFollowedByQU(word) || startsWithThreeConsonants(word)){
      translatedWord = word.substring(3) + word.substring(0, 3) + "ay";
    } else if (startsWithTwoConsonants(word)){
      translatedWord = word.substring(2) + word.substring(0,2) + "ay";
    } else {
      translatedWord = word.substring(1) + word.charAt(0) + "ay";
    }
    return translatedWord;
  }

  private boolean startsWithVowel(String word){
    String vowels = "aeiou";
    char letter = word.charAt(0);
    return (vowels.indexOf(letter) != -1);
  }

  private boolean startsWithVowelEdgeCase(String word){
    return (word.startsWith("xr") || word.startsWith("yt"));
  }

  private boolean consonantFollowedByQU(String word){
    String quCheck = word.substring(1, 3);
    return quCheck.equals("qu");
  }

  private boolean startsWithThreeConsonants(String word){
    return  (word.startsWith("thr") || word.startsWith("sch"));
  }

  private boolean startsWithTwoConsonants(String word){
    return  (word.startsWith("ch") || word.startsWith("qu") || word.startsWith("th"));
  }



  public static void main(String[] args) {
    System.out.println(new PigLatinTranslator().translate("BLue"));
  }
}
