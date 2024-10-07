/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import View.UI_Categorias;
import View.UI_Dashboard;
import View.UI_Home;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

/**
 *
 * @author franc
 */
public class DashboardController implements ActionListener {

    public static UI_Dashboard vista;
    UI_Home home = null;

    public DashboardController(UI_Dashboard dash) {
        this.vista = dash;
        vista.btnCaategoria.addActionListener(this);
        vista.btnDashboard.addActionListener(this);

        launchApp();
    }

    void launchApp() {
        vista.getRootPane().putClientProperty("JRootPane.titleBarForeground", Color.WHITE);
        vista.getRootPane().putClientProperty("JRootPane.titleBarBackground", new Color(153, 0, 51));
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
        home = new UI_Home();
        ChangePanel(home);
        vista.btnDashboard.setSelected(true);
    }

    public void ChangePanel(JPanel box) {
        box.setPreferredSize(new Dimension(1000, 500)); // Tamaño inicial

        vista.jpInternal.removeAll();
        vista.jpInternal.setLayout(new BorderLayout());
        vista.jpInternal.add(box, BorderLayout.CENTER);
        vista.jpInternal.revalidate();
        vista.jpInternal.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.btnDashboard) {
            ChangePanel(home);
            resetButtons();
            vista.btnDashboard.setSelected(true);
        }
        if (e.getSource() == vista.btnCaategoria) {
            UI_Categorias cat = new UI_Categorias();
            ChangePanel(cat);
            resetButtons();
            vista.btnCaategoria.setSelected(true);
        }
    }

    private void resetButtons() {
        vista.btnDashboard.setSelected(false);
        vista.btnCaategoria.setSelected(false);
    }

}
