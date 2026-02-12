package src.ui.view;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class SubjectPanel extends JPanel {
    private JTextField codeField;
    private JTextField nameField;
    private JTextField creditsField;
    private JTable subjectTable;
    private DefaultTableModel tableModel;

    public SubjectPanel() {

        setLayout(new BorderLayout(20, 20));
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // ===============================
        // TITLE
        // ===============================
        JLabel title = new JLabel("SUBJECTS");
        title.setFont(new Font("Arial", Font.BOLD, 22));

        add(title, BorderLayout.NORTH);

        // ===============================
        // CENTER PANEL
        // ===============================
        JPanel centerPanel = new JPanel(new BorderLayout(20, 20));

        centerPanel.add(createFormPanel(), BorderLayout.NORTH);
        centerPanel.add(createTablePanel(), BorderLayout.CENTER);

        add(centerPanel, BorderLayout.CENTER);
    }

    // ===================================
    // FORM PANEL
    // ===================================
    private JPanel createFormPanel() {

        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBorder(BorderFactory.createTitledBorder("Add / Update Subject"));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        codeField = new JTextField(15);
        nameField = new JTextField(15);
        creditsField = new JTextField(15);

        JButton addBtn = new JButton("Add");
        JButton updateBtn = new JButton("Update");
        JButton deleteBtn = new JButton("Delete");

        // Code
        gbc.gridx = 0;
        gbc.gridy = 0;
        formPanel.add(new JLabel("Code:"), gbc);

        gbc.gridx = 1;
        formPanel.add(codeField, gbc);

        // Name
        gbc.gridx = 0;
        gbc.gridy = 1;
        formPanel.add(new JLabel("Name:"), gbc);

        gbc.gridx = 1;
        formPanel.add(nameField, gbc);

        // Credits
        gbc.gridx = 0;
        gbc.gridy = 2;
        formPanel.add(new JLabel("Credits:"), gbc);

        gbc.gridx = 1;
        formPanel.add(creditsField, gbc);

        // Buttons
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addBtn);
        buttonPanel.add(updateBtn);
        buttonPanel.add(deleteBtn);

        formPanel.add(buttonPanel, gbc);

        return formPanel;
    }

    private JPanel createTablePanel() {

        JPanel tablePanel = new JPanel(new BorderLayout());
        tablePanel.setBorder(BorderFactory.createTitledBorder("Subject List"));

        tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(new String[]{"Code", "Name", "Credits"});

        subjectTable = new JTable(tableModel);
        subjectTable.setRowHeight(25);

        JScrollPane scrollPane = new JScrollPane(subjectTable);

        tablePanel.add(scrollPane, BorderLayout.CENTER);

        return tablePanel;
    }
}
