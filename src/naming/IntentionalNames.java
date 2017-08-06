package naming;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// Kapitel 2.2
public class IntentionalNames {
    
/*
* 4 und 0 sind Magic Numbers => Variablen mit sinnvollen Namen extrahieren
* getThem, list, list1 umbenennen
* */
//    class Game{
//        private List<int[]> list;
//    
//        public List<int[]> getThem(){
//            List<int[]> list1 = new ArrayList<>();
//            for(int[] x : list){
//                if(x[0] == 4){
//                    list1.add(x);
//                }
//            }
//            return list1;
//        }
//    }

    
/*
* int[] mit Stati in eigene Klasse auslagern => Cell mit Methode isFlagged
* */    
//    class Game{
//        private List<int[]> gameBoard;
//        private final int STATUS_VALUE = 0;
//        private final int FLAGGED = 4;
//        
//        public List<int[]> getFlaggedCells(){
//            List<int[]> flaggedCells = new ArrayList<>();
//            for(int[] cell : gameBoard){
//                if(cell[STATUS_VALUE] == FLAGGED){
//                    flaggedCells.add(cell);
//                }
//            }
//            return flaggedCells;
//        }
//    }

    
    
/*
* getFlaggedCells ist imperativ programmiert. Funktional geht es noch ausdruckstarker.
* */    
    class Game{
        private List<Cell> gameBoard;

        public List<Cell> getFlaggedCells(){
            List<Cell> flaggedCells = new ArrayList<>();
            for(Cell x : gameBoard){
                if(x.isFlagged()){
                    flaggedCells.add(x);
                }
            }
            return flaggedCells;
        }
        
        public List<Cell> getFlaggedCellsFunctional(){
            return gameBoard.stream()
                    .filter(c -> c.isFlagged())
                    .collect(Collectors.toList());
        }
    }

    class Cell{
        private int[] states; // 0 flag, 1 bomb, 2 open, 3 close
        private final int STATUS_VALUE = 0;
        private final int FLAGGED = 4;

        public boolean isFlagged(){
            return states[STATUS_VALUE] == FLAGGED;
        } 
    }
}
