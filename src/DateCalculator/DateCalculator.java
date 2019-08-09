package DateCalculator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;

public class DateCalculator extends JFrame implements ActionListener {
    JLabel label1 = new JLabel("Wpisz datę urodzenia: (yyyy-mm-dd)");
    JTextField dateOfBirth = new JTextField( 10);
    JButton button1 = new JButton("Oblicz");
    JLabel label2 = new JLabel("Masz");
    JTextField totalYears = new JTextField(10);
    JLabel label3 = new JLabel("lat.");
    JLabel label4 = new JLabel("Sprawdź ile masz dni!");
    JButton button2 = new JButton("Oblicz");
    JLabel label5 = new JLabel("Masz");
    JTextField totalDays = new JTextField(10);
    JLabel label6 = new JLabel("dni.");

    public DateCalculator() {
        super("Kalkulator lat i dni");
        setBounds(500, 200, 300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        panel.add(label1);
        button1.addActionListener(this);
        panel.add(dateOfBirth);

        panel.add(Box.createHorizontalStrut(300));
        panel.add(button1);
        panel.add(Box.createHorizontalStrut(200));
        panel.add(label2);
        panel.add(totalYears);
        totalYears.setEditable(false);
        panel.add(label3);
        panel.add(Box.createHorizontalStrut(250));
        panel.add(Box.createVerticalStrut(20));
        panel.add(label4);
        panel.add(Box.createHorizontalStrut(300));
        button2.addActionListener(this);
        panel.add(button2);
        panel.add(Box.createHorizontalStrut(200));
        panel.add(label5);
        panel.add(totalDays);
        totalDays.setEditable(false);
        panel.add(label6);
        add(panel);
        setVisible(true);
    }


    public void actionPerformed(ActionEvent event) {
        try {
            Object source = event.getSource();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate dob = LocalDate.parse(dateOfBirth.getText(), formatter);
            Period p = Period.between(dob, LocalDate.now());

            if (source == button1) {
                totalYears.setText(Integer.toString(p.getYears()));
            }
            if (source == button2) {
                long days = ChronoUnit.DAYS.between(dob, LocalDate.now());
                totalDays.setText(Long.toString(days));
            }
        } catch (DateTimeParseException dtpe) {
            JOptionPane.showMessageDialog(null, "Błędny format daty. Wpisz jeszcze raz poprawnie.");


        }
    }




}
