package tech.chongyan.project.common;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import tech.chongyan.common.constant.Constants;
import tech.chongyan.common.utils.ServletUtils;
import tech.chongyan.common.utils.StringUtils;
import tech.chongyan.common.utils.file.FileUploadUtils;
import tech.chongyan.common.utils.file.FileUtils;
import tech.chongyan.framework.config.RuoYiConfig;
import tech.chongyan.framework.config.ServerConfig;
import tech.chongyan.framework.security.LoginUser;
import tech.chongyan.framework.security.service.TokenService;
import tech.chongyan.framework.web.domain.AjaxResult;
import tech.chongyan.project.system.domain.SysAttachment;
import tech.chongyan.project.system.service.ISysAttachmentRelationService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 通用请求处理
 * 
 * @author ruoyi
 */
@Api(tags = "通用请求处理")
@RestController
public class CommonController
{
    private static final Logger log = LoggerFactory.getLogger(CommonController.class);

    @Autowired
    private ServerConfig serverConfig;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private ISysAttachmentRelationService iSysAttachmentRelationService;

    /**
     * 通用下载请求
     * 
     * @param fileName 文件名称
     * @param delete 是否删除
     */
    @GetMapping("common/download")
    public void fileDownload(String fileName, Boolean delete, HttpServletResponse response, HttpServletRequest request)
    {
        try
        {
            if (!FileUtils.isValidFilename(fileName))
            {
                throw new Exception(StringUtils.format("文件名称({})非法，不允许下载。 ", fileName));
            }
            String realFileName = System.currentTimeMillis() + fileName.substring(fileName.indexOf("_") + 1);
            String filePath = RuoYiConfig.getDownloadPath() + fileName;

            response.setCharacterEncoding("utf-8");
            response.setContentType("multipart/form-data");
            response.setHeader("Content-Disposition",
                    "attachment;fileName=" + FileUtils.setFileDownloadHeader(request, realFileName));
            FileUtils.writeBytes(filePath, response.getOutputStream());
            if (delete)
            {
                FileUtils.deleteFile(filePath);
            }
        }
        catch (Exception e)
        {
            log.error("下载文件失败", e);
        }
    }

    /**
     * 通用上传请求
     */
    @ApiOperation(value = "通用上传请求")
    @PostMapping("/common/upload")
    public AjaxResult uploadFile(MultipartFile file) throws Exception
    {
        try
        {
            LoginUser loginUser = tokenService.getLoginUser(ServletUtils.getRequest());
            // 上传文件路径
            String filePath = RuoYiConfig.getUploadPath();
            // 上传并返回新文件名称
            String fileName = FileUploadUtils.upload(filePath, file);
            //设置附件信息
            SysAttachment sysAttachment = new SysAttachment();
            sysAttachment.setCreateBy(Integer.parseInt(loginUser.getUser().getUserId().toString()));//创建人
            sysAttachment.setFileName(fileName.substring(fileName.lastIndexOf("/")+1));//文件名称
            sysAttachment.setFilePath(RuoYiConfig.getProfile()+fileName);//绝对路径
            sysAttachment.setFileUrl(fileName);//附件url
            sysAttachment.setFileSize(String.valueOf(file.getSize()));
            sysAttachment.setFileType(file.getContentType());

            //保存附件信息
            iSysAttachmentRelationService.insertAttachment(sysAttachment);

            String url = serverConfig.getUrl() + fileName;
            AjaxResult ajax = AjaxResult.success();
            ajax.put("fileName", fileName);
            ajax.put("url", url);
            ajax.put("attachment",sysAttachment);
            return ajax;
        }
        catch (Exception e)
        {
            return AjaxResult.error(e.getMessage());
        }
    }

    /**
     * 本地资源通用下载
     */
    @GetMapping("/common/download/resource")
    public void resourceDownload(String name, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        // 本地资源路径
        String localPath = RuoYiConfig.getProfile();
        // 数据库资源地址
        String downloadPath = localPath + StringUtils.substringAfter(name, Constants.RESOURCE_PREFIX);
        // 下载名称
        String downloadName = StringUtils.substringAfterLast(downloadPath, "/");
        response.setCharacterEncoding("utf-8");
        response.setContentType("multipart/form-data");
        response.setHeader("Content-Disposition",
                "attachment;fileName=" + FileUtils.setFileDownloadHeader(request, downloadName));
        FileUtils.writeBytes(downloadPath, response.getOutputStream());
    }
}
