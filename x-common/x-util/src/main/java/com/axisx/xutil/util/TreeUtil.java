package com.axisx.xutil.util;

import com.axisx.xutil.model.TreeNode;
import lombok.experimental.UtilityClass;

import java.util.ArrayList;
import java.util.List;

/**
 * 构造树工具
 * @author Axisx
 */
@UtilityClass
public class TreeUtil {

    public <T extends TreeNode> List<T> build(List<T> treeNodes,Object root){
        List<T> tree = new ArrayList<>();
        treeNodes.stream().forEach(node->{
            if(root.equals(node.getPid())){
                tree.add(findChild(treeNodes,node));
            }
        });
        return tree;
    }

    public <T extends TreeNode> T findChild(List<T> treeNodes,T rootNode){
        treeNodes.stream().forEach(node->{
            if(rootNode.getId().equals(node.getPid())){
                if(rootNode.getChildren()==null){
                    rootNode.setChildren(new ArrayList<>());
                }
                rootNode.addChild(findChild(treeNodes,node));
            }
        });
        return rootNode;
    }
}
