package gestion_de_cours;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

public class Home extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private Point lastPoint;
    private static boolean ft = true;
    private static JPanel panel4;
    private static JPanel panel5;
    private static JPanel panel8;
    private Timer timer2;
    private Timer timer3;
    private Gestion_de_cours gestionDeCours;
    private Finance_et_comptabilite financePanel;
    private Compte compteFrame;
    private FormationPage home;



    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                	Gestion_de_cours gestionDeCours = new Gestion_de_cours();
                    Home frame = new Home(gestionDeCours);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Home(Gestion_de_cours gestionDeCours) {
    	this.gestionDeCours = gestionDeCours;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1196, 739);
        setUndecorated(true);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(105, 105, 105));
        contentPane.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        financePanel = new Finance_et_comptabilite();
        compteFrame = new Compte();
        home = new FormationPage();
       
        

        JPanel panel1 = new JPanel();
        panel1.setBackground(Color.WHITE);
        panel1.setBounds(0, 0, 213, 788);
        panel1.setLayout(null);
        contentPane.add(panel1);

        JButton button20 = new JButton("   Déconnexion");
        button20.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Fermer la fenêtre actuelle
                setVisible(false);
                
                // Afficher la fenêtre précédente (Gestion_de_cours)
                gestionDeCours.showWindow();
            }
        });


        button20.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 13));
        button20.setBounds(12, 671, 185, 52);
        button20.setIcon(new ImageIcon(Home.class.getResource("/images/icons8-log-out-30.png")));
        button20.setBackground(Color.WHITE);
        button20.setForeground(Color.BLACK);
        button20.setOpaque(true);
        button20.setBorderPainted(false);
        button20.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        panel1.add(button20);

        JPanel panel6 = new JPanel();
        panel6.setBackground(new Color(105, 105, 105));
        panel6.setBounds(213, 0, 983, 60);
        panel6.setLayout(null);
        panel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lastPoint = evt.getLocationOnScreen();
            }
        });
        panel6.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                int deltaX = evt.getLocationOnScreen().x - lastPoint.x;
                int deltaY = evt.getLocationOnScreen().y - lastPoint.y;

                int newX = getLocation().x + deltaX;
                int newY = getLocation().y + deltaY;

                setLocation(newX, newY);

                lastPoint = evt.getLocationOnScreen();
            }
        });
        contentPane.add(panel6);

        JButton button15 = new JButton("");
        button15.setIcon(new ImageIcon(Gestion_de_cours.class.getResource("/images/icons8-multiply-30.png")));
        button15.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 13));
        button15.setForeground(Color.WHITE);
        button15.setBackground(new Color(105, 105, 105));
        button15.setOpaque(true);
        button15.setBorderPainted(false);
        button15.setBounds(945, 0, 38, 60);
        button15.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                System.exit(0);
            }
        });

        panel6.add(button15);

        JButton button17 = new JButton("");
        button17.setIcon(new ImageIcon(Gestion_de_cours.class.getResource("/images/icons8-remove-30.png")));
        button17.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 13));
        button17.setForeground(Color.WHITE);
        button17.setBackground(new Color(105, 105, 105));
        button17.setOpaque(true);
        button17.setBorderPainted(false);
        button17.setBounds(907, 0, 38, 60);
        button17.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                setExtendedState(JFrame.ICONIFIED);
            }
        });
        panel6.add(button17);

        JLabel label2 = new JLabel("Home");
        label2.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
        label2.setForeground(Color.WHITE);
        label2.setBounds(437, 11, 229, 38);
        panel6.add(label2);
        
        panel4 = new JPanel();
        panel4.setBackground(new Color(105, 105, 105));
        panel4.setBounds(470, 66, 185, 55);
        panel4.setLayout(null);
        panel4.setMinimumSize(new Dimension(185, 55));
        panel4.setMaximumSize(new Dimension(185, 148));

        timer2 = new Timer(100, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                timer2_Tick();
            }
        });

       
        contentPane.add(panel4);
        panel4.getParent().setComponentZOrder(panel4, panel4.getParent().getComponentCount() - 1);


        JButton button2 = new JButton("<html>Formation<br>professionnelle</html>");
        button2.setIcon(new ImageIcon(Home.class.getResource("/images/icons8-profile-30.png")));
        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                button2_Click();
            }
        });
        button2.setBackground(new Color(105, 105, 105));
        button2.setForeground(Color.WHITE);
        button2.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 13));
        button2.setBounds(0, 6, 175, 48);
        panel4.add(button2, BorderLayout.CENTER);

        JButton button4 = new JButton("<html>Finance et<br>comptabilité</html>");
        button4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Créer une instance de Finance_et_comptabilite
                Finance_et_comptabilite financePanel = new Finance_et_comptabilite();
                
                // Effacer tout contenu précédent dans panel8
                panel8.removeAll();
                
                // Ajouter le panel Finance_et_comptabilite à panel8
                panel8.add(financePanel);
                
                // Valider et redessiner le panneau
                panel8.revalidate();
                panel8.repaint();
            }
        });
        button4.setIcon(new ImageIcon(Home.class.getResource("/images/icons8-cash-receipt-30.png")));
        button4.setForeground(Color.WHITE);
        button4.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 13));
        button4.setBackground(new Color(50, 50, 50));
        button4.setBounds(0, 52, 175, 48);
        panel4.add(button4);

        JButton button5 = new JButton("<html>Boulangerie et<br>pâtisserie</html>");
        button5.setIcon(new ImageIcon(Home.class.getResource("/images/icons8-bread-30.png")));
        button5.setForeground(Color.WHITE);
        button5.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 13));
        button5.setBackground(new Color(50, 50, 50));
        button5.setBounds(0, 96, 175, 48);
        panel4.add(button5);

        panel5 = new JPanel();
        panel5.setLayout(null);
        panel5.setMinimumSize(new Dimension(185, 55));
        panel5.setMaximumSize(new Dimension(185, 148));
        panel5.setBackground(new Color(105, 105, 105));
        panel5.setBounds(729, 66, 185, 55);
        timer3 = new Timer(100, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                timer3_Tick();
            }
        });
        
        contentPane.add(panel5);
        panel5.getParent().setComponentZOrder(panel5, panel5.getParent().getComponentCount() - 1);


        JButton button9 = new JButton("<html>Formation<br>continue</html>");
        button9.setIcon(new ImageIcon(Home.class.getResource("/images/icons8-course-30.png")));
        button9.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		button9_Click();
        	}
        });
        button9.setForeground(Color.WHITE);
        button9.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 13));
        button9.setBackground(new Color(105, 105, 105));
        button9.setBounds(0, 6, 175, 48);
        panel5.add(button9);

        JButton button8 = new JButton("Langues");
        button8.setIcon(new ImageIcon(Home.class.getResource("/images/icons8-language-30.png")));
        button8.setForeground(Color.WHITE);
        button8.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 13));
        button8.setBackground(new Color(50, 50, 50));
        button8.setBounds(0, 52, 175, 48);
        panel5.add(button8);

        JButton button7 = new JButton("Informatique");
        button7.setIcon(new ImageIcon(Home.class.getResource("/images/icons8-informatics-30.png")));
        button7.setForeground(Color.WHITE);
        button7.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 13));
        button7.setBackground(new Color(50, 50, 50));
        button7.setBounds(0, 96, 175, 48);
        panel5.add(button7);
        
        
        panel8 = new JPanel();
        panel8.setBackground(new Color(105, 105, 105));
        panel8.setBounds(213, 235, 983, 501);
        panel8.setLayout(new BorderLayout());
        contentPane.add(panel8);
        
        JLabel label1 = new JLabel("Bienvenue !");
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        label1.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 99));
        label1.setForeground(Color.WHITE);
        label1.setBounds(156, 27, 684, 289);
        panel8.add(label1);

        JButton button1 = new JButton("      Home");
        button1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		panel8.removeAll();

                // Ajouter le panneau Compte à panel8
                panel8.add(home);

                // Valider et redessiner le panneau
                panel8.revalidate();
                panel8.repaint();
        	}
        });
        button1.setHorizontalAlignment(SwingConstants.LEFT);
        button1.setIcon(new ImageIcon(Home.class.getResource("/images/icons8-home-30.png")));
        button1.setForeground(Color.WHITE);
        button1.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 13));
        button1.setBackground(new Color(105, 105, 105));
        button1.setBounds(236, 71, 164, 50);
        contentPane.add(button1, BorderLayout.CENTER);

        JButton button19 = new JButton("Compte");
        button19.setIcon(new ImageIcon(Home.class.getResource("/images/icons8-account-30.png")));
        button19.setForeground(Color.WHITE);
        button19.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 13));
        button19.setBackground(new Color(105, 105, 105));
        button19.setBounds(978, 71, 173, 50);
        contentPane.add(button19);
        button19.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Effacer tout contenu précédent dans panel8
                panel8.removeAll();

                // Ajouter le panneau Compte à panel8
                panel8.add(compteFrame);

                // Valider et redessiner le panneau
                panel8.revalidate();
                panel8.repaint();
            }
        });
        
    }

    private void timer2_Tick() {
        int increment = 30;
        int maxHeight = panel4.getMaximumSize().height;
        int minHeight = panel4.getMinimumSize().height;
        
        if (ft) {
            panel4.setSize(panel4.getWidth(), panel4.getHeight() + increment);
            if (panel4.getHeight() >= maxHeight - increment) {
                ft = false;
                panel4.setSize(panel4.getWidth(), maxHeight); // Fixer la hauteur à la taille maximale exacte
                timer2.stop();
            }
        } else {
            panel4.setSize(panel4.getWidth(), panel4.getHeight() - increment);
            if (panel4.getHeight() <= minHeight + increment) {
                ft = true;
                panel4.setSize(panel4.getWidth(), minHeight); // Fixer la hauteur à la taille minimale exacte
                timer2.stop();
            }
        }
    }
    private void timer3_Tick() {
        int increment = 30;
        int maxHeight = panel5.getMaximumSize().height;
        int minHeight = panel5.getMinimumSize().height;
        
        if (ft) {
            panel5.setSize(panel5.getWidth(), panel5.getHeight() + increment);
            if (panel5.getHeight() >= maxHeight - increment) {
                ft = false;
                panel5.setSize(panel5.getWidth(), maxHeight); // Fixer la hauteur à la taille maximale exacte
                timer3.stop();
            }
        } else {
            panel5.setSize(panel5.getWidth(), panel5.getHeight() - increment);
            if (panel5.getHeight() <= minHeight + increment) {
                ft = true;
                panel5.setSize(panel5.getWidth(), minHeight); // Fixer la hauteur à la taille minimale exacte
                timer3.stop();
            }
        }
    }


    private void button2_Click() {
        if (!timer2.isRunning()) { // Vérifie si le timer n'est pas déjà en cours
            if (panel4.getHeight() == panel4.getMinimumSize().height) {
                // Si le panel est à sa taille minimale, on démarre l'animation pour l'agrandir
                timer2.start();
            } else if (panel4.getHeight() == panel4.getMaximumSize().height) {
                // Si le panel est déjà à sa taille maximale, on démarre l'animation pour le réduire
                timer2.start();
            }
        }
    }
    private void button9_Click() {
        if (!timer3.isRunning()) { // Vérifie si le timer n'est pas déjà en cours
            if (panel5.getHeight() == panel5.getMinimumSize().height) {
                // Si le panel est à sa taille minimale, on démarre l'animation pour l'agrandir
                timer3.start();
            } else if (panel5.getHeight() == panel5.getMaximumSize().height) {
                // Si le panel est déjà à sa taille maximale, on démarre l'animation pour le réduire
                timer3.start();
            }
        }
    }
}
