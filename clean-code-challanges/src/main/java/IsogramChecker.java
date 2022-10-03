import java.util.Arrays;

/**
 * Determine if a word or phrase is an isogram.
 *
 * An isogram (also known as a "nonpattern word") is a word or phrase without a repeating letter,
 * however spaces and hyphens are allowed to appear multiple times.
 *
 * Examples of isograms:
 *
 * lumberjacks
 * background
 * downstream
 * six-year-old
 *
 * The word isograms, however, is not an isogram, because the s repeats.
 */
class IsogramChecker {


  boolean isIsogram(String phrase) {
    String sortedPhrase = stringSortAlphabet(phrase.toUpperCase());
    char[] charSortedPhrase = sortedPhrase.toCharArray();
    char testingLetter = '$';
    boolean status = false;
    if (charSortedPhrase.length >1){
      for (char letter : charSortedPhrase) {
        if (testingLetter == letter && (letter !=' ' && letter !='-')){
          status = false;
          break;
        }else {
          status = true;
        }
        testingLetter = letter;
      }
    }else {
      status = true;
    }
    return status;
  }

  private String stringSortAlphabet(String word){
    char[] stringToChar = word.toCharArray();
    Arrays.sort(stringToChar);
    return new String(stringToChar);
  }

}
