package gestion_de_cours;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class ModifierFinance extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField Ordre;
    private JTextField CODE;
    private JLabel Modifier;
    private JTextField Nom_Complet;
    private JTextField Prix;
    private JTextField Date_Inscription;
    private JTextField Date_Debut;
    private static ModifierFinance currentInstance;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ModifierFinance frame = new ModifierFinance();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public ModifierFinance() {

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

        Modifier = new JLabel();
        Modifier.setFont(new Font("Tahoma", Font.PLAIN, 18));
        Modifier.setOpaque(true); // Set the JLabel to be opaque
        Modifier.setBackground(Color.GRAY);
        Modifier.setForeground(Color.WHITE);
        Modifier.setText("Modifier");
        Modifier.setBounds(0, 0, 496, 75);
        contentPane.add(Modifier);

        Insets insets = Modifier.getInsets();
        Modifier.setBorder(BorderFactory.createEmptyBorder(insets.top, 45, insets.bottom, insets.right));

        contentPane.add(Modifier);

        JLabel lblNewLabel_2 = new JLabel("Nom Complet");
        lblNewLabel_2.setBounds(43, 157, 74, 14);
        contentPane.add(lblNewLabel_2);

        Nom_Complet = new JTextField();
        Nom_Complet.setBounds(140, 154, 300, 20);
        contentPane.add(Nom_Complet);
        Nom_Complet.setColumns(10);

        Date_Inscription = new JTextField();
        Date_Inscription.setBounds(140, 208, 300, 25);
        contentPane.add(Date_Inscription);

        // Label for "Date début"
        JLabel lblNewLabel_4 = new JLabel("Date début");
        lblNewLabel_4.setBounds(43, 269, 74, 14);
        contentPane.add(lblNewLabel_4);

        // Date picker for "Date  début"
        Date_Debut = new JTextField();
        Date_Debut.setBounds(140, 259, 300, 25);
        contentPane.add(Date_Debut);

        JLabel lblNewLabel_3 = new JLabel("Date_Inscription");
        lblNewLabel_3.setBounds(43, 219, 100, 14);
        contentPane.add(lblNewLabel_3);

        JLabel lblNewLabel_5 = new JLabel("Prix ");
        lblNewLabel_5.setBounds(43, 314, 74, 14);
        contentPane.add(lblNewLabel_5);

        Prix = new JTextField();
        Prix.setBounds(87, 311, 118, 20);
        contentPane.add(Prix);
        Prix.setColumns(10);

        JButton btn_modifier = new JButton("Modifier");
        btn_modifier.setBackground(SystemColor.inactiveCaption);
        btn_modifier.setBounds(196, 560, 113, 35);
        contentPane.add(btn_modifier);
        btn_modifier.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                int ordreValue = Integer.parseInt(Ordre.getText());
                String codeValue = CODE.getText();
                String nomCompletValue = Nom_Complet.getText();
                String dateInscriptionValue = Date_Inscription.getText();
                String dateDebutValue = Date_Debut.getText();
                double prixValue = Double.parseDouble(Prix.getText());

                String connectionStr = "jdbc:mysql://localhost:3306/sfe";
                String username = "root";
                String password = "";

                try (Connection connection = DriverManager.getConnection(connectionStr, username, password)) {
                    String query = "UPDATE finance SET Ordre = ?, Code = ?, Nom_Complet = ?, Date_Inscription = ?, Date_Debut = ?, Prix = ? WHERE ordre = ?";
                    try (PreparedStatement statement = connection.prepareStatement(query)) {
                        statement.setInt(1, ordreValue);
                        statement.setString(2, codeValue);
                        statement.setString(3, nomCompletValue);
                        statement.setString(4, dateInscriptionValue);
                        statement.setString(5, dateDebutValue);
                        statement.setDouble(6, prixValue);
                        statement.setInt(7, ordreValue);

                        statement.executeUpdate();

                        JOptionPane.showMessageDialog(ModifierFinance.this, "Data successfully updated in the database", "Success", JOptionPane.INFORMATION_MESSAGE);
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(ModifierFinance.this, "Error: " + ex.getMessage(), "Modification Error", JOptionPane.ERROR_MESSAGE);
                }
                currentInstance.dispose();
            }
        });
    }

    public void setAncientData(String ordre, String code, String nomComplet, String dateInscription, String dateDebut, String prix) {
        Ordre.setText(ordre);
        CODE.setText(code);
        Nom_Complet.setText(nomComplet);
        Date_Inscription.setText(dateInscription);
        Date_Debut.setText(dateDebut);
        Prix.setText(prix);
    }
}
