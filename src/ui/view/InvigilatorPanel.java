package src.ui.view;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class InvigilatorPanel extends JPanel {

    private JTextField idField;
    private JTextField nameField;
    private JTextField phoneField;
    private JComboBox<String> hallBox;

    private JTable invigilatorTable;
    private DefaultTableModel tableModel;

    public InvigilatorPanel() {

        setLayout(new BorderLayout(20, 20));
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        add(createTitle(), BorderLayout.NORTH);
        add(createMainContent(), BorderLayout.CENTER);
    }

    // ===============================
    // TITLE SECTION
    // ===============================
    private JLabel createTitle() {

        JLabel title = new JLabel("INVIGILATORS");
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
        formPanel.setBorder(BorderFactory.createTitledBorder("Add / Update Invigilator"));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        idField = new JTextField(15);
        nameField = new JTextField(15);
        phoneField = new JTextField(15);

        hallBox = new JComboBox<>(new String[]{
                "Hall A",
                "Hall B",
                "Hall C"
        });

        JButton addBtn = new JButton("Add");
        JButton updateBtn = new JButton("Update");
        JButton deleteBtn = new JButton("Delete");

        // Row 1 - ID
        gbc.gridx = 0;
        gbc.gridy = 0;
        formPanel.add(new JLabel("Invigilator ID:"), gbc);

        gbc.gridx = 1;
        formPanel.add(idField, gbc);

        // Row 2 - Name
        gbc.gridx = 0;
        gbc.gridy = 1;
        formPanel.add(new JLabel("Full Name:"), gbc);

        gbc.gridx = 1;
        formPanel.add(nameField, gbc);

        // Row 3 - Phone
        gbc.gridx = 0;
        gbc.gridy = 2;
        formPanel.add(new JLabel("Phone:"), gbc);

        gbc.gridx = 1;
        formPanel.add(phoneField, gbc);

        // Row 4 - Hall
        gbc.gridx = 0;
        gbc.gridy = 3;
        formPanel.add(new JLabel("Assigned Hall:"), gbc);

        gbc.gridx = 1;
        formPanel.add(hallBox, gbc);

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
        tablePanel.setBorder(BorderFactory.createTitledBorder("Invigilator List"));

        tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(new String[]{
                "Invigilator ID",
                "Full Name",
                "Phone",
                "Assigned Hall"
        });

        invigilatorTable = new JTable(tableModel);
        invigilatorTable.setRowHeight(28);
        invigilatorTable.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 14));

        JScrollPane scrollPane = new JScrollPane(invigilatorTable);

        tablePanel.add(scrollPane, BorderLayout.CENTER);

        return tablePanel;
    }
}
