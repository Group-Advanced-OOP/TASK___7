import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.toedter.calendar.JDateChooser;

public class EmployeeRegistrationSystem extends JFrame {

    private JTextField fullNameField;
    private JTextField emailField;
    private JPasswordField passwordField;
    private JComboBox<String> departmentCombo;
    private JDateChooser dobChooser;
    private JTree orgTree;

    public EmployeeRegistrationSystem() {
        super("Employee Registration System");
        initComponents();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // corrected
        pack();
        setLocationRelativeTo(null);
    }

    private void initComponents() {
        JPanel mainPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(6, 6, 6, 6);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0;
        gbc.gridy = 0;
        mainPanel.add(new JLabel("Full Name:"), gbc);
        fullNameField = new JTextField(20);
        gbc.gridx = 1;
        mainPanel.add(fullNameField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        mainPanel.add(new JLabel("Email Address:"), gbc);
        emailField = new JTextField(20);
        gbc.gridx = 1;
        mainPanel.add(emailField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        mainPanel.add(new JLabel("Password:"), gbc);
        passwordField = new JPasswordField(20);
        gbc.gridx = 1;
        mainPanel.add(passwordField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        mainPanel.add(new JLabel("Department:"), gbc);
        departmentCombo = new JComboBox<>(new String[]{"-- Select --", "IT", "Finance", "HR", "Marketing"});
        gbc.gridx = 1;
        mainPanel.add(departmentCombo, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        mainPanel.add(new JLabel("Date of Birth:"), gbc);
        dobChooser = new JDateChooser();
        dobChooser.setDateFormatString("yyyy-MM-dd");
        dobChooser.setPreferredSize(new Dimension(200, dobChooser.getPreferredSize().height));
        gbc.gridx = 1;
        mainPanel.add(dobChooser, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;
        mainPanel.add(new JLabel("Organization Structure:"), gbc);

        orgTree = new JTree(createOrgTree());
        JScrollPane treeScroll = new JScrollPane(orgTree);
        treeScroll.setPreferredSize(new Dimension(350, 150));
        gbc.gridy++;
        mainPanel.add(treeScroll, gbc);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton submitBtn = new JButton("Submit");
        JButton clearBtn = new JButton("Clear");
        buttonPanel.add(clearBtn);
        buttonPanel.add(submitBtn);
        gbc.gridy++;
        mainPanel.add(buttonPanel, gbc);

        submitBtn.addActionListener(this::handleSubmit);
        clearBtn.addActionListener(e -> clearForm());

        getContentPane().add(mainPanel, BorderLayout.CENTER);
    }

    private DefaultMutableTreeNode createOrgTree() {
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Company");

        DefaultMutableTreeNode itDept = new DefaultMutableTreeNode("IT");
        itDept.add(new DefaultMutableTreeNode("Platform Team"));
        itDept.add(new DefaultMutableTreeNode("Web Team"));
        itDept.add(new DefaultMutableTreeNode("Support"));

        DefaultMutableTreeNode financeDept = new DefaultMutableTreeNode("Finance");
        financeDept.add(new DefaultMutableTreeNode("Accounts Payable"));
        financeDept.add(new DefaultMutableTreeNode("Accounts Receivable"));

        DefaultMutableTreeNode hrDept = new DefaultMutableTreeNode("HR");
        hrDept.add(new DefaultMutableTreeNode("Recruitment"));
        hrDept.add(new DefaultMutableTreeNode("Employee Relations"));

        DefaultMutableTreeNode marketingDept = new DefaultMutableTreeNode("Marketing");
        marketingDept.add(new DefaultMutableTreeNode("Content"));
        marketingDept.add(new DefaultMutableTreeNode("SEO"));

        root.add(itDept);
        root.add(financeDept);
        root.add(hrDept);
        root.add(marketingDept);

        return root;
    }
