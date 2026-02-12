package src.ui.view;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class ExamPanel extends JPanel {

    private JTextField examIdField;
    private JComboBox<String> subjectBox;
    private JTextField dateField;
    private JTextField durationField;

    private JTable examTable;
    private DefaultTableModel tableModel;

    public ExamPanel() {

        setLayout(new BorderLayout(25, 25));
        setBorder(BorderFactory.createEmptyBorder(30, 40, 30, 40));
        setBackground(new Color(15, 15, 20));

        add(createTitle(), BorderLayout.NORTH);
        add(createMainContent(), BorderLayout.CENTER);
    }

    // ===============================
    // TITLE
    // ===============================
    private JLabel createTitle() {

        JLabel title = new JLabel("EXAMS");
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Segoe UI", Font.BOLD, 30));

        return title;
    }

    // ===============================
    // MAIN CONTENT
    // ===============================
    private JPanel createMainContent() {

        JPanel main = new JPanel(new BorderLayout(25, 25));
        main.setOpaque(false);

        main.add(createFormContainer(), BorderLayout.NORTH);
        main.add(createTableContainer(), BorderLayout.CENTER);

        return main;
    }

    // ===============================
    // FORM CONTAINER (Glow + Rounded)
    // ===============================
    private JPanel createFormContainer() {

        JPanel container = createGlowPanel(25);
        container.setLayout(new BorderLayout());
        container.setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));

        container.add(createFormPanel(), BorderLayout.CENTER);

        return container;
    }

    private JPanel createFormPanel() {

        JPanel form = new JPanel(new GridBagLayout());
        form.setOpaque(false);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(12, 12, 12, 12);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        examIdField = createStyledField();
        dateField = createStyledField();
        durationField = createStyledField();

        subjectBox = new JComboBox<>(new String[]{
                "CSE101 - Data Structures",
                "MAT202 - Calculus",
                "PHY303 - Mechanics"
        });
        subjectBox.setFont(new Font("Segoe UI", Font.PLAIN, 16));

        JButton addBtn = createStyledButton("Add");
        JButton updateBtn = createStyledButton("Update");
        JButton deleteBtn = createStyledButton("Delete");

        // Exam ID
        gbc.gridx = 0; gbc.gridy = 0;
        form.add(createLabel("Exam ID:"), gbc);

        gbc.gridx = 1;
        form.add(examIdField, gbc);

        // Subject
        gbc.gridx = 0; gbc.gridy = 1;
        form.add(createLabel("Subject:"), gbc);

        gbc.gridx = 1;
        form.add(subjectBox, gbc);

        // Date
        gbc.gridx = 0; gbc.gridy = 2;
        form.add(createLabel("Exam Date:"), gbc);

        gbc.gridx = 1;
        form.add(dateField, gbc);

        // Duration
        gbc.gridx = 0; gbc.gridy = 3;
        form.add(createLabel("Duration (hrs):"), gbc);

        gbc.gridx = 1;
        form.add(durationField, gbc);

        // Buttons
        gbc.gridx = 0; gbc.gridy = 4;
        gbc.gridwidth = 2;

        JPanel btnPanel = new JPanel();
        btnPanel.setOpaque(false);
        btnPanel.add(addBtn);
        btnPanel.add(updateBtn);
        btnPanel.add(deleteBtn);

        form.add(btnPanel, gbc);

        return form;
    }

    // ===============================
    // TABLE CONTAINER (Glow + Rounded)
    // ===============================
    private JPanel createTableContainer() {

        JPanel container = createGlowPanel(30);
        container.setLayout(new BorderLayout());
        container.setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));

        container.add(createTable(), BorderLayout.CENTER);

        return container;
    }

    private JScrollPane createTable() {

        tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(new String[]{
                "Exam ID",
                "Subject",
                "Exam Date",
                "Duration (hrs)"
        });

        examTable = new JTable(tableModel);
        examTable.setRowHeight(40);
        examTable.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        examTable.setForeground(Color.WHITE);
        examTable.setBackground(new Color(22, 22, 30));
        examTable.setGridColor(Color.WHITE);
        examTable.setSelectionBackground(new Color(0, 150, 255));
        examTable.setSelectionForeground(Color.WHITE);

        JTableHeader header = examTable.getTableHeader();
        header.setFont(new Font("Segoe UI", Font.BOLD, 20));
        header.setForeground(new Color(0, 220, 255));
        header.setBackground(new Color(18, 18, 25));
        header.setPreferredSize(new Dimension(header.getWidth(), 50));

        JScrollPane scroll = new JScrollPane(examTable);
        scroll.setBorder(null);
        scroll.getViewport().setBackground(new Color(22, 22, 30));

        return scroll;
    }

    // ===============================
    // STYLED COMPONENTS
    // ===============================
    private JTextField createStyledField() {

        JTextField field = new JTextField(15);
        field.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        return field;
    }

    private JLabel createLabel(String text) {

        JLabel label = new JLabel(text);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Segoe UI", Font.BOLD, 16));
        return label;
    }

    private JButton createStyledButton(String text) {

        JButton btn = new JButton(text);
        btn.setFont(new Font("Segoe UI", Font.BOLD, 16));
        btn.setForeground(Color.WHITE);
        btn.setBackground(new Color(0, 140, 255));
        btn.setFocusPainted(false);
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));

        return btn;
    }

    // ===============================
    // GLOW PANEL GENERATOR
    // ===============================
    private JPanel createGlowPanel(int arc) {

        return new JPanel() {

            protected void paintComponent(Graphics g) {

                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                        RenderingHints.VALUE_ANTIALIAS_ON);

                for (int i = 8; i >= 2; i -= 2) {
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

                g2.setColor(new Color(22, 22, 30));
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
    }
}
