package 二叉树;



import java.util.*;

public class BinaryTree {
    static class TreeNode {
        public char val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(char val) {
            this.val = val;
        }
    }

    public TreeNode root;

    public TreeNode createTree() {
        TreeNode A = new TreeNode('A');
        TreeNode B = new TreeNode('B');
        TreeNode C = new TreeNode('C');
        TreeNode D = new TreeNode('D');
        TreeNode E = new TreeNode('E');
        TreeNode F = new TreeNode('F');
        TreeNode G = new TreeNode('G');
        TreeNode H = new TreeNode('H');

        A.left = B;
        A.right = C;
        B.left = D;
        B.right = E;
        E.right = H;
        C.left = F;
        C.right = G;
        root = A;
        return root;
    }

    // 前序遍历
    public void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    // 中序遍历
    public void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        preOrder(root.left);
        System.out.print(root.val + " ");
        preOrder(root.right);
    }

    // 后序遍历
    public void postOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        preOrder(root.left);
        preOrder(root.right);
        System.out.print(root.val + " ");
    }

    public static int nodeSize;

    // 获取树中节点的个数
    //写法一：
    public int size(TreeNode root) {
        if (root == null) return 0;
        ++nodeSize;

        size(root.left);
        size(root.right);
        return nodeSize;
    }

    //写法二：
    public int size2(TreeNode root) {
        if (root == null) return 0;
        return size2(root.left) + size2(root.right) + 1;
    }

    //获取叶子节点的个数:子问题思路
    public int getLeafNodeCount1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        return getLeafNodeCount1(root.left) + getLeafNodeCount1(root.left);
    }

    public static int leafCount = 0;

    //获取叶子节点的个数:遍历思路
    public int getLeafNodeCount2(TreeNode root) {
        if (root == null) return 0;

        if (root.left == null && root.right == null) {
            return ++leafCount;
        }
        getLeafNodeCount2(root.left);
        getLeafNodeCount2(root.right);
        return leafCount;
    }

    //获取第 k 层节点的个数
    public int getLevelNodeCount(TreeNode root, int k) {
        if (root == null) return 0;
        if (k == 1) return 1;
        return getLevelNodeCount(root.left, k - 1) + getLevelNodeCount(root.right, k - 1);
    }

    //获取二叉树的高度
    public int getHeight(TreeNode root) {
        if (root == null) return 0;
        int left = getHeight(root.left);
        int right = getHeight(root.right);

        return left > right ? left + 1 : right + 1;
    }

    //检测值为 value 的元素是否存在
    public TreeNode find(TreeNode root, char val) {
        if (root == null) return null;
        if (root.val == val) return root;
        TreeNode ret = find(root.left, val);
        if (ret != null) return ret;
        ret = find(root.right, val);
        if (ret != null) return ret;
        return null;
    }

    //层序遍历：非递归
    public void levelOrder(TreeNode root) {
        if (root == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            System.out.print(cur.val + " ");
            if (cur.left != null) {
                queue.offer(cur.left);
            }
            if (cur.right != null) {
                queue.offer(cur.right);
            }
        }
        System.out.println();
    }

    //判断一棵树是不是完全二叉树
    public boolean isCompleteTree(TreeNode root) {
        if (root == null) return false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur != null) {
                queue.offer(cur.left);
                queue.offer(cur.right);
            } else {
                break;
            }
        }

        //第二次遍历队列，判断队列当中是否存在非空元素
        while (!queue.isEmpty()) {
            TreeNode cur = queue.peek();
            if (cur == null) {
                queue.poll();
            } else {
                return false;
            }
        }
        return true;
    }

    //判断两棵树是否相同
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if ((p != null && q == null) || (p == null && q != null)) return false;

        if (p == null && q == null) return true;

        if (p.val != q.val) {
            return false;
        }

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    //一棵树是否是另一棵树的子树
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) return false;

        if (isSameTree(root, subRoot)) return true;

        if (isSubtree(root.left, subRoot)) return true;

        if (isSubtree(root.right, subRoot)) return true;

        return false;
    }

    //判断是否是平衡二叉树：每个节点都要判断是不是平衡的，每个节点都要求左右高度的差值<=1
    public int Height(TreeNode root) {
        if (root == null) return 0;
        int left = Height(root.left);
        int right = Height(root.right);

        if (left >= 0 && right >= 0 && Math.abs(left-right) <= 1) {
            return Math.max(left,right)+1;
        } else {
            return -1;
        }
    }
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;

        return Height(root) >= 0;
    }

    //判断是否为对称的二叉树
    public boolean isSymmetricChild(TreeNode left, TreeNode right) {
        if (left == null && right != null) return false;
        if (left != null && right == null) return false;
        if (left == null && right == null) return true;

        if (left.val == right.val) {
            return isSymmetricChild(left.left,right.right) && isSymmetricChild(left.right,right.left);
        } else {
            return false;
        }
    }
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isSymmetricChild(root.left,root.right);
    }

    // 找到 p, q 结点的公共祖先
    // 方法一：
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;

        // p,q其中一个为根节点，则最近公共祖先是root
        if (p == root || q == root) return root;

        TreeNode leftRet = lowestCommonAncestor1(root.left,p,q);
        TreeNode rightRet = lowestCommonAncestor1(root.right,p,q);

        // 如果p,q分别在根节点的两侧，则最近公共祖先还是 root
        if (leftRet != null && rightRet != null) {
            return root;
        } else if (leftRet != null) {
            // 如果 leftRet 不为空，而 rightRet 为空，则代表p,q在根节点的左侧
            return leftRet;
        } else if (rightRet != null) {
            // 如果 rightRet 不为空，而 leftRet 为空，则代表p,q在根节点的右侧
            return rightRet;
        }

        // leftRet 和 rightRet 都为空，则代表没有公共祖先
        return null;
    }

    //方法二：
    public boolean getPath(TreeNode root,TreeNode node,Stack<TreeNode> s) {
        if (root == null || node == null) return false;
        s.push(root);
        // 找到了节点，返回真
        if (root == node) return true;

        // 继续从左子树找节点
        boolean flag1 = getPath(root.left,node,s);
        // 找到了，返回为真
        if (flag1 == true) {
            return true;
        }

        // 继续从右子树找节点
        boolean flag2 = getPath(root.right,node,s);
        if (flag2 == true) {
            return true;
        }

        // 左右子树都找不到目标节点，则表示该 root 节点下无 目标节点，则把此 root 节点弹出
        s.pop();
        return false;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 把p节点的路径装入栈s1中
        Stack<TreeNode> s1 = new Stack();
        getPath(root,p,s1);

        // 把q节点的路径装入栈s2中
        Stack<TreeNode> s2 = new Stack();
        getPath(root,q,s2);

        int size1 = s1.size();
        int size2 = s2.size();

        if (size1 > size2) {
            // 弹出元素的个数：两个栈大小的差值，保证两个栈里面的元素个数相同
            int gap = size1-size2;
            while (gap != 0) {
                s1.pop();
                --gap;
            }
        }

        if (size2 > size1) {
            int gap = size2 - size1;
            while (gap != 0) {
                s2.pop();
                --gap;
            }
        }

        while (!s1.empty() && !s2.empty()) {
            if (s1.peek() == s2.peek()) {
                return s1.peek();
            }
            s1.pop();
            s2.pop();
        }
        return null;
    }

    /**
     * 非递归实现前序遍历
     */
    public List<Character> preorderTraversalNor(TreeNode root) {
        List<Character> list = new ArrayList<>();
        if (root == null) return list;

        Stack<TreeNode> stack = new Stack<>();

        TreeNode cur = root;
        while (cur != null || !stack.empty()) {
            while (cur != null) {
                stack.push(cur);
                list.add(cur.val);
                cur = cur.left;
            }
            TreeNode top = stack.pop();
            cur = top.right;
        }
        return list;
    }

    /**
     * 非递归实现中序遍历
     */
    public List<Character> inorderTraversalNor(TreeNode root) {
        List<Character> list = new ArrayList<>();
        if (root == null) return list;

        Stack<TreeNode> stack = new Stack<>();

        TreeNode cur = root;
        while (cur != null || !stack.empty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode top = stack.pop();
            list.add(top.val);
            cur = top.right;
        }
        return list;
    }

    /**
     * 非递归实现后序遍历
     */
    public List<Character> postorderTraversalNor(TreeNode root) {
        List<Character> list = new ArrayList<>();
        if (root == null) return list;

        Stack<TreeNode> stack = new Stack<>();

        TreeNode cur = root;
        TreeNode prev = null;

        while (cur != null || !stack.empty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode top = stack.peek();
            if (top.right == null || top.right == prev) {
                stack.pop();
                list.add(top.val);
                prev = top; //防止重复打印
            } else {
                cur = top.right;
            }
        }
        return list;
    }
}

