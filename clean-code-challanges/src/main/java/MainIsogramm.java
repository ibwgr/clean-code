/**
 * @author - John Schmidt
 * 25.09.2022, 23:52
 */
public class MainIsogramm {
  public static void main(String[] args) {

    String phrase = "sixyearoldd";

    System.out.println(findIsogramm(phrase));

  }

  public static boolean findIsogramm(String phrase){
    //String word = phrase + " hello";-
    String phrase1 = phrase.toLowerCase();
    System.out.println(phrase1);
    boolean isIsogram = false;
    //int hilfszahl = 0;
    int counter = 0;
    char derBuchstabe = ' ';

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

    if(derBuchstabe=='-'&&counter>1   || !(counter>1)){
      isIsogram=true;
    }else{
      isIsogram = false;
    }

//    if(counter>1|| (derBuchstabe=='-'&&counter>1)){
//      isIsogram = false;
//    }else{
//      isIsogram = true;
//    }

    System.out.println("derBuchstabe: " + derBuchstabe);
    System.out.println("counter: "+counter);

    return isIsogram;
  }

}
