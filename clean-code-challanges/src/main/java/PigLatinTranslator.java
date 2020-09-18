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
  private ArrayList<Word> words = new ArrayList<>();


  public String translate(String englishPhrase) {


    List<String> str = new ArrayList<>();
    str = Arrays.asList(englishPhrase.split(" "));

    for (String s:str){
      words.add(new Word(s));
    }




    for (Word word :words){

      if (word.beginsWithVowelSound()) {
        word.appendSuffix();
      } else if ( word.beginsWithVowelSoundCluster()){
        word.appendSuffix();
      }else if (word.beginsWithConsonantCluster()){
        word.moveFirstLatterToTheEndOfWord();
        word.moveFirstLatterToTheEndOfWord();
        word.appendSuffix();

      }else{
        word.moveFirstLatterToTheEndOfWord();
        word.appendSuffix();

      }

    }

    String translatedString = "";

    for (Word word : words){
      translatedString = translatedString + word.getPhrase();
    }

  return translatedString;
  }




  private String moveConsonantClusterToTheEndOfWord(String word){
    String returnString = word.substring(2) + word.charAt(0) + word.charAt(1);
    return returnString;
  }

}

class Word {
  private String phrase;
  private ArrayList<String> vowelSounds = new ArrayList<>();
  private ArrayList<String> consonantClusters = new ArrayList<>();
  private ArrayList<String>  vowelSoundsCluster = new ArrayList<>();
  private String suffix = "ay";

  Word(String phrase){
    this.phrase = phrase;

    initializeVovelSounds();
    initializeConsonantClusters();

    initializeVowelSoundCluster();

  }



  private void initializeVowelSoundCluster() {
    vowelSoundsCluster.add("yt");
    vowelSoundsCluster.add("xr");
  }

  private void initializeConsonantClusters() {
    consonantClusters.add("ch");
    consonantClusters.add("th");
  }

  private void initializeVovelSounds() {
    vowelSounds.add("a");
    vowelSounds.add("e");
    vowelSounds.add("i");
    vowelSounds.add("o");
    vowelSounds.add("u");
  }

  public boolean beginsWithVowelSound(){
    String firstLetter =  String.valueOf(this.phrase.charAt(0)).toLowerCase();
    return vowelSounds.contains(firstLetter);
  }

  public boolean beginsWithVowelSoundCluster(){
    String firstTwoLetters =  String.valueOf(this.phrase.charAt(0)).toLowerCase() + String.valueOf(this.phrase.charAt(1)).toLowerCase();
    return vowelSoundsCluster.contains(firstTwoLetters);
  }

  public boolean beginsWithConsonantCluster(){
    String firstTwoLetters =  String.valueOf(this.phrase.charAt(0)).toLowerCase() + String.valueOf(this.phrase.charAt(1)).toLowerCase();
    return consonantClusters.contains(firstTwoLetters);
  }


  public void appendSuffix() {
    this.phrase = this.phrase + this.suffix;
  }

  public void moveFirstLatterToTheEndOfWord(){
    this.phrase = this.phrase.substring(1) + this.phrase.charAt(0);
  }

  public String getPhrase(){
    return this.phrase;
  }

}

