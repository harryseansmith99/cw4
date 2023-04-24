
package cwk4;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class GameGUI extends JPanel implements ActionListener {
    private Image image;

    private WIN sw = new SpaceWars("");
    JTextArea textArea = textFrame();

    String admiralName = "";

    private void createText(String s, String t) {
        JPanel middlePanel = new JPanel();
        middlePanel.setBorder(new TitledBorder(new EtchedBorder(), t));
        middlePanel.setBackground(new Color(194, 178, 128));

        JTextArea display = new JTextArea(16, 40);
        display.setText(s);
        display.setBackground(new Color(194, 178, 128));
        display.setEditable(false);
        JScrollPane scroll = new JScrollPane(display);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        middlePanel.add(scroll);
        Frame frame = new JFrame();
        frame.add(middlePanel);
        frame.pack();

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setResizable(false);

    }

    private void getForce() {
        JPanel middlePanel = new JPanel();
        middlePanel.setBorder(new TitledBorder(new EtchedBorder(), "Get Force Details"));
        middlePanel.setBackground(new Color(194, 178, 128));

        JTextArea display = new JTextArea();
        String s = "Enter Force ID:";
        display.setEditable(false);
        display.setBorder(new TitledBorder(new EtchedBorder(), s));
        display.setBackground(new Color(194, 178, 128));

        JTextField inputField = new JTextField();
        inputField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                display.setText("");
                String text = inputField.getText();

                String ww = sw.getForceDetails(text);

                if (ww != null) {
                    display.append(ww + "\n\r");
                    inputField.setText("");

                } else {
                    display.append("No such Force" + "\n\r");
                    inputField.setText("");
                }

            }
        });

        Frame frame = new JFrame();
        frame.setBackground(new Color(194, 178, 128));
        frame.add(middlePanel);
        frame.add(display);
        frame.add(inputField, BorderLayout.SOUTH);
        frame.setSize(200, 250);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setResizable(false);

    }

    private void activateForce() {
        JPanel middlePanel = new JPanel();
        middlePanel.setBorder(new TitledBorder(new EtchedBorder()));
        middlePanel.setBackground(new Color(194, 178, 128));

        JTextArea display = new JTextArea();
        String s = "Please Enter Force ID";
        display.setEditable(false);
        display.setBorder(new TitledBorder(new EtchedBorder(), s));
        display.setBackground(new Color(194, 178, 128));

        JTextField inputField = new JTextField();
        inputField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                display.setText("");
                String text = inputField.getText();

                int res = sw.activateForce(text);
                String ww = "";
                if (res == 0) {
                    ww = "Force has been activated!";

                }

                else if (res == 1) {
                    ww = "Force not in the UEF dock!";
                }

                else if (res == 2) {
                    ww = "Not enough money to activate!";

                }

                else if (res == -1) {
                    ww = "No such force!";

                }

                else {
                    ww = "Unexpected input";

                }

                display.append(ww + "\n\r");
                inputField.setText("");

            }
        });

        Frame frame = new JFrame();
        frame.setBackground(new Color(194, 178, 128));
        frame.add(middlePanel);
        frame.add(display);
        frame.add(inputField, BorderLayout.SOUTH);
        frame.setSize(200, 250);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setResizable(false);

    }

    private void doBattle() {
        JPanel middlePanel = new JPanel();
        middlePanel.setBorder(new TitledBorder(new EtchedBorder()));
        middlePanel.setBackground(new Color(194, 178, 128));

        JTextArea display = new JTextArea();
        String s = "Please Enter Battle ID";
        display.setEditable(false);
        display.setBorder(new TitledBorder(new EtchedBorder(), s));
        display.setBackground(new Color(194, 178, 128));

        JTextField inputField = new JTextField();
        inputField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                display.setText("");
                int text = Integer.parseInt(inputField.getText());

                int res = sw.doBattle(text);
                String ww = "";
                if (res == 0) {
                    ww = ("Congratulations. Battle won!");
                } else if (res == 1) {
                    ww = ("Battle lost as no suitable force available.");
                } else if (res == 2) {
                    ww = ("Battle lost. Force wasn`t strong enough.");
                } else if (res == 3) {
                    ww = ("Battle lost. You have been defeated.");
                } else if (res == -1) {
                    ww = ("Selected battle doesn`t exist. Please select an appropriate number.");
                } else {
                    ww = ("Unexpected exception.");
                }

                display.append(ww + "\n\r");
                inputField.setText("");

            }
        });

        Frame frame = new JFrame();
        frame.setBackground(new Color(194, 178, 128));
        frame.add(middlePanel);
        frame.add(display);
        frame.add(inputField, BorderLayout.SOUTH);
        frame.setSize(400, 200);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setResizable(false);

    }

    private void recallForce() {
        JPanel middlePanel = new JPanel();
        middlePanel.setBorder(new TitledBorder(new EtchedBorder(), "Recall a Force"));
        middlePanel.setBackground(new Color(194, 178, 128));

        JTextArea display = new JTextArea();
        String s = "Enter Force ID:";
        display.setEditable(false);
        display.setBorder(new TitledBorder(new EtchedBorder(), s));
        display.setBackground(new Color(194, 178, 128));

        JTextField inputField = new JTextField();
        inputField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                display.setText("");
                String text = inputField.getText();

                sw.recallForce(text);
                inputField.setText("");

            }
        });

        Frame frame = new JFrame();
        frame.setBackground(new Color(194, 178, 128));
        frame.add(middlePanel);
        frame.add(display);
        frame.add(inputField, BorderLayout.SOUTH);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setResizable(false);

    }

    private void saveGame() {
        sw.saveGame(admiralName);
    }

    private void loadGame() {
        JPanel middlePanel = new JPanel();
        middlePanel.setBorder(new TitledBorder(new EtchedBorder(), "Load Game"));
        middlePanel.setBackground(new Color(194, 178, 128));

        File fileList = new File("src/cwk4/Saved Games/");

        JTextArea display = new JTextArea();
        String s = "Enter Admiral Name";
        display.setEditable(false);
        display.setBorder(new TitledBorder(new EtchedBorder(), s));
        display.setBackground(new Color(194, 178, 128));
        display.setText("Available saves: \n \n");

        String fl = "";

        for (File tempfile : fileList.listFiles()) {
            fl = (capitalize(tempfile.getName().replaceFirst("[.][^.]+$", "")));
            display.append(fl + "\n");
        }

        JTextField inputField = new JTextField();

        inputField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                display.setText("");
                String text = inputField.getText();

                sw = sw.restoreGame(text);
                inputField.setText("");

                ((JFrame) SwingUtilities.getWindowAncestor(inputField)).dispose();
            }
        });

        Frame frame = new JFrame();
        frame.setBackground(new Color(194, 178, 128));
        frame.add(middlePanel);
        frame.add(display);
        frame.add(inputField, BorderLayout.SOUTH);
        frame.setSize(200, 300);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setResizable(false);

    }

    private String capitalize(String str) {
        if (str == null || str.length() == 0)
            return str;
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

    private static String getPlayerName() {
        String playerName = JOptionPane.showInputDialog(null, "Please enter your name, Admiral:");
        if (playerName == null || playerName.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Invalid name, please try again.");
            playerName = getPlayerName();
        }
        return playerName;
    }

    public static void playSound() {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("src/cwk4/Resources/bgm.wav"));
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);

            clip.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (Exception ex) {
            System.out.println("Error with playing sound.");
            ex.printStackTrace();
        }
    }

    private JTextArea textFrame() {

        JTextArea textArea = new JTextArea("Welcome to SpaceWars.\n\rEnjoy the game!");

        textArea.setForeground(new Color(248, 244, 255));
        textArea.setMargin(new Insets(2, 50, 2, 2));
        textArea.setHighlighter(null);
        textArea.setRows(5);
        textArea.setOpaque(false);
        textArea.setLocation(new Point(50, 50));
        textArea.setMinimumSize(new Dimension(400, 40));
        textArea.setCursor(null);
        textArea.setWrapStyleWord(true);
        textArea.setLineWrap(true);
        textArea.setPreferredSize(new Dimension(500, 400));
        textArea.setFont(new Font("Lucida Calligraphy", Font.BOLD, 34));
        textArea.setEditable(false);

        return textArea;

    }

    private GameGUI(String amName) {

        admiralName = amName;

        sw = new SpaceWars(amName);

        try {
            image = ImageIO.read(new File("src/cwk4/Resources/bcg.jpg"));

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        textArea = textFrame();

        setLayout(new BorderLayout());

        JLabel background = new JLabel(new ImageIcon(image));
        FlowLayout fl_background = new FlowLayout(FlowLayout.LEFT);
        fl_background.setVgap(0);
        fl_background.setHgap(0);
        background.setLayout(fl_background);
        add(background);

        JPanel buttonPanel = new JPanel(new GridLayout(11, 1));
        buttonPanel.setBorder(new EmptyBorder(30, 30, 0, 0));
        buttonPanel.setOpaque(false);

        JButton lafButton = new JButton("List All Forces");
        lafButton.setPreferredSize(new Dimension(170, 45));
        buttonPanel.add(lafButton);
        lafButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                createText(sw.getAllForces(), "List all Forces");
            }
        });

        JButton abButton = new JButton("List All Battles");
        abButton.setPreferredSize(new Dimension(170, 45));
        buttonPanel.add(abButton);
        abButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                createText(sw.getAllBattles(), "List all Forces");
            }
        });

        JButton gdfButton = new JButton("Get Details Of a Force");
        gdfButton.setPreferredSize(new Dimension(170, 45));
        buttonPanel.add(gdfButton);
        gdfButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                getForce();
            }
        });

        JButton afButton = new JButton("Activate a Force");
        afButton.setPreferredSize(new Dimension(170, 45));
        buttonPanel.add(afButton);
        afButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                activateForce();
            }
        });

        JButton lfButton = new JButton("View Active Star Fleet");
        lfButton.setPreferredSize(new Dimension(170, 45));
        buttonPanel.add(lfButton);
        lfButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                createText(sw.getASFleet(), "List Active Star Fleet");
            }
        });

        JButton bButton = new JButton("Battle");
        bButton.setPreferredSize(new Dimension(170, 45));
        buttonPanel.add(bButton);
        bButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                doBattle();
            }
        });

        JButton rButton = new JButton("Recall Force");
        rButton.setPreferredSize(new Dimension(170, 45));
        buttonPanel.add(rButton);
        rButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                recallForce();
            }
        });

        JButton gsButton = new JButton("Game State");
        gsButton.setPreferredSize(new Dimension(170, 45));
        buttonPanel.add(gsButton);
        gsButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                createText(sw.toString(), "State of the game");
            }
        });

        JButton sButton = new JButton("Save Game");
        sButton.setPreferredSize(new Dimension(170, 45));
        buttonPanel.add(sButton);
        sButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                saveGame();
            }
        });

        JButton lButton = new JButton("Load Game");
        lButton.setPreferredSize(new Dimension(170, 45));
        buttonPanel.add(lButton);
        lButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                loadGame();
            }
        });

        background.add(buttonPanel);

        background.add(textArea, BorderLayout.EAST);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

    private static void createGUI() {

        JFrame frame = new JFrame("SpaceWars GUI");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        GameGUI gui = new GameGUI(getPlayerName());

        frame.getContentPane().add(gui);
        frame.setSize(900, 600);

        frame.setLocationByPlatform(true);
        frame.setVisible(true);

    }

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                playSound();
                createGUI();

            }
        });

    }

}
