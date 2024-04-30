package gestion_de_cours;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class FormationPage extends JFrame {
    public FormationPage() {
        setTitle("Formation Page");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 600);
        Color darkGray = new Color(64, 64, 64);
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(2, 1)); // Change layout to GridLayout
        mainPanel.setBackground(darkGray);

        JPanel formationPanel1 = createFormationPanel("Formation professionnelle", "Finance et Comptabilité", "Boulangerie et Patisserie");
        mainPanel.add(formationPanel1);

        JPanel formationPanel2 = createFormationPanel("Formation continue", "Langue", "Informatique");
        mainPanel.add(formationPanel2);

        add(mainPanel);
        setVisible(true);
    }

    private JPanel createFormationPanel(String sectionTitle, String courseTitle1, String courseTitle2) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); // Use BoxLayout for vertical alignment
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panel.setBackground(new Color(64, 64, 64));

        // Title Panel
        JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        titlePanel.setBackground(new Color(64, 64, 64));
        JLabel sectionLabel = new JLabel(sectionTitle);
        sectionLabel.setFont(new Font("Arial", Font.BOLD, 30));
        sectionLabel.setForeground(Color.WHITE);
        titlePanel.add(sectionLabel);
        // Add empty border to create space
        titlePanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0)); // Adjust bottom padding as needed
        panel.add(titlePanel);

        // Product Cards Panel
        JPanel productCardsPanel = new JPanel();
        productCardsPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 30, 5));
        productCardsPanel.setBackground(new Color(64, 64, 64));

        // Create product cards based on courses
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

        // Fetch member count from database
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
                return Color.GRAY; // Default color
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
        return 0; // Return 0 if count couldn't be fetched
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(FormationPage::new);
    }
}
