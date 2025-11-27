/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab4binarytrees;

/**
 *
 * 
 */

class TreeNode {
    int data;
    TreeNode left, right;

    TreeNode(int value) {
        data = value;
        left = right = null;
    }
}

// ===========================
// TASK 1: Binary Tree
// ===========================
class BinaryTree {
    TreeNode root;

    // Manually insert nodes (not ordered)
    void buildSampleTree() {
        root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(7);
        root.right.right = new TreeNode(20);
    }

    // Inorder Traversal (Left, Root, Right)
    void inorder(TreeNode node) {
        if (node != null) {
            inorder(node.left);
            System.out.print(node.data + " ");
            inorder(node.right);
        }
    }

    // Preorder Traversal (Root, Left, Right)
    void preorder(TreeNode node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preorder(node.left);
            preorder(node.right);
        }
    }

    // Postorder Traversal (Left, Right, Root)
    void postorder(TreeNode node) {
        if (node != null) {
            postorder(node.left);
            postorder(node.right);
            System.out.print(node.data + " ");
        }
    }
}

// ===========================
// TASK 2: Binary Search Tree
// ===========================
class BinarySearchTree {
    TreeNode root;

    // Insert following BST property
    void insert(int value) {
        root = insertRecursive(root, value);
    }

    TreeNode insertRecursive(TreeNode node, int value) {
        if (node == null) return new TreeNode(value);

        if (value < node.data)
            node.left = insertRecursive(node.left, value);
        else if (value > node.data)
            node.right = insertRecursive(node.right, value);

        return node;
    }

    // Search a value in BST
    boolean search(int value) {
        return searchRecursive(root, value);
    }

    boolean searchRecursive(TreeNode node, int value) {
        if (node == null) return false;
        if (node.data == value) return true;
        return (value < node.data)
            ? searchRecursive(node.left, value)
            : searchRecursive(node.right, value);
    }

    // Inorder traversal for sorted output
    void inorder(TreeNode node) {
        if (node != null) {
            inorder(node.left);
            System.out.print(node.data + " ");
            inorder(node.right);
        }
    }

    // ===========================
    // PRACTICE PROBLEMS
    // ===========================

    // Problem 2: Find minimum value (leftmost)
    int findMin(TreeNode node) {
        if (node == null) return Integer.MIN_VALUE;
        while (node.left != null)
            node = node.left;
        return node.data;
    }

    // Problem 2: Find maximum value (rightmost)
    int findMax(TreeNode node) {
        if (node == null) return Integer.MAX_VALUE;
        while (node.right != null)
            node = node.right;
        return node.data;
    }

    // Problem 3: Find height of BST
    int findHeight(TreeNode node) {
        if (node == null) return 0;
        int leftHeight = findHeight(node.left);
        int rightHeight = findHeight(node.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }
}

public class Lab4BinaryTrees {
   
    
    public static void main(String[] args) {
               // ===========================
        // TASK 1: Regular Binary Tree
        // ===========================
        BinaryTree bt = new BinaryTree();
        bt.buildSampleTree();

        System.out.println("Inorder traversal of Binary Tree:");
        bt.inorder(bt.root);
        System.out.println("\nPreorder traversal of Binary Tree:");
        bt.preorder(bt.root);
        System.out.println("\nPostorder traversal of Binary Tree:");
        bt.postorder(bt.root);

        // ===========================
        // TASK 2: Binary Search Tree
        // ===========================
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(50);
        bst.insert(30);
        bst.insert(70);
        bst.insert(20);
        bst.insert(40);
        bst.insert(60);
        bst.insert(80);

        System.out.println("\n\nInorder traversal of Binary Search Tree:");
        bst.inorder(bst.root);

        // ===========================
        // PRACTICE PROBLEM 1: Search
        // ===========================
        int searchValue = 40;
        System.out.println("\n\nSearching for " + searchValue + " in BST:");
        System.out.println(bst.search(searchValue)
            ? "✅ Found!"
            : "❌ Not Found.");

        // ===========================
        // PRACTICE PROBLEM 2: Min & Max
        // ===========================
        System.out.println("\nMinimum value in BST: " + bst.findMin(bst.root));
        System.out.println("Maximum value in BST: " + bst.findMax(bst.root));

        // ===========================
        // PRACTICE PROBLEM 3: Height
        // ===========================
        System.out.println("\nHeight of BST: " + bst.findHeight(bst.root));
    }
}
