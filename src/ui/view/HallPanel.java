package src.ui.view;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
public class HallPanel extends JPanel{
     private JTextField idField;
    private JTextField nameField;
    private JTextField capacityField;

    private JTable hallTable;
    private DefaultTableModel tableModel;

    public HallPanel() {

        setLayout(new BorderLayout(20, 20));
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        add(createTitle(), BorderLayout.NORTH);
        add(createMainContent(), BorderLayout.CENTER);
    }

    // ===============================
    // TITLE SECTION
    // ===============================
    private JLabel createTitle() {

        JLabel title = new JLabel("HALLS");
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
        formPanel.setBorder(BorderFactory.createTitledBorder("Add / Update Hall"));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        idField = new JTextField(15);
        nameField = new JTextField(15);
        capacityField = new JTextField(15);

        JButton addBtn = new JButton("Add");
        JButton updateBtn = new JButton("Update");
        JButton deleteBtn = new JButton("Delete");

        // Row 1 - Hall ID
        gbc.gridx = 0;
        gbc.gridy = 0;
        formPanel.add(new JLabel("Hall ID:"), gbc);

        gbc.gridx = 1;
        formPanel.add(idField, gbc);

        // Row 2 - Hall Name
        gbc.gridx = 0;
        gbc.gridy = 1;
        formPanel.add(new JLabel("Hall Name:"), gbc);

        gbc.gridx = 1;
        formPanel.add(nameField, gbc);

        // Row 3 - Capacity
        gbc.gridx = 0;
        gbc.gridy = 2;
        formPanel.add(new JLabel("Capacity:"), gbc);

        gbc.gridx = 1;
        formPanel.add(capacityField, gbc);

        // Row 4 - Buttons
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

    // ===============================
    // TABLE PANEL
    // ===============================
    private JPanel createTablePanel() {

        JPanel tablePanel = new JPanel(new BorderLayout());
        tablePanel.setBorder(BorderFactory.createTitledBorder("Hall List"));

        tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(new String[]{
                "Hall ID",
                "Hall Name",
                "Capacity"
        });

        hallTable = new JTable(tableModel);
        hallTable.setRowHeight(28);
        hallTable.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 14));

        JScrollPane scrollPane = new JScrollPane(hallTable);

        tablePanel.add(scrollPane, BorderLayout.CENTER);

        return tablePanel;
    }
}
