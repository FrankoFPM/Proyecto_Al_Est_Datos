/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import View.UI_Dashboard;
import java.awt.Color;

/**
 *
 * @author franc
 */
public class DashboardController {
    
    public static UI_Dashboard vista;

    public DashboardController(UI_Dashboard dash) {
        this.vista = dash;
        launchApp();
    }
    
    void launchApp() {
        vista.getRootPane().putClientProperty("JRootPane.titleBarForeground", Color.WHITE);
        vista.getRootPane().putClientProperty("JRootPane.titleBarBackground", new Color(23, 180, 252));
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
    }
    
}
