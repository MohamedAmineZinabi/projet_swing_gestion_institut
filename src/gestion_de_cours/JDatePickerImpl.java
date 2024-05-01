package gestion_de_cours;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class JDatePickerImpl extends JPanel {

    private final JComboBox<Integer> dayComboBox;
    private final JComboBox<String> monthComboBox;
    private final JComboBox<Integer> yearComboBox;

    public JDatePickerImpl() {
        setLayout(new FlowLayout());

        // Jour
        dayComboBox = new JComboBox<>();
        for (int i = 1; i <= 31; i++) {
            dayComboBox.addItem(i);
        }

        // Mois
        monthComboBox = new JComboBox<>(new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"});

        // Année (modifiable selon vos besoins)
        yearComboBox = new JComboBox<>();
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
       for (int i = currentYear - 100 ; i <= currentYear + 100 ; i++) {
            yearComboBox.addItem(i);
        }

        add(dayComboBox);
        add(monthComboBox);
        add(yearComboBox);
    }

    public String getDate() {
    	int day = (int) dayComboBox.getSelectedItem();
        int month = monthComboBox.getSelectedIndex() + 1; // Les mois sont indexés à partir de 0
        int year = (int) yearComboBox.getSelectedItem();

        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month - 1, day); // Mois -1 car Calendar utilise des mois 0-indexed

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy"); // Format de date souhaité
        String dateString = dateFormat.format(calendar.getTime());

        return dateString;
    }

    public void setDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int month = calendar.get(Calendar.MONTH);
        int year = calendar.get(Calendar.YEAR);

        dayComboBox.setSelectedItem(day);
        monthComboBox.setSelectedIndex(month);
        yearComboBox.setSelectedItem(year);
    }



}
