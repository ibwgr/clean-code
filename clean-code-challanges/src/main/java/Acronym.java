/**
 * Convert a phrase to its acronym.
 *
 * Techies love their TLA (Three Letter Acronyms)!
 *
 * Help generate some jargon by writing a program that converts a long name like Portable Network Graphics to its acronym (PNG).
 */

class Acronym {

  private String phrase;

  Acronym(String phrase) {
    this.phrase = phrase;
  }




  String get() {
    lineDeleter(phrase);

//    if(phrase.contains(" - ")) {
//      phrase = phrase.replace("-"," ");
//      return phrase;
//    }

   // PhraseContainsLine AND leftAndRightIsWhiteSpace

  //   phrase = phrase.replace(" - "," ");

    String[] words = phrase.split(" ");
    StringBuilder acronymPhrase = new StringBuilder();
    for (String word : words) {
      if (word.startsWith("_") && word.endsWith("_")) {
        String acronymMinusUnderline = word.substring(1, word.length() - 1);
        acronymPhrase.append(acronymMinusUnderline.substring(0, 1).toUpperCase());

      } else if (word.contains("-")) {
        word.replace(word, "\\s");

      } else {
        acronymPhrase.append(word.substring(0, 1).toUpperCase());
      }
    }
    return acronymPhrase.toString();
  }

  public String lineDeleter(String phrase){
    String result = phrase = phrase.replace(" - "," ");
    result = phrase.replaceAll("_", "");
    result = phrase.replaceAll("-", " ");
return result;
  }

}
