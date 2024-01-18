import java.util.*;

public class Day7 {
    public static Node head_node;
    public static int score = 0;
    public static List<Integer> dir_sizes = new ArrayList<Integer>();

    public static void day7(List<String> input) {
        BuildTree(input);
        // There's a better way to do this here, but my goal
        // is to de-rust and learn, so I'm going to build
        // the tree, then traverse the tree.
        TraverseTree(head_node);
        System.out.println(score);
        
        // Part 2 Logic:
        int freespace = 70000000 - head_node.size;
        int size_to_delete = 30000000 - freespace;
        Collections.sort(dir_sizes);
        for (int size : dir_sizes) {
            if (size >= size_to_delete) {
                System.out.println(size);
                break;
            }
        }
    }

    public static class Node {
        String name;
        boolean is_dir = false;
        int size = 0;
        List<Node> children = new ArrayList<Node>();
        Node parent;
    }

    public static void TraverseTree(Node node) {
        for (Node child : node.children) {
            TraverseTree(child);
        }
        if (node.is_dir) {
            dir_sizes.add(node.size);
        }
        if (node.is_dir && node.size <= 100000) {
            score = score + node.size;
        }
    }

    public static void BuildTree(List<String> input) {
        Node thisNode = new Node();
        thisNode.name = "/";
        thisNode.is_dir = true;
        head_node = thisNode;

        for (int i=1; i<input.size(); i++) {
            String input_line = input.get(i);

            if (input_line.equals("$ ls")) {
                List<String> items = GetItemsLs(input, i);
                for (String item : items) {
                    if (item.substring(0,3).equals("dir")) {
                        Node newNode = new Node();
                        newNode.parent = thisNode;
                        newNode.name = item.substring(item.indexOf(" ")+1);
                        newNode.is_dir = true;
                        newNode.size = 0;
                        thisNode.children.add(newNode);
                    } else {
                        int size = Integer.parseInt(item.substring(0, item.indexOf(" ")));
                        Node newNode = new Node();
                        newNode.parent = thisNode;
                        newNode.name = item.substring(item.indexOf(" ")+1);
                        newNode.is_dir = false;
                        newNode.size = size;
                        thisNode.children.add(newNode);
                        UpdateParentSizes(thisNode, size);
                    }
                }
            }

            if (input_line.substring(0, 4).equals("$ cd")) {
                String next_node_name = input_line.substring(5);
                if (next_node_name.equals("..")) {
                    thisNode = thisNode.parent;
                } else {
                    for (Node child : thisNode.children) {
                        if (child.name.equals(next_node_name)) {
                            thisNode = child;
                        }
                    }
                }
            }
        }
    }

    public static void UpdateParentSizes(Node node, Integer size) {
        node.size = node.size + size;
        if (node.parent == null) {
            return;
        }

        UpdateParentSizes(node.parent, size);
    }

    public static List<String> GetItemsLs(List<String> input, Integer i) {
        List<String> items = new ArrayList<String>();

        for (int j=i+1; j<input.size(); j++) {
            String line = input.get(j);
            if (line.charAt(0) != '$') {
                items.add(line);
            } else {
                return items;
            }
        }

        return items;
    }
}
