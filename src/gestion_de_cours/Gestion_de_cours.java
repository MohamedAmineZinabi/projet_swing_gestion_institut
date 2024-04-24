package gestion_de_cours;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.imageio.ImageIO;

public class Gestion_de_cours  {

    private JFrame frame;
    private JTextField textFieldUser;
    private JPasswordField passwordField;
    private JPanel panel14;
    private JPanel panel15;
    private Point lastPoint;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Gestion_de_cours window = new Gestion_de_cours();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Gestion_de_cours() {
       
        frame = new JFrame();
        frame.getContentPane().setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 9));
        frame.getContentPane().setBackground(new Color(30, 30, 30));
        frame.getContentPane().setLayout(null);
        frame.setUndecorated(true);
        frame.setBounds(100, 100, 855, 424);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel11 = new JPanel();
        panel11.setBackground(new Color(0, 128, 128));
        panel11.setBounds(0, 0, 855, 58);
        panel11.setLayout(null);
        panel11.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                lastPoint = e.getLocationOnScreen();
            }
        });
        panel11.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                int deltaX = e.getLocationOnScreen().x - lastPoint.x;
                int deltaY = e.getLocationOnScreen().y - lastPoint.y;

                int newX = frame.getLocation().x + deltaX;
                int newY = frame.getLocation().y + deltaY;

                frame.setLocation(newX, newY);

                lastPoint = e.getLocationOnScreen();
            }
        });
        frame.getContentPane().add(panel11);

        JButton button15 = new JButton("");
        button15.setIcon(new ImageIcon(Gestion_de_cours.class.getResource("/images/icons8-multiply-30.png")));
        button15.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 13));
        button15.setForeground(Color.WHITE);
        button15.setBackground(new Color(0, 127, 127));
        button15.setOpaque(true);
        button15.setBorderPainted(false);
        button15.setBounds(817, 0, 38, 58);
        button15.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0); // Ferme l'application
            }
        });

        panel11.add(button15);

        JButton button17 = new JButton("");
        button17.setIcon(new ImageIcon(Gestion_de_cours.class.getResource("/images/icons8-remove-30.png")));
        button17.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 13));
        button17.setForeground(Color.WHITE);
        button17.setBackground(new Color(0, 127, 127));
        button17.setOpaque(true);
        button17.setBorderPainted(false);
        button17.setBounds(779, 0, 38, 58);
        button17.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setExtendedState(JFrame.ICONIFIED); // Réduit la fenêtre à l'icône de la barre des tâches
            }
        });
        panel11.add(button17);

        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(0, 128, 128));
        panel_1.setBounds(0, 58, 130, 365);
        frame.getContentPane().add(panel_1);

        JLabel label11 = new JLabel("Connexion");
        label11.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 14));
        label11.setForeground(Color.WHITE);
        label11.setBounds(413, 71, 103, 24);
        frame.getContentPane().add(label11);

        JPanel panel12 = new JPanel();
        panel12.setBackground(new Color(30, 30, 30));
        panel12.setBounds(206, 110, 478, 59);
        panel12.setLayout(null);
        frame.getContentPane().add(panel12);

        textFieldUser = new JTextField();
        textFieldUser.setForeground(Color.WHITE);
        textFieldUser.setBackground(new Color(30, 30, 30));
        textFieldUser.setBounds(192, 11, 272, 23);
        textFieldUser.setBorder(null);
        panel12.add(textFieldUser);
        textFieldUser.setColumns(10);

        JPanel panel13 = new JPanel();
        panel13.setBounds(192, 47, 272, 1);
        panel13.setBackground(Color.WHITE);
        panel12.add(panel13);

        JLabel label7 = new JLabel("Nom Utilisateur");
        label7.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 14));
        label7.setForeground(Color.WHITE);
        label7.setBounds(60, 11, 107, 18);
        panel12.add(label7);

        JPanel panel3 = new JPanel();
        panel3.setBounds(0, 0, 50, 34);
        panel3.setBackground(new Color(30, 30, 30));
        panel3.setLayout(new BorderLayout());
        panel12.add(panel3);

        JPanel imagePanel = new JPanel(new BorderLayout());
        imagePanel.setOpaque(false);
        panel3.add(imagePanel, BorderLayout.CENTER);

        try {
            BufferedImage image = ImageIO.read(new File("C:\\Users\\hp\\eclipse-workspace\\Gestion_de_cours\\src\\images\\person-icon-1680.png"));
            Image scaledImage = image.getScaledInstance(panel3.getWidth(), panel3.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon icon = new ImageIcon(scaledImage);
            JLabel label = new JLabel(icon);
            imagePanel.add(label, BorderLayout.CENTER);
        } catch (IOException e) {
            e.printStackTrace();
        }

        panel14 = new JPanel();
        panel14.setBackground(new Color(30, 30, 30));
        panel14.setBounds(349, 175, 335, 41);
        panel14.setLayout(null);
        panel14.setVisible(false);
        frame.getContentPane().add(panel14);

        JLabel label8 = new JLabel("Nom Utilisateur incorrect");
        label8.setForeground(Color.RED);
        label8.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 13));
        label8.setBounds(92, 11, 169, 18);
        panel14.add(label8);

        JPanel panel16 = new JPanel();
        panel16.setLayout(null);
        panel16.setBackground(new Color(30, 30, 30));
        panel16.setBounds(206, 237, 478, 59);
        frame.getContentPane().add(panel16);

        JPanel panel17 = new JPanel();
        panel17.setBackground(Color.WHITE);
        panel17.setBounds(192, 47, 272, 1);
        panel16.add(panel17);

        JLabel label10 = new JLabel("mot de passe");
        label10.setForeground(Color.WHITE);
        label10.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 14));
        label10.setBounds(60, 11, 107, 18);
        panel16.add(label10);

        JPanel panel4 = new JPanel();
        panel4.setBounds(0, 0, 50, 34);
        panel4.setBackground(new Color(30, 30, 30));
        panel4.setLayout(new BorderLayout());
        panel16.add(panel4);

        JPanel imagePanel2 = new JPanel(new BorderLayout());
        imagePanel2.setOpaque(false);
        panel4.add(imagePanel2, BorderLayout.CENTER);

        try {
            BufferedImage image2 = ImageIO.read(new File("C:\\Users\\hp\\eclipse-workspace\\Gestion_de_cours\\src\\images\\icons8-lock-32 (1).png"));
            Image scaledImage2 = image2.getScaledInstance(panel4.getWidth(), panel4.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon icon2 = new ImageIcon(scaledImage2);
            JLabel label2 = new JLabel(icon2);
            imagePanel2.add(label2, BorderLayout.CENTER);

            passwordField = new JPasswordField();
            passwordField.setForeground(Color.WHITE);
            passwordField.setBackground(new Color(30, 30, 30));
            passwordField.setBounds(192, 11, 272, 25);
            passwordField.setBorder(null);
            panel16.add(passwordField);
        } catch (IOException e) {
            e.printStackTrace();
        }

        panel15 = new JPanel();
        panel15.setLayout(null);
        panel15.setBackground(new Color(30, 30, 30));
        panel15.setBounds(349, 302, 335, 41);
        panel15.setVisible(false);
        frame.getContentPane().add(panel15);

        JLabel label9 = new JLabel("mot de passe incorrect");
        label9.setForeground(Color.RED);
        label9.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 13));
        label9.setBounds(92, 11, 169, 18);
        panel15.add(label9);

        JButton button2 = new JButton("Connexion");
        button2.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 13));
        button2.setForeground(Color.WHITE);
        button2.setBackground(new Color(30, 30, 30));
        button2.setOpaque(true);
        button2.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        button2.setBounds(390, 366, 126, 36);
        frame.getContentPane().add(button2);
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                connectToDatabase();
            }
        });

    }

    private void connectToDatabase() {
        String user = textFieldUser.getText();
        String password = new String(passwordField.getPassword());

        String connectionString = "jdbc:mysql://localhost/sfe";
        String dbUser = "amineznb";
        String dbPassword = "123654789582";

        try {
            Connection conn = DriverManager.getConnection(connectionString, dbUser, dbPassword);

            String query = "SELECT * FROM conn WHERE user=? AND password=?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, user);
            statement.setString(2, password);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                // Successful login
                frame.dispose(); // Close login form
                new Home(this).setVisible(true); // Open next form
            } else {
                // Invalid user/password
                resultSet.close();

                String queryCheckUser = "SELECT * FROM conn WHERE user=?";
                PreparedStatement statementCheckUser = conn.prepareStatement(queryCheckUser);
                statementCheckUser.setString(1, user);
                ResultSet resultSetCheckUser = statementCheckUser.executeQuery();

                if (resultSetCheckUser.next()) {
                    panel15.setVisible(true); // Show panel15 if password is incorrect
                } else {
                    panel14.setVisible(true); // Show panel14 if user does not exist
                }

                resultSetCheckUser.close();
            }

            resultSet.close();
            conn.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(frame, "Connection error: " + ex.getMessage());
        }
    }
    public void showWindow() {
        frame.setVisible(true);
    }

}

