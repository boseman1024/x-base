package com.axisx.apiuac.vo;

import lombok.Data;
import com.axisx.xutil.model.TreeNode;
import lombok.EqualsAndHashCode;

/**
 * @author Axisx
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class DeptTreeVO extends TreeNode {
    private String type;
}
