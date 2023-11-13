import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class SimpleCalculator extends JFrame {
    private JTextField firstNumberField, secondNumberField, resultField;
    private JButton addButton, subtractButton, multiplyButton, divideButton;
    public SimpleCalculator() {
        setTitle("SimpleCalculator");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 2));
        Font labelFont = new Font("Arial", Font.PLAIN, 16);
        Font buttonFont = new Font("Arial", Font.BOLD, 16);
        firstNumberField = new JTextField(10);
        secondNumberField = new JTextField(10);
        resultField = new JTextField(10);
        resultField.setEditable(false);
        firstNumberField.setFont(labelFont);
        secondNumberField.setFont(labelFont);
        resultField.setFont(labelFont);
        addButton = createStyledButton("Add", buttonFont);
        subtractButton = createStyledButton("Subtract", buttonFont);
        multiplyButton = createStyledButton("Multiply", buttonFont);
        divideButton = createStyledButton("Divide", buttonFont);
        addButton.addActionListener(e -> performOperation("+"));
        subtractButton.addActionListener(e -> performOperation("-"));
        multiplyButton.addActionListener(e -> performOperation("*"));
        divideButton.addActionListener(e -> performOperation("/"));
        add(new JLabel("First Number:"));
        add(firstNumberField);
        add(new JLabel("Second Number:"));
        add(secondNumberField);
        add(new JLabel("Result:"));
        add(resultField);
        add(addButton);
        add(subtractButton);
        add(multiplyButton);
        add(divideButton);
    }
    private JButton createStyledButton(String label, Font font) {
        JButton button = new JButton(label);
        button.setFont(font);
        button.setBackground(new Color(120, 190, 255));
        button.setFocusPainted(false);
        return button;
    }
    private void performOperation(String operator) {
        try {
            double num1 = Double.parseDouble(firstNumberField.getText());
            double num2 = Double.parseDouble(secondNumberField.getText());
            double result = 0.0;
            switch (operator) {
                case "+":
                    result = num1 + num2;
                    break;
                case "-":
                    result = num1 - num2;
                    break;
                case "*":
                    result = num1 * num2;
                    break;
                case "/":
                    if (num2 != 0) {
                        result = num1 / num2;
                    } else {
                        JOptionPane.showMessageDialog(this, "Cannot divide by zero.");
                        return;
                    }
                    break;
            }
            resultField.setText(Double.toString(result));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid input. Please enter valid numbers.");}}
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SimpleCalculator calculator = new SimpleCalculator();
            calculator.setVisible(true);
            calculator.setLocationRelativeTo(null);});
}
}