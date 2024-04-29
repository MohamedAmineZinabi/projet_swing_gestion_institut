package gestion_de_cours;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Vector;

public class Finance_et_comptabilite extends JPanel {
    private JTextField textbox1;
    private ImageIcon icon;
    private JLabel iconLabel;
    private JTable table1;
    private JTextField searchField;
    private int scrollPosition;
    private JScrollPane scrollPane;


    public Finance_et_comptabilite() {
        setBackground(new Color(105, 105, 105));
        initComponents();
    }

    private void initComponents() {
        setLayout(null);
        
        JButton Button1 = new JButton("Nouveau");
        Button1.setBackground(new Color(0, 128, 255));
        Button1.setBounds(58, 43, 89, 23);
        add(Button1);
        // ActionListener pour le bouton "Nouveau"
        Button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Création et affichage de la frame Ajout_finance
                Ajout_finance ajoutFinanceFrame = new Ajout_finance();
                ajoutFinanceFrame.setVisible(true);
            }
        });

        textbox1 = new JTextField();
        textbox1.setBounds(695, 36, 183, 29);
        add(textbox1);
        textbox1.setColumns(10);

        icon = new ImageIcon("C:\\Users\\hp\\eclipse-workspace\\Gestion_de_cours\\src\\images\\icons8-search-30.png");
        iconLabel = new JLabel(icon);
        iconLabel.setBounds(888, 36, 30, 30);
        add(iconLabel);

        table1 = new JTable();
        table1.getTableHeader().setReorderingAllowed(false);
        table1.setBounds(68, 106, 870, 444);
        add(table1);
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Ordre");
        model.addColumn("Code");
        model.addColumn("Nom complet");
        model.addColumn("Date d'inscription");
        model.addColumn("Date");
        model.addColumn("Prix");
        model.addColumn(""); // Colonne vide pour le premier bouton
        model.addColumn(""); // Colonne vide pour le deuxiÃ¨me bouton
        model.addColumn(""); // Colonne vide pour le troisiÃ¨me bouton	

        table1.setModel(model); // Important : associer le modÃ¨le de donnÃ©es Ã  la table

        // RÃ©gler la largeur prÃ©fÃ©rÃ©e des colonnes
        table1.getColumnModel().getColumn(0).setPreferredWidth(70); // Largeur de la colonne "Ordre"
        table1.getColumnModel().getColumn(1).setPreferredWidth(70); // Largeur de la colonne "Code"
        table1.getColumnModel().getColumn(2).setPreferredWidth(150); // Largeur de la colonne "Nom complet"
        table1.getColumnModel().getColumn(3).setPreferredWidth(120); // Largeur de la colonne "Date d'inscription"
        table1.getColumnModel().getColumn(4).setPreferredWidth(120); // Largeur de la colonne "Date"
        table1.getColumnModel().getColumn(5).setPreferredWidth(70);
        // Ajout de la largeur prÃ©fÃ©rÃ©e pour les colonnes vides
        table1.getColumnModel().getColumn(6).setPreferredWidth(50);
        table1.getColumnModel().getColumn(7).setPreferredWidth(50);
        table1.getColumnModel().getColumn(8).setPreferredWidth(50);

        scrollPane = new JScrollPane(table1); 
        scrollPane.setBounds(68, 106, 870, 372); 
        add(scrollPane);
        
        TableColumnModel columnModel = table1.getColumnModel();
        for (int i = 0; i < columnModel.getColumnCount(); i++) {
            TableColumn column = columnModel.getColumn(i);
            column.setResizable(false); 
        }
    /*
        ButtonRenderer buttonRenderer = new ButtonRenderer();
        ButtonEditor buttonEditor = new ButtonEditor(new JButton());
        table1.getColumnModel().getColumn(6).setCellRenderer(buttonRenderer);
        table1.getColumnModel().getColumn(6).setCellEditor(buttonEditor);
        table1.getColumnModel().getColumn(7).setCellRenderer(buttonRenderer);
        table1.getColumnModel().getColumn(7).setCellEditor(buttonEditor);
        table1.getColumnModel().getColumn(8).setCellRenderer(buttonRenderer);
        table1.getColumnModel().getColumn(8).setCellEditor(buttonEditor);
    */
        searchField = new JTextField();
        searchField.setBackground(new Color(105, 105, 105));
        searchField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AfficherDonnees();
            }
        });
        add(searchField, BorderLayout.NORTH);

        // Ajout de l'Ã©couteur de modification de texte pour la recherche
        textbox1.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                AfficherDonnees();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                AfficherDonnees();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                AfficherDonnees();
            }
        });

        // Ajout de l'Ã©couteur de clic de souris
        table1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int col = table1.columnAtPoint(e.getPoint());
                int row = table1.rowAtPoint(e.getPoint());
                
                if (col == 6 && row >= 0) {
                    String ordre = table1.getValueAt(row, 0).toString(); // RÃ©cupÃ©rer l'ordre de la colonne 0
                    String code = table1.getValueAt(row, 1).toString(); // RÃ©cupÃ©rer le CODE de la colonne 1

                    // Connexion Ã  la base de donnÃ©es MySQL
                    String connectionStr = "jdbc:mysql://localhost/sfe";
                    String username = "root";
                    String password = "";
                    
                    try (Connection connection = DriverManager.getConnection(connectionStr, username, password)) {
                        // PrÃ©parer la requÃªte SQL paramÃ©trÃ©e pour rÃ©cupÃ©rer les dÃ©tails de finance basÃ©s sur l'ordre
                        String query = "SELECT CODE, Nom_Complet, Date_inscription, Date_debut, septembre, octobre, novembre, decembre, janvier, fevrier, mars, avril, mai, juin, juillet FROM finance WHERE ordre = ?";
                        
                        try (PreparedStatement statement = connection.prepareStatement(query)) {
                            statement.setString(1, ordre);
                            
                            try (ResultSet resultSet = statement.executeQuery()) {
                                if (resultSet.next()) {
                                    // RÃ©cupÃ©rer les valeurs des champs de la base de donnÃ©es
                                    String cod = resultSet.getString("CODE");
                                    String nom = resultSet.getString("Nom_Complet");
                                    String sep = resultSet.getString("septembre");
                                    String oct = resultSet.getString("octobre");
                                    String nov = resultSet.getString("novembre");
                                    String dec = resultSet.getString("decembre");
                                    String jan = resultSet.getString("janvier");
                                    String fev = resultSet.getString("fevrier");
                                    String mar = resultSet.getString("mars");
                                    String avr = resultSet.getString("avril");
                                    String mai = resultSet.getString("mai");
                                    String jui = resultSet.getString("juin");
                                    String juil = resultSet.getString("juillet");
                                    Date inscri = resultSet.getDate("Date_inscription");
                                    Date debut = resultSet.getDate("Date_debut");

                                    // CrÃ©er une nouvelle instance de Fiche_finance
                                    Fiche_finance ficheFinance = new Fiche_finance();

                                    // Mettre Ã  jour les champs de la fenÃªtre Fiche_finance avec les valeurs rÃ©cupÃ©rÃ©es
                                    ficheFinance.setTextbox1Text(cod);
                                    ficheFinance.setTextbox4Text(nom);
                                    ficheFinance.setTextbox5Text(sep);
                                    ficheFinance.setTextbox6Text(oct);
                                    ficheFinance.setTextbox7Text(nov);
                                    ficheFinance.setTextbox8Text(dec);
                                    ficheFinance.setTextbox9Text(jan);
                                    ficheFinance.setTextbox10Text(fev);
                                    ficheFinance.setTextbox11Text(mar);
                                    ficheFinance.setTextbox12Text(avr);
                                    ficheFinance.setTextbox13Text(mai);
                                    ficheFinance.setTextbox14Text(jui);
                                    ficheFinance.setTextbox15Text(juil);
                                    ficheFinance.setTextbox16Text(inscri);
                                    ficheFinance.setTextbox17Text(debut);

                                    // Afficher la fenÃªtre Fiche_finance
                                    ficheFinance.setVisible(true);
                                }
                            }
                        }
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Erreur : " + ex.getMessage(), "Erreur de connexion", JOptionPane.ERROR_MESSAGE);
                    }
                } else if (col == 8 && row >= 0) {
                    // Si la colonne cliquÃ©e est la colonne 8, appeler la mÃ©thode pour supprimer l'entrÃ©e
                    supprimerEntree(row);
                }
            }
        });


        // Afficher les donnÃ©es au chargement
        AfficherDonnees();
    }

    // MÃ©thode pour afficher les donnÃ©es dans la table
    private void AfficherDonnees() {
        scrollPosition = scrollPane.getVerticalScrollBar().getValue();

        String searchTerm = textbox1.getText();
        String query = "SELECT ordre, CODE, Nom_Complet, Date_inscription, Date_debut, Prix FROM finance WHERE Nom_Complet LIKE ? ORDER BY ordre";
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new Object[]{"Ordre", "Code", "Nom complet","Date d'inscription","Date debut", "Prix", "", "", ""});

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/sfe", "root", "");
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, "%" + searchTerm + "%");
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Vector<Object> row = new Vector<>();
                    row.add(resultSet.getInt("ordre"));
                    row.add(resultSet.getString("CODE"));
                    row.add(resultSet.getString("Nom_Complet"));
                    row.add(resultSet.getString("Date_inscription"));
                    row.add(resultSet.getString("Date_debut"));
                    row.add(resultSet.getString("Prix"));
                    row.add("Fiche");
                    row.add("Modifier");
                    row.add("Supprimer");
                    model.addRow(row);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erreur : " + ex.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
        }

        table1.setModel(model);
        table1.setRowHeight(30);

        if (scrollPosition >= 0 && scrollPosition < table1.getRowCount()) {
            table1.setRowSelectionInterval(scrollPosition, scrollPosition);
            scrollPane.getVerticalScrollBar().setValue(scrollPosition * table1.getRowHeight());
        }
    }

    // MÃ©thode pour supprimer une entrÃ©e de la base de donnÃ©es
    private void supprimerEntree(int rowIndex) {
        String code = (String) table1.getValueAt(rowIndex, 1); // RÃ©cupÃ©ration du code dans la colonne 1 (0-indexed)
        String query = "DELETE FROM finance WHERE CODE = ?";
        
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/sfe", "root", "");
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, code);
            statement.executeUpdate();
            AfficherDonnees(); 

        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erreur : " + ex.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }
    public void afficherDonnees() {
        AfficherDonnees();
    }

}
