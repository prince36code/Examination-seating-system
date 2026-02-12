package src.ui.view;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
public class StudentPanel extends JPanel{
    private JTextField idField;
    private JTextField nameField;
    private JComboBox<String> courseBox;

    private JTable studentTable;
    private DefaultTableModel tableModel;

    public StudentPanel() {

        setLayout(new BorderLayout(20, 20));
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        add(createTitle(), BorderLayout.NORTH);
        add(createMainContent(), BorderLayout.CENTER);
    }

    // ============================
    // TITLE SECTION
    // ============================
    private JLabel createTitle() {

        JLabel title = new JLabel("STUDENTS");
        title.setFont(new Font("Segoe UI", Font.BOLD, 24));

        return title;
    }

    // ============================
    // MAIN CONTENT CONTAINER
    // ============================
    private JPanel createMainContent() {

        JPanel mainPanel = new JPanel(new BorderLayout(20, 20));

        mainPanel.add(createFormPanel(), BorderLayout.NORTH);
        mainPanel.add(createTablePanel(), BorderLayout.CENTER);

        return mainPanel;
    }

    // ============================
    // FORM PANEL
    // ============================
    private JPanel createFormPanel() {

        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBorder(BorderFactory.createTitledBorder("Add / Update Student"));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        idField = new JTextField(15);
        nameField = new JTextField(15);
        courseBox = new JComboBox<>(new String[]{
                "CSE101",
                "MAT202",
                "PHY303"
        });

        JButton addBtn = new JButton("Add");
        JButton updateBtn = new JButton("Update");
        JButton deleteBtn = new JButton("Delete");

        // Row 1 - ID
        gbc.gridx = 0;
        gbc.gridy = 0;
        formPanel.add(new JLabel("Student ID:"), gbc);

        gbc.gridx = 1;
        formPanel.add(idField, gbc);

        // Row 2 - Name
        gbc.gridx = 0;
        gbc.gridy = 1;
        formPanel.add(new JLabel("Full Name:"), gbc);

        gbc.gridx = 1;
        formPanel.add(nameField, gbc);

        // Row 3 - Course
        gbc.gridx = 0;
        gbc.gridy = 2;
        formPanel.add(new JLabel("Course:"), gbc);

        gbc.gridx = 1;
        formPanel.add(courseBox, gbc);

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

    // ============================
    // TABLE PANEL
    // ============================
    private JPanel createTablePanel() {

        JPanel tablePanel = new JPanel(new BorderLayout());
        tablePanel.setBorder(BorderFactory.createTitledBorder("Student List"));

        tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(new String[]{
                "Student ID",
                "Full Name",
                "Course"
        });

        studentTable = new JTable(tableModel);
        studentTable.setRowHeight(28);
        studentTable.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 14));

        JScrollPane scrollPane = new JScrollPane(studentTable);

        tablePanel.add(scrollPane, BorderLayout.CENTER);

        return tablePanel;
    }
}