package org.example;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MainApp extends Tarea{
    private static ArrayList<Tarea> listaTareas = new ArrayList<>();

    private static DefaultListModel<String> model = new DefaultListModel<>();
    private static JList<String> tareaList = new JList<>();

    public MainApp(String descripcion) {
        super(descripcion);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Aplicacion de Tareas");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600,500);

        JPanel panel = new JPanel(new BorderLayout());
        JButton agregarButton = new JButton("Agregar Tarea");
        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarTarea();
            }
        });

        JButton completarButton = new JButton("Marcar como completada");
        completarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                marcarComoCompletada();
            }
        });
        panel.add(agregarButton, BorderLayout.NORTH);
        panel.add(new JScrollPane(tareaList), BorderLayout.CENTER);
        panel.add(completarButton, BorderLayout.SOUTH);

        frame.add(panel);
        frame.setVisible(true);
        JOptionPane.showInputDialog("Presiona Enter para salir.");
        System.exit(0);
    }

    private static void marcarComoCompletada() {
        int selectedIndex = tareaList.getSelectedIndex();
        if(selectedIndex !=-1){
            Tarea tarea = listaTareas.get(selectedIndex);
            tarea.completar();
            actualizarLista();
        }
    }

    private static void agregarTarea() {
        String descripcion = JOptionPane.showInputDialog("Ingrese la descripcion de la tarea:");
        if(descripcion != null && !descripcion.isEmpty()){
            Tarea nuevaTarea = new Tarea(descripcion);
            listaTareas.add(nuevaTarea);
            actualizarLista();
        }
    }

    private static void actualizarLista() {
        model.clear();
        for(Tarea tarea : listaTareas){
            model.addElement(tarea.getDescripcion() + " - "+ (tarea.isCompletada() ? "Completada" : "Pendiente"));
        }
    }
}
