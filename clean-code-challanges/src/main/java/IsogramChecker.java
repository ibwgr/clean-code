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
    return true;
  }
/*    int counter = 0;
    for (int i = 0; i < phrase.length(); i++) {
      for (int j = 0; j < phrase.length(); j++) {

        if (phrase.charAt(i) == (phrase.charAt(j))) {
          counter++;
        }
      }
    }

      if (counter >= 2) {
        return false;
      } else {
        return true;
      }
  }*/
}

