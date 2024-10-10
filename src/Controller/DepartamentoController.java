/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import View.UI_Dashboard;
import View.UI_Categorias;

/**
 *
 * @author Renzo
 */
public class DepartamentoController extends PanelController{
    UI_Categorias categoria; 
    
    public DepartamentoController(UI_Categorias cate, UI_Dashboard api){
        super(cate,api);
        this.categoria= cate;
    }

    @Override
    protected void addListeners() {
    }

    @Override
    protected void reloadWindow() {
    }
    
}
