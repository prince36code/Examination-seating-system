package src.ui.view;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class StudentPanel extends JPanel {

    private JTextField idField;
    private JTextField nameField;
    private JComboBox<String> courseBox;

    private JTable studentTable;
    private DefaultTableModel tableModel;

    public StudentPanel() {

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

        JLabel title = new JLabel("STUDENTS");
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
    // FORM CONTAINER (Rounded + Glow)
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
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        idField = createStyledField();
        nameField = createStyledField();

        courseBox = createStyledComboBox(new String[]{
        "CSE101",
        "MAT202",
        "PHY303"
});


        courseBox.setFont(new Font("Segoe UI", Font.PLAIN, 16));

        JButton addBtn = createStyledButton("Add");
        JButton updateBtn = createStyledButton("Update");
        JButton deleteBtn = createStyledButton("Delete");

        gbc.gridx = 0; gbc.gridy = 0;
        form.add(createLabel("Student ID:"), gbc);

        gbc.gridx = 1;
        form.add(idField, gbc);

        gbc.gridx = 0; gbc.gridy = 1;
        form.add(createLabel("Full Name:"), gbc);

        gbc.gridx = 1;
        form.add(nameField, gbc);

        gbc.gridx = 0; gbc.gridy = 2;
        form.add(createLabel("Course:"), gbc);

        gbc.gridx = 1;
        form.add(courseBox, gbc);

        gbc.gridx = 0; gbc.gridy = 3;
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
    // TABLE CONTAINER (Rounded + Glow)
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
                "Student ID",
                "Full Name",
                "Course"
        });

        studentTable = new JTable(tableModel);
        studentTable.setRowHeight(40);
        studentTable.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        studentTable.setForeground(Color.WHITE);
        studentTable.setBackground(new Color(22, 22, 30));
        studentTable.setGridColor(Color.WHITE);
        studentTable.setSelectionBackground(new Color(0, 150, 255));
        studentTable.setSelectionForeground(Color.WHITE);

        JTableHeader header = studentTable.getTableHeader();
        header.setFont(new Font("Segoe UI", Font.BOLD, 20));
        header.setForeground(new Color(0, 220, 255));
        header.setBackground(new Color(18, 18, 25));
        header.setPreferredSize(new Dimension(header.getWidth(), 50));

        JScrollPane scroll = new JScrollPane(studentTable);
        scroll.setBorder(null);
        scroll.getViewport().setBackground(new Color(22, 22, 30));

        return scroll;
    }

    // ===============================
    // REUSABLE STYLED COMPONENTS
    // ===============================
   private JTextField createStyledField() {

    JTextField field = new JTextField(15) {

        @Override
        protected void paintComponent(Graphics g) {

            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);

            int arc = 20;

            // ===== OUTER BLUE GLOW =====
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

            // ===== INNER DARK BACKGROUND =====
            g2.setColor(new Color(28, 28, 38));
            g2.fillRoundRect(
                    4,
                    4,
                    getWidth() - 8,
                    getHeight() - 8,
                    arc,
                    arc
            );

            g2.dispose();

            super.paintComponent(g);
        }
    };

    field.setOpaque(false);
    field.setForeground(Color.WHITE);
    field.setCaretColor(new Color(0, 200, 255));
    field.setFont(new Font("Segoe UI", Font.PLAIN, 16));
    field.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15));

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
   private JComboBox<String> createStyledComboBox(String[] items) {

    JComboBox<String> combo = new JComboBox<>(items) {

        @Override
        protected void paintComponent(Graphics g) {

            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);

            int arc = 20;

            // Blue glow
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

            // Dark background
            g2.setColor(new Color(22, 22, 30));
            g2.fillRoundRect(
                    4,
                    4,
                    getWidth() - 8,
                    getHeight() - 8,
                    arc,
                    arc
            );

            g2.dispose();
        }
    };

    combo.setOpaque(false);
    combo.setForeground(Color.WHITE);
    combo.setFont(new Font("Segoe UI", Font.PLAIN, 16));
    combo.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 40)); // space for arrow

    // =========================
    // CUSTOM UI (ARROW FIX)
    // =========================
    combo.setUI(new javax.swing.plaf.basic.BasicComboBoxUI() {

        @Override
        protected JButton createArrowButton() {

            JButton arrow = new JButton() {

                @Override
                protected void paintComponent(Graphics g) {

                    Graphics2D g2 = (Graphics2D) g.create();
                    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                            RenderingHints.VALUE_ANTIALIAS_ON);

                    int w = getWidth();
                    int h = getHeight();

                    // Draw white triangle arrow
                    g2.setColor(Color.WHITE);

                    int size = 6;
                    int x = w / 2;
                    int y = h / 2;

                    Polygon triangle = new Polygon();
                    triangle.addPoint(x - size, y - size / 2);
                    triangle.addPoint(x + size, y - size / 2);
                    triangle.addPoint(x, y + size);

                    g2.fill(triangle);

                    g2.dispose();
                }
            };

            arrow.setOpaque(false);
            arrow.setContentAreaFilled(false);
            arrow.setBorder(null);

            return arrow;
        }
    });

    // =========================
    // DARK POPUP STYLE
    // =========================
    combo.setRenderer(new DefaultListCellRenderer() {

        @Override
        public Component getListCellRendererComponent(
                JList<?> list,
                Object value,
                int index,
                boolean isSelected,
                boolean cellHasFocus) {

            JLabel label = (JLabel) super.getListCellRendererComponent(
                    list, value, index, isSelected, cellHasFocus);

            label.setFont(new Font("Segoe UI", Font.PLAIN, 16));
            label.setOpaque(true);

            label.setBackground(new Color(22, 22, 30));
            label.setForeground(Color.WHITE);

            if (isSelected) {
                label.setBackground(new Color(0, 140, 255));
            }

            return label;
        }
    });

    return combo;
}


}
