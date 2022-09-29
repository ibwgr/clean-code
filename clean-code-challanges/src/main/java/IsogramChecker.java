import java.util.Arrays;
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
    String cleanedPhrase = phrase.replaceAll("-| ", "").toLowerCase(Locale.ROOT);
    int len = cleanedPhrase.length();

    char[] letters = cleanedPhrase.toCharArray();

    Arrays.sort(letters);
    return checkNotSameLetter(letters, len);

  }


  private boolean checkNotSameLetter(char [] letters, int len){
    for (int i = 0; i < len - 1; i++) {
      if (letters[i] == letters[i + 1])
        return false;
    }
    return true;
  }

}
