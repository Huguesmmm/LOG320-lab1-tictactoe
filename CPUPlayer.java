import java.util.ArrayList;
import java.util.HashMap;

// IMPORTANT: Il ne faut pas changer la signature des méthodes
// de cette classe, ni le nom de la classe.
// Vous pouvez par contre ajouter d'autres méthodes (ça devrait 
// être le cas)
class CPUPlayer
{

    // Contient le nombre de noeuds visités (le nombre
    // d'appel à la fonction MinMax ou Alpha Beta)
    // Normalement, la variable devrait être incrémentée
    // au début de votre MinMax ou Alpha Beta.
    private int numExploredNodes;
    private Mark maxMark;
    private Mark nextMarkToPlay;
    ArrayList<Move> lastMoves = new ArrayList<>();

    // Le constructeur reçoit en paramètre le
    // joueur MAX (X ou O)
    public CPUPlayer(Mark cpu){
        this.maxMark = cpu;
        this.nextMarkToPlay = maxMark;
    }

    // Ne pas changer cette méthode
    public int  getNumOfExploredNodes(){
        return numExploredNodes;
    }

    // Retourne la liste des coups possibles.  Cette liste contient
    // plusieurs coups possibles si et seuleument si plusieurs coups
    // ont le même score.
    public ArrayList<Move> getNextMoveMinMax(Board board)
    {
        ArrayList<Move> moves = new ArrayList<Move>();


        final int numEmptyMoves = board.getEmptyMoves().size();

        // get all possible moves from minmax
        for(int i = 0; i < numEmptyMoves; i++){
            int eval = minmax(board, numEmptyMoves, nextMarkToPlay);
            if(eval == Mark.isWinning()){
                moves.add(board.getEmptyMoves().get(i));
            }
        }

        // don't know what to do here
        numExploredNodes = 0;

        return moves;

    }

    // Retourne la liste des coups possibles.  Cette liste contient
    // plusieurs coups possibles si et seuleument si plusieurs coups
    // ont le même score.
    // public ArrayList<Move> getNextMoveAB(Board board){
    //     numExploredNodes = 0;
    // }

    private int minmax(Board board, int numEmptyMoves, Mark mark){

        // retourne l'inverse à cause de la récursion appelle l'opposé
        if(board.evaluate(maxMark) == Mark.isWinning()){
            return Mark.isWinning();
        }

        if(board.evaluate(maxMark) == Mark.isLosing()){
            return Mark.isLosing();
        }

        if(board.getEmptyMoves().isEmpty()){
            return Mark.isDraw();
        }

        if(mark == maxMark){
            int maxEval = -1000;
            for(int i = 0; i < numEmptyMoves; i++){
                Move moveMax = board.getEmptyMoves().get(i);
                board.play(moveMax, mark);
                printTicTacToeGame(board.getBoard());
                if (lastMoves.size() == 2) {
                    lastMoves.remove(0);
                }
                lastMoves.add(moveMax);
                int eval = minmax(board, numEmptyMoves, mark.opposite());

                if (lastMoves.size() == 2)
                    mark = mark.opposite();
                board.undo(lastMoves);
                lastMoves = new ArrayList<>();
                maxEval = Math.max(maxEval, eval);
            }
            return maxEval;
        } else {
            int minEval = 1000;
            for(int i = 0; i < numEmptyMoves; i++){
                Move moveMin = board.getEmptyMoves().get(i);
                board.play(board.getEmptyMoves().get(i), mark);
                printTicTacToeGame(board.getBoard());
                if (lastMoves.size() == 2) {
                    lastMoves.remove(0);
                }
                lastMoves.add(moveMin);
                int eval = minmax(board, numEmptyMoves, mark.opposite());

                if (lastMoves.size() == 2)
                    mark = mark.opposite();
                board.undo(lastMoves);
                lastMoves = new ArrayList<>();
                minEval = Math.min(minEval, eval);
            }
            return minEval;
        }
    }

    public static void printTicTacToeGame(Mark[][] gameBoard) {
        System.out.println("[");

        for (int i = 0; i < gameBoard.length; i++) {
            System.out.print("  [ ");
            for (int j = 0; j < gameBoard[i].length; j++) {
                System.out.print(gameBoard[i][j] + " ");
            }
            System.out.println("]");
        }

        System.out.println("]");
    }

    // public String toString(Board board){

    //     this.getNextMoveMinMax(board) = 
    //     return "";
    // }

}
