import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
    phrase = removeSpacesAndHypens(phrase);
    return !checkForDoubleChars(phrase);
  }

  private Boolean checkForDoubleChars(String phrase) {
    String partPhraseToTest = phrase.toLowerCase(Locale.ROOT);
    for (char charUnderTest : partPhraseToTest.toCharArray()) {
      partPhraseToTest = partPhraseToTest.substring(1);
      boolean charFoundInPartPhrase = partPhraseToTest.indexOf(charUnderTest) != -1;
      if(charFoundInPartPhrase) {
        return true;
      }
    }
    return false;
  }

  private String removeSpacesAndHypens(String phrase) {
    return phrase.replace(" ", "").replace("-", "");
  }



}
