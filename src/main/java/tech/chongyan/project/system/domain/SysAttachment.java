package tech.chongyan.project.system.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * @Description 附件表
 * @param
 * @author yangbo
 * @Date 2020/7/13 0013 17:20
 */
public class SysAttachment {

    private static final long serialVersionUID = 1L;

    /**附件id*/
    @ApiModelProperty("附件id")
    private Integer attachmentId;
    /**附件名称*/
    @ApiModelProperty("附件名称")
    private String fileName;
    /**附件保存绝对地址*/
    @ApiModelProperty("附件绝对地址")
    private String filePath;
    /**附件url*/
    @ApiModelProperty("附件url")
    private String fileUrl;
    /**附件大小*/
    @ApiModelProperty("附件大小")
    private String fileSize;
    /**附件类型*/
    @ApiModelProperty("附件类型")
    private String fileType;
    /**创建人*/
    @ApiModelProperty("创建人")
    private Integer createBy;
    /**创建时间*/
    @ApiModelProperty("创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    @Override
    public String toString() {
        return "SysAttachment{" +
                "attachmentId=" + attachmentId +
                ", fileName='" + fileName + '\'' +
                ", filePath='" + filePath + '\'' +
                ", fileUrl='" + fileUrl + '\'' +
                ", fileSize='" + fileSize + '\'' +
                ", fileType='" + fileType + '\'' +
                ", createBy=" + createBy +
                ", createTime=" + createTime +
                '}';
    }

    public Integer getAttachmentId() {
        return attachmentId;
    }

    public void setAttachmentId(Integer attachmentId) {
        this.attachmentId = attachmentId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public String getFileSize() {
        return fileSize;
    }

    public void setFileSize(String fileSize) {
        this.fileSize = fileSize;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public Integer getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Integer createBy) {
        this.createBy = createBy;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
