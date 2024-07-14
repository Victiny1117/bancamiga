package com.mycompany.proyecto2ziad;

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
}
