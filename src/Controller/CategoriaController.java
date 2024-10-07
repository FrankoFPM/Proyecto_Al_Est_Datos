/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import View.UI_Categorias;
import View.UI_Dashboard;

/**
 *
 * @author franc
 */
public class CategoriaController extends PanelController{
    
    UI_Categorias categoriaui;

    public CategoriaController(UI_Categorias cat, UI_Dashboard dash) {
        super(cat, dash);
        this.categoriaui = cat;
    }
    
    

    @Override
    protected void addListeners() {
    }

    @Override
    protected void reloadWindow() {
    }
    
}
