package com.mycompany.proyecto2ziad;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

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
        this.next = null;
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
    
    nodeLS getStart() {
        return start;
    } 
}

class queue {

    nodeQ front, rear, actual;
    
    public queue() {
        this.front = this.rear = this.actual = null;
    }


    void add(String name, String surname, int age) {
        nodeQ  newNode = new nodeQ(name, surname, age);
        if (front == null) {
            front = rear = newNode;
            actual = front;
        } else {
            rear.next = newNode;
            rear = newNode;   
        }
        rear.next = null;
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
    nodeQ cnextnull(nodeQ node) {
        if (node != null && node.next != null) {
            return node.next;
        }
        return null;
    }
    void remClient (String remArchName) throws IOException {
        PrintWriter printer = new PrintWriter(new FileWriter(remArchName));
            while (!cnull()) {
                nodeQ node = unadd();
                printer.println(node.name + "/" + node.surname + "/" + node.age);
                printer.close();
            }
}
    void priorySort(queue prioryQ, int prioryAge) {
        queue tempQ = new queue(); 
        while (this.cnull()) {
            nodeQ node = this.unadd();
            if (node.age >= prioryAge) {
                prioryQ.add(node.name, node.surname, node.age);
            } else {
                tempQ.add(node.name, node.surname, node.age);
            }
        }
        while (!tempQ.cnull()) {
            nodeQ node = tempQ.unadd();
            this.add(node.name, node.surname, node.age);
        }
    }
    void defSort(queue q0, queue q1) {
        int prioryTurn = 0;
         while (!this.cnull()) {
            nodeQ node = this.unadd();
            q1.add(node.name, node.surname, node.age);
            prioryTurn++;
            if (prioryTurn % 4 == 0 && !q0.cnull()) {
                nodeQ node1 = q1.unadd();
                q1.add(node1.name, node1.surname, node1.age);
    }
    }
    }
}


class stack {
    nodeLS top = null;

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
    void createLog() throws IOException {
        archives manageStackLog = new archives();
        while(!cnull()) {
        nodeLS node = unstack();
        manageStackLog.saveLog(node);
        }
    }
}


class archives {
        String name; 
        String surname; 
        PrintWriter printer;
        
    void saveLog(nodeLS node) throws IOException {
        String log;
        String logName = "Taquilla.log";
        SimpleDateFormat simpDate = new SimpleDateFormat("dd-MM-yyyy");
        String simpDateName = simpDate.format(new Date());
        String actDateLogName = "taquilla " + simpDateName + ".log";
        archives saver = new archives();
        File txt = new File(logName);
        log = node.name + " " + node.surname + " ha realizado " + node.transaction;
        if(!txt.exists()) {
             saver.writeLog("Taquilla.log", log);
        } else {
             saver.writeLog(actDateLogName, log);
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
