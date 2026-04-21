import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class NumberPronunciationGame extends JFrame implements ActionListener {

    JLabel enterLabel, pronunciationLabel;
    JTextField numberField, pronunciationField;
    JButton showButton;

    public NumberPronunciationGame() {
        setTitle("Number Pronunciation Game");
        setSize(400, 200);
        setLayout(new GridLayout(3, 2, 10, 10));

        enterLabel = new JLabel("Enter the number (1-100):");
        numberField = new JTextField();

        pronunciationLabel = new JLabel("Pronunciation:");
        pronunciationField = new JTextField();
        pronunciationField.setEditable(false);

        showButton = new JButton("Show Pronunciation");
        showButton.addActionListener(this);

        add(enterLabel);
        add(numberField);
        add(pronunciationLabel);
        add(pronunciationField);
        add(showButton);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            int num = Integer.parseInt(numberField.getText());
            pronunciationField.setText(convertToWords(num));
        } catch (Exception ex) {
            pronunciationField.setText("Invalid input");
        }
    }

    public String convertToWords(int num) {
        String[] ones = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine",
                "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen",
                "Seventeen", "Eighteen", "Nineteen"};

        String[] tens = {"", "", "Twenty", "Thirty", "Forty", "Fifty",
                "Sixty", "Seventy", "Eighty", "Ninety"};

        if (num < 1 || num > 100) {
            return "Number out of range";
        }
        if (num == 100) {
            return "One Hundred";
        }
        if (num < 20) {
            return ones[num];
        }

        return tens[num / 10] + ((num % 10 != 0) ? " " + ones[num % 10] : "");
    }

    public static void main(String[] args) {
        new NumberPronunciationGame();
    }
}