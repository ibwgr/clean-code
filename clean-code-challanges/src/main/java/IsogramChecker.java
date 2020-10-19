package main.java;

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
public class IsogramChecker {

  public boolean isIsogram(String phrase) {
    //throw new UnsupportedOperationException("Delete this statement and write your own implementation.");
    //}

    if (phrase.length() > 1) {
      phrase = phrase.toLowerCase().replaceAll(" ", "").replaceAll("-", "");
      return phrase.length() == phrase.chars().distinct().count();
    }
    return true;
  }
}
