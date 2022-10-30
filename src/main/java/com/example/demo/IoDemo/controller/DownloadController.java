package com.example.demo.IoDemo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

/**
 * 文件名：
 * 版权：Copyright 2017-2022 CMCC ALL Right Reserved.
 * 描述：
 */
@RestController
public class DownloadController {
    @RequestMapping("/download")
    public void download(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        File file = new File("D:\\install\\tomcat9\\apache-tomcat-9.0.37\\apache-tomcat-9.0.37\\cmcc\\ImageProblemsAndProcess (1)\\运维问题-01-影像常见问题 -1.2(1).docx");
        String path = file.getPath();
        String substring = path.substring(path.lastIndexOf("\\") + 1, path.length());
        String userAgent = request.getHeader("USER-AGENT") == null ?
                "other" : request.getHeader("USER-AGENT").toLowerCase();
        if (userAgent.indexOf("firefox") >= 0) {
            response.addHeader("Content-Disposition",  "attachment;filename=\"" +
                    new String(substring.getBytes("UTF-8"), StandardCharsets.ISO_8859_1) + "\"");
        } else {
            response.addHeader("Content-Disposition", "attachment;filename=\"" +
                    URLEncoder.encode(substring, "UTF-8") + "\"");
        }
        response.setContentType("multipart/form-data");
        response.setHeader("Accept-Ranges", "bytes");
        int fileLength = (int) file.length();
        response.setContentLength(fileLength);
        byte[] buf = new byte[1024];
        try (InputStream inStream = new FileInputStream(file);
             ServletOutputStream outputStream = response.getOutputStream()) {
            int readLength;
            while (((readLength = inStream.read(buf)) != -1)) {
                outputStream.write(buf, 0, readLength);
            }
            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
