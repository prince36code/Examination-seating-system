package src.ui.view;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
public class AllocationPanel extends JPanel {
    
     private JComboBox<String> examBox;
    private JTable allocationTable;
    private DefaultTableModel tableModel;

    public AllocationPanel() {

        setLayout(new BorderLayout(20, 20));
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        add(createTitle(), BorderLayout.NORTH);
        add(createMainContent(), BorderLayout.CENTER);
    }

    // ===============================
    // TITLE
    // ===============================
    private JLabel createTitle() {

        JLabel title = new JLabel("ALLOCATION");
        title.setFont(new Font("Segoe UI", Font.BOLD, 26));

        return title;
    }

    // ===============================
    // MAIN CONTENT
    // ===============================
    private JPanel createMainContent() {

        JPanel mainPanel = new JPanel(new BorderLayout(20, 20));

        mainPanel.add(createControlPanel(), BorderLayout.NORTH);
        mainPanel.add(createResultPanel(), BorderLayout.CENTER);

        return mainPanel;
    }

    // ===============================
    // CONTROL PANEL
    // ===============================
    private JPanel createControlPanel() {

        JPanel controlPanel = new JPanel(new GridBagLayout());
        controlPanel.setBorder(BorderFactory.createTitledBorder("Allocation Controls"));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        examBox = new JComboBox<>(new String[]{
                "Exam 1 - Data Structures",
                "Exam 2 - Calculus",
                "Exam 3 - Physics"
        });

        JButton runBtn = new JButton("Run Allocation");
        JButton clearBtn = new JButton("Clear Results");

        // Row 1 - Exam Dropdown
        gbc.gridx = 0;
        gbc.gridy = 0;
        controlPanel.add(new JLabel("Select Exam:"), gbc);

        gbc.gridx = 1;
        controlPanel.add(examBox, gbc);

        // Row 2 - Buttons
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(runBtn);
        buttonPanel.add(clearBtn);

        controlPanel.add(buttonPanel, gbc);

        // Button Actions (UI level only)
        runBtn.addActionListener(e -> runDummyAllocation());
        clearBtn.addActionListener(e -> clearResults());

        return controlPanel;
    }

    // ===============================
    // RESULT PANEL
    // ===============================
    private JPanel createResultPanel() {

        JPanel resultPanel = new JPanel(new BorderLayout());
        resultPanel.setBorder(BorderFactory.createTitledBorder("Allocation Results"));

        tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(new String[]{
                "Hall",
                "Subject",
                "Students Assigned",
                "Capacity"
        });

        allocationTable = new JTable(tableModel);
        allocationTable.setRowHeight(28);

        JScrollPane scrollPane = new JScrollPane(allocationTable);

        resultPanel.add(scrollPane, BorderLayout.CENTER);

        return resultPanel;
    }

    // ===============================
    // TEMPORARY DUMMY LOGIC (UI ONLY)
    // ===============================
    private void runDummyAllocation() {

        tableModel.setRowCount(0);

        tableModel.addRow(new Object[]{"Hall A", "CSE101", 120, 150});
        tableModel.addRow(new Object[]{"Hall B", "MAT202", 80, 100});
        tableModel.addRow(new Object[]{"Hall C", "PHY303", 60, 80});
    }

    private void clearResults() {
        tableModel.setRowCount(0);
    }
}
