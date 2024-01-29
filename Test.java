public class Test {

    public static void main(String[] args) {
        Board board1 = new Board();
        CPUPlayer cpu1 = new CPUPlayer(Mark.X);


        // supposed  to return -100
        // board1.play(new Move(0, 0), Mark.X);
        // board1.play(new Move(0, 1), Mark.X);
        // board1.play(new Move(0, 2), Mark.O);
        // board1.play(new Move(1, 0), Mark.X);
        // board1.play(new Move(1, 1), Mark.O);
        // board1.play(new Move(1, 2), Mark.X);
        // board1.play(new Move(2, 0), Mark.O);
        // board1.play(new Move(2, 1), Mark.O);
        // board1.play(new Move(2, 2), Mark.X);

        // return 0
        // board1.play(new Move(0, 0), Mark.X);
        // board1.play(new Move(0, 1), Mark.O);
        // board1.play(new Move(0, 2), Mark.X);
        // board1.play(new Move(1, 0), Mark.X);
        // board1.play(new Move(1, 1), Mark.O);
        // board1.play(new Move(1, 2), Mark.O);
        // board1.play(new Move(2, 0), Mark.O);
        // board1.play(new Move(2, 1), Mark.X);
        // board1.play(new Move(2, 2), Mark.X);

        // return 100
        // board1.play(new Move(0, 0), Mark.X);
        // board1.play(new Move(0, 1), Mark.O);
        // board1.play(new Move(0, 2), Mark.O);
        // board1.play(new Move(1, 0), Mark.EMPTY);
        // board1.play(new Move(1, 1), Mark.X);
        // board1.play(new Move(1, 2), Mark.O);
        // board1.play(new Move(2, 0), Mark.O);
        // board1.play(new Move(2, 1), Mark.X);
        // board1.play(new Move(2, 2), Mark.X);

        // return 0
        board1.play(new Move(0, 0), Mark.X);
        board1.play(new Move(0, 1), Mark.O);
        board1.play(new Move(2, 2), Mark.X);
        board1.play(new Move(0, 2), Mark.O);
        board1.play(new Move(2, 1), Mark.X);
        // board1.play(new Move(1, 0), Mark.X);
        board1.play(new Move(1, 1), Mark.O);
        // board1.play(new Move(1, 2), Mark.O);
        // board1.play(new Move(2, 0), Mark.O);

        // printTicTacToeGame(board1.getBoard());
        
        

        cpu1.getNextMoveMinMax(board1);

        for (int i = 0; i < cpu1.getNextMoveMinMax(board1).size(); i++) {
            System.out.println(cpu1.getNextMoveMinMax(board1).get(i));
        }

        // System.out.println(board1.evaluate(Mark.X));

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
