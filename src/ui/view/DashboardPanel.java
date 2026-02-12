package src.ui.view;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class DashboardPanel extends JPanel {

    private JLabel totalStudentsLabel;
    private JLabel totalSubjectsLabel;
    private JLabel totalHallsLabel;

    private JTable upcomingExamTable;
    private DefaultTableModel tableModel;

    public DashboardPanel() {

        setLayout(new BorderLayout(20, 20));
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        add(createTitle(), BorderLayout.NORTH);
        add(createMainContent(), BorderLayout.CENTER);
    }

    // ===============================
    // TITLE
    // ===============================
    private JLabel createTitle() {

        JLabel title = new JLabel("DASHBOARD");
        title.setFont(new Font("Segoe UI", Font.BOLD, 26));

        return title;
    }

    // ===============================
    // MAIN CONTENT
    // ===============================
    private JPanel createMainContent() {

        JPanel mainPanel = new JPanel(new BorderLayout(20, 20));

        mainPanel.add(createStatsPanel(), BorderLayout.NORTH);
        mainPanel.add(createUpcomingExamPanel(), BorderLayout.CENTER);

        return mainPanel;
    }

    // ===============================
    // STATS PANEL (TOP CARDS)
    // ===============================
    private JPanel createStatsPanel() {

        JPanel statsPanel = new JPanel(new GridLayout(1, 3, 20, 20));

        totalStudentsLabel = new JLabel("250", SwingConstants.CENTER);
        totalSubjectsLabel = new JLabel("12", SwingConstants.CENTER);
        totalHallsLabel = new JLabel("8", SwingConstants.CENTER);

        statsPanel.add(createStatCard("Total Students", totalStudentsLabel));
        statsPanel.add(createStatCard("Total Subjects", totalSubjectsLabel));
        statsPanel.add(createStatCard("Total Halls", totalHallsLabel));

        return statsPanel;
    }

    // ===============================
    // INDIVIDUAL STAT CARD
    // ===============================
    private JPanel createStatCard(String title, JLabel valueLabel) {

        JPanel card = new JPanel(new BorderLayout());
        card.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
        card.setBackground(Color.WHITE);

        JLabel titleLabel = new JLabel(title, SwingConstants.CENTER);
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));

        valueLabel.setFont(new Font("Segoe UI", Font.BOLD, 28));
        valueLabel.setForeground(new Color(0, 102, 204));

        card.add(titleLabel, BorderLayout.NORTH);
        card.add(valueLabel, BorderLayout.CENTER);

        return card;
    }

    // ===============================
    // UPCOMING EXAMS PANEL
    // ===============================
    private JPanel createUpcomingExamPanel() {

        JPanel examPanel = new JPanel(new BorderLayout());
        examPanel.setBorder(BorderFactory.createTitledBorder("Upcoming Exams"));

        tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(new String[]{
                "Exam ID",
                "Subject",
                "Date",
                "Duration"
        });

        upcomingExamTable = new JTable(tableModel);
        upcomingExamTable.setRowHeight(25);

        JScrollPane scrollPane = new JScrollPane(upcomingExamTable);

        examPanel.add(scrollPane, BorderLayout.CENTER);

        return examPanel;
    }
}
