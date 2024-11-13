package Controller;

import Model.Informe;
import Persistence.saveInforme;
import Processes.ProcessInforme;
import Structures.ListasEnlazadas.*;
import View.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class InformeController extends PanelController implements ActionListener {

    UI_Informe info;
    Informe est;
    Nodo actual;
    ListaEnlazada Lista;

    public InformeController(UI_Informe info, UI_Dashboard dash) {
        super(info, dash);
        this.info = info;
        super.showWindow(info);

        Lista = saveInforme.RecuperarLista();

        ProcessInforme.MostrarInf(info, Lista);
        Lista.MostrarResumen(info.txaDatos);
        addListeners();
    }

    private void ActualizarFrame() {
        ProcessInforme.LimpiaCampos(info);
        saveInforme.GuardarLista(Lista);
        Lista = saveInforme.RecuperarLista();
        ProcessInforme.MostrarInf(info, Lista);
        Lista.MostrarResumen(info.txaDatos);
    }

    @Override
    protected void addListeners() {
        this.info.btnRegistrar.addActionListener(this);
        this.info.btnActualizar.addActionListener(this);
        this.info.btnConsultar.addActionListener(this);
        this.info.btnEliminar.addActionListener(this);
    }

    @Override
    protected void reloadWindow() {
        // Empty method as per current code structure
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == info.btnRegistrar) {
            // Validar que los campos no estén vacíos
            if (info.cbxAccionesTomadas.getSelectedIndex() == 0
                    || info.cbxEstado.getSelectedIndex() == 0
                    || info.atxtDescripcion.getText().trim().isEmpty()) {

                JOptionPane.showMessageDialog(null, "Por favor complete todos los campos",
                        "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Crear el nuevo informe
            est = ProcessInforme.LeerInforme(info);

            if (est != null) { 
                int i = Lista.getCtotal() + 1;
                Nodo nuevo = new Nodo(est);
                est.RegistroInforme(i); 

                Lista.AgregarAlFinal(nuevo);  // Agregar el nodo a la lista

                // Actualizar la interfaz
                ActualizarFrame();
                JOptionPane.showMessageDialog(null, "Informe registrado exitosamente");
            }

        }
        if (e.getSource() == info.btnConsultar) {
            // Pedir al usuario el número 'i' del informe que desea buscar
            String idBuscado = JOptionPane.showInputDialog("Ingrese el número de informe a buscar:");

            try {
                int i = Integer.parseInt(idBuscado);  
                actual = Lista.BuscarPorID(i); // Buscar el informe por su ID

                if (actual == null) {
                    // Si no se encuentra el informe, mostrar un mensaje
                    JOptionPane.showMessageDialog(null, "El número de informe no existe en la lista", "Informe no encontrado", JOptionPane.ERROR_MESSAGE);
                } else {
                    // Mostrar la información del informe en la interfaz
                    info.atxtDescripcion.setText(actual.inf.getDescripcion());

                    // Configurar el campo de acciones tomadas según el valor del informe
                    switch (actual.inf.getAccionesTomadas()) {
                        case "Actualización de Hardware":
                            info.cbxAccionesTomadas.setSelectedIndex(1);
                            break;
                        case "Actualización de Software":
                            info.cbxAccionesTomadas.setSelectedIndex(2);
                            break;
                        case "Reinicio de Sistema":
                            info.cbxAccionesTomadas.setSelectedIndex(3);
                            break;
                        case "Corrección de Configuración":
                            info.cbxAccionesTomadas.setSelectedIndex(4);
                            break;
                        case "Establecimiento de Red":
                            info.cbxAccionesTomadas.setSelectedIndex(5);
                            break;
                        case "Optimización de Rendimiento":
                            info.cbxAccionesTomadas.setSelectedIndex(6);
                            break;
                        default:
                            info.cbxAccionesTomadas.setSelectedIndex(0);  // Selección por defecto
                    }

                    // Configurar el campo de estado según el valor del informe
                    switch (actual.inf.getEstado()) {
                        case "EN PROCESO":
                            info.cbxEstado.setSelectedIndex(1);
                            break;
                        case "ATENDIDO":
                            info.cbxEstado.setSelectedIndex(2);
                            break;
                        case "DERIVADO":
                            info.cbxEstado.setSelectedIndex(3);
                            break;
                        default:
                            info.cbxEstado.setSelectedIndex(0);  // Selección por defecto
                    }
                }
            } catch (NumberFormatException ex) {
                // Si el número no es válido, mostrar un mensaje de error
                JOptionPane.showMessageDialog(null, "Por favor ingrese un número válido para el informe", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        if (e.getSource() == info.btnActualizar) {
            if (actual != null) {
                est = ProcessInforme.LeerInforme(info);
                if (est != null) {
                    actual.inf = est;  // Actualiza la información del nodo actual
                    ActualizarFrame();
                    JOptionPane.showMessageDialog(null, "Informe actualizado exitosamente");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Primero debe consultar un informe para actualizarlo",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        if (e.getSource() == info.btnEliminar) {
            if (actual != null) {
                int confirm = JOptionPane.showConfirmDialog(null, "¿Está seguro de que desea eliminar el informe?",
                        "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    Lista.EliminarNodo(actual);
                    ActualizarFrame();
                    JOptionPane.showMessageDialog(null, "Informe eliminado exitosamente");
                    actual = null;  // Reinicia la referencia al nodo actual
                }
            } else {
                JOptionPane.showMessageDialog(null, "Primero debe consultar un informe para eliminarlo",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
