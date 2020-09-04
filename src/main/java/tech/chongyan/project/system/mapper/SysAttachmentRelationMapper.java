package tech.chongyan.project.system.mapper;

import tech.chongyan.project.system.domain.SysAttachment;
import tech.chongyan.project.system.domain.SysAttachmentRelation;

import java.util.List;

public interface SysAttachmentRelationMapper {


    List<SysAttachment> getAttachmentList(SysAttachmentRelation sysAttachmentRelation);

    int insertAttachment(SysAttachment sysAttachment);

    int deleteAttachment(Integer attachmentId);

    int insertAttachmentRelation(SysAttachmentRelation sysAttachmentRelation);

    List<SysAttachmentRelation> getAttachmentRelationList(SysAttachmentRelation sysAttachmentRelation);

    int deleteAttachmentRelation(Integer relationId);

    List<SysAttachment> getAll();
}
