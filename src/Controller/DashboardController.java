/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import View.UI_Dashboard;
import View.UI_Home;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;

/**
 *
 * @author franc
 */
public class DashboardController {
    
    public static UI_Dashboard vista;
    UI_Home home = null;

    public DashboardController(UI_Dashboard dash) {
        this.vista = dash;
        launchApp();
    }
    
    void launchApp() {
        vista.getRootPane().putClientProperty("JRootPane.titleBarForeground", Color.WHITE);
        vista.getRootPane().putClientProperty("JRootPane.titleBarBackground", new Color(23, 180, 252));
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
        home = new UI_Home();
        ChangePanel(home);
    }
    
    public void ChangePanel(JPanel box) {
        box.setPreferredSize(new Dimension(1000, 500)); // Tamaño inicial

        vista.jpInternal.removeAll();
        vista.jpInternal.setLayout(new BorderLayout());
        vista.jpInternal.add(box, BorderLayout.CENTER);
        vista.jpInternal.revalidate();
        vista.jpInternal.repaint();
    }
    
}
