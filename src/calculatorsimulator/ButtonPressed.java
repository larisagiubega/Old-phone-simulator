/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculatorsimulator;

import static calculatorsimulator.CalculatorSimulator.*;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.concurrent.TimeUnit;
import javax.swing.JButton;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;

/**
 *
 * @author laris
 */
public class ButtonPressed implements ActionListener {

    static int pressings = 0, prev_pressings;
    static JButton oldAction = new JButton();
    static boolean upperCase = false;

    int currentAct = 0; // 0 - fName, 1 - lName, 2 - address, 3 - no

    static String fName = "";
    static String lName = "";
    static String address = "";
    static String no = "";

    public void noOfPressings(int p) {
        this.pressings = p;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() != oldAction) {
            pressings = 1;
            text.setText(text.getText().concat(" "));
        } else {
            pressings++;
        }

        if (e.getSource() == buttons[0]) {
            // text.setText(text.getText().concat(" OK "));
            System.out.println(pressings);
            if (agenda == true) {
                if (currentAct < 4) {
                    currentAct++;
                } else {
                    currentAct = 0;
                }
            }
        }

        if (e.getSource() == buttons[1]) {
            // text.setText(text.getText().concat(" LEFT "));
            System.out.println(pressings);
            if (calculator == false && agenda == false) {
                text.setText(text.getText().concat("\nYou chose the calculator.\n"));
                calculator = true;
            } else if (pressings == 1) {
                text.setText(text.getText().concat("\nYou've already chosen "));
                if (agenda) {
                    text.setText(text.getText().concat("the agenda.\n"));
                }
                if (calculator) {
                    text.setText(text.getText().concat("the calculator.\n"));
                }
                text.setText(text.getText().concat("To back out press CANCEL."));
            }
        }

        if (e.getSource()
                == buttons[2]) {
            // text.setText(text.getText().concat(" UP "));
            System.out.println(pressings);

        }

        if (e.getSource()
                == buttons[3]) {
            //  text.setText(text.getText().concat(" DOWN "));
            System.out.println(pressings);
        }

        if (e.getSource()
                == buttons[4]) {
            //  text.setText(text.getText().concat(" RIGHT "));
            System.out.println(pressings);

            if (calculator == false && agenda == false) {
                text.setText(text.getText().concat("\nYou chose the agenda. \n "));
                agenda = true;
            } else if (pressings == 1) {
                text.setText(text.getText().concat("\nYou've already chosen "));
                if (agenda) {
                    text.setText(text.getText().concat("the agenda. \n"));
                }
                if (calculator) {
                    text.setText(text.getText().concat("the calculator. \n"));
                }
                text.setText(text.getText().concat("To back out press CANCEL."));

            }
        }

        if (e.getSource()
                == buttons[5]) {
            //   text.setText(text.getText().concat(" CANCEL "));
            System.out.println(pressings);
            calculator = false;
            agenda = false;

            if (pressings == 1) {
                text.setText(text.getText().concat("\nPress LEFT button to use the calculator and RIGHT button to use the agenda"));
            }
        }

        if (e.getSource()
                == buttons[6]) {
            //  text.setText(text.getText().concat(" B1 "));
            System.out.println(pressings);
            if (agenda || calculator) {
                switch (pressings) {
                    case 1:
                        text.setText(text.getText().substring(0, text.getText().length() - 1) + '.');
                        break;
                    case 2:
                        text.setText(text.getText().substring(0, text.getText().length() - 1) + ',');
                        break;
                    case 3:
                        text.setText(text.getText().substring(0, text.getText().length() - 1) + '?');
                        break;
                    case 4:
                        text.setText(text.getText().substring(0, text.getText().length() - 1) + '!');
                        break;
                    default:
                        if (agenda && currentAct == 3) {
                            no.concat("1");
                        } else {
                            text.setText(text.getText().substring(0, text.getText().length() - 1) + '1');
                        }

                        pressings = 0;

                }
            }
        }

        if (e.getSource()
                == buttons[7]) {
            // text.setText(text.getText().concat(" B2 "));
            System.out.println(pressings);

            if (agenda || calculator) {
                if (upperCase == false) {
                    switch (pressings) {
                        case 1:
                            text.setText(text.getText().substring(0, text.getText().length() - 1) + 'a');
                            break;
                        case 2:
                            text.setText(text.getText().substring(0, text.getText().length() - 1) + 'b');
                            break;
                        case 3:
                            text.setText(text.getText().substring(0, text.getText().length() - 1) + 'c');
                            break;
                        default:
                            if (agenda && currentAct == 3) {
                                no.concat("2");
                            } else {
                                text.setText(text.getText().substring(0, text.getText().length() - 1) + '2');
                            }
                            pressings = 0;
                    }
                } else {
                    switch (pressings) {
                        case 1:
                            text.setText(text.getText().substring(0, text.getText().length() - 1) + 'A');
                            break;
                        case 2:
                            text.setText(text.getText().substring(0, text.getText().length() - 1) + 'B');
                            break;
                        case 3:
                            text.setText(text.getText().substring(0, text.getText().length() - 1) + 'C');
                            break;
                        default:
                            if (agenda && currentAct == 3) {
                                no.concat("2");
                            } else {
                                text.setText(text.getText().substring(0, text.getText().length() - 1) + '2');
                            }
                            pressings = 0;
                    }
                }
            }
        }

        if (e.getSource()
                == buttons[8]) {
            //text.setText(text.getText().concat(" B3 "));
            System.out.println(pressings);
            if (agenda || calculator) {
                if (upperCase == false) {
                    switch (pressings) {
                        case 1:
                            text.setText(text.getText().substring(0, text.getText().length() - 1) + 'd');
                            break;
                        case 2:
                            text.setText(text.getText().substring(0, text.getText().length() - 1) + 'e');
                            break;
                        case 3:
                            text.setText(text.getText().substring(0, text.getText().length() - 1) + 'f');
                            break;
                        default:
                            if (agenda && currentAct == 3) {
                                no.concat("3");
                            } else {

                                text.setText(text.getText().substring(0, text.getText().length() - 1) + '3');
                            }

                            pressings = 0;
                    }
                } else {
                    switch (pressings) {
                        case 1:
                            text.setText(text.getText().substring(0, text.getText().length() - 1) + 'D');
                            break;
                        case 2:
                            text.setText(text.getText().substring(0, text.getText().length() - 1) + 'E');
                            break;
                        case 3:
                            text.setText(text.getText().substring(0, text.getText().length() - 1) + 'F');
                            break;
                        default:
                            if (agenda && currentAct == 3) {
                                no.concat("3");
                            } else {
                                text.setText(text.getText().substring(0, text.getText().length() - 1) + '3');
                            }

                            pressings = 0;
                    }
                }
            }
        }

        if (e.getSource()
                == buttons[9]) {
            //  text.setText(text.getText().concat(" B4 "));
            System.out.println(pressings);
            if (agenda || calculator) {
                if (upperCase == false) {
                    switch (pressings) {
                        case 1:
                            text.setText(text.getText().substring(0, text.getText().length() - 1) + 'g');
                            break;
                        case 2:
                            text.setText(text.getText().substring(0, text.getText().length() - 1) + 'h');
                            break;
                        case 3:
                            text.setText(text.getText().substring(0, text.getText().length() - 1) + 'i');
                            break;
                        default:
                            if (agenda && currentAct == 3) {
                                no.concat("4");
                            } else {
                                text.setText(text.getText().substring(0, text.getText().length() - 1) + '4');
                            }

                            pressings = 0;
                    }
                } else {
                    switch (pressings) {
                        case 1:
                            text.setText(text.getText().substring(0, text.getText().length() - 1) + 'G');
                            break;
                        case 2:
                            text.setText(text.getText().substring(0, text.getText().length() - 1) + 'H');
                            break;
                        case 3:
                            text.setText(text.getText().substring(0, text.getText().length() - 1) + 'I');
                            break;
                        default:
                            if (agenda && currentAct == 3) {
                                no.concat("4");
                            } else {
                                text.setText(text.getText().substring(0, text.getText().length() - 1) + '4');
                            }

                            pressings = 0;
                    }
                }
            }
        }

        if (e.getSource()
                == buttons[10]) {
            //   text.setText(text.getText().concat(" B5 ")); 
            System.out.println(pressings);
            if (agenda || calculator) {
                if (upperCase == false) {
                    switch (pressings) {
                        case 1:
                            text.setText(text.getText().substring(0, text.getText().length() - 1) + 'j');
                            break;
                        case 2:
                            text.setText(text.getText().substring(0, text.getText().length() - 1) + 'k');
                            break;
                        case 3:
                            text.setText(text.getText().substring(0, text.getText().length() - 1) + 'l');
                            break;
                        default:
                            if (agenda && currentAct == 3) {
                                no.concat("5");
                            } else {
                                text.setText(text.getText().substring(0, text.getText().length() - 1) + '5');
                            }

                            pressings = 0;
                    }
                } else {
                    switch (pressings) {
                        case 1:
                            text.setText(text.getText().substring(0, text.getText().length() - 1) + 'J');
                            break;
                        case 2:
                            text.setText(text.getText().substring(0, text.getText().length() - 1) + 'K');
                            break;
                        case 3:
                            text.setText(text.getText().substring(0, text.getText().length() - 1) + 'L');
                            break;
                        default:
                            if (agenda && currentAct == 3) {
                                no.concat("5");
                            } else {
                                text.setText(text.getText().substring(0, text.getText().length() - 1) + '5');
                            }

                            pressings = 0;
                    }
                }
            }
        }

        if (e.getSource()
                == buttons[11]) {
            //   text.setText(text.getText().concat(" B6 "));
            System.out.println(pressings);
            if (agenda || calculator) {
                if (upperCase == false) {
                    switch (pressings) {
                        case 1:
                            text.setText(text.getText().substring(0, text.getText().length() - 1) + 'm');
                            break;
                        case 2:
                            text.setText(text.getText().substring(0, text.getText().length() - 1) + 'n');
                            break;
                        case 3:
                            text.setText(text.getText().substring(0, text.getText().length() - 1) + 'o');
                            break;
                        default:
                            if (agenda && currentAct == 3) {
                                no.concat("6");
                            } else {
                                text.setText(text.getText().substring(0, text.getText().length() - 1) + '6');
                            }

                            pressings = 0;
                    }
                } else {
                    switch (pressings) {
                        case 1:
                            text.setText(text.getText().substring(0, text.getText().length() - 1) + 'M');
                            break;
                        case 2:
                            text.setText(text.getText().substring(0, text.getText().length() - 1) + 'N');
                            break;
                        case 3:
                            text.setText(text.getText().substring(0, text.getText().length() - 1) + 'O');
                            break;
                        default:
                            if (agenda && currentAct == 3) {
                                no.concat("6");
                            } else {
                                text.setText(text.getText().substring(0, text.getText().length() - 1) + '6');
                            }

                            pressings = 0;
                    }
                }
            }
        }

        if (e.getSource()
                == buttons[12]) {
            //    text.setText(text.getText().concat(" B7 "));
            System.out.println(pressings);
            if (agenda || calculator) {
                if (upperCase == false) {
                    switch (pressings) {
                        case 1:
                            text.setText(text.getText().substring(0, text.getText().length() - 1) + 'p');
                            break;
                        case 2:
                            text.setText(text.getText().substring(0, text.getText().length() - 1) + 'q');
                            break;
                        case 3:
                            text.setText(text.getText().substring(0, text.getText().length() - 1) + 'r');
                            break;
                        case 4:
                            text.setText(text.getText().substring(0, text.getText().length() - 1) + 's');
                            break;
                        default:
                            if (agenda && currentAct == 3) {
                                no.concat("7");
                            } else {
                                text.setText(text.getText().substring(0, text.getText().length() - 1) + '7');
                            }

                            pressings = 0;
                    }
                } else {
                    switch (pressings) {

                        case 1:
                            text.setText(text.getText().substring(0, text.getText().length() - 1) + 'P');
                            break;
                        case 2:
                            text.setText(text.getText().substring(0, text.getText().length() - 1) + 'Q');
                            break;
                        case 3:
                            text.setText(text.getText().substring(0, text.getText().length() - 1) + 'R');
                            break;
                        case 4:
                            text.setText(text.getText().substring(0, text.getText().length() - 1) + 'S');
                            break;
                        default:
                            if (agenda && currentAct == 3) {
                                no.concat("7");
                            } else {
                                text.setText(text.getText().substring(0, text.getText().length() - 1) + '7');
                            }

                            pressings = 0;
                    }
                }
            }
        }

        if (e.getSource()
                == buttons[13]) {
            //   text.setText(text.getText().concat(" B8 "));
            System.out.println(pressings);
            if (agenda || calculator) {
                if (upperCase == false) {
                    switch (pressings) {
                        case 1:
                            text.setText(text.getText().substring(0, text.getText().length() - 1) + 't');
                            break;
                        case 2:
                            text.setText(text.getText().substring(0, text.getText().length() - 1) + 'u');
                            break;
                        case 3:
                            text.setText(text.getText().substring(0, text.getText().length() - 1) + 'v');
                            break;
                        default:
                            if (agenda && currentAct == 3) {
                                no.concat("8");
                            } else {
                                text.setText(text.getText().substring(0, text.getText().length() - 1) + '8');
                            }

                            pressings = 0;
                    }
                } else {
                    switch (pressings) {
                        case 1:
                            text.setText(text.getText().substring(0, text.getText().length() - 1) + 'T');
                            break;
                        case 2:
                            text.setText(text.getText().substring(0, text.getText().length() - 1) + 'U');
                            break;
                        case 3:
                            text.setText(text.getText().substring(0, text.getText().length() - 1) + 'V');
                            break;
                        default:
                            if (agenda && currentAct == 3) {
                                no.concat("8");
                            } else {
                                text.setText(text.getText().substring(0, text.getText().length() - 1) + '8');
                            }

                            pressings = 0;
                    }
                }
            }
        }

        if (e.getSource()
                == buttons[14]) {
            //  text.setText(text.getText().concat(" B9 ")); 
            System.out.println(pressings);
            if (agenda || calculator) {
                if (upperCase == false) {
                    switch (pressings) {
                        case 1:
                            text.setText(text.getText().substring(0, text.getText().length() - 1) + 'w');
                            break;
                        case 2:
                            text.setText(text.getText().substring(0, text.getText().length() - 1) + 'x');
                            break;
                        case 3:
                            text.setText(text.getText().substring(0, text.getText().length() - 1) + 'y');
                            break;
                        case 4:
                            text.setText(text.getText().substring(0, text.getText().length() - 1) + 'z');
                            break;
                        default:
                            if (agenda && currentAct == 3) {
                                no.concat("9");
                            } else {
                                text.setText(text.getText().substring(0, text.getText().length() - 1) + '9');
                            }

                            pressings = 0;
                    }
                } else {
                    switch (pressings) {

                        case 1:
                            text.setText(text.getText().substring(0, text.getText().length() - 1) + 'W');
                            break;
                        case 2:
                            text.setText(text.getText().substring(0, text.getText().length() - 1) + 'X');
                            break;
                        case 3:
                            text.setText(text.getText().substring(0, text.getText().length() - 1) + 'Y');
                            break;
                        case 4:
                            text.setText(text.getText().substring(0, text.getText().length() - 1) + 'Z');
                            break;
                        default:
                            if (agenda && currentAct == 3) {
                                no.concat("9");
                            } else {
                                text.setText(text.getText().substring(0, text.getText().length() - 1) + '9');
                            }

                            pressings = 0;
                    }
                }
            }
        }

        if (e.getSource()
                == buttons[15]) {
            //  text.setText(text.getText().concat(" B0 ")); 

            if (agenda || calculator) {
                if (agenda && currentAct == 3) {
                    no.concat("0");
                } else {
                    if (agenda) {
                        text.setText(text.getText().concat(" "));
                    } else {
                        text.setText(text.getText().concat("0"));
                    }
                }

                System.out.println(pressings);
            }
        }

        if (e.getSource()
                == buttons[16]) {
            //  text.setText(text.getText().concat(" ASTER "));
            System.out.println(pressings);
        }

        if (e.getSource()
                == buttons[17]) {
            //  text.setText(text.getText().concat(" HASH "));
            System.out.println(pressings);
            if (upperCase == false) {
                upperCase = true;
            } else {
                upperCase = false;
            }
            if (currentAct == 3 && !no.isEmpty()) {
                System.out.println(no);
            }
        }

        oldAction = (JButton) e.getSource();

    }

    public static void main(String[] args) {
//        Highlighter.HighlightPainter painter;
//        
//        try {
//            painter = new DefaultHighlighter.DefaultHighlightPainter(Color.YELLOW);
//            int startIndex = text.getLineStartOffset(lineNumber);
//            int endIndex = text.getLineEndOffset(lineNumber);
//            text.getHighlighter().addHighlight(startIndex, endIndex, painter);
//        } catch (Exception e) {
//            System.out.println("PROBLEM");
//        }
//https://stackoverflow.com/questions/10191723/highlight-one-specific-row-line-in-jtextarea

//        if (agenda == true) {
//            if (!fName.isEmpty()) {
//                text.setText(text.getText().concat("0"));
//            }
//        }
    }
}
