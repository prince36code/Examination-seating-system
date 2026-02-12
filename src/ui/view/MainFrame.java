package src.ui.view;
 import javax.swing.*;
 import java.awt.*;
public class MainFrame extends JFrame{

    
    private CardLayout cardLayout;
    private JPanel contentPanel;

    public MainFrame() {

        setTitle("Exam Hall Allocation System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Make full screen
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        // ==========================
        // SIDEBAR
        // ==========================
        SidebarPanel sidebar = new SidebarPanel(this);
        add(sidebar, BorderLayout.WEST);

        // ==========================
        // CONTENT PANEL (CardLayout)
        // ==========================
        cardLayout = new CardLayout();
        contentPanel = new JPanel(cardLayout);

        // Add all section panels
        contentPanel.add(new DashboardPanel(), "Dashboard");
        contentPanel.add(new StudentPanel(), "Students");
        contentPanel.add(new SubjectPanel(), "Subjects");
        contentPanel.add(new ExamPanel(), "Exams");
        contentPanel.add(new HallPanel(), "Halls");
        contentPanel.add(new AllocationPanel(), "Allocation");
        contentPanel.add(new InvigilatorPanel(), "Invigilator");

        add(contentPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    // ==========================
    // PANEL SWITCHING METHOD
    // ==========================
    public void showPanel(String panelName) {
        cardLayout.show(contentPanel, panelName);
    }

}