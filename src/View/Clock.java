/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author multi
 */
public class Clock extends JPanel {

    private Calendar calendar;
    private SimpleDateFormat timeFormat;
    private SimpleDateFormat dayFormat;
    private JLabel timeLabel;
    private JLabel imageLabel;
    private JLabel dayLabel;
    private String formatOfTime;
    private String formatOfDay;
    private String currentTime;
    private String currentDay;
    public boolean loop = true;
    private Font timeFont = new Font("calibre", Font.PLAIN, 50);
    private Font dayFont = new Font("calibre", Font.PLAIN, 30);
    private GridBagConstraints gbc = new GridBagConstraints();

    public Clock() {
        this.setLayout(new GridBagLayout());
        this.setBackground(Color.white);
        setTime();
        setDay();
    }

    private void setTime() {
        gbc.fill = GridBagConstraints.HORIZONTAL;
        formatOfTime = "hh:mm:ss a";
        timeFormat = new SimpleDateFormat(formatOfTime);
        timeLabel = new JLabel();

        timeLabel.setFont(timeFont);
        timeLabel.setForeground(Color.BLUE);
        timeLabel.setBackground(Color.BLACK);
        timeLabel.setOpaque(true);
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.gridx = 0;
        gbc.gridy = 1;
        this.add(timeLabel, gbc);

    }

    private void setDay() {

        gbc.fill = GridBagConstraints.HORIZONTAL;

        dayLabel = new JLabel();
        dayLabel.setFont(dayFont);
        dayLabel.setForeground(Color.BLACK);
        dayLabel.setBackground(Color.white);
        dayLabel.setOpaque(true);

        formatOfDay = "dd-MM-yyyy";
        dayFormat = new SimpleDateFormat(formatOfDay);

        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.gridx = 0;
        gbc.gridy = 2;

        this.add(dayLabel, gbc);
    }

    public void updateTimeAndDay() {
        while (loop) {
            //Time
            Date data = calendar.getInstance().getTime();
            currentTime = timeFormat.format(data);
            timeLabel.setText(currentTime);

            //Day
            currentDay = dayFormat.format(calendar.getInstance().getTime());
            dayLabel.setText("Current: " + currentDay);

            changeImage(isMorning(currentTime));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                JOptionPane.showMessageDialog(null, "Erro: " + ex);
            }

        }
    }

    private boolean isMorning(String time) {
        if (time.contains("da tarde")) {
            return false;
        } else {
            return true;
        }
    }

    private void changeImage(boolean currentTime) {//True -> Manha; False -> Tarde
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.gridx = 0;
        gbc.gridy = 0;
        if (currentTime) {
            ImageIcon imgSun = new ImageIcon("src/Imagens/sun.jpg");
            imageLabel = new JLabel(imgSun);
            this.add(imageLabel, gbc);

        } else {
            ImageIcon imgMoon = new ImageIcon("src/Imagens/full-moon.jpg");
            imageLabel = new JLabel(imgMoon);
            this.add(imageLabel, gbc);
        }
    }

    public boolean isLoop() {
        return loop;
    }

    public void setLoop(boolean loop) {
        this.loop = loop;
    }

}
