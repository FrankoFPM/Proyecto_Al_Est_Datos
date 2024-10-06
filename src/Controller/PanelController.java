package Controller;

import View.UI_Dashboard;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JPanel;

public abstract class PanelController {

    JPanel panel;
    UI_Dashboard app;

    public PanelController(JPanel panel, UI_Dashboard app) {
        this.panel = panel;
        this.app = app;
        showWindow(panel);
    }

    void showWindow(JPanel panel) {
        panel.setPreferredSize(new Dimension(1000, 500)); // Tamaño inicial
        app.jpInternal.removeAll();
        app.jpInternal.setLayout(new BorderLayout());
        app.jpInternal.add(panel, BorderLayout.CENTER);
        app.jpInternal.revalidate();
        app.jpInternal.repaint();
    }

    protected abstract void addListeners();
    protected abstract void reloadWindow();
}
