package oop.assigment_problems;

public class PriorityTokenInsertion {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    static Node addFirst(Node head, int token) {
        Node newNode = new Node(token);
        newNode.next = head;
        return newNode;
    }

    static Node addLast(Node head, int token) {
        Node newNode = new Node(token);

        if (head == null) {
            return newNode;
        }

        Node current = head;

        while (current.next != null) {
            current = current.next;
        }

        current.next = newNode;
        return head;
    }

    static Node insertAt(Node head, int index, int token) {
        if (index < 0) {
            throw new IndexOutOfBoundsException();
        }

        if (index == 0) {
            return addFirst(head, token);
        }

        Node current = head;

        for (int i = 0; i < index - 1 && current != null; i++) {
            current = current.next;
        }

        if (current == null) {
            throw new IndexOutOfBoundsException();
        }

        Node newNode = new Node(token);
        newNode.next = current.next;
        current.next = newNode;

        return head;
    }

    static void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + " -> ");
            head = head.next;
        }

        System.out.println("null");
    }

    public static void main(String[] args) {
        Node head = new Node(101);
        head.next = new Node(102);
        head.next.next = new Node(103);

        head = addFirst(head, 100);
        head = addLast(head, 104);
        head = insertAt(head, 2, 150);

        printList(head);
    }
}