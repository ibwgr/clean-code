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
    int counter = 0;
    String adaptedPhrase = phrase.replaceAll("[\\s-]+", "");
    System.out.println(adaptedPhrase);
    for (int i = 0; i < adaptedPhrase.length(); i++) {
      for (int j = 0; j < adaptedPhrase.length(); j++) {

        if (adaptedPhrase.charAt(i) == adaptedPhrase.charAt(j)) {
          counter++;
        }
      }
    }

    if (counter >= 2) {
      return false;
    } else {
      return true;
    }
  }
}

