/**
 * Convert a phrase to its acronym.
 *
 * Techies love their TLA (Three Letter Acronyms)!
 *
 * Help generate some jargon by writing a program that converts a long name like
 * Portable Network Graphics to its acronym (PNG).
 */
class Acronym {

  String phrase;

  Acronym(String phrase) {
    this.phrase = phrase;
  }

  String get() {
    String acronym = "";

    char[] arrChar = new char[phrase.length()];

    for (int i = 0; i < phrase.length(); i++) {
      arrChar[i] = phrase.charAt(i);
    }

    acronym += arrChar[0];

    for(int i = 1; i<phrase.length();i++){
      if((phrase.substring(i-1, i).equals(" ")&&!phrase.substring(i).equals("_"))||(phrase.substring(i-1, i).equals("-")&&!phrase.substring(i).equals(" "))
      ||(phrase.substring(i-1, i).equals("-")&&!phrase.substring(i).equals(" "))){
        acronym += Character.toUpperCase(phrase.charAt(i));
      }
    }

    return acronym;
  }

}
