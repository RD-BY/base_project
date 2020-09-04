package tech.chongyan.project.system.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tech.chongyan.project.system.domain.SysAttachment;
import tech.chongyan.project.system.domain.SysAttachmentRelation;
import tech.chongyan.project.system.mapper.SysAttachmentRelationMapper;
import tech.chongyan.project.system.service.ISysAttachmentRelationService;

import java.util.List;

@Service
public class SysAttactmentRelationServiceImpl implements ISysAttachmentRelationService {

    @Autowired
    private SysAttachmentRelationMapper sysAttachmentRelationMapper;

    /**
     * @Description 获取附件列表
     * @param sysAttachmentRelation
     * @return java.util.List<tech.chongyan.project.system.domain.SysAttachment>
     * @author yangbo
     * @Date 2020/7/14 0014 10:45
     */

    @Override
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public List<SysAttachment> getAttachmentList(SysAttachmentRelation sysAttachmentRelation) {
        System.out.println("进入查询附件类表service");
        List<SysAttachment> attachmentList = sysAttachmentRelationMapper.getAttachmentList(sysAttachmentRelation);
        return attachmentList;
    }
    /**
     * @Description 新增附件
     * @param sysAttachment
     * @return int
     * @author yangbo
     * @Date 2020/7/14 0014 18:10
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public int insertAttachment(SysAttachment sysAttachment) {
        System.out.println("进入新增附件serviceImpl");
        System.out.println("sysAttachment = " + sysAttachment);
        return sysAttachmentRelationMapper.insertAttachment(sysAttachment);
    }

    /**
     * @Description 删除附件
     * @param attachmentId
     * @return int
     * @author yangbo
     * @Date 2020/7/14 0014 18:10
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public int deleteAttachment(Integer attachmentId) {
        System.out.println("获取到的附件id： " + attachmentId);
        return sysAttachmentRelationMapper.deleteAttachment(attachmentId);
    }
    /**
     * @Description  新增附件关联
     * @param sysAttachmentRelation
     * @return int
     * @author yangbo
     * @Date 2020/7/15 0015 9:00
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public int insertAttachmentRelation(SysAttachmentRelation sysAttachmentRelation) {
        return sysAttachmentRelationMapper.insertAttachmentRelation(sysAttachmentRelation);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public List<SysAttachmentRelation> getAttachmentRelationList(SysAttachmentRelation sysAttachmentRelation) {
        return sysAttachmentRelationMapper.getAttachmentRelationList(sysAttachmentRelation);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public int deleteAttachmentRelation(Integer relationId) {
        return sysAttachmentRelationMapper.deleteAttachmentRelation(relationId);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public List<SysAttachment> getAll() {
        return sysAttachmentRelationMapper.getAll();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public void deleteAttachmentAndRelation(String tableName, int tableId) {
        System.out.println("tableName = [" + tableName + "], tableId = [" + tableId + "]");
        SysAttachmentRelation sysAttachmentRelation = new SysAttachmentRelation();
        sysAttachmentRelation.setTableId(tableId);
        sysAttachmentRelation.setTableName(tableName);
        //获取所有关系
        List<SysAttachmentRelation> relationList = sysAttachmentRelationMapper.getAttachmentRelationList(sysAttachmentRelation);
        for(SysAttachmentRelation attachmentRelation : relationList){
            //删除附件
            sysAttachmentRelationMapper.deleteAttachment(attachmentRelation.getAttachmentId());
            //删除关系
            sysAttachmentRelationMapper.deleteAttachmentRelation(attachmentRelation.getRelationId());
        }
    }
}
