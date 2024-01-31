import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// IMPORTANT: Il ne faut pas changer la signature des méthodes
// de cette classe, ni le nom de la classe.
// Vous pouvez par contre ajouter d'autres méthodes (ça devrait 
// être le cas)
class CPUPlayer {

    // Contient le nombre de noeuds visités (le nombre
    // d'appel à la fonction MinMax ou Alpha Beta)
    // Normalement, la variable devrait être incrémentée
    // au début de votre MinMax ou Alpha Beta.
    private int numExploredNodes;
    private Mark maxMark;

    // Le constructeur reçoit en paramètre le
    // joueur MAX (X ou O)
    public CPUPlayer(Mark cpu) {
        this.maxMark = cpu;
    }

    // Ne pas changer cette méthode
    public int getNumOfExploredNodes() {
        return numExploredNodes;
    }

    // Retourne la liste des coups possibles. Cette liste contient
    // plusieurs coups possibles si et seuleument si plusieurs coups
    // ont le même score.
    public ArrayList<Move> getNextMoveMinMax(Board board) {
        ArrayList<Move> moves = new ArrayList<Move>();

        List<Move> emptyMoves = new ArrayList<>(board.getEmptyMoveMap().values());
        emptyMoves.forEach(
                move -> {
                    board.play(move, maxMark);
                    // printTicTacToeGame(board.getBoard());
                    int score = minmax(board, maxMark.opposite());
                    if (score == Mark.isWinning()) {
                        moves.add(move);
                    }
                    board.undo(move);
                });

        return moves;

    }

    // Retourne la liste des coups possibles. Cette liste contient
    // plusieurs coups possibles si et seuleument si plusieurs coups
    // ont le même score.
    // public ArrayList<Move> getNextMoveAB(Board board){
    // numExploredNodes = 0;
    // }

    private int minmax(Board board, Mark mark) {

        // retourne l'inverse à cause de la récursion appelle l'opposé
        if (board.evaluate(maxMark) == Mark.isWinning()) {
            return Mark.isWinning();
        }

        if (board.evaluate(maxMark) == Mark.isLosing()) {
            return Mark.isLosing();
        }

        if (board.getEmptyMoveMap().isEmpty()) {
            return Mark.isDraw();
        }

        if (mark == maxMark) {
            final int[] maxEval = { -1000 };
            List<Move> moves = new ArrayList<>(board.getEmptyMoveMap().values());
            moves.forEach(
                    move -> {
                        board.play(move, mark);
                        int eval = minmax(board, mark.opposite());
                        board.undo(move);
                        maxEval[0] = Math.max(maxEval[0], eval);
                    });
            return maxEval[0];
        } else {
            final int[] minEval = { 1000 };
            List<Move> moves = new ArrayList<>(board.getEmptyMoveMap().values());
            moves.forEach(
                    move -> {
                        board.play(move, mark);
                        int eval = minmax(board, mark.opposite());
                        board.undo(move);
                        minEval[0] = Math.min(minEval[0], eval);
                    });
            return minEval[0];
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

    // this.getNextMoveMinMax(board) =
    // return "";
    // }



}
