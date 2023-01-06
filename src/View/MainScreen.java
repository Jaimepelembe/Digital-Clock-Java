/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author multi
 */


public class MainScreen {
    private JFrame window;
    private int windowsWidth = 700;
    private int windowsHeight = 650;
    private JPanel mainPanel;
    private JPanel buttonPanel;
    private JPanel currentPanel;
    private Clock clock;
    private StopWatch stopWatch;

    public MainScreen() {
    initComponents();
    createWindow();   
    }
    
    private void initComponents(){
    clock = new Clock();
    stopWatch= new StopWatch();
    mainPanel= new JPanel(new BorderLayout());
    currentPanel = new JPanel(new BorderLayout());
    buttonPanel=new JPanel(new GridBagLayout());
    }
    private void createWindow() {
       window = new JFrame();
       window.setSize(windowsWidth, windowsHeight);
        window.setTitle("Digital Clock by James");
        window.setLocationRelativeTo(null);
        ImageIcon image = new ImageIcon("");
        window.setIconImage(image.getImage());
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //window.setResizable(true);
        window.setBackground(Color.white);
        //window.add(mainPanel());
        window.add(clock);
        //window.add(stopWatch);
       //window.pack();
        window.setVisible(true);
       clock.updateTimeAndDay();
    }
    
    private void addClock(){
        removeFromCurrentPanel();
        currentPanel.add(clock);
    }
    
    private void addStopWatch(){
        removeFromCurrentPanel();
        currentPanel.add(stopWatch);
    }
    
    private JPanel mainPanel(){
   mainPanel.add(currentPanel,BorderLayout.CENTER);
    
    
    return mainPanel;}
    private void removeFromCurrentPanel(){
    currentPanel.removeAll();
    }
    
    public static void main(String[] args) {
        new MainScreen();
    }
 
    
}
