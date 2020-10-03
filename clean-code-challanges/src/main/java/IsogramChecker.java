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
    String adaptedPhrase = phrase.replaceAll("[\\s-]+", "").toLowerCase();
    char [] adaptedPhraseChar = adaptedPhrase.toCharArray();
  	Arrays.sort(adaptedPhraseChar);

  	for (int i = 1; i < adaptedPhraseChar.length; i++) {
  	  if(adaptedPhraseChar[i-1] == adaptedPhraseChar[i]){
  	    return false;
  	  }
  	}
   	return true;
  }
}

