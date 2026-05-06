
package com.mycompany.phonebook;

public class PhonebookLinkedList {
     private Node head;
    private int size;

    public PhonebookLinkedList() {
        head = null;
        size = 0;
    }
        public void insert(String name, String phone) {
        Node newNode = new Node(name, phone);

        if (head == null) {
            head = newNode;
            size++;
            return;
        }

        if (name.compareToIgnoreCase(head.name) < 0) {
            newNode.next = head;
            head = newNode;
            size++;
            return;
        }

        Node current = head;

        while (current.next != null &&
               name.compareToIgnoreCase(current.next.name) > 0) {
            current = current.next;
        }

        if (current.name.equalsIgnoreCase(name) ||
            (current.next != null && current.next.name.equalsIgnoreCase(name))) {
            System.out.println("Contact already exists.");
            return;
        }

        newNode.next = current.next;
        current.next = newNode;
        size++;
    }
        public Node search(String name) {
        Node current = head;

        while (current != null) {
            if (current.name.equalsIgnoreCase(name)) {
                return current;
            }
            current = current.next;
        }

        return null;
    }
                public void update(String name, String newPhone) {
        Node found = search(name);

        if (found != null) {
            found.phone = newPhone;
            System.out.println("Updated successfully.");
        } else {
            System.out.println("Contact not found.");
        }
    }
                    public void remove(String name) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        if (head.name.equalsIgnoreCase(name)) {
            head = head.next;
            size--;
            System.out.println("Deleted.");
            return;
        }

        Node current = head;

        while (current.next != null &&
               !current.next.name.equalsIgnoreCase(name)) {
            current = current.next;
        }

        if (current.next == null) {
            System.out.println("Contact not found.");
        } else {
            current.next = current.next.next;
            size--;
            System.out.println("Deleted.");
        }
    }
        public void display() {
        if (head == null) {
            System.out.println("Phonebook is empty.");
            return;
        }

        Node current = head;

        while (current != null) {
            System.out.println(current.name + " - " + current.phone);
            current = current.next;
        }
    }
        public void filter0100() {
        Node current = head;

        while (current != null) {
            if (current.phone.startsWith("0100")) {
                System.out.println(current.name + " - " + current.phone);
            }
            current = current.next;
        }
    }
        public int size() {
        return size;
    }
}
    



