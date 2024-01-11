package org.example;

class Tarea {
    private String descripcion;
    private boolean completada;

    public Tarea(String descripcion){
        this.descripcion = descripcion;
        this.completada = false;
    }

    public String getDescripcion(){
        return descripcion;
    }

    public boolean isCompletada(){
        return completada;
    }

    public void completar(){
        completada = true;
    }
}
