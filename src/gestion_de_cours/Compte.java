package gestion_de_cours;


import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JPasswordField;
import javax.swing.border.MatteBorder;
import java.awt.Button;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Compte extends JPanel {

    private static final long serialVersionUID = 1L;
    private JPasswordField passwordField;
    private JPasswordField passwordField_1;
    private JPasswordField passwordField_2;
    static String user="admin";
    static Connection conn = null;


    /**
     * Create the panel.
     */
    public Compte() {
        setBackground(new Color(105, 105, 105)); // Set background color to gray
        setBorder(new EmptyBorder(5, 5, 5, 5));
        setLayout(null);

        passwordField = new JPasswordField();
        passwordField.setBounds(425, 92, 200, 20);
        passwordField.setBorder(new MatteBorder(0, 0, 3, 0, Color.WHITE)); // Set border color to white
        passwordField.setOpaque(false);
        add(passwordField);
        System.out.println("test");
        passwordField_1 = new JPasswordField();
        passwordField_1.setBounds(425, 175, 200, 20);
        passwordField_1.setBorder(new MatteBorder(0, 0, 3, 0, Color.WHITE)); // Set border color to white
        passwordField_1.setOpaque(false);
        add(passwordField_1);

        passwordField_2 = new JPasswordField();
        passwordField_2.setBounds(425, 274, 200, 20);
        passwordField_2.setBorder(new MatteBorder(0, 0, 3, 0, Color.WHITE)); // Set border color to white
        passwordField_2.setOpaque(false);
        add(passwordField_2);

        Button button = new Button("Modifier");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                @SuppressWarnings("deprecation")
                String ancienMotDePasse = passwordField.getText();
                String nouveauMotDePasse = passwordField_1.getText();
                String confirmationMotDePasse = passwordField_2.getText();

                // V rifier si l'ancien mot de passe est correct
                boolean ancienMotDePasseCorrect = verifierAncienMotDePasse(ancienMotDePasse);

                if (ancienMotDePasseCorrect) {
                    // V rifier si les nouveaux mots de passe correspondent
                    if (nouveauMotDePasse.equals(confirmationMotDePasse)) {
                        // Mettre   jour le mot de passe dans la base de donn es
                        if (changerMotDePasseDansBaseDeDonnees(conn,user,nouveauMotDePasse)) {
                            // Afficher un message de succ s
                            JOptionPane.showMessageDialog(null, "Mot de passe chang  avec succ s.", "Succ s", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            // Afficher un message d'erreur en cas d' chec de la mise   jour
                            JOptionPane.showMessageDialog(null, "Erreur lors du changement de mot de passe.", "Erreur", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        // Afficher un message d'erreur si les nouveaux mots de passe ne correspondent pas
                        JOptionPane.showMessageDialog(null, "Les nouveaux mots de passe ne correspondent pas.", "Erreur", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    // Afficher un message d'erreur si l'ancien mot de passe est incorrect
                    JOptionPane.showMessageDialog(null, "Mot de passe incorrect. Veuillez r essayer.", "Erreur", JOptionPane.ERROR_MESSAGE);
                }
            }

            public boolean changerMotDePasseDansBaseDeDonnees(Connection conn, String user, String nouveauMotDePasse) {
                PreparedStatement stmt = null;
                boolean success = false;

                try {
                    // Requ te SQL pour mettre   jour le mot de passe
                    String sql = "UPDATE conn SET password = ? WHERE user = ?";
                    stmt = conn.prepareStatement(sql);
                    stmt.setString(1, nouveauMotDePasse);
                    stmt.setString(2, user);


                    int rowsAffected = stmt.executeUpdate();


                    System.out.println("Requ te SQL ex cut e : " + stmt.toString());
                    System.out.println("Nombre de lignes affect es : " + rowsAffected);


                    if (rowsAffected > 0) {
                        success = true;
                    } else {
                        System.out.println("Aucune ligne modifi e. La mise   jour du mot de passe a  chou .");
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                } finally {
                    // Fermer les ressources
                    try {
                        if (stmt != null) stmt.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }

                return success;
            }

	        });

        button.setActionCommand("");
		button.setForeground(Color.WHITE);
		button.setBackground(SystemColor.desktop);
		button.setBounds(425, 341, 200, 36);
		add(button);

		JLabel lblNewLabel = new JLabel("Ancien mot de passe");
		lblNewLabel.setForeground(SystemColor.text);
		lblNewLabel.setBounds(475, 58, 150, 14);
		add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Nouveau mot de passe");
		lblNewLabel_1.setForeground(SystemColor.text);
		lblNewLabel_1.setBounds(475, 150, 150, 14);
		add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Confirmation mot de passe");
		lblNewLabel_2.setForeground(SystemColor.text);
		lblNewLabel_2.setBounds(462, 238, 175, 14);
		add(lblNewLabel_2);

    }

    public static boolean verifierAncienMotDePasse(String ancienMotDePasse) {
    	ResultSet rs = null;
        boolean motDePasseCorrect = false;
        PreparedStatement stmt = null;
        try {						
        	 conn = DriverManager.getConnection("jdbc:mysql://localhost/sfe", "root", "");
        	    if (conn != null) {
        	        System.out.println("Connexion   la base de donn es  tablie avec succ s.");
        	        // Votre code pour ex cuter la requ te SQL et traiter les r sultats va ici
        	    } else {
        	        System.out.println(" chec de la connexion   la base de donn es.");
        	        // Votre code pour g rer l' chec de la connexion va ici
        	    }
        	    String sql = "SELECT password FROM conn WHERE user = '" + user + "'";

                 stmt = conn.prepareStatement(sql);
                 rs = stmt.executeQuery();
            // V rifier si le r sultat de la requ te contient une ligne
            if (rs.next()) {
                String motDePasseBD = rs.getString("password");
                // R cup rer le mot de passe de la base de donn es
                System.out.println(motDePasseBD);
                // Comparer le mot de passe r cup r  avec celui entr  dans le champ "Ancien mot de passe"
                if (ancienMotDePasse.equals(motDePasseBD)) {
                    motDePasseCorrect = true;
                } else {
                    JOptionPane.showMessageDialog(null, "Mot de passe incorrect. Veuillez r essayer.", "Erreur", JOptionPane.ERROR_MESSAGE);
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Fermer les ressources
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return motDePasseCorrect;
    }
}