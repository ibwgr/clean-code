package naming;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// Kapitel 2.2
public class IntentionalNames {

}

  /*
   * Ausgangslage
   *
   * Schritt 1:
   *
   * Schaue die Klasse Game an, und führe dann folgende Refactorings durch:
   *  - 1 und 0 sind Magic Numbers => Variablen mit sinnvollen Namen extrahieren
   *  - getThem, list, list1 umbenennen
   * */
//    class Game{
//        private List<int[]> list;
//
//        public List<int[]> getThem(){
//            List<int[]> list1 = new ArrayList<>();
//            for(int[] x : list){
//                if(x[0] == 1){
//                    list1.add(x);
//                }
//            }
//            return list1;
//        }
//    }


  /*
   * Schritt 2
   *
   * Folgendes soll nun noch optimiert werden:
   *   - int[] in eigene Klasse auslagern => Cell mit Methode isFlagged
   * */
//    class Game{
//        private List<int[]> gameBoard;
//        private final int POS_FLAG = 0;
//
//        public List<int[]> getFlaggedCells(){
//            List<int[]> flaggedCells = new ArrayList<>();
//            for(int[] cell : gameBoard){
//                if(cell[POS_FLAG] == 1){
//                    flaggedCells.add(cell);
//                }
//            }
//            return flaggedCells;
//        }
//    }


  /*
   * Lösungsvariante
   *
   * Hinweis:
   *  getFlaggedCells ist imperativ programmiert.
   *  Funktional geht es noch ausdrucksstarker, siehe getFlaggedCellsFunctional.
   * */
//  class Game {
//    private List<Cell> gameBoard;
//
//    public Game(List<Cell> gameBoard) {
//      this.gameBoard = gameBoard;
//      this.getFlaggedCells();
//    }
//
//    public List<Cell> getFlaggedCells() throws RuntimeException {
//      List<Cell> flaggedCells = new ArrayList<>();
//
//      for (Cell x : gameBoard) {
//        if (x.isFlagged()) {
//          flaggedCells.add(x);
//        }
//      }
//      return flaggedCells;
//
//    }
//
//    public List<Cell> getFlaggedCellsFunctional() {
//      return gameBoard.stream()
//        .filter(Cell::isFlagged)
//        .collect(Collectors.toList());
//
//    }
//  }
//
//  class Cell {
//    private byte[] states = new int[]{0,0,0,0}; // Array index 0=flag, 1=bomb, 2=open, 3=close
//    private byte POS_FLAG = 0;
//
//    public setFlagged(int state){
//      states[POS_FLAG] = state;
//    }
//
//    boolean isFlagged() {
//      return states[POS_FLAG] == 1;
//    }
//  }
//}
//
// Hast du eine Idee wie man die Klasse Cell weiter vereinfachen könnte?
