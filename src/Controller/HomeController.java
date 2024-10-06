/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import View.UI_Dashboard;
import View.UI_Home;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author franc
 */
public class HomeController extends PanelController{
    
    UI_Home home;

    public HomeController(UI_Home panel, UI_Dashboard app) {
        super(panel, app);
        this.home = panel;
    }

    @Override
    protected void addListeners() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    protected void reloadWindow() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
}
