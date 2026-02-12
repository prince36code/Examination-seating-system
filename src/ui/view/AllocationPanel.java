package src.ui.view;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class AllocationPanel extends JPanel {

    private JComboBox<String> examBox;
    private JTable allocationTable;
    private DefaultTableModel tableModel;

    public AllocationPanel() {

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

        JLabel title = new JLabel("ALLOCATION");
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

        main.add(createControlPanel(), BorderLayout.NORTH);
        main.add(createTableContainer(), BorderLayout.CENTER);

        return main;
    }

    // ===============================
    // CONTROL PANEL
    // ===============================
    private JPanel createControlPanel() {

        JPanel control = new JPanel();
        control.setOpaque(false);
        control.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 10));

        JLabel label = new JLabel("Select Exam:");
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Segoe UI", Font.BOLD, 18));

        examBox = new JComboBox<>(new String[]{
                "Exam 1 - Data Structures",
                "Exam 2 - Calculus",
                "Exam 3 - Physics"
        });

        examBox.setFont(new Font("Segoe UI", Font.PLAIN, 16));

        JButton runBtn = new JButton("Run Allocation");
        JButton clearBtn = new JButton("Clear");

        styleButton(runBtn);
        styleButton(clearBtn);

        runBtn.addActionListener(e -> runDummyAllocation());
        clearBtn.addActionListener(e -> tableModel.setRowCount(0));

        control.add(label);
        control.add(examBox);
        control.add(runBtn);
        control.add(clearBtn);

        return control;
    }

    // ===============================
    // TABLE CONTAINER (ROUNDED + GLOW)
    // ===============================
    private JPanel createTableContainer() {

        JPanel container = new JPanel() {

            protected void paintComponent(Graphics g) {

                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                        RenderingHints.VALUE_ANTIALIAS_ON);

                int arc = 30;

                // Outer blue glow
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

                // Dark background
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

        container.setOpaque(false);
        container.setLayout(new BorderLayout());
        container.setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));

        container.add(createTable(), BorderLayout.CENTER);

        return container;
    }

    // ===============================
    // TABLE DESIGN
    // ===============================
    private JScrollPane createTable() {

        tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(new String[]{
                "Hall",
                "Subject",
                "Students Assigned",
                "Capacity"
        });

        allocationTable = new JTable(tableModel);
        allocationTable.setRowHeight(42);
        allocationTable.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        allocationTable.setForeground(Color.WHITE);
        allocationTable.setBackground(new Color(22, 22, 30));
        allocationTable.setGridColor(Color.WHITE);
        allocationTable.setSelectionBackground(new Color(0, 150, 255));
        allocationTable.setSelectionForeground(Color.WHITE);
        allocationTable.setShowVerticalLines(true);
        allocationTable.setShowHorizontalLines(true);

        JTableHeader header = allocationTable.getTableHeader();
        header.setFont(new Font("Segoe UI", Font.BOLD, 20));
        header.setForeground(new Color(0, 220, 255));
        header.setBackground(new Color(18, 18, 25));
        header.setReorderingAllowed(false);
        header.setPreferredSize(new Dimension(header.getWidth(), 50));

        JScrollPane scroll = new JScrollPane(allocationTable);
        scroll.setBorder(null);
        scroll.getViewport().setBackground(new Color(22, 22, 30));

        return scroll;
    }

    // ===============================
    // BUTTON STYLE
    // ===============================
    private void styleButton(JButton btn) {

        btn.setFont(new Font("Segoe UI", Font.BOLD, 16));
        btn.setForeground(Color.WHITE);
        btn.setBackground(new Color(0, 140, 255));
        btn.setFocusPainted(false);
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    // ===============================
    // DUMMY DATA
    // ===============================
    private void runDummyAllocation() {

        tableModel.setRowCount(0);

        tableModel.addRow(new Object[]{"Hall A", "CSE101", 120, 150});
        tableModel.addRow(new Object[]{"Hall B", "MAT202", 80, 100});
        tableModel.addRow(new Object[]{"Hall C", "PHY303", 60, 80});
    }
}
