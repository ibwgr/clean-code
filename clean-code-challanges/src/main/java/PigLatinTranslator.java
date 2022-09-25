/**
 * Implement a program that translates from English to Pig Latin.
 * <p>
 * Pig Latin is a made-up children's language that's intended to be confusing. It obeys a few simple rules (below),
 * but when it's spoken quickly it's really difficult for non-children (and non-native speakers) to understand.
 * <p>
 * Rule 1: If a word begins with a vowel sound, add an "ay" sound to the end of the word.
 * Please note that "xr" and "yt" at the beginning of a word make vowel sounds (e.g. "xray" -> "xrayay", "yttria" -> "yttriaay").
 * Rule 2: If a word begins with a consonant sound, move it to the end of the word and then add an "ay" sound to the end of the word.
 * Consonant sounds can be made up of multiple consonants, a.k.a. a consonant cluster (e.g. "chair" -> "airchay").
 * Rule 3: If a word starts with a consonant sound followed by "qu", move it to the end of the word, and then add an "ay" sound to the end of the word (e.g. "square" -> "aresquay").
 * Rule 4: If a word contains a "y" after a consonant cluster or as the second letter in a two letter word it makes a vowel sound (e.g. "rhythm" -> "ythmrhay", "my" -> "ymay").
 * <p>
 * There are a few more rules for edge cases, and there are regional variants too.
 * <p>
 * See http://en.wikipedia.org/wiki/Pig_latin for more details.
 */
public class PigLatinTranslator {

  public String translate(String englishPhrase) {
    String[] arrEnglishPhraseSplit = englishPhrase.split(" ");
    String pigPhrase = "";

    for (int i = 0; i < arrEnglishPhraseSplit.length - 1; i++) {
      pigPhrase += String.join("", translateWord(arrEnglishPhraseSplit[i]), " ");
    }
    pigPhrase += translateWord(arrEnglishPhraseSplit[arrEnglishPhraseSplit.length - 1]);

    return pigPhrase;
  }


  public String translateWord(String splitWordFromEnglishPhrase) {
    String engWord = splitWordFromEnglishPhrase;

    String strConsonat = "bcdfghjklmnpqrstvwxyz";

    String pigWord = "";


    if (engWord.length() == 1) {
      if(findVowelFirstChar(engWord)==true){
        pigWord = engWord + "ay";
      }
      else{
        pigWord = engWord;
      }
    } else if (engWord.length() == 2) {
      System.out.println("xr: "+find_xr_yt_BeginningOfWord(engWord));
      if(findVowelFirstChar(engWord)==true || find_xr_yt_BeginningOfWord(engWord) == true ){
        pigWord = engWord + "ay";
      }
      else{
        pigWord = engWord;
      }
    } else if(engWord.length()>=3){
      if(findVowelFirstChar(engWord)==true||find_xr_yt_BeginningOfWord(engWord)==true){
        pigWord = engWord + "ay";
      }
      else{
        pigWord = engWord;
      }

      if(findConsonantFirstChar(engWord)== true){
        char first = engWord.charAt(0);//engWord.substring(engWord.charAt(0),1);
        char last = engWord.charAt(engWord.length()-1);
        System.out.println("first: "+first);
        System.out.println("last: "+last);

        pigWord = engWord.substring(1,engWord.length())+first+"ay";
        System.out.println("piggy:" + pigWord);
        System.out.println("Consonant:" + findConsonantFirstChar(engWord));
      }

    }


    return pigWord;
  }
  public  boolean findConsonantFirstChar(String engWord){
    boolean bIsConsonantFirstChar = false;
    String strConsonant = "bcdfghjklmnpqrstvwxyz";
    char charfirstCharakter = engWord.charAt(0);
    for (int i = 0; i < strConsonant.length(); i++) {
      if (engWord.charAt(0) == (strConsonant.charAt(i))) {
        bIsConsonantFirstChar = true;
        break;
      } else {
        bIsConsonantFirstChar = false;
      }
    }
    return bIsConsonantFirstChar;
  }




  public boolean findVowelFirstChar(String engWord) {
    boolean bIsFirstCharakterVowel = false;
    String strVowel = "aeiou";
    char charfirstCharakter = engWord.charAt(0);
    for (int i = 0; i < strVowel.length(); i++) {
      if (engWord.charAt(0) == (strVowel.charAt(i))) {
        bIsFirstCharakterVowel = true;
        break;
      } else {
        bIsFirstCharakterVowel = false;
      }
    }
    return bIsFirstCharakterVowel;
  }


  public boolean find_xr_yt_BeginningOfWord(String engWord){
    boolean bIs_xr_yt_BeginningOfWord = false;

    for(int i = 1; i<engWord.length();i++){
      if(engWord.substring(0,2).equals("xr")||engWord.substring(0,2).equals("yt")){
        System.out.println("hat xr");
        bIs_xr_yt_BeginningOfWord = true;
      }else{
        bIs_xr_yt_BeginningOfWord = false;
        System.out.println("hat kein xr");
      }
    }

    return bIs_xr_yt_BeginningOfWord;
  }
}


/*
        for(int i = 1; i<=pigPhrase.length()-1;i++){
          if(pigPhrase.substring(0,1) == ""){

          }
        }



            if (engWord.length() == 1) {
      System.out.println("blabla: "+findVowelFirstChar(engWord));
      for (int i = 0; i < strVowel.length(); i++) {
        if (engWord.charAt(engWord.length() - 1) == (strVowel.charAt(i))) {
          pigWord = engWord + "ay";
          break;
        } else {
          pigWord = engWord;
        }
      }
    } else if (engWord.length() == 2) {

    }
 */
