package org.myJava.algorithm.tree.binarytree;


public class Demo {

    public static void main(String[] args) {
        TreeNode binaryTree = createBinaryTree();
        preTraverseBTree(binaryTree);
        System.out.println("======================");
        inTraverseBTree(binaryTree);
        System.out.println("======================");
        aftTraverseBTree(binaryTree);

        System.out.println("查询树的高度");
        System.out.println(getHeight(binaryTree));
        System.out.println("查询最大值");
        System.out.println(getMax(binaryTree));

    }

    /**
     * 先序遍历:先访问根节点，然后访问左节点，最后访问右节点(根->左->右)
     */
    public static void preTraverseBTree(TreeNode root){
        if(null != root){
            System.out.println(root.getValue());
            preTraverseBTree(root.getLeftTree());
            preTraverseBTree(root.getRightTree());
        }
    }

    /**
     * 中序遍历:先访问左节点，然后访问根节点，最后访问右节点(左->根->右)
     */
    public static void inTraverseBTree(TreeNode root){
        if(null != root){
            inTraverseBTree(root.getLeftTree());
            System.out.println(root.getValue());
            inTraverseBTree(root.getRightTree());
        }
    }

    /**
     * 后序遍历:先访问左节点，然后访问右节点，最后访问根节点(左->右->根)
     */
    public static void aftTraverseBTree(TreeNode root){
        if(null != root){
            aftTraverseBTree(root.getLeftTree());
            aftTraverseBTree(root.getRightTree());
            System.out.println(root.getValue());
        }
    }

    /**
     * 查询树的高度
     */
    public static int getHeight(TreeNode root){
        if(null == root){
            return 0;
        } else {
            int leftHeight = getHeight(root.getLeftTree());
            int rightHeight = getHeight(root.getRightTree());
            return leftHeight >= rightHeight ? leftHeight + 1 : rightHeight + 1;
        }
    }

    public static int getMax(TreeNode root){
        if(null == root){
            return -1;
        } else {
            int leftHeight = getMax(root.getLeftTree());
            int rightHeight = getMax(root.getRightTree());
            int currentValue = root.getValue();
            return currentValue >= leftHeight ? (Math.max(currentValue, rightHeight)) : leftHeight;
        }
    }


    public static TreeNode createBinaryTree(){
        TreeNode tree1 = new TreeNode(10);
        TreeNode tree2 = new TreeNode(9);
        TreeNode tree3 = new TreeNode(20);
        TreeNode tree4 = new TreeNode(15);
        TreeNode tree5 = new TreeNode(35);

        //根节点的左右孩子
        tree1.setLeftTree(tree2);
        tree1.setRightTree(tree3);

        //20节点的左右孩子
        tree3.setLeftTree(tree4);
        tree3.setRightTree(tree5);
        return tree1;
    }
}
