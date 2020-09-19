import java.util.ArrayList;
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
    Phrase phrase = new Phrase(englishPhrase);
    phrase.translateToPigLatin();
    return phrase.getTranslatedPhrase();
  }

}


class Phrase {
  private List<String> sourcePhrase;
  private List<String> translatedPhrase = new ArrayList<>();

  Phrase(String sourcePhrase){
    this.sourcePhrase = Arrays.asList(sourcePhrase.split(" "));
  }

  public void translateToPigLatin() {
    for (String sourceWord : sourcePhrase){
      translatedPhrase.add(translateWordToPigLatin(sourceWord));
    }
  }

  public String getTranslatedPhrase() {
    return String.join(" ",translatedPhrase);
  }


  private String translateWordToPigLatin(String sourceWord){
      Word word = new Word(sourceWord);
      if  (word.beginsWithTripleConsonantCluster() || word.firstConsonantFollowedByQU()){
        word.moveFirstThreeLettersToTheEndOfWord();

      }else if (word.beginsWithDoubleConsonantCluster()) {
        word.moveFirstTwoLettersToTheEndOfWord();

      }else if (!word.beginsWithVowelSound() && !word.beginsWithVowelSoundCluster() ){
        word.moveFirstLetterToTheEndOfWord();
      }
      word.appendSuffix();

      return word.getString();
  }

}



class Word {
  private String word;
  private ArrayList<String> vowelSounds = new ArrayList<>(Arrays.asList("a", "e", "i", "o", "u"));
  private ArrayList<String> doubleConsonantClusters = new ArrayList<>(Arrays.asList("ch", "th", "qu"));
  private ArrayList<String> tripleConsonantClusters = new ArrayList<>(Arrays.asList("thr", "sch"));
  private ArrayList<String>  vowelSoundsCluster = new ArrayList<>(Arrays.asList("yt", "xr"));
  private String specialCombo = "qu";
  private String suffix = "ay";


  Word(String word){
    this.word = word;
  }


  public boolean beginsWithVowelSound(){
    String firstLetter =  word.substring(0,1).toLowerCase();
    return vowelSounds.contains(firstLetter);
  }

  public boolean beginsWithVowelSoundCluster(){
    String firstTwoLetters =  word.substring(0,2).toLowerCase();
    return vowelSoundsCluster.contains(firstTwoLetters);
  }

  public boolean beginsWithDoubleConsonantCluster(){
    String firstTwoLetters =  word.substring(0,2).toLowerCase();
    return doubleConsonantClusters.contains(firstTwoLetters);
  }

  public boolean beginsWithTripleConsonantCluster(){
    String firstThreeLetters = word.substring(0,3).toLowerCase();
    return tripleConsonantClusters.contains(firstThreeLetters);
  }

  public boolean firstConsonantFollowedByQU( ){
    String secondAndThirdLetter =  word.substring(1,3).toLowerCase();
    return (secondAndThirdLetter.equals(specialCombo));
  }

  public void appendSuffix() {
    word = word + suffix;
  }

  public void moveFirstLetterToTheEndOfWord(){
    word = word.substring(1) + word.charAt(0);
  }

  public void moveFirstTwoLettersToTheEndOfWord(){
    word = word.substring(2) + word.charAt(0) + word.charAt(1);
  }

  public void moveFirstThreeLettersToTheEndOfWord(){
    word = word.substring(3) + word.charAt(0) + word.charAt(1) + word.charAt(2);
  }

  public String getString(){
    return word;
  }

}

