/**
 * @author - John Schmidt
 * 12.09.2022, 01:32
 */
public class Main {
  public static void main(String[] args) {

    String englishPhrase = "school";
    String strtranslate = "";

    strtranslate = translate(englishPhrase);

    System.out.println("--> " + strtranslate + " <--");
  }


  public static String translate(String englishPhrase) {
    String[] arrEnglishPhraseSplit = englishPhrase.split(" ");
    String pigPhrase = "";

    for (int i = 0; i < arrEnglishPhraseSplit.length - 1; i++) {
      pigPhrase += String.join("", translateWord(arrEnglishPhraseSplit[i]), "_");
    }
    pigPhrase += translateWord(arrEnglishPhraseSplit[arrEnglishPhraseSplit.length - 1]);

    return pigPhrase;
  }

  public static String translateWord(String engWord) {
    String pigWord = "";
    String strVowel = "aeiou";


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

  public static boolean findConsonantFirstChar(String engWord){
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

  public static boolean find_xr_yt_BeginningOfWord(String engWord){
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

  public static boolean findVowelFirstChar(String engWord) {
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


}


/*
//      System.out.println("blabla: "+findVowelFirstChar(engWord));
//      for (int i = 0; i < strVowel.length(); i++) {
//        if (engWord.charAt(engWord.length() - 1) == (strVowel.charAt(i))) {
//          pigWord = engWord + "ay";
//          break;
//        } else {
//          pigWord = engWord;
//        }
//      }





//    String my_str = "This_is_a_sample";
//    String[] split_str = my_str.split("_", 4);
//    System.out.println("The split string is:");
//    for (String every_Str : split_str)
//      System.out.println(every_Str);
//    String joined_str = String.join("_", "This", "is", "a", "sample");
//    System.out.println("The joined string is:");
//    System.out.println(joined_str);
 */
