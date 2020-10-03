import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    String spacesAndHyphens = "[-\\s]";

    String [] singleLetter = phrase.toLowerCase().replaceAll(spacesAndHyphens,"").split("");

    List<String> lettersAsList = Arrays.asList(singleLetter);
    Set<String> lettersAsSet = new HashSet<>(Arrays.asList(singleLetter));

    return lettersAsList.size() == lettersAsSet.size();

  }
}
