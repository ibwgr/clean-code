/**
 * Convert a phrase to its acronym.
 *
 * Techies love their TLA (Three Letter Acronyms)!
 *
 * Help generate some jargon by writing a program that converts a long name like Portable Network Graphics to its acronym (PNG).
 */
class Acronym {

  private final String phrase;

  Acronym(String phrase) {
        this.phrase = phrase;
  }

  String get() {
    StringBuffer acronym = new StringBuffer();
    String[] words = phrase.trim().split("[\\s-_]+");
    for(String word : words) {
      acronym.append(word.toUpperCase().charAt(0));
    }
    return acronym.toString();
  }

}
