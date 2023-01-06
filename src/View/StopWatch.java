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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;

/**
 *
 * @author multi
 */
public class StopWatch extends JPanel implements ActionListener {

    private GridBagConstraints gbc = new GridBagConstraints();
    private JButton startButton;
    private JButton resetButton;
    private JLabel timeLabel;
    private int seconds = 0;
    private int minutes = 0;
    private int hours = 0;
    private int elapsedTime = 0;
    private boolean started = false;
    private String seconds_String;
    private String minutes_String;
    private String hours_String;
    private Font labelFont = new Font("calibre", Font.PLAIN, 35);
    private Font buttonFont = new Font("calibre", Font.PLAIN, 20);
    private Timer timer;

    public StopWatch() {
        this.setLayout(new GridBagLayout());
        this.setBackground(Color.white);
        initComponents();
        addComponents();
    }

    private void initComponents() {
        startButton = new JButton();
        startButton.setIcon(new ImageIcon("src/Imagens/play.jpg"));
        startButton.setBackground(Color.white);
        startButton.setBorderPainted(false);
        startButton.setFocusable(false);
        startButton.setToolTipText("Start");
        startButton.addActionListener(this);

        resetButton = new JButton();
        resetButton.setIcon(new ImageIcon("src/Imagens/history gray.jpg"));
        resetButton.setBackground(Color.white);
        resetButton.setBorderPainted(false);
        resetButton.setFocusable(false);
        resetButton.addActionListener(this);
        resetButton.setToolTipText("Reset");

        seconds_String = String.format("%02d", seconds);
        minutes_String = String.format("%02d", minutes);
        hours_String = String.format("%02d", hours);

        timeLabel = new JLabel(hours_String + ":" + minutes_String + ":" + seconds_String);
        timeLabel.setFont(labelFont);
        timeLabel.setBorder(BorderFactory.createBevelBorder(1));
        timeLabel.setOpaque(true);
        timeLabel.setHorizontalAlignment(JTextField.CENTER);
        timeLabel.setBackground(Color.LIGHT_GRAY);

        timer = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateTime();

            }
        });

    }

    private void addComponents() {
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.gridwidth = 2;
        gbc.ipadx = 100;
        gbc.gridx = 0;
        gbc.gridy = 0;
        this.add(timeLabel, gbc);

        gbc.gridwidth = 1;
        gbc.ipadx = 0;
        gbc.gridx = 0;
        gbc.gridy = 1;
        this.add(startButton, gbc);

        gbc.gridwidth = 1;
        gbc.ipadx = 20;
        gbc.weightx = 0;
        gbc.gridx = 1;
        gbc.gridy = 1;
        this.add(resetButton, gbc);

    }

    private void updateTime() {
        elapsedTime = elapsedTime + 1000;
        hours = (elapsedTime / 3600000);
        minutes = (elapsedTime / 60000) % 60;
        seconds = (elapsedTime / 1000) % 60;

        seconds_String = String.format("%02d", seconds);
        minutes_String = String.format("%02d", minutes);
        hours_String = String.format("%02d", hours);
        timeLabel.setText(hours_String + ":" + minutes_String + ":" + seconds_String);
    }

    private void Start() {
        timer.start();
        started = true;
        startButton.setIcon(new ImageIcon("src/Imagens/pause-button.jpg"));
        startButton.setToolTipText("Stop");
    }

    private void Stop() {
        timer.stop();
        started = false;
        startButton.setIcon(new ImageIcon("src/Imagens/play.jpg"));
        startButton.setToolTipText("Start");
    }

    private void Reset() {
        timer.stop();
        this.elapsedTime = 0;
        this.seconds = 0;
        this.minutes = 0;
        this.hours = 0;

        seconds_String = String.format("%02d", seconds);
        minutes_String = String.format("%02d", minutes);
        hours_String = String.format("%02d", hours);
        timeLabel.setText(hours_String + ":" + minutes_String + ":" + seconds_String);

        started = false;
        startButton.setIcon(new ImageIcon("src/Imagens/play.jpg"));
        startButton.setToolTipText("Start");

       
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == startButton) {

            if (started == false) {
                Start();

            } else {
                Stop();

            }

        }
        if (e.getSource() == resetButton) {
            if (started) {
                Reset();
            }
        }

    }

}
