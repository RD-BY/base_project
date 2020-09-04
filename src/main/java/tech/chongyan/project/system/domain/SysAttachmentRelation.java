package tech.chongyan.project.system.domain;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

/**
 * @Description 附件关系表
 * @param
 * @author yangbo
 * @Date 2020/7/14 0014 10:21
 */

public class SysAttachmentRelation{


    private static final long serialVersionUID = 1L;
    /**关联id*/
    private Integer relationId;
    /**关联表名称*/
    @ApiModelProperty("关联表名称")
    @NotBlank(message = "关联表名称不能为空")
    private String tableName;
    /**关联表id*/
    @NotEmpty(message = "关联表ID不能为空")
    @ApiModelProperty("关联表ID")
    private Integer tableId;
    /**附件id*/
    private Integer attachmentId;

    @Override
    public String toString() {
        return "SysAttachmentRelation{" +
                "relationId=" + relationId +
                ", tableName='" + tableName + '\'' +
                ", tableId=" + tableId +
                ", attachmentId=" + attachmentId +
                '}';
    }

    public Integer getRelationId() {
        return relationId;
    }

    public void setRelationId(Integer relationId) {
        this.relationId = relationId;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public Integer getTableId() {
        return tableId;
    }

    public void setTableId(Integer tableId) {
        this.tableId = tableId;
    }

    public Integer getAttachmentId() {
        return attachmentId;
    }

    public void setAttachmentId(Integer attachmentId) {
        this.attachmentId = attachmentId;
    }
}
