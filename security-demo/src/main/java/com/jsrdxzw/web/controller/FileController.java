package com.jsrdxzw.web.controller;

import com.jsrdxzw.dto.FileInfo;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * @Author: xuzhiwei
 * @Date: 2019/10/24
 * @Description:
 */
@RestController
@RequestMapping("/file")
public class FileController {

    private static final String FOLDER = "/Users/xuzhiwei/开发文件/best-security-practice/security-demo/src/main/java/com/jsrdxzw/web/controller";


    /**
     * 文件，图片上传
     *
     * @param file 和前端的名称要匹配
     * @return
     */
    @PostMapping
    public FileInfo update(MultipartFile file) throws IOException {
        System.out.println(file.getName());
        System.out.println(file.getOriginalFilename());
        System.out.println(file.getSize());
        System.out.println(file.getContentType());
        File localFile = new File(FOLDER, System.currentTimeMillis() + ".txt");
        file.transferTo(localFile);
        return new FileInfo(localFile.getAbsolutePath());
    }

    @GetMapping("/{id}")
    public void download(@PathVariable String id, HttpServletRequest request, HttpServletResponse response) {
        try (
                InputStream inputStream = new FileInputStream(new File(FOLDER, id + ".txt"));
                OutputStream outputStream = response.getOutputStream();
        ) {
            response.setContentType("application/x-download");
            IOUtils.copy(inputStream, outputStream);
            outputStream.flush();
        } catch (Exception ignored) {

        }
    }

}
