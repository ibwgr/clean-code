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

//  String phrase;
////
//  IsogramChecker(String phrase){
//    this.phrase = phrase;
//  }

  public boolean isIsogram(String phrase) {//static
    //throw new UnsupportedOperationException("Delete this statement and write your own implementation.");
    String phrase1 = phrase.toLowerCase();
    boolean isIsogram = false;
    //int hilfszahl = 0;
    int counter = 0;
    char derBuchstabe = ' ';

    //td lowercase phrase
    //todo wenn grösser zwei, nur, wenn es eine leertaste oder ein bindestrich ist

    String phraseCopy = phrase1;
    for(int i = 0; i<phrase1.length();i++){
      int hilfszahl = 0;

      for(int j = 0; j<phraseCopy.length();j++){
        if(phrase1.charAt(i)==phraseCopy.charAt(j)){
          hilfszahl++;
        }
      }

      if (hilfszahl > counter) {
        counter = hilfszahl;
        //derBuchstabe = derBuchstabe+phrase.charAt(i);
        // System.out.println("derBuchstabdfffe: " + phrase.charAt(i));
        derBuchstabe = phrase1.charAt(i);
      }
    }

    if(derBuchstabe=='-'&&counter>1 || (derBuchstabe==' '&&counter>1)  || !(counter>1)){
      isIsogram=true;
    }else{
      isIsogram = false;
    }
//    if(counter>1 || !(derBuchstabe=='-'&&counter>1)){//(Character.isLetter(derBuchstabe))){// Character.isDefined(derBuchstabe)=='-'){//|| (counter>1 && derBuchstabe='-')){
//      isIsogram = false;
//    }else{
//      isIsogram = true;
//    }

   // System.out.println("derBuchstabe: " + derBuchstabe);
   // System.out.println("counter: "+counter);

    return isIsogram;
  }

}
