package com.mycompany.phonebook;

class TreeNode {
    String name;
    String phone;
    TreeNode left, right;

    TreeNode(String name, String phone) {
        this.name = name;
        this.phone = phone;
        this.left = null;
        this.right = null;
    }
}