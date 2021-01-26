package calculatorsimulator;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;
import javax.swing.*;

/**
 *
 * @author laris
 */
class CalculatorSimulator {

    /**
     * @param args the command line arguments
     */
    static JFrame frame = new JFrame("Your phone");

    static JTextArea text = new JTextArea("");

    static JScrollPane scroll = new JScrollPane(text, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

    static JPanel panel = new JPanel(null);
    static JButton ok = new JButton("OK");
    static JButton cancel = new JButton("Cancel");

    static JButton up = new JButton(new ImageIcon("C:\\Users\\Larisa\\Desktop\\java proiect\\icons\\up.PNG"));
    static JButton down = new JButton(new ImageIcon("C:\\Users\\Larisa\\Desktop\\java proiect\\icons\\down.PNG"));
    static JButton left = new JButton(new ImageIcon("C:\\Users\\Larisa\\Desktop\\java proiect\\icons\\left.PNG"));
    static JButton right = new JButton(new ImageIcon("C:\\Users\\Larisa\\Desktop\\java proiect\\icons\\right.PNG"));

    static JButton b0 = new JButton("0 _");
    static JButton b1 = new JButton("1 .,?!");
    static JButton b2 = new JButton("2 abc");
    static JButton b3 = new JButton("3 def");
    static JButton b4 = new JButton("4 ghi");
    static JButton b5 = new JButton("5 jkl");
    static JButton b6 = new JButton("6 mno");
    static JButton b7 = new JButton("7 pqrs");
    static JButton b8 = new JButton("8 tuv");
    static JButton b9 = new JButton("9 wxyz");

    static JButton hash = new JButton("# ^");
    static JButton plus = new JButton("+-*/");

    static JButton[] buttons = new JButton[18];

    static boolean calculator = false;
    static boolean agenda = false;

    private static void createFrame() {

        //frame.setLayout(null);
        frame.setVisible(true);
        frame.setSize(360, 650);

        //frame.setBackground(Color.GRAY);
        //frame.setLocationRelativeTo(null); //window centered on screen
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel.setBackground(Color.GRAY);

        createButtons();
        createTextArea();
        frame.add(panel);

    }

    private static void createButtons() {

        up.setMnemonic(KeyEvent.VK_PAGE_UP);
        down.setMnemonic(KeyEvent.VK_PAGE_DOWN);
        left.setMnemonic(KeyEvent.VK_KP_LEFT);
        right.setMnemonic(KeyEvent.VK_KP_RIGHT);

        b0.setMnemonic(0);
        b1.setMnemonic(1);
        b2.setMnemonic(2);
        b3.setMnemonic(3);
        b4.setMnemonic(4);
        b5.setMnemonic(5);
        b6.setMnemonic(6);
        b7.setMnemonic(7);
        b8.setMnemonic(8);
        b9.setMnemonic(9);

        initializeButtons();

        buttons[0] = ok;
        buttons[1] = left;
        buttons[2] = up;
        buttons[3] = down;
        buttons[4] = right;
        buttons[5] = cancel;
        buttons[6] = b1;
        buttons[7] = b2;
        buttons[8] = b3;
        buttons[9] = b4;
        buttons[10] = b5;
        buttons[11] = b6;
        buttons[12] = b7;
        buttons[13] = b8;
        buttons[14] = b9;
        buttons[15] = b0;
        buttons[16] = plus;
        buttons[17] = hash;

        for (int i = 0; i < 18; i++) {
            if (i > 0 && i < 5) {
                buttons[i].setSize(45, 20);
            } else {
                buttons[i].setSize(80, 30);
            }

            buttons[i].setBackground(Color.white);
            panel.add(buttons[i]);
        }
    }

    private static void createTextArea() {
        text.setEditable(false);
        text.setBounds(10, 10, 315, 200);
        text.setVisible(true);

        scroll.setBounds(10, 10, 330, 210);

        text.setLineWrap(true);
        // panel.add(text);
        panel.add(scroll);

    }

    private static void initializeButtons() {
        ok.setLocation(10, 250);

        up.setLocation(150, 230);
        down.setLocation(150, 270);
        left.setLocation(130, 250);
        right.setLocation(170, 250);

        cancel.setLocation(255, 250);

        b1.setLocation(10, 350);
        b2.setLocation(133, 350);
        b3.setLocation(255, 350);

        b4.setLocation(10, 400);
        b5.setLocation(133, 400);
        b6.setLocation(255, 400);

        b7.setLocation(10, 450);
        b8.setLocation(133, 450);
        b9.setLocation(255, 450);

        plus.setLocation(10, 500);
        b0.setLocation(133, 500);
        hash.setLocation(255, 500);
    }

    public static void main(String[] args) {
        createFrame();

        ButtonPressed button = new ButtonPressed();
        if (calculator == false && agenda == false) {
            text.setText(text.getText().concat("Press LEFT button to use the calculator and RIGHT button to use the agenda"));
        }

        for (int i = 0; i < 18; i++) {
            buttons[i].addActionListener(button);
        }

        while (true) {
            try {
                TimeUnit.SECONDS.sleep(4);
                button.noOfPressings(0);
                System.out.println("OK");
            } catch (Exception e) {
                Thread.currentThread().interrupt();
            }

        }

    }
}



