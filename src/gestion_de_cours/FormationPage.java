package gestion_de_cours;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class FormationPage extends JPanel {
    public FormationPage() {
        setBackground(new Color(64, 64, 64));
        setLayout(new GridLayout(2, 1));

        JPanel formationPanel1 = createFormationPanel("Formation professionnelle", "Finance et Comptabilité", "Boulangerie et Patisserie");
        add(formationPanel1);

        JPanel formationPanel2 = createFormationPanel("Formation continue", "Langue", "Informatique");
        add(formationPanel2);
    }

    private JPanel createFormationPanel(String sectionTitle, String courseTitle1, String courseTitle2) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panel.setBackground(new Color(64, 64, 64));

        JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        titlePanel.setBackground(new Color(64, 64, 64));
        JLabel sectionLabel = new JLabel(sectionTitle);
        sectionLabel.setFont(new Font("Arial", Font.BOLD, 30));
        sectionLabel.setForeground(Color.WHITE);
        titlePanel.add(sectionLabel);
        titlePanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
        panel.add(titlePanel);

        JPanel productCardsPanel = new JPanel();
        productCardsPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 30, 5));
        productCardsPanel.setBackground(new Color(64, 64, 64));

        JPanel productCard1 = createProductCard(courseTitle1);
        JPanel productCard2 = createProductCard(courseTitle2);

        productCardsPanel.add(productCard1);
        productCardsPanel.add(productCard2);

        panel.add(productCardsPanel);

        return panel;
    }

    private JPanel createProductCard(String courseTitle) {
        JPanel productCard = new JPanel();
        productCard.setPreferredSize(new Dimension(250, 150));
        productCard.setLayout(new BorderLayout());

        int memberCount = fetchMemberCount(courseTitle);

        productCard.setBackground(getColorForCourse(courseTitle));

        JLabel titleLabel = new JLabel(courseTitle);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        productCard.add(titleLabel, BorderLayout.NORTH);

        JLabel memberLabel = new JLabel("Members: " + memberCount);
        memberLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        memberLabel.setForeground(Color.WHITE);
        memberLabel.setHorizontalAlignment(SwingConstants.CENTER);
        productCard.add(memberLabel, BorderLayout.SOUTH);

        return productCard;
    }

    private Color getColorForCourse(String courseTitle) {
        switch (courseTitle) {
            case "Finance et Comptabilité":
                return Color.BLUE;
            case "Boulangerie et Patisserie":
                return new Color(128, 0, 128);
            case "Langue":
                return Color.BLACK;
            case "Informatique":
                return Color.ORANGE;
            default:
                return Color.GRAY;
        }
    }

    private int fetchMemberCount(String courseTitle) {
        String connectionString = "jdbc:mysql://localhost/sfe?user=root";
        String tableName;
        switch (courseTitle) {
            case "Finance et Comptabilité":
                tableName = "finance";
                break;
            case "Boulangerie et Patisserie":
                tableName = "boulangerie";
                break;
            case "Informatique":
                tableName = "informatique";
                break;
            case "Langue":
                tableName = "langues";
                break;
            default:
                tableName = "";
                break;
        }

        if (!tableName.isEmpty()) {
            try (Connection connection = DriverManager.getConnection(connectionString)) {
                String query = "SELECT COUNT(*) FROM " + tableName;
                try (Statement statement = connection.createStatement()) {
                    try (ResultSet resultSet = statement.executeQuery(query)) {
                        if (resultSet.next()) {
                            return resultSet.getInt(1);
                        }
                    }
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return 0;
    }

    // Method to refresh the FormationPage
    public void refresh() {
        removeAll(); // Clear the current content
        // Rebuild the FormationPage with updated member counts
        JPanel formationPanel1 = createFormationPanel("Formation professionnelle", "Finance et Comptabilité", "Boulangerie et Patisserie");
        add(formationPanel1);

        JPanel formationPanel2 = createFormationPanel("Formation continue", "Langue", "Informatique");
        add(formationPanel2);

        revalidate(); // Revalidate the layout
        repaint(); // Repaint the panel
    }

    public static void main(String[] args) {
        FormationPage formationPage = new FormationPage();
        JFrame frame = new JFrame("Formation Page");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        frame.add(formationPage);
        frame.setVisible(true);

        // Example usage: Call refresh after adding members to courses
        // formationPage.refresh();
    }
}
