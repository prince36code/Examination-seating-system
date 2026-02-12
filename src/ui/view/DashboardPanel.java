package src.ui.view;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class DashboardPanel extends JPanel {

    private JLabel totalStudentsLabel;
    private JLabel totalSubjectsLabel;
    private JLabel totalHallsLabel;

    private JTable upcomingExamTable;
    private DefaultTableModel tableModel;

    public DashboardPanel() {

        setOpaque(false);
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(30, 40, 30, 40));

        add(createMainContainer(), BorderLayout.CENTER);
    }

    // ===============================
    // MAIN GLOW CONTAINER
    // ===============================
    private JPanel createMainContainer() {

        JPanel container = new JPanel() {

            protected void paintComponent(Graphics g) {

                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                        RenderingHints.VALUE_ANTIALIAS_ON);

                int arc = 30;

                // Outer blue glow
                for (int i = 8; i >= 2; i -= 2) {
                    g2.setColor(new Color(0, 180, 255, 40));
                    g2.setStroke(new BasicStroke(i));
                    g2.drawRoundRect(
                            i / 2,
                            i / 2,
                            getWidth() - i,
                            getHeight() - i,
                            arc,
                            arc
                    );
                }

                // Dark background
                g2.setColor(new Color(25, 25, 30));
                g2.fillRoundRect(
                        6,
                        6,
                        getWidth() - 12,
                        getHeight() - 12,
                        arc,
                        arc
                );

                g2.dispose();
            }
        };

        container.setOpaque(false);
        container.setLayout(new BorderLayout(20, 20));
        container.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));

        container.add(createTitle(), BorderLayout.NORTH);
        container.add(createContent(), BorderLayout.CENTER);

        return container;
    }

    // ===============================
    // TITLE
    // ===============================
    private JLabel createTitle() {

        JLabel title = new JLabel("DASHBOARD");
        title.setFont(new Font("Segoe UI", Font.BOLD, 28));
        title.setForeground(Color.WHITE);

        return title;
    }

    // ===============================
    // CONTENT
    // ===============================
    private JPanel createContent() {

        JPanel panel = new JPanel(new BorderLayout(30, 30));
        panel.setOpaque(false);

        panel.add(createStatsPanel(), BorderLayout.NORTH);
        panel.add(createUpcomingExamPanel(), BorderLayout.CENTER);

        return panel;
    }

    // ===============================
    // STATS CARDS
    // ===============================
    private JPanel createStatsPanel() {

        JPanel statsPanel = new JPanel(new GridLayout(1, 3, 20, 20));
        statsPanel.setOpaque(false);

        totalStudentsLabel = new JLabel("250", SwingConstants.CENTER);
        totalSubjectsLabel = new JLabel("12", SwingConstants.CENTER);
        totalHallsLabel = new JLabel("8", SwingConstants.CENTER);

        statsPanel.add(createStatCard("Total Students", totalStudentsLabel));
        statsPanel.add(createStatCard("Total Subjects", totalSubjectsLabel));
        statsPanel.add(createStatCard("Total Halls", totalHallsLabel));

        return statsPanel;
    }

    // ===============================
    // INDIVIDUAL CARD
    // ===============================
    private JPanel createStatCard(String title, JLabel valueLabel) {

        JPanel card = new JPanel() {

            protected void paintComponent(Graphics g) {

                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                        RenderingHints.VALUE_ANTIALIAS_ON);

                int arc = 20;

                // Soft blue glow
                for (int i = 6; i >= 2; i -= 2) {
                    g2.setColor(new Color(0, 180, 255, 35));
                    g2.setStroke(new BasicStroke(i));
                    g2.drawRoundRect(
                            i / 2,
                            i / 2,
                            getWidth() - i,
                            getHeight() - i,
                            arc,
                            arc
                    );
                }

                g2.setColor(new Color(35, 35, 45));
                g2.fillRoundRect(
                        6,
                        6,
                        getWidth() - 12,
                        getHeight() - 12,
                        arc,
                        arc
                );

                g2.dispose();
            }
        };

        card.setOpaque(false);
        card.setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel(title, SwingConstants.CENTER);
        titleLabel.setForeground(Color.LIGHT_GRAY);
        titleLabel.setFont(new Font("Segoe UI", Font.PLAIN, 16));

        valueLabel.setFont(new Font("Segoe UI", Font.BOLD, 32));
        valueLabel.setForeground(new Color(0, 200, 255));

        card.add(titleLabel, BorderLayout.NORTH);
        card.add(valueLabel, BorderLayout.CENTER);

        return card;
    }

    // ===============================
    // UPCOMING EXAMS TABLE
    // ===============================
    private JPanel createUpcomingExamPanel() {

    JPanel wrapper = new JPanel(new BorderLayout());
    wrapper.setOpaque(false);

    JLabel title = new JLabel("Upcoming Exams");
    title.setForeground(Color.WHITE);
    title.setFont(new Font("Segoe UI", Font.BOLD, 22));
    title.setBorder(BorderFactory.createEmptyBorder(0, 0, 15, 0));

    // ===============================
    // TABLE MODEL
    // ===============================
    tableModel = new DefaultTableModel();
    tableModel.setColumnIdentifiers(new String[]{
            "Exam ID",
            "Subject",
            "Date",
            "Duration"
    });

    upcomingExamTable = new JTable(tableModel);

    upcomingExamTable.setRowHeight(35);
    upcomingExamTable.setFont(new Font("Segoe UI", Font.PLAIN, 16));
    upcomingExamTable.setBackground(new Color(30, 30, 40));
    upcomingExamTable.setForeground(Color.WHITE);
    upcomingExamTable.setGridColor(new Color(0, 180, 255));
    upcomingExamTable.setShowGrid(true);
    upcomingExamTable.setIntercellSpacing(new Dimension(1, 1));
    upcomingExamTable.setSelectionBackground(new Color(0, 150, 255));
    upcomingExamTable.setSelectionForeground(Color.WHITE);

    // Header Styling
    JTableHeader header = upcomingExamTable.getTableHeader();
    header.setFont(new Font("Segoe UI", Font.BOLD, 18));
    header.setBackground(new Color(20, 20, 30));
    header.setForeground(new Color(0, 200, 255));
    header.setPreferredSize(new Dimension(header.getWidth(), 45));
    header.setBorder(BorderFactory.createEmptyBorder());

    // ===============================
    // SCROLLPANE (NO SHARP EDGES)
    // ===============================
    JScrollPane scrollPane = new JScrollPane(upcomingExamTable);
    scrollPane.setBorder(BorderFactory.createEmptyBorder());
    scrollPane.getViewport().setBackground(new Color(30, 30, 40));

    // ===============================
    // ROUNDED GLOW CONTAINER
    // ===============================
    JPanel roundedContainer = new JPanel() {

        protected void paintComponent(Graphics g) {

            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);

            int arc = 25;

            // Thin blue glow
            for (int i = 6; i >= 2; i -= 2) {
                g2.setColor(new Color(0, 180, 255, 40));
                g2.setStroke(new BasicStroke(i));
                g2.drawRoundRect(
                        i / 2,
                        i / 2,
                        getWidth() - i,
                        getHeight() - i,
                        arc,
                        arc
                );
            }

            // Dark background
            g2.setColor(new Color(28, 28, 35));
            g2.fillRoundRect(
                    6,
                    6,
                    getWidth() - 12,
                    getHeight() - 12,
                    arc,
                    arc
            );

            g2.dispose();
        }
    };

    roundedContainer.setLayout(new BorderLayout());
    roundedContainer.setOpaque(false);
    roundedContainer.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

    roundedContainer.add(scrollPane, BorderLayout.CENTER);

    wrapper.add(title, BorderLayout.NORTH);
    wrapper.add(roundedContainer, BorderLayout.CENTER);

    return wrapper;
}


}
