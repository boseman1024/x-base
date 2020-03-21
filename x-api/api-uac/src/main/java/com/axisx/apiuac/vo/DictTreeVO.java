package com.axisx.apiuac.vo;

import com.axisx.xutil.model.TreeNode;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Axisx
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class DictTreeVO extends TreeNode {
    private String code;
    private String type;
}
