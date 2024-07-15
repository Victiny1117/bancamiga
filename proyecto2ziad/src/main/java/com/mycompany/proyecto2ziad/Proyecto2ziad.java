package com.mycompany.proyecto2ziad;
import java.io.*;
import java.util.Scanner;
/*
    Para el horario calcule cuantos minutos hay de 8:30 a 3:30 de la tarde
*/

public class Proyecto2ziad {
    public static void main(String[] args) throws IOException {
        queue genQueue = new queue();
        queue prioryQueue = new queue();
        queue defQueue = new queue();
        list logList = new list();
        stack logStack = new stack();
        archives manageArch = new archives();
        Scanner read = new Scanner(System.in);
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
            
            int actLimit = 0;
            double limit = 0;
            int opt = 0;
            int priority = 65;
            boolean endQ = false;
            genQueue.priorySort(prioryQueue, priority);
            genQueue.defSort(prioryQueue, defQueue);
        System.out.println("Tasa del dia segun el bcv: ");
        System.out.println("1 USD = xx Bs; 1 EUR = xx Bs."); /*Pon aqui el precio del dolar y el euro en bolivares */
        while(limit != 450 && !defQueue.cnull() && endQ != true) {
            actLimit = 0;
            System.out.println("Bienvenido a Bancamiga, " + defQueue.actual.name + " " + defQueue.actual.surname + ". Presione 1 para realizar un deposito, 2 para realizar un retiro");
            System.out.println("3 para consultar movimientos, 4 para actualizar libretas");
            System.out.println("5 para realizar un pago de servicios, 6 para cerrar sesion");
            while(actLimit != 5) {
                opt = read.nextInt();
            switch (opt) {
                case 1 -> {
                    actLimit++;
                    limit = limit + 3;
                    logList.add(defQueue.actual.name, defQueue.actual.surname, "deposito");
                    System.out.println("Deposito exitoso");
                    System.out.println("¿Desea hacer algo mas?");
                }
                case 2 -> {
                    actLimit++;
                    limit = limit + 4;
                    logList.add(defQueue.actual.name, defQueue.actual.surname, "retiro");
                    System.out.println("Retiro exitoso");
                    System.out.println("¿Desea hacer algo mas?");
                }
                case 3 -> {
                    actLimit++;
                    limit = limit + 1.5;
                    logList.add(defQueue.actual.name, defQueue.actual.surname, "consulta de movimientos");
                    System.out.println("Consulta exitosa");
                    System.out.println("¿Desea hacer algo mas?");
                }
                case 4 -> {
                    actLimit++;
                    limit = limit + 5;
                    logList.add(defQueue.actual.name, defQueue.actual.surname, "actualizacion de libretas");
                    System.out.println("Actualizacion de libretas exitosa");
                    System.out.println("¿Desea hacer algo mas?");
                }
                case 5 -> {
                    actLimit++;
                    limit = limit + 2;
                    logList.add(defQueue.actual.name, defQueue.actual.surname, "pago de servicios");
                    System.out.println("Pago de servicios exitoso");
                    System.out.println("¿Desea hacer algo mas?");
                }
                case 6 -> {
                    actLimit = 5;
                    logList.add(defQueue.actual.name, defQueue.actual.surname, "cierre de sesion");
                    System.out.println("Esperamos verlo pronto.");
                }
                    
            }
        }
            if (defQueue.rear == defQueue.actual) {
                endQ = true;
            } else {
         nodeQ nodeTemp = defQueue.cnextnull(defQueue.actual);
         if (nodeTemp != null) {
             defQueue.actual = nodeTemp;
             
         } 
    }
    }
        nodeLS tempLog = logList.getStart();
        while (tempLog != null && !logList.cnull()) {
            logStack.stack(tempLog.name, tempLog. surname, tempLog.transaction);
            tempLog = tempLog.next;
        }
        logStack.createLog();
        if (!defQueue.cnull()) {
            defQueue.remClient("Clientes_pendientes.in");
        }
        }
    }
