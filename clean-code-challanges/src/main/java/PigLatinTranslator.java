import java.util.*;

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

  private final List<String> vowelSounds = Arrays.asList("a", "e", "i", "o", "u");
  private final List<String> consonantSounds = Arrays.asList("b", "c", "d", "f", "g", "j", "k", "l", "m", "n", "p", "q", "s", "t", "v", "x", "z", "h", "r", "w", "y");
  private final String ay = "ay";
  private final  String qu = "qu";
  private final String xr = "xr";
  private final String yt = "yt";


  public String translate(String englishPhrase) {
    List<String> wordsList = transformEnglishPhraseToWords(englishPhrase);
    List<String> cleanedWords = cleanWords(wordsList);

    return pigify(cleanedWords);
  }
  private String pigify (List <String> words){
    for (String word : words){
      if (isFirstLetterVowel(word) || isWordStartingWithXrOrYt(word)){
        words.set(words.indexOf(word), appendAy(word));
      } else if (isConsonantClusterFollwedByY(word)){
        words.set(words.indexOf(word), appendTwoFirstLetterAy(word));
      }else if (isConsonantFollowedByQu(word)){
        words.set(words.indexOf(word), appendThreeFirstLetterAy(word));
      }else if (isConsonantCluster(word)){
        words.set(words.indexOf(word), appendTwoFirstLetterAy(word));
      }else if (isFirstLetterConsonant(word)){
        words.set(words.indexOf(word), appendFirstLetterAy(word));
      }
    }

    return transformWordsToPhrase(words);
  }

  private List<String> transformEnglishPhraseToWords(String englishPhrase) {
    return List.of(englishPhrase.toLowerCase(Locale.ROOT).split("\\s+"));
  }

  private List<String> cleanWords(List<String> words){
    List<String> cleanWords = new ArrayList<>();
    for (String word : words){
      cleanWords.add(word.replaceAll("[^\\w]", ""));
    }
    System.out.println(cleanWords);

    return cleanWords;
  }





  private boolean isFirstLetterVowel(String word){
    String firstLetter = String.valueOf(word.charAt(0));
    return vowelSounds.contains(firstLetter);
  }

  private boolean isWordStartingWithXrOrYt(String word){
    String firstTwoLetters = word.substring(0,2);
    return firstTwoLetters.equals(xr) || firstTwoLetters.equals(yt);
  }

  private boolean isFirstLetterConsonant(String word){
    String firstLetter = String.valueOf(word.charAt(0));
    return consonantSounds.contains(firstLetter);
  }

  private boolean isConsonantCluster(String word){
    String secondLetter = String.valueOf(word.charAt(1));
    return isFirstLetterConsonant(word) && consonantSounds.contains(secondLetter);
  }


  private boolean isConsonantFollowedByQu(String word){
    String secondAndThirdLetter = "";
    if (isMinLengthThree(word)){
      secondAndThirdLetter = word.substring(1,3);
    }
    return isFirstLetterConsonant(word) && secondAndThirdLetter.equals(qu);
  }

  private boolean isConsonantClusterFollwedByY(String word){
    String thirdLetter = "";
    if (isMinLengthThree(word)){
      thirdLetter = word.substring(2,3);
    }

    return isConsonantCluster(word) && thirdLetter.equals("y");
  }

  private boolean isMinLengthThree(String word){
   return word.length() >= 3;
  }

  private String appendAy(String word){
   return word + ay;
  }
  private String appendFirstLetterAy(String word){
    return word.substring(1) + word.charAt(0) + ay;

  }
  private String appendTwoFirstLetterAy(String word){
    return word.substring(2) + word.substring(0,2) + ay;
  }
  private String appendThreeFirstLetterAy(String word){
    return word.substring(3) + word.substring(0,3) + ay;
  }

  private String transformWordsToPhrase(List <String> words){
    return String.join(" ", words);
  }





}



