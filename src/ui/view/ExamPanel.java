package src.ui.view;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
public class ExamPanel extends JPanel {
    
     private JTextField examIdField;
    private JComboBox<String> subjectBox;
    private JTextField dateField;
    private JTextField durationField;

    private JTable examTable;
    private DefaultTableModel tableModel;

    public ExamPanel() {

        setLayout(new BorderLayout(20, 20));
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        add(createTitle(), BorderLayout.NORTH);
        add(createMainContent(), BorderLayout.CENTER);
    }

    // ===============================
    // TITLE
    // ===============================
    private JLabel createTitle() {

        JLabel title = new JLabel("EXAMS");
        title.setFont(new Font("Segoe UI", Font.BOLD, 24));

        return title;
    }

    // ===============================
    // MAIN CONTENT
    // ===============================
    private JPanel createMainContent() {

        JPanel mainPanel = new JPanel(new BorderLayout(20, 20));

        mainPanel.add(createFormPanel(), BorderLayout.NORTH);
        mainPanel.add(createTablePanel(), BorderLayout.CENTER);

        return mainPanel;
    }

    // ===============================
    // FORM PANEL
    // ===============================
    private JPanel createFormPanel() {

        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBorder(BorderFactory.createTitledBorder("Create / Update Exam"));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        examIdField = new JTextField(15);

        subjectBox = new JComboBox<>(new String[]{
                "CSE101 - Data Structures",
                "MAT202 - Calculus",
                "PHY303 - Mechanics"
        });

        dateField = new JTextField(15);     // Later you can replace with DatePicker
        durationField = new JTextField(15);

        JButton addBtn = new JButton("Add");
        JButton updateBtn = new JButton("Update");
        JButton deleteBtn = new JButton("Delete");

        // Row 1 - Exam ID
        gbc.gridx = 0;
        gbc.gridy = 0;
        formPanel.add(new JLabel("Exam ID:"), gbc);

        gbc.gridx = 1;
        formPanel.add(examIdField, gbc);

        // Row 2 - Subject
        gbc.gridx = 0;
        gbc.gridy = 1;
        formPanel.add(new JLabel("Subject:"), gbc);

        gbc.gridx = 1;
        formPanel.add(subjectBox, gbc);

        // Row 3 - Exam Date
        gbc.gridx = 0;
        gbc.gridy = 2;
        formPanel.add(new JLabel("Exam Date:"), gbc);

        gbc.gridx = 1;
        formPanel.add(dateField, gbc);

        // Row 4 - Duration
        gbc.gridx = 0;
        gbc.gridy = 3;
        formPanel.add(new JLabel("Duration (hrs):"), gbc);

        gbc.gridx = 1;
        formPanel.add(durationField, gbc);

        // Row 5 - Buttons
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addBtn);
        buttonPanel.add(updateBtn);
        buttonPanel.add(deleteBtn);

        formPanel.add(buttonPanel, gbc);

        return formPanel;
    }

    // ===============================
    // TABLE PANEL
    // ===============================
    private JPanel createTablePanel() {

        JPanel tablePanel = new JPanel(new BorderLayout());
        tablePanel.setBorder(BorderFactory.createTitledBorder("Exam List"));

        tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(new String[]{
                "Exam ID",
                "Subject",
                "Exam Date",
                "Duration (hrs)"
        });

        examTable = new JTable(tableModel);
        examTable.setRowHeight(28);
        examTable.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 14));

        JScrollPane scrollPane = new JScrollPane(examTable);

        tablePanel.add(scrollPane, BorderLayout.CENTER);

        return tablePanel;
    }
}
