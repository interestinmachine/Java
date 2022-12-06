package 非递归实现二叉树遍历;


public class Test {
    public static void main(String[] args) {
        MyDoubleTree myDoubleTree = new MyDoubleTree();
        MyDoubleTree.TreeNode root =  myDoubleTree.createTree();
        myDoubleTree.preOrder(root);
        myDoubleTree.inOreder(root);
        myDoubleTree.posOrder(root);
    }
}

