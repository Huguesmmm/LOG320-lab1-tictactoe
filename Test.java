public class Test {

    public static void main(String[] args) {
        Board board1 = new Board();

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
        //board1.play(new Move(0, 1), Mark.O);
       // board1.play(new Move(0, 2), Mark.O);
        // board1.play(new Move(1, 0), Mark.EMPTY);
        //board1.play(new Move(1, 1), Mark.X);
         board1.play(new Move(1, 2), Mark.O);
        // board1.play(new Move(2, 0), Mark.O);
        // board1.play(new Move(2, 1), Mark.X);
        //board1.play(new Move(2, 2), Mark.X);

       // System.out.println(board1.evaluate(Mark.X));

        CPUPlayer player = new CPUPlayer(Mark.X);
        player.MovesAvailable(board1);


    }
    
}
