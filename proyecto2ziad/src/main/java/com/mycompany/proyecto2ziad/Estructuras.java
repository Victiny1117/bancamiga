package com.mycompany.proyecto2ziad;
import java.io.*;
import java.text.SimpleDateFormat;

public class Estructuras {
    /*
        Aqui se manejan las estructuras del proyecto
     */
}

class nodeQ {
    String name;
    String surname;
    int age;
    nodeQ next;
    nodeQ(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }
    }


class nodeLS {

    String name;
    String surname;
    String transaction;
    nodeLS next;

    nodeLS(String name, String surname, String transaction) {
        this.name = name;
        this.surname = surname;
        this.transaction = transaction;
    }
    @Override
    public String toString() {
      return String.format("%s %s ha realizado %s", name, surname, transaction);  
    }
}

class list {

    nodeLS start = null;

    void add(String name, String surname, String transaction) {
        nodeLS newN = new nodeLS(name, surname, transaction);
        newN.name = name;
        newN.surname = surname;
        newN.transaction = transaction;
        newN.next = null;
        if (start == null) {
            start = newN;
        } else {
            nodeLS temp = start;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newN;
        }
    }
    boolean cnull() {
        return start == null;
    }

}

class queue {

    nodeQ front, rear;

    void add(String name, String surname, int age) {
        if (front == null) {
            front = rear = new nodeQ(name, surname, age);
        } else {
            rear.next = new nodeQ(name, surname, age);
            rear = rear.next;
        }
    }


    nodeQ unadd() {
        nodeQ temp = front;
        front = front.next;
        temp.next = null;
        return temp;
    }

    boolean cnull() {
        return front == null;
    }
    void remClient (String remArchName) throws IOException {
        PrintWriter printer = new PrintWriter(new FileWriter(remArchName));
            while (!cnull()) {
                nodeQ node = unadd();
                printer.println(node.name + "/" + node.surname + "/" + node.age);
                printer.close();
            }
}
}

class stack {
    nodeLS top = null;
    PrintWriter printer;

    void stack(String name, String surname, String transaction) {
        nodeLS newN = new nodeLS(name, surname, transaction);
        newN.next = top;
        top = newN;
    }

    nodeLS unstack() {
        if (top == null) {
            return null;
        }
        nodeLS nUnstacked = top;
        top = top.next;
        return nUnstacked;
    }

    boolean cnull() {
        return top == null;
    }
    void crLog(String archName) throws IOException {
        printer = new PrintWriter(new FileWriter(archName));
        while(!cnull()) {
        nodeLS node = unstack();
        printer.println(node.toString());
        printer.close();
        }
    }
}


class archives {
        String name; 
        String surname; 
        String transaction;
        PrintWriter printer;
        
    void saveLog() throws IOException {
        String log;
        String logName = "Taquilla.log";
        SimpleDateFormat simpDate = new SimpleDateFormat("dd-mm-yyyy");
        String actDateLogName = "taquilla " + simpDate + ".log";
        archives saver = new archives();
        File txt = new File(logName);
        log = name + " " + surname + " Ha realizado " + transaction;
        if(txt.exists()) {
            saver.writeLog(actDateLogName, log);
        } else {
        saver.writeLog("Taquilla.log", log);
        }
    }
    
    void writeLog(String txtName, String log) throws IOException {
        printer = new PrintWriter(new FileWriter(txtName, true));
        printer.println(log);
        printer.close();
    }
    
    void serviceQueue(File arch, queue Queue) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(arch));
        String line;
        while ((line = br.readLine()) != null) {
                String[] customer = line.split("/");
                if (customer.length == 3) {
                    name = customer[0];
                    surname = customer[1];
                    int age = Integer.parseInt(customer[2]);
                    Queue.add(name, surname, age);
                }
        }
    }
    void deleteArch(File arch) {
        arch.delete();
    }
}
