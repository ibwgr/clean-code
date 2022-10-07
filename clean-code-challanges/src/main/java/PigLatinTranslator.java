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
 * Regel 1: Wenn ein Wort mit einem Vokal beginnt, fügen Sie am Ende des Wortes ein „ay“ hinzu. (a, e, i, o, u)
 * Bitte beachten Sie, dass „xr“ und „yt“ am Anfang eines Wortes Vokale erzeugen (z. B. „xray“ -> „xrayay“, „yttria“ -> „yttriaay“).
 * Regel 2: Wenn ein Wort mit einem Konsonanten beginnt, verschieben Sie es an das Ende des Wortes und fügen Sie dann einen „ay“-Laut am Ende des Wortes hinzu.
 * Konsonantenlaute können aus mehreren Konsonanten bestehen, auch bekannt als Konsonantencluster (z. B. „Stuhl“ -> „airchay“).
 * Regel 3: Wenn ein Wort mit einem Konsonanten beginnt, gefolgt von „qu“, verschieben Sie es an das Ende des Wortes und fügen Sie dann einen „ay“-Laut an das Ende des Wortes an (z. B. „Quadrat“ -> „aresquay ").
 * Regel 4: Wenn ein Wort ein „y“ nach einer Konsonantengruppe oder als zweiten Buchstaben in einem Wort mit zwei Buchstaben enthält, erzeugt es einen Vokal (z. B. „rhythm“ -> „ythmrhay“, „my“ -> „ymay“) ).
 *
 *
 *
 * There are a few more rules for edge cases, and there are regional variants too.
 *
 * See http://en.wikipedia.org/wiki/Pig_latin for more details.
 */
public class PigLatinTranslator {
  char[] vowels = {'a','e','i','o','u'};
  char[] consonant = {'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p', 'q', 'r', 's', 't', 'v', 'w', 'x', 'y', 'z'};
  String[] doubelconsonant = {"ch", "qu", "th","rh"};
  String[] doubelvowel = {"xr", "yt"};

  public String translate(String englishPhrase) {
    char c = englishPhrase.charAt(0);
    String result = "";
    char[] chars = stringToCharArray(englishPhrase);

    if (isFirstCharAvowel(c)||isFirst2CharsAdoubleconsonant(chars,doubelvowel,0)){
      result = translateAyToTheEnd(englishPhrase);
    }else {
      if(isCharAconsonant(chars,0)){
        result = translateConsonantAndAYtoEnd(chars);
        if(isFirst2CharsAdoubleconsonant(chars,doubelconsonant,0)){
          result = translateDoubleConsAndAytoEnd(englishPhrase,chars);
          if(isCharAconsonant(chars,2)){
            result = translateFirst3charsAndAyToEnd(englishPhrase,chars);
            if(chars[2] =='y'){
              result = translateDoubleConsAndAytoEnd(englishPhrase,chars);
            }
          }
        }
        if (isFirst2CharsAdoubleconsonant(chars,doubelconsonant,1)){
            result = translateFirst3charsAndAyToEnd(englishPhrase, chars);
        }
        if(chars[1] =='y'){
          result = translateConsonantAndAYtoEnd(chars);
        }
      }
    }
    return result;
  }

  //Check
  private boolean isFirstCharAvowel(char character){
    for (char c:vowels) {
      if(c == character){
        return true;
      }
    }return false;
  }

  private boolean isCharAconsonant(char[] chars,int position){
    for (int i = position; i < consonant.length; i++) {
      if(chars[position] == consonant[i]){
        return true;
      }
    }
    return false;
  }

  private boolean isFirst2CharsAdoubleconsonant(char[] chars, String[] stringarray, int start){
    String res = String.valueOf(chars[start])+ String.valueOf(chars[start+1]);
    for (String text:stringarray) {
      if(res.equals(text)){
        return true;
      }
    }
    return false;
  }

  //Translate
  private String translateAyToTheEnd(String text){
    return text + "ay";
  }
  private String translateConsonantAndAYtoEnd(char[] textchars){
    String result = "";
    for (int j = 1; j < textchars.length; j++) {
      result = result + String.valueOf(textchars[j]);
    }
    return  result + textchars[0] + "ay";
  }
  private String translateDoubleConsAndAytoEnd(String text, char[] textchars){
    String result = "";
    for (int i = 2; i < textchars.length; i++) {
      result = result + String.valueOf(textchars[i]);
    }
   return result + textchars[0] + textchars[1]+"ay";

  }
  private String translateFirst3charsAndAyToEnd(String text, char[] textchars){
    String result="";
    for (int i = 3; i < textchars.length; i++) {
      result = result + String.valueOf(textchars[i]);
    }
    return result + textchars[0] + textchars[1] + textchars[2] + "ay";
  }

  //Helpers
  private char[] stringToCharArray(String text){
    char[] result = new char[text.length()];
    for (int i = 0; i < text.length(); i++) {
      result[i] = text.charAt(i);
    }
    return result;
  }

}

