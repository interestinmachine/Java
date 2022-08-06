package 二叉树;

public class Test {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        BinaryTree.TreeNode root = binaryTree.createTree();
        binaryTree.preOrder(root);
        System.out.println();
        binaryTree.inOrder(root);
        System.out.println();
        binaryTree.postOrder(root);
        System.out.println();
        System.out.println(binaryTree.size(root));
        System.out.println(binaryTree.size2(root));
        System.out.println(binaryTree.getLeafNodeCount1(root));
        System.out.println(binaryTree.getLeafNodeCount2(root));
        System.out.println(binaryTree.getHeight(root));
        System.out.println(binaryTree.find(root,'E').val);
        binaryTree.levelOrder(root);
        System.out.println("===========================");
        System.out.println(binaryTree.isCompleteTree(root));
    }
}

