import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FontChangerApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(FontChangerApp::createAndShowGUI);
    }

    private static void createAndShowGUI() {
        // Frame
        JFrame frame = new JFrame("Font Changer Web-like Page");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 500);
        frame.setLocationRelativeTo(null);

        // Main panel with BorderLayout (for web page look)
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(Color.WHITE);

        // ======= TOP BAR =======
        JPanel topBar = new JPanel(new BorderLayout());
        topBar.setBackground(new Color(230, 230, 250)); // Light lavender

        JLabel title = new JLabel("My Web Page");
        title.setFont(new Font("SansSerif", Font.BOLD, 20));
        title.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 10));
        topBar.add(title, BorderLayout.WEST);

        // Font selector (top right)
        String[] fonts = GraphicsEnvironment.getLocalGraphicsEnvironment()
                .getAvailableFontFamilyNames();
        JComboBox<String> fontBox = new JComboBox<>(fonts);
        fontBox.setSelectedItem("Serif");
        JPanel fontPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        fontPanel.setOpaque(false);
        fontPanel.add(new JLabel("Font: "));
        fontPanel.add(fontBox);
        topBar.add(fontPanel, BorderLayout.EAST);

        mainPanel.add(topBar, BorderLayout.NORTH);

        // ======= TEXT AREA =======
        JTextArea textArea = new JTextArea(
                "This is a sample text.\n" +
                "Use the font selector in the top right to change my style!"
        );
        textArea.setFont(new Font("Serif", Font.PLAIN, 18));
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        JScrollPane scrollPane = new JScrollPane(textArea);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        // Font change action
        fontBox.addActionListener(e -> {
            String selectedFont = (String) fontBox.getSelectedItem();
            textArea.setFont(new Font(selectedFont, Font.PLAIN, 18));
        });

        // Add to frame
        frame.setContentPane(mainPanel);
        frame.setVisible(true);
    }
}
