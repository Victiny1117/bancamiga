package com.mycompany.proyecto2ziad;
import java.io.*;
/*
    Para el horario calcule cuantos minutos hay de 8:30 a 3:30 de la tarde
*/

public class Proyecto2ziad {
    public static void main(String[] args) throws IOException {
        queue genQueue = new queue();
        queue prioryQueue = new queue();
        list logList = new list();
        stack logStack = new stack();
        archives manageArch = new archives();
        String[] archives = {"Clientes_pendientes.in", "Clientes.in"};
            for(int i = 0; i < archives.length; i++) {
                 File arch = new File(archives[i]);
            if (arch.exists()) {
                manageArch.serviceQueue(arch, genQueue);
                if (i == 0) {
                    manageArch.deleteArch(arch);
                }
            }
            }
        System.out.println("Bienvenido a Bancamiga, ¿En que podemos ayudarle?");
        System.out.println("Tasa del dia segun el bcv: ");
        System.out.println("1 USD = xx Bs; 1 EUR = xx Bs."); /*Pon aqui el precio del dolar y el euro en bolivares */
            int limit = 0;
            int actLimit = 5;
            int action = 0;
        while(limit != 450 && !genQueue.cnull()) {
          limit = 450;  
        }
    }
    }

