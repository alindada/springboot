package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
public class UploadController {


    private static final String filePath = "/Users/cyh/Documents/classpro/images/";


    @RequestMapping("upload")
    public Object Upload(@RequestParam("fileMame") MultipartFile upFile, HttpServletRequest request) {


        String name = request.getParameter("fileType");
        System.out.println("文件类型：" + name);

        // 获取文件名
        String fileName = upFile.getOriginalFilename();
        System.out.println("上传的文件名为：" + fileName);

        // 获取文件的后缀名,比如图片的jpeg,png
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        System.out.println("上传的后缀名为：" + suffixName);

        // 文件上传后的路径
        fileName = UUID.randomUUID() + suffixName;
        System.out.println("转换后的名称:" + fileName);

        File dest = new File(filePath + fileName);

        try {
            upFile.transferTo(dest);
            return fileName;
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "上传错误 ";

    }
}
