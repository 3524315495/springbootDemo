package com.example.demo.demoOther;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.HashMap;

/**
 * 文件名：
 * 版权：Copyright 2017-2022 CMCC ALL Right Reserved.
 * 描述：
 */
public class Test1 {
    @Test
    public void test01() {
        Person p = ret(3);
        if (p == null) System.out.println("为空");
    }

    @Test
    public void test02() {
        int i = 1;
        int j = 0;
        try {
            System.out.println(i / j);
        } catch (ArithmeticException e) {
            System.out.println("!!!");
            throw e;
        }
        System.out.println("???");
    }

    @Test
    public void test04() {
        for (int i = 0; i < 10; i++) {
            if (i == 5) continue;
            System.out.println(i);
        }
    }

    private Person ret(int a) {
        if (a > 2) {
            return new Person();
        }
        return null;
    }

//    private String[] retrieveGroupAndKey(String key) {
//        String group = "zh_CN";
//        String str = ".";
//        if (key != null && key.indexOf(str) != -1) {
//            group = StringUtils.substringAfterLast(key, str);
//            key = StringUtils.substringBeforeLast(key, str);
//        }
//        return new String[] { group, key };
//    }
//    filingStatusData=CMF_AF_FILING_STATUS&systemNameData=CMF_AF_VOUCHER_SOURCE_SYSTEM&voucherJeSource=CMF_AF_VOUCHER_JE_SOURCE&scanStatusData=CMF_AF_SCAN_STATUS&yesNoData=SYS.YES_NO&&glSerialNumData=CMF_AF_GL_SERIAL_NUM&sectionStatusData=CMF_AF_FILING_STATUS&pageData=CMF_AF_IS_HAVE_PAPER

    @Test
    public void test5() {
        String s = "2020-12";
//        System.out.println(s.replace("-", ""));
        System.out.println(s.substring( 2));
        String s1=  "123456";
        StringBuilder builder = new StringBuilder("000");
        System.out.println(builder.append(s1, 0, 2));
    }

    @Test
    public void test6(){
        File file = new File("D:\\测试用例\\53452345.docx");
        System.out.println(file.renameTo(new File("D:\\测试用例\\53452345.docx")));
    }

    @Test
    public void test7(){
        HashMap<String, String> map = new HashMap<>();
        System.out.println(map.containsKey("s"));
        map.put("s", "s");
        boolean equals = map.get("s").equals("s");
        System.out.println(equals);
    }

}
