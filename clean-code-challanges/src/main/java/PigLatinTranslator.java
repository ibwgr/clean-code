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

  private static final String VOWELS = "aeiou";
  private static final String ENDING = "ay";

  public String translate(String englishPhrase) {

    StringBuilder translation = new StringBuilder();
    String [] englishWords = englishPhrase.toLowerCase().split(" ");

    for (String wordToTranslate : englishWords){
      translation.append(translateWord(wordToTranslate));
      translation.append(" ");
    }
    return translation.toString().trim();
  }

  private String translateWord (String word){
    String translatedWord;

    if(startsWithVowel(word) || startsWithVowelEdgeCase(word)){
      translatedWord = word + ENDING;
    } else if (consonantFollowedByQU(word)){
      translatedWord = reArrangeWord(word, 3) + ENDING;
    } else if (word.startsWith("qu")){
      translatedWord = reArrangeWord(word, 2) + ENDING;
    } else {
      int consonantsBeforeVowel = countConsonants(word);
      translatedWord = reArrangeWord(word, consonantsBeforeVowel) + ENDING;
    }
    return translatedWord;
  }

  private boolean startsWithVowel(String word){
    char letter = word.charAt(0);
    return (VOWELS.indexOf(letter) != -1);
  }

  private boolean startsWithVowelEdgeCase(String word){
    return (word.startsWith("xr") || word.startsWith("yt"));
  }

  private boolean consonantFollowedByQU(String word){
    String quCheck = word.substring(1, 3);
    return quCheck.equals("qu");
  }

  private int countConsonants (String word){
    char [] charsInWord = word.toCharArray();
    int indexOfChar;

    for (indexOfChar = 0; indexOfChar < charsInWord.length; indexOfChar++){
      if(VOWELS.indexOf(charsInWord[indexOfChar]) != -1){
        break;
      }
    }
    return indexOfChar;
  }

  private String reArrangeWord (String word, int firstCharsToCut){
    return word.substring(firstCharsToCut) + word.substring(0,firstCharsToCut);
  }

}
