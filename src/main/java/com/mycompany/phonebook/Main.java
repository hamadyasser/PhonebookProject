package com.mycompany.phonebook;

import java.util.Scanner;

public class Main {

    public static void showMenu() {
        System.out.println("=========== MENU ===========");
        System.out.println("1. Insert");
        System.out.println("2. Search");
        System.out.println("3. Delete");
        System.out.println("4. Update");
        System.out.println("5. Display");
        System.out.println("6. Filter 0100");
        System.out.println("7. Size");
        System.out.println("8. Exit");
        System.out.print("Choose: ");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Choose Data Structure:");
        System.out.println("1. Linked List");
        System.out.println("2. BST");
        System.out.print("Enter choice: ");

        int dsChoice = sc.nextInt();
        sc.nextLine();

        PhonebookLinkedList pbList = new PhonebookLinkedList();
        PhonebookBST pbBST = new PhonebookBST();

        while (true) {

            showMenu();

            if (!sc.hasNextInt()) {
                System.out.println("Invalid input. Enter a number.");
                sc.nextLine();
                continue;
            }

            int choice = sc.nextInt();
            sc.nextLine();

            System.out.println("============================");

            if (choice == 1) {
                System.out.print("Name: ");
                String name = sc.nextLine();

                System.out.print("Phone: ");
                String phone = sc.nextLine();

                if (name.isEmpty() || phone.isEmpty()) {
                    System.out.println("Invalid input.");
                    continue;
                }

                if (dsChoice == 1)
                    pbList.insert(name, phone);
                else
                    pbBST.insert(name, phone);

                System.out.println("Contact added.");

            } else if (choice == 2) {
                System.out.print("Name: ");
                String name = sc.nextLine();

                if (dsChoice == 1) {
                    Node res = pbList.search(name);
                    if (res != null)
                        System.out.println(res.name + " - " + res.phone);
                    else
                        System.out.println("Not found");
                } else {
                    TreeNode res = pbBST.search(name);
                    if (res != null)
                        System.out.println(res.name + " - " + res.phone);
                    else
                        System.out.println("Not found");
                }

            } else if (choice == 3) {
                System.out.print("Name: ");
                String name = sc.nextLine();

                if (dsChoice == 1)
                    pbList.remove(name);
                else
                    pbBST.remove(name); 

                System.out.println("Delete operation done.");

            } else if (choice == 4) {
                System.out.print("Name: ");
                String name = sc.nextLine();

                System.out.print("New Phone: ");
                String newPhone = sc.nextLine();

                if (name.isEmpty() || newPhone.isEmpty()) {
                    System.out.println("Invalid input.");
                    continue;
                }

                if (dsChoice == 1)
                    pbList.update(name, newPhone);
                else {
                    TreeNode res = pbBST.search(name);
                    if (res != null) {
                        res.phone = newPhone;
                        System.out.println("Update operation done.");
                    } else {
                        System.out.println("Not found");
                    }
                }

            } else if (choice == 5) {
                if (dsChoice == 1)
                    pbList.display();
                else
                    pbBST.display();

            } else if (choice == 6) {
                if (dsChoice == 1)
                    pbList.filter0100();
                else
                    pbBST.filter0100();

            } else if (choice == 7) {
                if (dsChoice == 1)
                    System.out.println("Size: " + pbList.size());
                else
                    System.out.println("Size: " + pbBST.size());

            } else if (choice == 8) {
                System.out.println("Exiting...");
                break;

            } else {
                System.out.println("Invalid choice");
            }

            System.out.println("============================");
        }

        sc.close();
    }
}