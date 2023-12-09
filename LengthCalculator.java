import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LengthCalculator {
    private JFrame frame;
    private JTextField textField1;
    private JTextField textField2;
    private JComboBox<String> unitComboBox1;
    private JComboBox<String> unitComboBox2;
    private JButton convertButton;

    public LengthCalculator() {
        frame = new JFrame("Length Calculator");
        frame.setSize(450, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JLabel inputLabel = new JLabel("Enter Length:");
        inputLabel.setBounds(20, 20, 100, 25);
        frame.add(inputLabel);
        
        
        //FIRST TEXT FIELD
        textField1 = new JTextField();
        textField1.setBounds(140, 20, 150, 25);
        frame.add(textField1);
        
        //FIRST SELCTION 
        unitComboBox1 = new JComboBox<>(new String[]{"Centimeters", "Meters", "Inches"});
        unitComboBox1.setBounds(300, 20, 120, 25);
        frame.add(unitComboBox1);

        JLabel outputLabel = new JLabel("Converted Length:");
        outputLabel.setBounds(20, 50, 300, 25);
        frame.add(outputLabel);

        textField2 = new JTextField();
        textField2.setEditable(false);
        textField2.setBounds(140, 50, 150, 25);
        frame.add(textField2);
        
        
        //2ND SELECTION
        unitComboBox2 = new JComboBox<>(new String[]{"Centimeters", "Meters", "Inches"});
        unitComboBox2.setBounds(300, 50, 120, 25);
        frame.add(unitComboBox2);

        convertButton = new JButton("Convert");
        convertButton.setBounds(120, 90, 100, 30);
        frame.add(convertButton);

        convertButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                convertLength();
            }
        });

        frame.setVisible(true);
    }

    private void convertLength() {
        try {
            double inputLength = Double.parseDouble(textField1.getText());
            String fromUnit = (String) unitComboBox1.getSelectedItem();
            String toUnit = (String) unitComboBox2.getSelectedItem();
            double convertedLength;

            // Convert to meters as an intermediate step
            double meters;

            switch (fromUnit) {
                case "Centimeters":
                    meters = inputLength / 100.0;
                    break;
                case "Meters":
                    meters = inputLength;
                    break;
                case "Inches":
                    meters = inputLength / 39.37;
                    break;
                default:
                    meters = 0;
            }

            // Convert meters to the target unit
            switch (toUnit) {
                case "Centimeters":
                    convertedLength = meters * 100.0;
                    break;
                case "Meters":
                    convertedLength = meters;
                    break;
                case "Inches":
                    convertedLength = meters * 39.37;
                    break;
                default:
                    convertedLength = 0;
            }

            textField2.setText(String.format("%.2f", convertedLength));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "Please enter a valid number!");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new LengthCalculator();
            }
        });
    }
}
