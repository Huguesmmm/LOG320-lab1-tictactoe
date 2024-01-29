import java.util.ArrayList;

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

    // Le constructeur reçoit en paramètre le
    // joueur MAX (X ou O)
    public CPUPlayer(Mark cpu){
        this.maxMark = cpu;
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


        // get all possible moves from minmax
        for(int i = 0; i < board.getEmptyMoves().size(); i++){
            int eval = minmax(board, maxMark);
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

    private int minmax(Board board, Mark mark){

        // retourne l'inverse à cause de la récursion appelle l'opposé
        if(board.evaluate(mark) == Mark.isWinning()){
            return Mark.isLosing();
        }

        if(board.evaluate(mark) == Mark.isLosing()){
            return Mark.isWinning();
        }

        if(board.getEmptyMoves().isEmpty()){
            return Mark.isDraw();
        }

        if(mark == maxMark){
            int maxEval = -1000;
            for(int i = 0; i < board.getEmptyMoves().size(); i++){
                Move moveMax = board.getEmptyMoves().get(i);
                board.play(moveMax, mark);
                printTicTacToeGame(board.getBoard());
                int eval = minmax(board, mark.opposite());
                board.undo(moveMax);
                maxEval = Math.max(maxEval, eval);
            }
            return maxEval;
        } else {
            int minEval = 1000;
            for(int i = 0; i < board.getEmptyMoves().size(); i++){
                Move moveMin = board.getEmptyMoves().get(i);
                board.play(board.getEmptyMoves().get(i), mark);
                printTicTacToeGame(board.getBoard());
                int eval = minmax(board, mark.opposite());
                board.undo(moveMin);
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
