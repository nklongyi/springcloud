package com.nklongyi.Util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;

/**
 * 专用于处理图片上传的类
 * Created by longyi on 2017/8/27.
 */
@Controller
public class ImgProcessController {

    private Logger logger =  LoggerFactory.getLogger(this.getClass());

    //配置文件的上传路径
    @Value("${web.upload-path}")
    private String filePath;
    /**
     * 单文件上传处理ajax
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/admin/img/upload",method = RequestMethod.POST,produces = "application/json")
    public Map<String,Object> uploadImg(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {

        request.setCharacterEncoding("UTF-8");

        Map<String, Object> json = new HashMap<String, Object>();
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        /** 页面控件的文件流* */
        MultipartFile multipartFile = null;
        Map map =multipartRequest.getFileMap();
        for (Iterator i = map.keySet().iterator(); i.hasNext();) {
            Object obj = i.next();
            multipartFile=(MultipartFile) map.get(obj);
        }
        // 获取文件名
        String fileName = multipartFile.getOriginalFilename();
        logger.info("上传的文件名为：" + fileName);

        // 获取文件的后缀名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        logger.info("上传的后缀名为：" + suffixName);


        String path=null;
        // 解决中文问题，liunx下中文路径，图片显示问题
         fileName = UUID.randomUUID() + suffixName;

        File dest = new File(filePath + fileName);
        // 检测是否存在目录
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            multipartFile.transferTo(dest);
            path = filePath+fileName;
            json.put("message", "应用上传成功");
            json.put("status", true);
            json.put("filePath", path);
        } catch (IllegalStateException e) {
            e.printStackTrace();
            json.put("message", "应用失败");
            json.put("status", false);
        } catch (IOException e) {
            e.printStackTrace();
            json.put("message", "应用失败");
            json.put("status", false);
        }

        return json;
    }

    /**
     * 富文本编辑器图片上传处理interface
     */
    @ResponseBody
    @RequestMapping(value = "/admin/wangEditor/img/upload",method = RequestMethod.POST,produces = "application/json")
    public Map<String,Object> uploadImgofText(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");

        Map<String, Object> json = new HashMap<String, Object>();
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        /** 页面控件的文件流* */
        MultipartFile multipartFile = null;
        Map map =multipartRequest.getFileMap();
        for (Iterator i = map.keySet().iterator(); i.hasNext();) {
            Object obj = i.next();
            multipartFile=(MultipartFile) map.get(obj);
        }
        // 获取文件名
        String fileName = multipartFile.getOriginalFilename();
        logger.info("上传的文件名为：" + fileName);

        // 获取文件的后缀名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        logger.info("上传的后缀名为：" + suffixName);

        // 文件上传后的路径
        String path=null;
        // 解决中文问题，liunx下中文路径，图片显示问题
        fileName = UUID.randomUUID() + suffixName;
        File dest = new File(filePath + fileName);
        // 检测是否存在目录
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            multipartFile.transferTo(dest);
            path = request.getContextPath()+'/'+fileName;
            json.put("message", "应用上传成功");
            json.put("error", 0);
            json.put("data", path);
        } catch (IllegalStateException e) {
            e.printStackTrace();
            json.put("message", "应用失败");
            json.put("error", false);
        } catch (IOException e) {
            json.put("message", "应用失败");
            json.put("error", false);
            e.printStackTrace();
        }
        return json;
    }

}
