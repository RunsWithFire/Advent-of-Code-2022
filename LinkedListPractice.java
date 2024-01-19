import java.util.*;

public class LinkedListPractice {
    public static void linkedList() {
        LinkedList list = new LinkedList();
        list.add(new Node(1));
        list.add(new Node(2));
        list.add(new Node(3));
        list.add(new Node(4));
        list.add(new Node(5));
        list.print();
        System.out.println("Insert Time");
        list.insert(3, new Node(7));
        list.insert(5, new Node(6));
        list.print();
        System.out.println("Delete Time");
        list.delete(7);
        list.delete(6);
        list.print();
    }

    public static class LinkedList {
        static Node head_node;

        public static void print() {
            Node cur_node = head_node;
            while (cur_node != null) {
                System.out.println(cur_node.value);
                cur_node = cur_node.next;
            }
        }

        public static void add(Node new_node) {
            if (head_node == null) {
                head_node = new_node;
                return;
            }
            Node cur_node = head_node;
            while (cur_node.next != null) {
                cur_node = cur_node.next;
            }
            cur_node.next = new_node;
            new_node.prev = cur_node;
        }

        public static void delete(int value) {
            Node cur_node = head_node;
            while (cur_node.value != value && cur_node.next != null) {
                cur_node = cur_node.next;
            }
            if (cur_node.value == value) {
                if (cur_node.next == null) {
                    cur_node.prev.next = null;
                    return;
                }
                cur_node.next.prev = cur_node.prev;
                cur_node.prev.next = cur_node.next;
            }
        }

        public static void insert(int after_value, Node new_node) {
            Node cur_node = head_node;
            while (cur_node.value != after_value && cur_node.next != null) {
                cur_node = cur_node.next;
            }
            if (cur_node.next == null) {
                cur_node.next = new_node;
                new_node.prev = cur_node;
                return;
            }
            new_node.next = cur_node.next;
            new_node.prev = cur_node;
            cur_node.next.prev = new_node;
            cur_node.next = new_node;
        }
    }

    public static class Node {
        int value;
        Node next;
        Node prev;

        Node(int value) {
            this.value = value;
        }
    }
}