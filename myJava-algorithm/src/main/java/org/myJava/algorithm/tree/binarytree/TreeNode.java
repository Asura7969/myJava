package org.myJava.algorithm.tree.binarytree;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TreeNode {

    private int value;
    private TreeNode leftTree;
    private TreeNode rightTree;


    public TreeNode(int value) {
        this.value = value;
    }
}
