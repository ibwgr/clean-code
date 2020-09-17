import java.util.ArrayList;

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

    if (phrase.beginsWithVowelSound()){
      phrase.appendSuffix();
    }else if (phrase.beginsWithConsonantCluster()){
      phrase.moveFirstLatterToTheEndOfWord();
      phrase.moveFirstLatterToTheEndOfWord();
      phrase.appendSuffix();

    }else{
      phrase.moveFirstLatterToTheEndOfWord();
      phrase.appendSuffix();

    }

  return phrase.getPhrase();
  }




  private String moveConsonantClusterToTheEndOfWord(String word){
    String returnString = word.substring(2) + word.charAt(0) + word.charAt(1);
    return returnString;
  }

}

class Phrase {
  private String phrase;
  private ArrayList<String> vowelSounds = new ArrayList<>();
  private ArrayList<String> consonantClusters = new ArrayList<>();
  private String suffix = "ay";

  Phrase(String phrase){
    this.phrase = phrase;

    vowelSounds.add("a");
    vowelSounds.add("e");
    vowelSounds.add("i");
    vowelSounds.add("o");
    vowelSounds.add("u");

    consonantClusters.add("ch");
  }

  public boolean beginsWithVowelSound(){
    String firstLetter =  String.valueOf(this.phrase.charAt(0)).toLowerCase();
    return vowelSounds.contains(firstLetter);
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

