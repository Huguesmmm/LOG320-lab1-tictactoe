import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Graphic {
    // graphic components for the game
    private Board board;
    private CPUPlayer cpu;

    // graphic components for the window
    private JFrame frame;
    private JPanel panel;
    private JButton[][] buttons;

    // constructor
    public Graphic(Board board, CPUPlayer cpu) {
        this.board = board;
        this.cpu = cpu;

        // create the window
        frame = new JFrame("Tic Tac Toe");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);

        // create the panel
        panel = new JPanel();
        panel.setLayout(new GridLayout(3, 3));

        // create the buttons
        buttons = new JButton[3][3];
        for (int i = 0; i < buttons.length; i++) {
            for (int j = 0; j < buttons.length; j++) {
                buttons[i][j] = new JButton();
                //buttons[i][j].addActionListener(new ButtonListener(i, j));
                panel.add(buttons[i][j]);
            }
        }

        // add the panel to the frame
        frame.add(panel);

        // make the frame visible
        frame.setVisible(true);
    }
}
