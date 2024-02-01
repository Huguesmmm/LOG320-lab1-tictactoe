import java.lang.reflect.Array;
import java.util.ArrayList;

// IMPORTANT: Il ne faut pas changer la signature des méthodes
// de cette classe, ni le nom de la classe.
// Vous pouvez par contre ajouter d'autres méthodes (ça devrait 
// être le cas)
class Board {
    private Mark[][] board;
    private ArrayList<Move> emptyMoves = new ArrayList<Move>();

    // Ne pas changer la signature de cette méthode
    public Board() {
        board = new Mark[3][3];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = Mark.E;
            }
        }

        // initialiser la liste des coups vides
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length ; j++) {
                emptyMoves.add(new Move(i, j));
            }
        }
    }

    public Board(Mark[][] board, ArrayList<Move> emptyMoves) {
        this.board = board;
        this.emptyMoves = emptyMoves;
    }

    public Board(Board deepCopiedBoard) {
        this(deepCopiedBoard.getBoard(), deepCopiedBoard.getEmptyMoves());
    }

    public ArrayList<Move> getEmptyMoves() {
        return emptyMoves;
    }

    public Mark[][] getBoard() {
        return board;
    }

    // Place la pièce 'mark' sur le plateau, à la
    // position spécifiée dans Move
    //
    // Ne pas changer la signature de cette méthode
    public void play(Move m, Mark mark) {
        board[m.getRow()][m.getCol()] = mark;
        for (Move move : this.emptyMoves) {
            if(move.getRow() == m.getRow() && move.getCol() == m.getCol()) {
                this.emptyMoves.remove(move);
                break;
            }
        }
    }

    public void playMinMax(Move m, Mark mark) {
        board[m.getRow()][m.getCol()] = mark;
        for (Move move : this.emptyMoves) {
            if(move.getRow() == m.getRow() && move.getCol() == m.getCol()) {
                this.emptyMoves.remove(move);
                break;
            }
        }
    }

    public void undo(ArrayList<Move> lastMoves) {
        for (Move lastMove : lastMoves) {
            board[lastMove.getRow()][lastMove.getCol()] = Mark.E;
            this.emptyMoves.add(lastMove);
        }
//        board[m.getRow()][m.getCol()] = Mark.E;
//        this.emptyMoves.add(m);
    }

    // retourne 100 pour une victoire
    // -100 pour une défaite
    // 0 pour un match nul
    // Ne pas changer la signature de cette méthode
    public int evaluate(Mark mark) {
        int score = 0;

        if (mark.isEmpty()) {
            return score = 0;
        }

        for (int i = 0; i < board.length; i++) {
            if (evaluateRows(mark, i) != Mark.isDraw())
                return evaluateRows(mark, i);

            if (evaluateCols(mark, i) != Mark.isDraw())
                return evaluateCols(mark, i);

            if (evaluateDiags(mark) != Mark.isDraw())
                return evaluateDiags(mark);
        }

        return score;
    }

    private int evaluateRows(Mark mark, int row) {
        int score = Mark.isDraw();

        if (board[row][0] == mark) {
            if (board[row][1] == mark) {
                if (board[row][2] == mark) {
                    score = Mark.isWinning();
                }
            }
        } else if (board[row][0] == mark.opposite()) {
            if (board[row][1] == mark.opposite()) {
                if (board[row][2] == mark.opposite()) {
                    score = Mark.isLosing();
                }
            }
        }

        return score;
    }

    private int evaluateCols(Mark mark, int col) {
        int score = Mark.isDraw();

        if (board[0][col] == mark) {
            if (board[1][col] == mark) {
                if (board[2][col] == mark) {
                    score = Mark.isWinning();
                }
            }
        } else if (board[0][col] == mark.opposite()) {
            if (board[1][col] == mark.opposite()) {
                if (board[2][col] == mark.opposite()) {
                    score = Mark.isLosing();
                }
            }
        }

        return score;
    }

    private int evaluateDiags(Mark mark) {
        int score = Mark.isDraw();

        if (board[1][1] == mark) {
            if (board[0][0] == mark) {
                if (board[2][2] == mark) {
                    score = Mark.isWinning();
                }
            }

            if (board[0][2] == mark) {
                if (board[2][0] == mark) {
                    score = Mark.isWinning();
                }
            }
        } else if (board[1][1] == mark.opposite()) {
            if (board[0][0] == mark.opposite()) {
                if (board[2][2] == mark.opposite()) {
                    score = Mark.isLosing();
                }
            }

            if (board[0][2] == mark.opposite()) {
                if (board[2][0] == mark.opposite()) {
                    score = Mark.isLosing();
                }
            }
        }

        return score;
    }

}
