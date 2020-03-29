package com.axisx.apiworkflow.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class ActReProcdef {
    @TableId(value = "ID_")
    private Integer id;
    @TableField("NAME_")
    private String name;
    @TableField("KEY_")
    private String key;
    @TableField("VERSION_")
    private Integer version;
    @TableField("DEPLOYMENT_ID_")
    private String deploymentId;
    @TableField("RESOURCE_NAME_")
    private String resourceName;
    @TableField("CATEGORY_")
    private String category;
    @TableField("REV_")
    private Integer rev;
    @TableField("DGRM_RESOURCE_NAME_")
    private String dgrmResourceName;
    @TableField("HAS_START_FORM_KEY_")
    private String hasStartFromKey;
    @TableField("SUSPENSION_STATE_")
    private Integer suspensionState;
    @TableField("TENANT_ID_")
    private String tenantId;
    @TableField("VERSION_TAG_")
    private String versionTag;
    @TableField("HISTORY_TTL_")
    private Integer historyTtl;
    @TableField("STARTABLE_")
    private Integer startAble;
    @TableField(exist=false)
    private String group;
}
