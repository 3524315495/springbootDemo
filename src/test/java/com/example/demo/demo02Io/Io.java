package com.example.demo.demo02Io;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/**
 * 文件名：
 * 版权：Copyright 2017-2022 CMCC ALL Right Reserved.
 * 描述：
 */
@SpringBootTest
public class Io {
    static int i = 0;

    @Test
    public void test01() {
        //遍历C:\Windows下所有文件夹和文件
        File file = new File("D:\\sql优化");
        File[] files = file.listFiles();
        readFile(files);
        System.out.println(i);
    }

    @Test
    void test02() {
        try {
            //准备文件lol.txt其中的内容是AB，对应的ASCII分别是65 66
            File f = new File("d:/lol.txt");
            //创建基于文件的输入流
            FileInputStream fis = new FileInputStream(f);
            //创建字节数组，其长度就是文件的长度
            byte[] all = new byte[(int) f.length()];
            //以字节流的形式读取文件所有内容
            fis.read(all);
            for (byte b : all) {
                //打印出来是65 66
                System.out.println(b);
            }

            //每次使用完流，都应该进行关闭
            fis.close();

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Test
    public void copyFile() throws IOException {
        String s1 = "D:\\install\\tomcat9\\apache-tomcat-9.0.37\\apache-tomcat-9.0.37\\cmcc\\ccx.docx";
        String s2 = "D:\\install\\tomcat9\\apache-tomcat-9.0.37\\apache-tomcat-9.0.37\\cmcc\\666.docx";
        File file = new File(s1);
        System.out.println(file.getPath());
        File file1 = new File(s2);
        boolean b = file1.renameTo(file);
        System.out.println(b);

    }

    private void readFile(File[] file) {
        for (File file1 : file) {
            if (file1.isDirectory()) {
                ++i;
                System.out.println("文件夹名" + file1);
                File[] files = file1.listFiles();
                if (files != null) {
                    readFile(files);
                }
            } else {
                System.out.println("文件名" + file1.getName());
//                break;
            }
        }
    }

    @Test
    public void code() throws UnsupportedEncodingException {
        String s = "汉得信息.docx";
        System.out.println(s.substring(s.lastIndexOf(".")));
        byte[] bytes = s.getBytes("UTF-8");
        System.out.println(bytes);
        String s1 = new String(bytes, "iso-8859-1");
        System.out.println(s1);
    }

    /**
     * 解压文件
     */
    @Test
    public void zipFile() throws IOException {
        String filePath = "D:\\cmcc\\mftdir\\MFTT\\HQ_ERPtoRBS_HQ\\MftXfeArchiveFileSrv\\VF_GD_APL_0001_C1015C0A3BB448EBE05400144FFBEBD9.zip";
        String toFilePath = "D:\\测试用例\\ccx";
        ZipFile zipFile = new ZipFile(filePath);
        Enumeration<? extends ZipEntry> entries = zipFile.entries();
        while (entries.hasMoreElements()) {
            ZipEntry zipEntry = entries.nextElement();
            int index = zipEntry.getName().lastIndexOf(File.separator);
            String filePath1 = zipEntry.getName().substring(0, index);
            String fileName = zipEntry.getName().substring( index);
            if (!zipEntry.isDirectory()) {
                File unzipPath = new File(toFilePath + "\\" +
                        filePath1);
                if (!unzipPath.exists()) {
                    unzipPath.mkdirs();
                }
                unzipPath.setWritable(true, true);
                try (InputStream inputStream = zipFile.getInputStream(zipEntry);
                     FileOutputStream os = new FileOutputStream(unzipPath + "\\" + fileName)) {
                    int length = 0;
                    byte[] bytes = new byte[1024];
                    while ((length = inputStream.read(bytes)) != -1) {
                        os.write(bytes, 0, length);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
