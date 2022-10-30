//package com.example.demo.demo03Xml.demo1;
//
//import com.fasterxml.jackson.dataformat.xml.JacksonXmlModule;
//import com.fasterxml.jackson.dataformat.xml.XmlMapper;
//
//import java.io.IOException;
//import java.io.InputStream;
//
///**
// * 文件名：
// * 版权：Copyright 2017-2022 CMCC ALL Right Reserved.
// * 描述：
// */
//public class Test {
//    @org.junit.jupiter.api.Test
//    public void test01() throws IOException {
//        InputStream inputStream = Test.class.getResourceAsStream("/book.xml");
//        JacksonXmlModule jacksonXmlModule = new JacksonXmlModule();
//        XmlMapper mapper = new XmlMapper(jacksonXmlModule);
//        Book book = mapper.readValue(inputStream, Book.class);
//        System.out.println(book.toString());
//    }
//}