import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

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
 * https://de.wikipedia.org/wiki/Pig_Latin
 *
 * * Regel 1: Wenn ein Wort mit einem Vokal beginnt, fügen Sie am Ende des Wortes ein „ay“ hinzu.
 *  * Bitte beachten Sie, dass „xr“ und „yt“ am Anfang eines Wortes Vokale erzeugen (z. B. „xray“ -> „xrayay“, „yttria“ -> „yttriaay“).
 *
 *  * Regel 2: Wenn ein Wort mit einem Konsonanten beginnt, verschieben Sie es an das Ende des Wortes und fügen Sie dann einen „ay“-Laut am Ende des Wortes hinzu.
 *  * Konsonantenlaute können aus mehreren Konsonanten bestehen, auch bekannt als Konsonantencluster (z. B. „chair“ -> „airchay“).
 *
 *  * Regel 3: Wenn ein Wort mit einem Konsonanten beginnt, gefolgt von „qu“, verschieben Sie es an das Ende des Wortes und fügen Sie dann einen „ay“-Laut an das Ende des Wortes an (z. B. „square“ -> „aresquay ").
 *
 *  * Regel 4: Wenn ein Wort ein „y“ nach einer Konsonantengruppe oder als zweiten Buchstaben in einem Wort mit zwei Buchstaben enthält, erzeugt es einen Vokal (z. B. „rhythm“ -> „ythmrhay“, „my“ -> „ymay“) ).
 *  *
 */
public class PigLatinTranslator {
  private final ArrayList<String> VOCALES = new ArrayList<String>(Arrays.asList("a","e","i","o","u"));
  private final String Y = "y";
  private final String QU = "qu";
  private final String XR = "xr";
  private final String YT = "yt";
  private final String langAppender = "ay";

  public String translate(String englishPhrase) {
    String[] englishWords = englishPhrase.split(" ");
    String sentence = "";
    for (String englishWord : englishWords) {
      sentence = sentence.concat(" ").concat(translateWord(englishWord));
    }
    return sentence.strip();
  }

  private String translateWord(String englishWord) {
    if(isFirstCharacterVocal(englishWord) || wordStartWithXrOrYT(englishWord)) {
      return appendWordByLangAppender(englishWord);
    }

    if(isFirstCharacterY(englishWord)) {
      englishWord = moveCharactersToEndOfWord(englishWord, 1);
      return appendWordByLangAppender(englishWord);
    }

    if(getStartIfFirstSecondThirdChar_a_qu(englishWord)>-1) {
      englishWord = moveCharactersToEndOfWord(englishWord, (getStartIfFirstSecondThirdChar_a_qu(englishWord)+2));
      return appendWordByLangAppender(englishWord);
    }

    if(getFirstOccuranceOfVocalOrY(englishWord)>-1) {
      englishWord = moveCharactersToEndOfWord(englishWord, getFirstOccuranceOfVocalOrY(englishWord));
      return appendWordByLangAppender(englishWord);
    }

    return appendWordByLangAppender(englishWord);
  }

  private boolean isFirstCharacterVocal(String word) {
    return (VOCALES.contains(word.toLowerCase(Locale.ROOT).substring(0,1)));
  }

  private boolean isFirstCharacterY(String word) {
    return (word.toLowerCase(Locale.ROOT).substring(0,1).equals(Y));
  }

  private boolean wordStartWithXrOrYT(String word) {
    String firstAndSecondCharacter = word.toLowerCase(Locale.ROOT).substring(0,2);
    return (firstAndSecondCharacter.equals(XR) || firstAndSecondCharacter.equals(YT));
  }
  private int getStartIfFirstSecondThirdChar_a_qu(String word) {
      return word.toLowerCase(Locale.ROOT).indexOf(QU)<=3 ? word.toLowerCase(Locale.ROOT).indexOf(QU) : -1;
  }

  private String moveCharactersToEndOfWord(String word, int numberOfCharactersToMove) {
    return word.substring(numberOfCharactersToMove).concat(word.substring(0,numberOfCharactersToMove));
  }

  private String appendWordByLangAppender(String word) {
    return word.concat(langAppender);
  }

  private int getFirstOccuranceOfVocalOrY(String word) {
    final ArrayList<String> VOCALES_WITH_Y = new ArrayList<String>(VOCALES);
    VOCALES_WITH_Y.add("y");
    for (int i = 0; i < word.length(); i++) {
      if(VOCALES_WITH_Y.contains(word.toLowerCase(Locale.ROOT).substring(i,i+1))) {
        return i;
      }
    }
    return -1;
  }
}
