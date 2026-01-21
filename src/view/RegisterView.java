package view;

import javax.swing.*;
import java.awt.*;

public class RegisterView extends JFrame {
    private JPanel panelMain, panelLeft;
    private JLabel usernameLabel, mobileLabel, genderLabel, dobLabel, addressLabel, successLabel;
    private JTextField usernameField, mobileField, dobField;
    private JTextArea addressArea, outputArea;
    private JButton submitButton, clearButton;
    private JRadioButton maleRadio, femaleRadio;
    private JComboBox<Integer> dateCombo, yearCombo;
    private JComboBox<String> monthCombo;
    private JCheckBox termsCheckBox;
    JButton resetButton;

    String[] months= {"Jan", "Feb", "Mar", "Apr", "May", "Jun",
            "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};


    public RegisterView() {
        setTitle("Register");

        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setBackground(Color.LIGHT_GRAY);

        InitUI();

    }
    public String getUsername() {
        return usernameField.getText();
    }

    public String getMobile() {
        return mobileField.getText();
    }

    public JTextField getMobileField() {
        return mobileField;
    }

    public String getGender() {
        if (maleRadio.isSelected()) return "Male";
        if (femaleRadio.isSelected()) return "Female";
        return "";
    }

    public String getDOB() {
        return dateCombo.getSelectedItem() + "-" +
                monthCombo.getSelectedItem() + "-" +
                yearCombo.getSelectedItem();
    }

    public String getAddress() {
        return addressArea.getText();
    }

    public boolean isTermsAccepted() {
        return termsCheckBox.isSelected();
    }

    public JButton getSubmitButton() {
        return submitButton;
    }

    public JButton getResetButton() {
        return resetButton;
    }

    public JTextField getUsernameField() {
        return usernameField;
    }

    public JTextArea getAddressArea() {
        return addressArea;
    }

    public JRadioButton getMaleRadio() {
        return maleRadio;
    }

    public JRadioButton getFemaleRadio() {
        return femaleRadio;
    }

    public JComboBox<Integer> getDateCombo() {
        return dateCombo;
    }

    public JComboBox<Integer> getYearCombo() {
        return yearCombo;
    }

    public JComboBox<String> getMonthCombo() {
        return monthCombo;
    }

    public JCheckBox getTermsCheckBox() {
        return termsCheckBox;
    }

    public void showOutput(String text) {
        outputArea.setText(text);
    }

    public void showMessage(String msg) {
        JOptionPane.showMessageDialog(this, msg);
    }
    public void clearForm() {
        usernameField.setText("");
        mobileField.setText("");
        addressArea.setText("");
        maleRadio.setSelected(false);
        femaleRadio.setSelected(false);
        dateCombo.setSelectedIndex(0);
        monthCombo.setSelectedIndex(0);
        yearCombo.setSelectedIndex(0);
        termsCheckBox.setSelected(false);
        outputArea.setText("");
    }

    private void InitUI() {
        panelMain = new JPanel();
        panelMain.setLayout(new GridLayout(1,2,20,0));

        JLabel titleLabel = new JLabel("Registration Form",JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));

        add(titleLabel, BorderLayout.NORTH);
        this.add(panelMain, BorderLayout.CENTER);

        panelLeft = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.WEST;

// Username
        gbc.gridx = 0;
        gbc.gridy = 0;
        panelLeft.add(new JLabel("Username:"), gbc);

        gbc.gridx = 1;
//        gbc.fill = GridBagConstraints.HORIZONTAL;
//        gbc.weightx = 1.0;
        usernameField = new JTextField(15);
        panelLeft.add(usernameField, gbc);


// Mobile
        gbc.gridx = 0;
        gbc.gridy = 1;
//        gbc.weightx = 0;
//        gbc.fill = GridBagConstraints.NONE;
        panelLeft.add(new JLabel("Mobile Number:"), gbc);

        gbc.gridx = 1;
//        gbc.fill = GridBagConstraints.HORIZONTAL;
//        gbc.weightx = 1.0;
        mobileField = new JTextField(15);
        panelLeft.add(mobileField, gbc);

        this.add(panelLeft, BorderLayout.WEST);

        // Gender
        gbc.gridx = 0; gbc.gridy++;
        panelLeft.add(new JLabel("Gender"), gbc);

        gbc.gridx = 1;
        maleRadio = new JRadioButton("Male");
        femaleRadio = new JRadioButton("Female");
        ButtonGroup bg = new ButtonGroup();
        bg.add(maleRadio);
        bg.add(femaleRadio);

        JPanel genderPanel = new JPanel();
        genderPanel.add(maleRadio);
        genderPanel.add(femaleRadio);
        panelLeft.add(genderPanel, gbc);

        // DOB
        gbc.gridx = 0; gbc.gridy++;
        panelLeft.add(new JLabel("DOB"), gbc);

        gbc.gridx = 1;
        dateCombo = new JComboBox<>();
        monthCombo = new JComboBox<>();
        yearCombo = new JComboBox<>();
        for (int i = 1; i <= 31; i++) dateCombo.addItem(i);

        for(String month : months){
            monthCombo.addItem(month);
        }



        for (int i = 1990; i <= 2026; i++) yearCombo.addItem(i);

        JPanel dobPanel = new JPanel();
        dobPanel.add(dateCombo);
        dobPanel.add(monthCombo);
        dobPanel.add(yearCombo);
        panelLeft.add(dobPanel, gbc);

        // Address
        gbc.gridx = 0; gbc.gridy++;
        panelLeft.add(new JLabel("Address"), gbc);

        gbc.gridx = 1;
        addressArea = new JTextArea(4, 15);
        panelLeft.add(new JScrollPane(addressArea), gbc);

        // Terms
        gbc.gridx = 1; gbc.gridy++;
        termsCheckBox = new JCheckBox("Accept Terms And Conditions");
        panelLeft.add(termsCheckBox, gbc);

        // Buttons
        gbc.gridx = 1; gbc.gridy++;



        JPanel btnPanel = new JPanel();
        submitButton = new JButton("Submit");
        btnPanel.add(submitButton);

        resetButton = new JButton("Reset");
        btnPanel.add(resetButton);

        panelLeft.add(btnPanel, gbc);

        // Success Label
        gbc.gridy++;
        successLabel = new JLabel("");
        successLabel.setForeground(Color.BLUE);
        panelLeft.add(successLabel, gbc);


        // Output Area
        outputArea = new JTextArea();
        panelMain.add(new JScrollPane(outputArea));





    }


}
//new branchv2 changes