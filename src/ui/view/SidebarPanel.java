package src.ui.view;

import java.awt.*;
import javax.swing.*;

public class SidebarPanel extends JPanel {

    private JPanel container;
    private boolean expanded = true;

    public SidebarPanel(MainFrame frame) {

        setLayout(new BorderLayout());
        setOpaque(false);
        setPreferredSize(new Dimension(320, 0)); // Wider sidebar

        // ==========================
        // MAIN CONTAINER
        // ==========================
        
container = new JPanel() {

    protected void paintComponent(Graphics g) {

        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        int arc = 30; // Smaller radius

        // ===== OUTER BLUE GLOW (Thin) =====
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

        // ===== DARK BACKGROUND =====
        g2.setColor(new Color(22, 22, 28));
        g2.fillRoundRect(
                5,
                5,
                getWidth() - 10,
                getHeight() - 10,
                arc,
                arc
        );

        g2.dispose();
    }
};

        container.setOpaque(false);
        container.setLayout(new BorderLayout());
        container.setBorder(BorderFactory.createEmptyBorder(30, 25, 30, 25));

        // ==========================
        // TOP PANEL (TITLE + HAMBURGER)
        // ==========================
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setOpaque(false);

        JLabel title = new JLabel("Exam Hall System");
        title.setForeground(Color.WHITE);
        title.setFont(new Font("SansSerif", Font.BOLD, 25));

        JButton toggleBtn = createHamburgerButton();
        toggleBtn.addActionListener(e -> toggleSidebar());

        topPanel.add(title, BorderLayout.WEST);
        topPanel.add(toggleBtn, BorderLayout.EAST);

        
        JPanel headerWrapper = new JPanel();
        headerWrapper.setOpaque(false);
        headerWrapper.setLayout(new BoxLayout(headerWrapper, BoxLayout.Y_AXIS));

        headerWrapper.add(topPanel);
        headerWrapper.add(Box.createVerticalStrut(35)); 

        container.add(headerWrapper, BorderLayout.NORTH);


        // ==========================
        // MENU PANEL
        // ==========================
        JPanel menuPanel = new JPanel();
        menuPanel.setOpaque(false);
        menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.Y_AXIS));

        String[] items = {
                "Dashboard",
                "Students",
                "Subjects",
                "Exams",
                "Halls",
                "Allocation",
                "Invigilator",
                "Logout"
        };

        for (int i = 0; i < items.length; i++) {

            String item = items[i];

            JButton btn = createWhiteGlowButton(item);

            btn.addActionListener(e -> {
                if (item.equals("Logout")) {
                    frame.dispose();
                    new src.ui.loginwindow.LoginFrame();
                } else {
                    frame.showPanel(item);
                }
            });

            menuPanel.add(btn);

            // Divider line (except last item)
            if (i != items.length - 1) {
                menuPanel.add(Box.createVerticalStrut(10));
                menuPanel.add(createDivider());
                menuPanel.add(Box.createVerticalStrut(10));
            }
        }

        container.add(menuPanel, BorderLayout.CENTER);
        add(container);
    }

    // ============================================
    // WHITE GLOW HOVER BUTTON
    // ============================================
    private JButton createWhiteGlowButton(String text) {

        JButton button = new JButton(text) {

            protected void paintComponent(Graphics g) {

                Graphics2D g2 = (Graphics2D) g;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                        RenderingHints.VALUE_ANTIALIAS_ON);
           if (getModel().isRollover()) {

    int arc = 20;

    // OUTER BLUE THIN GLOW
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

    // INNER WHITE BORDER
    g2.setColor(Color.WHITE);
    g2.setStroke(new BasicStroke(1.5f));
    g2.drawRoundRect(
            2,
            2,
            getWidth() - 4,
            getHeight() - 4,
            arc,
            arc
    );
}


                super.paintComponent(g);
            }
        };

        button.setContentAreaFilled(false);
        button.setFocusPainted(false);
        button.setForeground(Color.WHITE);
        button.setFont(new Font("SansSerif", Font.PLAIN, 20));
        button.setBorder(BorderFactory.createEmptyBorder(12, 20, 12, 20));
        button.setHorizontalAlignment(SwingConstants.LEFT);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));

        return button;
    }

    // ============================================
    // DIVIDER LINE
    // ============================================
    private JSeparator createDivider() {

        JSeparator sep = new JSeparator();
        sep.setForeground(new Color(70, 70, 70));
        sep.setMaximumSize(new Dimension(Integer.MAX_VALUE, 1));
        return sep;
    }

    // ============================================
    // HAMBURGER BUTTON
    // ============================================
    private JButton createHamburgerButton() {

        JButton btn = new JButton("☰");
        btn.setForeground(Color.WHITE);
        btn.setFont(new Font("SansSerif", Font.BOLD, 18));
        btn.setContentAreaFilled(false);
        btn.setFocusPainted(false);
        btn.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));

        return btn;
    }

    // ============================================
    // TOGGLE SIDEBAR
    // ============================================
    private void toggleSidebar() {

        if (expanded) {
            setPreferredSize(new Dimension(0, 0));
        } else {
            setPreferredSize(new Dimension(320, 0));
        }

        expanded = !expanded;
        revalidate();
        repaint();
    }
}
