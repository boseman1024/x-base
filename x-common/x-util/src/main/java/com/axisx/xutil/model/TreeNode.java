package com.axisx.xutil.model;

import lombok.Data;
import java.util.List;

/**
 * 树模型
 * @author Axisx
 */
@Data
public class TreeNode {
    private String label;
    private Integer id;
    private String value;
    private Integer pid;
    private List<TreeNode> children;

    public void addChild(TreeNode treeNode){
        this.children.add(treeNode);
    }
}
