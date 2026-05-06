package com.mycompany.phonebook;


class Node {
    String name;
    String phone;
    Node next;

    Node(String name, String phone) {
        this.name = name;
        this.phone = phone;
        this.next = null;
    }
}