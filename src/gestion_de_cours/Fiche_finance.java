package gestion_de_cours;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.awt.event.ActionEvent;

public class Fiche_finance extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField textbox1;
	private JTextField textbox4;
	private JTextField textbox2;
	private JTextField textbox19;
	private JTextField textbox3;
	private JTextField textbox16;
	private JTextField textbox18;
	private JTextField textbox17;
	private JTextField textField21;
    private JDatePickerImpl datePicker;
    private JTextField textbox20;
    private JTextField textbox5;
    private JTextField textbox6;
    private JTextField textbox7;
    private JTextField textbox8;
    private JTextField textbox9;
    private JTextField textbox10;
    private JTextField textbox11;
    private JTextField textbox12;
    private JTextField textbox13;
    private JTextField textbox14;
    private JTextField textbox15;
    LocalDateTime now = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    String formattedDate = now.format(formatter);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Fiche_finance frame = new Fiche_finance();
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
	public Fiche_finance() {
		getContentPane().setEnabled(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 992, 680);
		getContentPane().setLayout(null);
		setResizable(false);
		
		JPanel panel1 = new JPanel();
		panel1.setBackground(new Color(105, 105, 105));
		panel1.setBounds(0, 0, 976, 89);
		panel1.setLayout(null);
		getContentPane().add(panel1);
		
		JLabel label1 = new JLabel("Fiche d'inscription");
		label1.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
		label1.setForeground(Color.WHITE);
		label1.setBounds(41, 21, 207, 38);
		panel1.add(label1);
		
		JLabel label2 = new JLabel("Code");
		label2.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 17));
		label2.setBounds(29, 126, 46, 14);
		getContentPane().add(label2);
		
		textbox1 = new JTextField();
		textbox1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textbox1.setBounds(99, 125, 132, 20);
		getContentPane().add(textbox1);
		textbox1.setEditable(false);
		textbox1.setColumns(10);
		
		JLabel label5 = new JLabel("<html>Nom et<br>Prènom</html>");
		label5.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 17));
		label5.setBounds(255, 104, 72, 41);
		getContentPane().add(label5);
		
		textbox4 = new JTextField();
		textbox4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textbox4.setColumns(10);
		textbox4.setBounds(337, 126, 132, 20);
		textbox4.setEditable(false);
		getContentPane().add(textbox4);
		
		JLabel label3 = new JLabel("<html>Année<br>Scolaire<html>");
		label3.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 17));
		label3.setBounds(505, 104, 72, 41);
		getContentPane().add(label3);
		
		textbox2 = new JTextField();
		textbox2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textbox2.setColumns(10);
		textbox2.setBounds(587, 126, 132, 20);
		getContentPane().add(textbox2);
		
		JLabel label20 = new JLabel("CIN");
		label20.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 17));
		label20.setBounds(778, 126, 46, 14);
		getContentPane().add(label20);
		
		textbox19 = new JTextField();
		textbox19.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textbox19.setColumns(10);
		textbox19.setBounds(834, 126, 132, 20);
		getContentPane().add(textbox19);
		
		JLabel label4 = new JLabel("Filière");
		label4.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 17));
		label4.setBounds(29, 192, 46, 14);
		getContentPane().add(label4);
		
		textbox3 = new JTextField();
		textbox3.setText("Technicien spécialisé en finance et comptabilité");
		textbox3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textbox3.setEditable(false);
		textbox3.setColumns(10);
		textbox3.setBounds(99, 191, 312, 20);
		getContentPane().add(textbox3);
		
		JLabel label6 = new JLabel("<html>Date<br>D'inscription</html>");
		label6.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 17));
		label6.setBounds(421, 173, 97, 49);
		getContentPane().add(label6);
		
		textbox16 = new JTextField();
		textbox16.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textbox16.setEditable(false);
		textbox16.setColumns(10);
		textbox16.setBounds(528, 191, 171, 20);
		getContentPane().add(textbox16);
		
		JLabel label8 = new JLabel("<html>Lieu de<br>Naissance</html>");
		label8.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 17));
		label8.setBounds(734, 181, 79, 33);
		getContentPane().add(label8);
		
		textbox18 = new JTextField();
		textbox18.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textbox18.setColumns(10);
		textbox18.setBounds(823, 192, 143, 20);
		getContentPane().add(textbox18);
		
		JLabel label7 = new JLabel("<html>Date<br>Début</html>");
		label7.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 17));
		label7.setBounds(29, 245, 97, 49);
		getContentPane().add(label7);
		
		textbox17 = new JTextField();
		textbox17.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textbox17.setEditable(false);
		textbox17.setColumns(10);
		textbox17.setBounds(99, 266, 171, 20);
		getContentPane().add(textbox17);
		
		JLabel label22 = new JLabel("N° Tél");
		label22.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 17));
		label22.setBounds(301, 269, 64, 14);
		getContentPane().add(label22);
		
		textField21 = new JTextField();
		textField21.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField21.setColumns(10);
		textField21.setBounds(375, 266, 132, 20);
		getContentPane().add(textField21);
		
		datePicker = new JDatePickerImpl();
		datePicker.setBounds(675, 261, 171, 33);
		getContentPane().add(datePicker);
		
		JLabel label23 = new JLabel("<html>Date<br>De naissance</html>");
		label23.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 17));
		label23.setBounds(536, 245, 115, 49);
		getContentPane().add(label23);
		
		JLabel label21 = new JLabel("Adresse");
		label21.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 17));
		label21.setBounds(29, 337, 64, 14);
		getContentPane().add(label21);
		
		textbox20 = new JTextField();
		textbox20.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textbox20.setColumns(10);
		textbox20.setBounds(103, 328, 811, 33);
		getContentPane().add(textbox20);
		
		JLabel label9 = new JLabel("Septembre");
		label9.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 17));
		label9.setBounds(17, 406, 94, 20);
		getContentPane().add(label9);
		
		textbox5 = new JTextField();
		textbox5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textbox5.setColumns(10);
		textbox5.setBounds(113, 409, 132, 20);
		getContentPane().add(textbox5);
		
		JLabel label10 = new JLabel("Octobre");
		label10.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 17));
		label10.setBounds(269, 406, 94, 20);
		getContentPane().add(label10);
		
		textbox6 = new JTextField();
		textbox6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textbox6.setColumns(10);
		textbox6.setBounds(347, 409, 132, 20);
		getContentPane().add(textbox6);
		
		JLabel label11 = new JLabel("Novembre");
		label11.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 17));
		label11.setBounds(500, 407, 94, 20);
		getContentPane().add(label11);
		
		textbox7 = new JTextField();
		textbox7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textbox7.setColumns(10);
		textbox7.setBounds(594, 410, 132, 20);
		getContentPane().add(textbox7);
		
		JLabel label12 = new JLabel("Décembre");
		label12.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 17));
		label12.setBounds(741, 407, 94, 20);
		getContentPane().add(label12);
		
		textbox8 = new JTextField();
		textbox8.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textbox8.setColumns(10);
		textbox8.setBounds(837, 410, 132, 20);
		getContentPane().add(textbox8);
		
		JLabel label13 = new JLabel("Janvier");
		label13.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 17));
		label13.setBounds(15, 458, 94, 20);
		getContentPane().add(label13);
		
		textbox9 = new JTextField();
		textbox9.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textbox9.setColumns(10);
		textbox9.setBounds(111, 461, 132, 20);
		getContentPane().add(textbox9);
		
		JLabel label14 = new JLabel("Février");
		label14.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 17));
		label14.setBounds(267, 458, 94, 20);
		getContentPane().add(label14);
		
		textbox10 = new JTextField();
		textbox10.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textbox10.setColumns(10);
		textbox10.setBounds(345, 461, 132, 20);
		getContentPane().add(textbox10);
		
		JLabel label15 = new JLabel("Mars");
		label15.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 17));
		label15.setBounds(498, 459, 94, 20);
		getContentPane().add(label15);
		
		textbox11 = new JTextField();
		textbox11.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textbox11.setColumns(10);
		textbox11.setBounds(592, 462, 132, 20);
		getContentPane().add(textbox11);
		
		JLabel label16 = new JLabel("Avril");
		label16.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 17));
		label16.setBounds(739, 459, 94, 20);
		getContentPane().add(label16);
		
		textbox12 = new JTextField();
		textbox12.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textbox12.setColumns(10);
		textbox12.setBounds(835, 462, 132, 20);
		getContentPane().add(textbox12);
		
		JLabel label17 = new JLabel("Mai");
		label17.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 17));
		label17.setBounds(14, 511, 94, 20);
		getContentPane().add(label17);
		
		textbox13 = new JTextField();
		textbox13.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textbox13.setColumns(10);
		textbox13.setBounds(110, 514, 132, 20);
		getContentPane().add(textbox13);
		
		JLabel label18 = new JLabel("Juin");
		label18.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 17));
		label18.setBounds(266, 511, 94, 20);
		getContentPane().add(label18);
		
		textbox14 = new JTextField();
		textbox14.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textbox14.setColumns(10);
		textbox14.setBounds(344, 514, 132, 20);
		getContentPane().add(textbox14);
		
		JLabel label19 = new JLabel("Juillet");
		label19.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 17));
		label19.setBounds(497, 512, 94, 20);
		getContentPane().add(label19);
		
		textbox15 = new JTextField();
		textbox15.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textbox15.setColumns(10);
		textbox15.setBounds(591, 515, 132, 20);
		getContentPane().add(textbox15);
		
		JButton button1 = new JButton("Modifier");
		button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mettreAJourDonnees();
            }
        });
		button1.setBackground(new Color(128, 128, 255));
		button1.setBounds(77, 608, 89, 23);
		getContentPane().add(button1);
		
		JButton button2 = new JButton("Imprimer");
		button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                imprimerDocument();
            }
        });
		button2.setBackground(new Color(255, 255, 192));
		button2.setBounds(194, 607, 89, 23);
		getContentPane().add(button2);

	}
	private void imprimerDocument() {
        try {
            String fileText = Files.readString(Paths.get("C:\\Users\\hp\\eclipse-workspace\\Gestion_de_cours\\src\\fichiers_txt\\reçu.txt"), StandardCharsets.UTF_8);

            
         
            fileText = fileText.replace("Intitulé de formation : ……………………………………………… ", "Intitulé de formation : " + textbox3.getText());
            fileText = fileText.replace("Année scolaire : …………………………………", "Année scolaire : " + textbox2.getText());
            fileText = fileText.replace("Date d’inscription : …………………………", "Date d’inscription : " + textbox16.getText());
            fileText = fileText.replace("Date début : ……………………………", "Date début : " + textbox17.getText());
            fileText = fileText.replace("Nom complet : ……………………………………………………………………………", "Nom complet : " + textbox4.getText());
            fileText = fileText.replace("Né(e) le : ……………………………………………………", "Né(e) le : " + datePicker.getDate()); // Assuming datePicker is your JDatePicker component
            fileText = fileText.replace("à : ………………………………………", "à : " + textbox18.getText());
            fileText = fileText.replace("CIN : …………………………………………………", "CIN : " + textbox19.getText());
            fileText = fileText.replace("Adresse : ……………………………………………………………………………………………………………", "Adresse : " + textbox20.getText());
            fileText = fileText.replace("N° Tél : ……………………………………………………", "N° Tél : " + textField21.getText());
            fileText = fileText.replace("Fait à Guelmim le ……………………………………", "Fait à Agadir le " + formattedDate);
            fileText = fileText.replace("Septembre : …………………………", "Septembre : " + textbox5.getText());
            fileText = fileText.replace("Octobre : …………………………", "Octobre : " + textbox6.getText());
            fileText = fileText.replace("Novembre : ……………………", "Novembre : " + textbox7.getText());
            fileText = fileText.replace("Décembre : …………………………", "Décembre : " + textbox8.getText());
            fileText = fileText.replace("Janvier : …………………………", "Janvier : " + textbox9.getText());
            fileText = fileText.replace("Février : …………………………", "Février : " + textbox10.getText());
            fileText = fileText.replace("Mars : …………………………………", "Mars : " + textbox11.getText());
            fileText = fileText.replace("Avril : ……………………………", "Avril : " + textbox12.getText());
            fileText = fileText.replace("Mai : ……………………………", "Mai : " + textbox13.getText());
            fileText = fileText.replace("Juin : …………………………………", "Juin : " + textbox14.getText());
            fileText = fileText.replace("Juillet : ……………………………", "Juillet : " + textbox15.getText());


            // Save the updated text file
            Files.writeString(Paths.get("C:\\Users\\hp\\eclipse-workspace\\Gestion_de_cours\\src\\fichiers_txt\\reçu2.txt"), fileText, StandardCharsets.UTF_8);

            // Print the document
            PrinterJob job = PrinterJob.getPrinterJob();
            job.setPrintable(new MyPrintable(fileText));
            if (job.printDialog()) {
                job.print();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erreur : " + ex.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
        } catch (PrinterException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erreur d'impression : " + ex.getMessage(), "Erreur d'impression", JOptionPane.ERROR_MESSAGE);
        }
    }
	private void mettreAJourDonnees() {
	    try {
	        // Récupérer les valeurs des champs de texte
	        String septembre = textbox5.getText();
	        String octobre = textbox6.getText();
	        String novembre = textbox7.getText();
	        String decembre = textbox8.getText();
	        String janvier = textbox9.getText();
	        String fevrier = textbox10.getText();
	        String mars = textbox11.getText();
	        String avril = textbox12.getText();
	        String mai = textbox13.getText();
	        String juin = textbox14.getText();
	        String juillet = textbox15.getText();
	        String code = textbox1.getText(); 

	        // Connexion à la base de données (ex. MySQL)
	        String url = "jdbc:mysql://localhost/sfe";
	        String utilisateur = "root";
	        String motDePasse = "";
	        
	        Connection connexion = DriverManager.getConnection(url, utilisateur, motDePasse);

	        // Requête SQL pour mettre à jour les données
	        String query = "UPDATE finance SET septembre = ?, octobre = ?, novembre = ?, decembre = ?, " +
	                       "janvier = ?, fevrier = ?, mars = ?, avril = ?, mai = ?, juin = ?, juillet = ? " +
	                       "WHERE CODE = ?";
	        
	        PreparedStatement statement = connexion.prepareStatement(query);
	        statement.setString(1, septembre);
	        statement.setString(2, octobre);
	        statement.setString(3, novembre);
	        statement.setString(4, decembre);
	        statement.setString(5, janvier);
	        statement.setString(6, fevrier);
	        statement.setString(7, mars);
	        statement.setString(8, avril);
	        statement.setString(9, mai);
	        statement.setString(10, juin);
	        statement.setString(11, juillet);
	        statement.setString(12, code);

	        // Exécuter la mise à jour
	        int rowsAffected = statement.executeUpdate();

	        // Fermer la connexion et les ressources
	        statement.close();
	        connexion.close();

	        // Afficher un message de succès
	        if (rowsAffected > 0) {
	            JOptionPane.showMessageDialog(this, "Données modifiées avec succès !");
	        } else {
	            JOptionPane.showMessageDialog(this, "Aucune donnée n'a été modifiée.", "Avertissement", JOptionPane.WARNING_MESSAGE);
	        }

	    } catch (SQLException ex) {
	        JOptionPane.showMessageDialog(this, "Erreur lors de la mise à jour des données : " + ex.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
	        ex.printStackTrace();
	    }
	}

	public void setTextbox1Text(String valeur) {
		textbox1.setText(valeur);
	}
	public void setTextbox2Text(String valeur) {
		textbox2.setText(valeur);
	}
	public void setTextbox3Text(String valeur) {
		textbox3.setText(valeur);
	}
	public void setTextbox4Text(String valeur) {
		textbox4.setText(valeur);
	}
	public void setTextbox5Text(String valeur) {
		textbox5.setText(valeur);
	}
	public void setTextbox6Text(String valeur) {
		textbox6.setText(valeur);
	}
	public void setTextbox7Text(String valeur) {
		textbox7.setText(valeur);
	}
	public void setTextbox8Text(String valeur) {
		textbox8.setText(valeur);
	}
	public void setTextbox9Text(String valeur) {
		textbox9.setText(valeur);
	}
	public void setTextbox10Text(String valeur) {
		textbox10.setText(valeur);
	}
	public void setTextbox11Text(String valeur) {
		textbox11.setText(valeur);
	}
	public void setTextbox12Text(String valeur) {
		textbox12.setText(valeur);
	}
	public void setTextbox13Text(String valeur) {
		textbox13.setText(valeur);
	}
	public void setTextbox14Text(String valeur) {
		textbox14.setText(valeur);
	}
	public void setTextbox15Text(String valeur) {
		textbox15.setText(valeur);
	}
	public void setTextbox16Text(Date valeur) {
	    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
	    String formattedDate = dateFormat.format(valeur);
	    textbox16.setText(formattedDate);
	}
	public void setTextbox17Text(Date valeur) {
	    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
	    String formattedDate = dateFormat.format(valeur);
	    textbox17.setText(formattedDate);
	}
}
