package com.aluracursos.conversor;

public class Principal {

    public static void main(String[] args) {
        try {
            ConversorMenu conversor = new ConversorMenu();
            conversor.iniciar();
        } catch (Exception e) {
            System.err.println("Error fatal al iniciar el conversor: " + e.getMessage());
            e.printStackTrace();
        }
    }
}