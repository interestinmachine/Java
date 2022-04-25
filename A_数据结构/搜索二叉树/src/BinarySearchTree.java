class Node {
    public int val;
    public Node left;
    public Node right;

    public Node(int val) {
        this.val = val;
    }
}

public class BinarySearchTree {
    public Node root = null;

    public Node search(int key) {
        Node cur = root;
        while (cur != null) {
            if (cur.val < key) {
                cur = cur.right;
            } else if (cur.val == key) {
                return cur;
            } else {
                cur = cur.left;
            }
        }
        return null;
    }

    public boolean insert(int val) {
        Node newNode = new Node(val);
        if (root == null) {
            root = newNode;
            return true;
        }

        Node cur = root;
        Node parent = null;

        while (cur != null) {
            if (cur.val > val) {
                parent = cur;
                cur = cur.left;
            } else if (cur.val < val) {
                parent = cur;
                cur = cur.right;
            } else {
                return false;
            }
        }

        if (parent.val < val) {
            parent.right = newNode;
        } else if (parent.val > val) {
            parent.left = newNode;
        }

        return true;
    }

    public void remove(int key) {
        Node cur = root;
        Node parent = null;
        while (cur != null) {
            if (cur.val == key) {
                removeNode(cur,parent);
            } else if (cur.val < key) {
                parent = cur;
                cur = cur.right;
            } else {
                cur = cur.left;
            }
        }
    }

    public void removeNode(Node cur,Node parent) {
        if (cur.left == null) {
            if (cur == root) {
                root = cur.right;
            } else if (cur == parent.left) {
                parent.left = cur.right;
            } else if (cur == parent.right) {
                parent.right = cur.right;
            }
        } else if (cur.right == null) {
            if (cur == root) {
                root = cur.left;
            } else if (cur == parent.left) {
                parent.left = cur.left;
            } else if (cur == parent.right) {
                parent.right = cur.left;
            }
        } else {
            Node targetParent = cur;
            Node target = cur.right;
            while (target.left != null) {
                targetParent = target;
                target = target.left;
            }
            cur.val = target.val;
            if (target == targetParent.left) {
                targetParent.left = target.right;
            } else {
                targetParent.right = target.right;
            }
        }
    }
}

