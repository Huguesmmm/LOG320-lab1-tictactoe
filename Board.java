import java.util.ArrayList;

// IMPORTANT: Il ne faut pas changer la signature des méthodes
// de cette classe, ni le nom de la classe.
// Vous pouvez par contre ajouter d'autres méthodes (ça devrait
// être le cas)
class Board {
    private Mark[][] board;

    // Ne pas changer la signature de cette méthode
    public Board() {
        board = new Mark[3][3];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = Mark.EMPTY;
            }
        }
    }

    // Place la pièce 'mark' sur le plateau, à la
    // position spécifiée dans Move
    //
    // Ne pas changer la signature de cette méthode
    public void play(Move m, Mark mark) {
        board[m.getRow()][m.getCol()] = mark;

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
            if (evaluateRows(mark, i) != 0)
                return evaluateRows(mark, i);

            if (evaluateCols(mark, i) != 0)
                return evaluateCols(mark, i);

            if (evaluateDiags(mark) != 0)
                return evaluateDiags(mark);
        }

        return score;
    }

    private int evaluateRows(Mark mark, int row) {
        int score = 0;

        if (board[row][0] == mark) {
            if (board[row][1] == mark) {
                if (board[row][2] == mark) {
                    score = 100;
                }
            }
        } else if (board[row][0] == mark.opposite()) {
            if (board[row][1] == mark.opposite()) {
                if (board[row][2] == mark.opposite()) {
                    score = -100;
                }
            }
        }

        return score;
    }

    private int evaluateCols(Mark mark, int col) {
        int score = 0;

        if (board[0][col] == mark) {
            if (board[1][col] == mark) {
                if (board[2][col] == mark) {
                    score = 100;
                }
            }
        } else if (board[0][col] == mark.opposite()) {
            if (board[1][col] == mark.opposite()) {
                if (board[2][col] == mark.opposite()) {
                    score = -100;
                }
            }
        }

        return score;
    }

    private int evaluateDiags(Mark mark) {
        int score = 0;

        if (board[1][1] == mark) {
            if (board[0][0] == mark) {
                if (board[2][2] == mark) {
                    score = 100;
                }
            }

            if (board[0][2] == mark) {
                if (board[2][0] == mark) {
                    score = 100;
                }
            }
        } else if (board[1][1] == mark.opposite()) {
            if (board[0][0] == mark.opposite()) {
                if (board[2][2] == mark.opposite()) {
                    score = -100;
                }
            }

            if (board[0][2] == mark.opposite()) {
                if (board[2][0] == mark.opposite()) {
                    score = -100;
                }
            }
        }

        return score;
    }

    //Board Getter
    public Mark[][] getBoard() {
        return board;
    }

    //Check if position is empty in the specific position of the board
    public boolean isEmpty(int row, int col) {

        return board[row][col] == Mark.EMPTY;
    }



}
