package gestion_de_cours;

import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ajout_informatique extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField Ordre;
    private JTextField CODE;
    private JLabel Ajout;
    private JLabel lblNewLabel_2;
    private JTextField Nom_Complet;
    private JLabel lblNewLabel_3;
    private JTextField Prix;
    private JTextField septembre;
    private JTextField octobre;
    private JTextField novembre;
    private JTextField decembre;
    private JTextField janvier;
    private JTextField fevrier;
    private JTextField mars;
    private JTextField avril;
    private JTextField mai;
    private JTextField juin;
    private JTextField juillet;
    private static Ajout_informatique currentInstance;
    private JDatePickerImpl Date_Inscription;
    private JDatePickerImpl Date_Debut;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Ajout_informatique frame = new Ajout_informatique();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    boolean recordExists(int ordre, String code) {
        String connectionStr = "jdbc:mysql://localhost:3306/sfe";
        String username = "root";
        String password = "";

        String query = "SELECT COUNT(*) FROM informatique WHERE ordre = ? OR CODE = ?";
        try (Connection connection = DriverManager.getConnection(connectionStr, username, password);
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, ordre);
            statement.setString(2, code);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    int count = resultSet.getInt(1);
                    return count > 0;
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(Ajout_informatique.this, "Error: " + ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        }

        return false;
    }

    public Ajout_informatique() {

        currentInstance = this;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 512, 645);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        Ordre = new JTextField();
        Ordre.setBounds(87, 104, 118, 20);
        contentPane.add(Ordre);
        Ordre.setColumns(10);

        JLabel lblNewLabel = new JLabel("Ordre");
        lblNewLabel.setBounds(43, 107, 46, 14);
        contentPane.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Code");
        lblNewLabel_1.setBounds(263, 107, 46, 14);
        contentPane.add(lblNewLabel_1);

        CODE = new JTextField();
        CODE.setBounds(305, 104, 118, 20);
        contentPane.add(CODE);
        CODE.setColumns(10);

        Ajout = new JLabel();
        Ajout.setFont(new Font("Tahoma", Font.PLAIN, 18));
        Ajout.setOpaque(true); // Set the JLabel to be opaque
        Ajout.setBackground(Color.GRAY);
        Ajout.setForeground(Color.WHITE);
        Ajout.setText("Ajouter");
        Ajout.setBounds(0, 0, 496, 75);
        contentPane.add(Ajout);

        Insets insets = Ajout.getInsets();
        Ajout.setBorder(BorderFactory.createEmptyBorder(insets.top, 45, insets.bottom, insets.right));

        contentPane.add(Ajout);

        lblNewLabel_2 = new JLabel("Nom Complet");
        lblNewLabel_2.setBounds(43, 157, 74, 14);
        contentPane.add(lblNewLabel_2);

        Nom_Complet = new JTextField();
        Nom_Complet.setBounds(140, 154, 300, 20);
        contentPane.add(Nom_Complet);
        Nom_Complet.setColumns(10);

        JDatePickerImpl Date_Inscription = new JDatePickerImpl();
        Date_Inscription.setBounds(140, 208, 300, 25);
        contentPane.add(Date_Inscription);

        JLabel lblNewLabel_4 = new JLabel("Date début");
        lblNewLabel_4.setBounds(43, 269, 74, 14);
        contentPane.add(lblNewLabel_4);

        JDatePickerImpl Date_Debut = new JDatePickerImpl();
        Date_Debut.setBounds(140, 259, 300, 25);
        contentPane.add(Date_Debut);

        lblNewLabel_3 = new JLabel("Date Inscription");
        lblNewLabel_3.setBounds(43, 219, 100, 14);
        contentPane.add(lblNewLabel_3);

        JLabel lblNewLabel_5 = new JLabel("Prix ");
        lblNewLabel_5.setBounds(43, 314, 74, 14);
        contentPane.add(lblNewLabel_5);

        Prix = new JTextField();
        Prix.setBounds(87, 311, 118, 20);
        contentPane.add(Prix);
        Prix.setColumns(10);

        JLabel lblNewLabel_6 = new JLabel("Les numéros des reçus pour chaque mois");
        lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblNewLabel_6.setForeground(Color.RED);
        lblNewLabel_6.setBounds(140, 350, 283, 32);
        contentPane.add(lblNewLabel_6);

        JLabel lblNewLabel_7 = new JLabel("Septembre");
        lblNewLabel_7.setBounds(24, 405, 86, 14);
        contentPane.add(lblNewLabel_7);

        septembre = new JTextField();
        septembre.setBounds(87, 402, 86, 20);
        contentPane.add(septembre);
        septembre.setColumns(10);

        JLabel lblNewLabel_8 = new JLabel("Octobre");
        lblNewLabel_8.setBounds(183, 405, 46, 14);
        contentPane.add(lblNewLabel_8);

        octobre = new JTextField();
        octobre.setBounds(239, 402, 86, 20);
        contentPane.add(octobre);
        octobre.setColumns(10);

        JLabel lblNewLabel_9 = new JLabel("Novembre");
        lblNewLabel_9.setBounds(335, 405, 56, 14);
        contentPane.add(lblNewLabel_9);

        novembre = new JTextField();
        novembre.setBounds(400, 402, 86, 20);
        contentPane.add(novembre);
        novembre.setColumns(10);

        JLabel lblNewLabel_10 = new JLabel("Décembre");
        lblNewLabel_10.setBounds(24, 442, 65, 14);
        contentPane.add(lblNewLabel_10);

        JLabel lblNewLabel_11 = new JLabel("Janvier");
        lblNewLabel_11.setBounds(183, 442, 46, 14);
        contentPane.add(lblNewLabel_11);

        JLabel lblNewLabel_12 = new JLabel("Février ");
        lblNewLabel_12.setBounds(335, 442, 46, 14);
        contentPane.add(lblNewLabel_12);

        JLabel lblNewLabel_13 = new JLabel("Mars");
        lblNewLabel_13.setBounds(24, 479, 46, 14);
        contentPane.add(lblNewLabel_13);

        JLabel lblNewLabel_14 = new JLabel("Avril");
        lblNewLabel_14.setBounds(183, 479, 46, 14);
        contentPane.add(lblNewLabel_14);

        JLabel lblNewLabel_15 = new JLabel("Mai");
        lblNewLabel_15.setBounds(335, 479, 46, 14);
        contentPane.add(lblNewLabel_15);

        JLabel lblNewLabel_16 = new JLabel("Juin");
        lblNewLabel_16.setBounds(24, 513, 46, 14);
        contentPane.add(lblNewLabel_16);

        JLabel lblNewLabel_17 = new JLabel("Juillet");
        lblNewLabel_17.setBounds(183, 513, 46, 14);
        contentPane.add(lblNewLabel_17);

        decembre = new JTextField();
        decembre.setColumns(10);
        decembre.setBounds(87, 439, 86, 20);
        contentPane.add(decembre);

        janvier = new JTextField();
        janvier.setColumns(10);
        janvier.setBounds(239, 439, 86, 20);
        contentPane.add(janvier);

        fevrier = new JTextField();
        fevrier.setColumns(10);
        fevrier.setBounds(400, 439, 86, 20);
        contentPane.add(fevrier);

        mars = new JTextField();
        mars.setColumns(10);
        mars.setBounds(87, 476, 86, 20);
        contentPane.add(mars);

        avril = new JTextField();
        avril.setColumns(10);
        avril.setBounds(239, 476, 86, 20);
        contentPane.add(avril);

        mai = new JTextField();
        mai.setColumns(10);
        mai.setBounds(400, 476, 86, 20);
        contentPane.add(mai);

        juin = new JTextField();
        juin.setColumns(10);
        juin.setBounds(87, 510, 86, 20);
        contentPane.add(juin);

        juillet = new JTextField();
        juillet.setColumns(10);
        juillet.setBounds(239, 510, 86, 20);
        contentPane.add(juillet);

        JButton btn_ajout = new JButton("Ajout");
        btn_ajout.setBackground(SystemColor.inactiveCaption);
        btn_ajout.setBounds(196, 560, 113, 35);
        contentPane.add(btn_ajout);
        btn_ajout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String codeValue = CODE.getText();
                String nomCompletValue = Nom_Complet.getText();
                Date dateInscriptionValue1 = Date_Inscription.getDate();
                Date dateDebutValue1 = Date_Debut.getDate();
                String septembreValue = septembre.getText();
                String octobreValue = octobre.getText();
                String novembreValue = novembre.getText();
                String decembreValue = decembre.getText();
                String janvierValue = janvier.getText();
                String fevrierValue = fevrier.getText();
                String marsValue = mars.getText();
                String avrilValue = avril.getText();
                String maiValue = mai.getText();
                String juinValue = juin.getText();
                String juilletValue = juillet.getText();
                if (Ordre.getText().isEmpty() || CODE.getText().isEmpty() || Nom_Complet.getText().isEmpty() || Prix.getText().isEmpty() || dateInscriptionValue1 == null || dateDebutValue1 == null) {
                    JOptionPane.showMessageDialog(Ajout_informatique.this, "Veuillez remplir les champs importants.", "Information manquante", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                int ordreValue = Integer.parseInt(Ordre.getText());
                double prixValue = Double.parseDouble(Prix.getText());
                String connectionStr = "jdbc:mysql://localhost:3306/sfe";
                String username = "root";
                String password = "";
                if (recordExists(ordreValue, codeValue)) {
                    JOptionPane.showMessageDialog(Ajout_informatique.this, "Code ou ordre déjà existant.", "Duplicate Record", JOptionPane.WARNING_MESSAGE);
                    currentInstance.dispose();
                    return;
                }
                try (Connection connection = DriverManager.getConnection(connectionStr, username, password)) {
                    String query = "INSERT INTO informatique (ordre, CODE, Nom_Complet, Date_inscription, Date_debut, Prix, septembre, octobre, novembre, decembre, janvier, fevrier, mars, avril, mai, juin, juillet) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                    try (PreparedStatement statement = connection.prepareStatement(query)) {
                        statement.setInt(1, ordreValue);
                        statement.setString(2, codeValue);
                        statement.setString(3, nomCompletValue);
                        statement.setDate(4, dateInscriptionValue1);
                        statement.setDate(5, dateDebutValue1);
                        statement.setDouble(6, prixValue);
                        statement.setString(7, septembreValue);
                        statement.setString(8, octobreValue);
                        statement.setString(9, novembreValue);
                        statement.setString(10, decembreValue);
                        statement.setString(11, janvierValue);
                        statement.setString(12, fevrierValue);
                        statement.setString(13, marsValue);
                        statement.setString(14, avrilValue);
                        statement.setString(15, maiValue);
                        statement.setString(16, juinValue);
                        statement.setString(17, juilletValue);

                        statement.executeUpdate();

                        JOptionPane.showMessageDialog(Ajout_informatique.this, "Data successfully added to the database", "Success", JOptionPane.INFORMATION_MESSAGE);

                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(Ajout_informatique.this, "Error: " + ex.getMessage(), "Addition Error", JOptionPane.ERROR_MESSAGE);
                }

                currentInstance.dispose();

            }
        });
    }
}
