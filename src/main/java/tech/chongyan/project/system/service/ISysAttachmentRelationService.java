package tech.chongyan.project.system.service;

import tech.chongyan.project.system.domain.SysAttachment;
import tech.chongyan.project.system.domain.SysAttachmentRelation;

import java.util.List;

/**
 * @Description  附件   服务层
 * @param
 * @author yangbo
 * @Date 2020/7/14 0014 10:27
 */
public interface ISysAttachmentRelationService {

    List<SysAttachment> getAttachmentList(SysAttachmentRelation sysAttachmentRelation);

    int insertAttachment(SysAttachment sysAttachment);

    int deleteAttachment(Integer attachmentId);

    int insertAttachmentRelation(SysAttachmentRelation sysAttachmentRelation);

    List<SysAttachmentRelation> getAttachmentRelationList(SysAttachmentRelation sysAttachmentRelation);

    int deleteAttachmentRelation(Integer relationId);

    List<SysAttachment> getAll();

    void deleteAttachmentAndRelation(String tableName, int tableId);
}
