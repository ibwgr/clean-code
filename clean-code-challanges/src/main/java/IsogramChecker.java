import java.util.stream.Collectors;

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
    final String whiteSpacesAndHyphens = "[\\s\\-]";

    String cleanPhrase = phrase.replaceAll(whiteSpacesAndHyphens, "").toLowerCase();

    int numberOfUniqueCharacters = cleanPhrase.chars()
      .mapToObj(o -> (char)o)
      .collect(Collectors.toSet())
      .size();

    return cleanPhrase.length() == numberOfUniqueCharacters;
  }

}
