package 非递归实现二叉树遍历;

import java.util.Stack;

public class MyDoubleTree {
    static class TreeNode {
        char val;
        TreeNode left;
        TreeNode right;

        public TreeNode(char val) {
            this.val = val;
        }
    }

    TreeNode root;

    public TreeNode createTree() {
        TreeNode A = new TreeNode('A');
        TreeNode B = new TreeNode('B');
        TreeNode C = new TreeNode('C');
        TreeNode D = new TreeNode('D');
        TreeNode E = new TreeNode('E');

        A.left = B;
        A.right = C;
        B.left = D;
        B.right = E;

        root = A;
        return root;
    }

    public void preOrder(TreeNode root) {
        if (root != null) {
            Stack<TreeNode> stack = new Stack<>();
            stack.add(root);
            while (!stack.isEmpty()) {
                root = stack.pop();
                System.out.print(root.val + " ");

                if (root.right != null) {
                    stack.add(root.right);
                }

                if (root.left != null) {
                    stack.add(root.left);
                }
            }
        }
        System.out.println();
    }

    public void inOreder(TreeNode root) {
        if (root != null) {
            Stack<TreeNode> stack = new Stack<>();
            while (!stack.isEmpty() || root != null) {
                if (root != null) {
                    stack.add(root);
                    root = root.left;
                } else {
                    root = stack.pop();
                    System.out.print(root.val + " ");
                    root = root.right;
                }
            }
        }
        System.out.println();
    }

    public void posOrder(TreeNode root) {
        if (root != null) {
            Stack<TreeNode> s1 = new Stack<>();
            Stack<TreeNode> s2 = new Stack<>();
            s1.add(root);
            while (!s1.isEmpty()) {
                root = s1.pop();
                s2.add(root);

                if (root.left != null) {
                    s1.add(root.left);
                }

                if (root.right!=null){
                    s1.add(root.right);
                }
            }
            while (!s2.isEmpty()) {
                System.out.print(s2.pop().val + " ");
            }
        }
        System.out.println();
    }
}

