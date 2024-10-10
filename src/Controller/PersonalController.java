/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import View.UI_Dashboard;
import View.UI_Personal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.UUID;

/**
 *
 * @author Renzo
 */
public class PersonalController extends PanelController implements ActionListener{

    UI_Personal perso;
    public PersonalController(UI_Personal perso, UI_Dashboard apo) {
        super(perso, apo);
        this.perso=perso;
        this.perso.btnAutoGenerarUser.addActionListener(this);
    }

    // GENERAR USUARIO ALEATORIO
    public String autoUsuario() {
        String uuid = UUID.randomUUID().toString().substring(0, 4);
        String nombres = perso.txtNombrePE.getText().replace(" ", "");
        String apellidos = perso.txtApellidoPE.getText().replace(" ", "");
        return (nombres + '.' + apellidos + '.' + uuid).toLowerCase();
    }
    @Override
    protected void addListeners() {
    }

    @Override
    protected void reloadWindow() {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    
        if (e.getSource() == perso.btnAutoGenerarUser) {            
            perso.txtUsuarioPE.setText(autoUsuario());
        } 
    }
    
}
