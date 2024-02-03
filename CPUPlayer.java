import java.util.ArrayList;
import java.util.List;

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
        ArrayList<Move> winningMoves = new ArrayList<Move>();
        ArrayList<Move> tyingMoves = new ArrayList<Move>();

        List<Move> emptyMoves = new ArrayList<>(board.getEmptyMoveMap().values());
        emptyMoves.forEach(
                move -> {
                    board.play(move, maxMark);
                    // printTicTacToeGame(board.getBoard());
                    int score = minmax(board, maxMark.opposite());
                    if (score == Mark.isWinning()) {
                        winningMoves.add(move);
                    } else if (score == Mark.isDraw()) {
                        tyingMoves.add(move);
                    }
                    board.undo(move);
                });

        if (!winningMoves.isEmpty())
            return winningMoves;
        else
            return tyingMoves;
    }

    // Retourne la liste des coups possibles. Cette liste contient
    // plusieurs coups possibles si et seuleument si plusieurs coups
    // ont le même score.
    public ArrayList<Move> getNextMoveAB(Board board) {
        ArrayList<Move> winningMoves = new ArrayList<Move>();
        ArrayList<Move> tyingMoves = new ArrayList<Move>();

        List<Move> emptyMoves = new ArrayList<>(board.getEmptyMoveMap().values());
        emptyMoves.forEach(
                move -> {
                    board.play(move, maxMark);
                    // printTicTacToeGame(board.getBoard());
                    int score = alphaBeta(board, maxMark.opposite(), -1000, 1000);
                    if (score == Mark.isWinning()) {
                        winningMoves.add(move);
                    } else if (score == Mark.isDraw()) {
                        tyingMoves.add(move);
                    }
                    board.undo(move);
                });

        if (!winningMoves.isEmpty())
            return winningMoves;
        else
            return tyingMoves;
    }

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
            int maxEval = -1000;
            List<Move> moves = new ArrayList<>(board.getEmptyMoveMap().values());
            for (Move move : moves) {
                board.play(move, mark);
                int eval = minmax(board, mark.opposite());
                board.undo(move);
                maxEval = Math.max(maxEval, eval);
            }
            return maxEval;
        } else {
            int minEval = 1000;
            List<Move> moves = new ArrayList<>(board.getEmptyMoveMap().values());
            for (Move move : moves) {
                board.play(move, mark);
                int eval = minmax(board, mark.opposite());
                board.undo(move);
                minEval = Math.min(minEval, eval);
            }
            return minEval;
        }
    }

    private int alphaBeta(Board board, Mark mark, int alpha, int beta) {

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
            List<Move> moves = new ArrayList<>(board.getEmptyMoveMap().values());
            for (Move move : moves) {
                board.play(move, mark);
                alpha = Math.max(alpha, alphaBeta(board, mark.opposite(), alpha, beta));
                board.undo(move);
                if (beta <= alpha) {
                    break;
                }
            }
            return alpha;
        } else {
            List<Move> moves = new ArrayList<>(board.getEmptyMoveMap().values());
            for (Move move : moves) {
                board.play(move, mark);
                beta = Math.min(beta, alphaBeta(board, mark.opposite(), alpha, beta));
                board.undo(move);
                if (beta <= alpha) {
                    break;
                }
            }
            return beta;
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

}
