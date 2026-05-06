package com.mycompany.phonebook;

public class PhonebookBST {

    private TreeNode root;
    private int size;

    public PhonebookBST() {
        root = null;
        size = 0;
    }

    public void insert(String name, String phone) {
        root = insertRec(root, name, phone);
    }

    private TreeNode insertRec(TreeNode node, String name, String phone) {
        if (node == null) {
            size++;
            return new TreeNode(name, phone);
        }

        int cmp = name.compareToIgnoreCase(node.name);

        if (cmp < 0)
            node.left = insertRec(node.left, name, phone);
        else if (cmp > 0)
            node.right = insertRec(node.right, name, phone);
        else
            System.out.println("Contact already exists.");

        return node;
    }

    public TreeNode search(String name) {
        return searchRec(root, name);
    }

    private TreeNode searchRec(TreeNode node, String name) {
        if (node == null) return null;

        int cmp = name.compareToIgnoreCase(node.name);

        if (cmp == 0) return node;
        else if (cmp < 0) return searchRec(node.left, name);
        else return searchRec(node.right, name);
    }

    public void remove(String name) {
        int before = size;
        root = removeRec(root, name);

        if (size < before)
            System.out.println("Deleted.");
        else
            System.out.println("Contact not found.");
    }

    private TreeNode removeRec(TreeNode node, String name) {
        if (node == null) return null;

        int cmp = name.compareToIgnoreCase(node.name);

        if (cmp < 0) {
            node.left = removeRec(node.left, name);

        } else if (cmp > 0) {
            node.right = removeRec(node.right, name);

        } else {
            
           
            if (node.left == null && node.right == null) {
                size--;
                return null;
            }

            
            if (node.left == null) {
                size--;
                return node.right;
            }

            if (node.right == null) {
                size--;
                return node.left;
            }

         
            TreeNode successor = findMin(node.right);

            node.name = successor.name;
            node.phone = successor.phone;

            node.right = removeRec(node.right, successor.name);
        }

        return node;
    }

    private TreeNode findMin(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    public void display() {
        inorder(root);
    }

    private void inorder(TreeNode node) {
        if (node != null) {
            inorder(node.left);
            System.out.println(node.name + " - " + node.phone);
            inorder(node.right);
        }
    }

    
    public void filter0100() {
        filterRec(root);
    }

    private void filterRec(TreeNode node) {
        if (node != null) {
            filterRec(node.left);
            if (node.phone.startsWith("0100"))
                System.out.println(node.name + " - " + node.phone);
            filterRec(node.right);
        }
    }

  
    public int size() {
        return size;
    }
}