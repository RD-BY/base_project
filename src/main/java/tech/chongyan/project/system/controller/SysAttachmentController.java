package tech.chongyan.project.system.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tech.chongyan.common.utils.StringUtils;
import tech.chongyan.framework.aspectj.lang.annotation.Log;
import tech.chongyan.framework.aspectj.lang.enums.BusinessType;
import tech.chongyan.framework.web.controller.BaseController;
import tech.chongyan.framework.web.domain.AjaxResult;
import tech.chongyan.project.system.domain.SysAttachment;
import tech.chongyan.project.system.domain.SysAttachmentRelation;
import tech.chongyan.project.system.service.ISysAttachmentRelationService;

import java.util.List;

/**
 * @Description 附件控制器
 * @param
 * @author yangbo
 * @Date 2020/7/14 0014 10:22
 */
@Api(tags = "附件管理")
@RestController
@RequestMapping("/system/attachment")
public class SysAttachmentController extends BaseController {

    @Autowired
    private ISysAttachmentRelationService iSysAttachmentRelationService;


    @PostMapping(value = "/getAttachmentList")
    @ApiOperation("查询附件列表")
    public AjaxResult getAttachmentList(@RequestBody  SysAttachmentRelation sysAttachmentRelation){
        System.out.println("sysAttachmentRelation.toString() = " + sysAttachmentRelation.toString());
        if (StringUtils.isNull(sysAttachmentRelation)){
            return AjaxResult.error("参数不能为空");
        }else{
            if (sysAttachmentRelation.getTableId()==null||sysAttachmentRelation.getTableId()==0){
                return AjaxResult.error("关联表id不能为空或者为0");
            }
            if (sysAttachmentRelation.getTableName()==null || sysAttachmentRelation.getTableName().equals("")){
                return AjaxResult.error("关联表名称不能为空");
            }
        }
        System.out.println("进入查询附件列表接口");
        System.out.println("sysAttachmentRelation = " + sysAttachmentRelation.getTableName());
        List<SysAttachment> sysAttachmentList = iSysAttachmentRelationService.getAttachmentList(sysAttachmentRelation);
        return AjaxResult.success(sysAttachmentList);
    }

    /**
     * @Description 新增附件信息
     * @param
     * @return tech.chongyan.framework.web.domain.AjaxResult
     * @author yangbo
     * @Date 2020/7/14 0014 17:42
     */

    @PostMapping("/insertAttachment")
    @ApiOperation("新增附件信息")
    @Log(title = "附件管理", businessType = BusinessType.INSERT)
    public AjaxResult insertAttachment(SysAttachment sysAttachment){
       logger.info("接收到的数据：" + sysAttachment.toString());
       iSysAttachmentRelationService.insertAttachment(sysAttachment);
       return AjaxResult.success(sysAttachment);
    }

    /**
     * @Description 删除附件
     * @param attachmentId
     * @return tech.chongyan.framework.web.domain.AjaxResult
     * @author yangbo
     * @Date 2020/7/14 0014 18:09
     */

    @DeleteMapping("/deleteAttachment/{attachmentId}")
    @ApiOperation("删除附件信息")
    @Log(title = "附件管理",businessType = BusinessType.DELETE)
    public AjaxResult deleteAttachment(@PathVariable Integer attachmentId){
        return toAjax(iSysAttachmentRelationService.deleteAttachment(attachmentId));
    }
    /**
     * @Description  新增附件关系
     * @param
     * @return tech.chongyan.framework.web.domain.AjaxResult
     * @author yangbo
     * @Date 2020/7/15 0015 8:57
     */

    @PostMapping("/insertAttachmentRelation")
    @ApiOperation("新增附件关联")
    @Log(title = "附件管理" ,businessType = BusinessType.INSERT)
    public AjaxResult insertAttachmentRelation(@RequestBody SysAttachmentRelation sysAttachmentRelation){
        iSysAttachmentRelationService.insertAttachmentRelation(sysAttachmentRelation);
        return  AjaxResult.success(sysAttachmentRelation);
    }
    @ApiOperation("删除附件关联")
    @DeleteMapping("/deleteAttachmentRelation/{relationId}")
    @Log(title = "附件管理",businessType = BusinessType.DELETE)
    public AjaxResult deleteAttachmentRelation(@PathVariable Integer relationId){
            return toAjax(iSysAttachmentRelationService.deleteAttachmentRelation(relationId));
    }
    @ApiOperation("查询附件关联关系列表")
    @PostMapping("/getAttachmentRelationList")
    public AjaxResult getAttachmentRelationList(@RequestBody SysAttachmentRelation sysAttachmentRelation){
        List<SysAttachmentRelation> list = iSysAttachmentRelationService.getAttachmentRelationList(sysAttachmentRelation);
        return AjaxResult.success(list);
    }

}
