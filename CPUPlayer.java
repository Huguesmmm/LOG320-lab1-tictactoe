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
    public ArrayList<Move> getNextMoveAB(Board board){
        numExploredNodes = 0;

    }

    private int minmax(Board board, Mark max){

        if(board.evaluate(max) == Mark.isWinning()){
            return Mark.isWinning();
        }

        if(board.evaluate(max) == Mark.isLosing()){
            return Mark.isLosing();
        }

        if(board.getEmptyMoves().isEmpty()){
            return Mark.isDraw();
        }

        if(max == maxMark){
            int maxEval = -1000;
            for(int i = 0; i < board.getEmptyMoves().size(); i++){
                int eval = minmax(board, max.opposite());
                maxEval = Math.max(maxEval, eval);
            }
            return maxEval;
        } else {
            int minEval = 1000;
            for(int i = 0; i < board.getEmptyMoves().size(); i++){
                int eval = minmax(board, max.opposite());
                minEval = Math.min(minEval, eval);
            }
            return minEval;
        }
    }

}
