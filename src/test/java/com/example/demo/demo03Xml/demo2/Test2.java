package com.example.demo.demo03Xml.demo2;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.StringReader;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * 文件名：
 * 版权：Copyright 2017-2022 CMCC ALL Right Reserved.
 * 描述：
 */
public class Test2 {

    private static ObjectMapper mapper = new ObjectMapper();

    private static String json = "{ \"brand\" : \"Mercedes\", \"doors\" : 4 }";

    private static String jsonArray = "[{\"brand\":\"ford\"}, {\"brand\":\"Fiat\"}]";

    private static String jsonMap = "{\n" +
            "  \"identification\" :  {\n" +
            "        \"name\" : \"James\",\n" +
            "        \"ssn: \"ABC123552\"\n" +
            "    }\n" +
            "}";

    String carJson =
            "{ \"brand\" : \"Mercedes\", \"doors\" : 5," +
                    "  \"owners\" : [\"John\", \"Jack\", \"Jill\"]," +
                    "  \"nestedObject\" : { \"field\" : \"value\" } }";


    /**
     * 使用ObjectMapper将json字符串转换为java对象.
     *
     * @throws JsonProcessingException
     */
    @Test
    public void test() throws IOException {
        Car car = mapper.readValue("{ \"brand\" : \"Mercedes\", \"doors\" : 5 }", Car.class);
        System.out.println(car.toString());
    }

    /**
     * 2、 ObjectMapper如何匹配JSON对象的字段和Java对象的属性
     * 默认情况下，Jackson通过将JSON字段的名称与Java对象中的getter和setter方法进行匹配，将JSON对象的字段映射到Java对象中的属性。
     * Jackson删除了getter和setter方法名称的“ get”和“ set”部分，并将其余名称的第一个字符转换为小写。
     *
     * 例如，名为brand的JSON字段与名为getBrand()和setBrand()的Java  getter和setter方法匹配。
     * 名为engineNumber的JSON字段将与名为getEngineNumber()和setEngineNumber()的getter和setter匹配。
     * 如果需要以其他方式将JSON对象字段与Java对象字段匹配，则需要使用自定义序列化器和反序列化器，或者使用一些Jackson注解。
     *
     */

    /**
     * 3、Json字符输入流--java对象
     */
    @Test
    public void test2() throws IOException {
        StringReader reader = new StringReader(json);

        Car car = mapper.readValue(reader, Car.class);
        System.out.println(car.toString());
    }

    /**
     * 读取文件中json字符串，转换成java对象
     */
    @Test
    public void test3() {
        File file = new File("D:\\测试用例\\JsonCar.txt");
        try (FileInputStream fis = new FileInputStream(file);) {
            Car car = mapper.readValue(fis, Car.class);
            System.out.println(car.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 二进制数组-->java对象
     */
    @Test
    public void test4() throws IOException {
        byte[] bytes = json.getBytes(StandardCharsets.UTF_8);
        Car car = mapper.readValue(bytes, Car.class);
        System.out.println(car.toString());
    }


    /**
     * 数组字符串-->java对象
     */
    @Test
    public void test5() throws IOException {
        Car[] car = mapper.readValue(jsonArray, Car[].class);
        System.out.println(car[0].toString());
    }

    /**
     * json数组字符串-->List
     */
    @Test
    public void test6() throws IOException {
        List<Car> cars = mapper.readValue(jsonArray, new TypeReference<List<Car>>() {
        });
        cars.stream().forEach(System.out::println);
        cars.stream().filter(e -> Objects.equals(e.getBrand(), "ford")).forEach(System.out::println);
    }

    /**
     * Json字符串-->map
     */
    @Test
    public void test7() throws IOException {
        Map<String, Object> map = mapper.readValue(json, new TypeReference<Map<String, Object>>() {
        });
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }

    /**
     * 忽略未知的json字段
     */
    @Test
    public void test8() {
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    /**
     * 不允许基本数据类型为null
     */
    @Test
    public void test9() throws IOException {
        mapper.configure(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES, true);
        String carJson = "{ \"brand\":\"Toyota\", \"doors\":null }";
        Car car = mapper.readValue(carJson, Car.class);//MismatchedInputException
        System.out.println(car.toString());
    }

    /**
     * 自定义反序化 addDeserializer
     */
    @Test
    public void test10() {
        SimpleModule module = new SimpleModule("CarDeserializer", new Version(3, 1, 8, null, null, null));
        module.addDeserializer(Car.class, new CarDeserializer(Car.class));
    }

    /**
     * 对象-->json
     */
    @Test
    public void test11() throws JsonProcessingException {
        Car car = new Car();
        car.setBrand("a");
        car.setDoors(4);
        String s = mapper.writeValueAsString(car);
        System.out.println(s);
    }

    /**
     * Date转Long
     */
    @Test
    public void test12() throws JsonProcessingException {
        Date date = new Date();
        Transaction transfer = new Transaction("transfer", date);
        String s = mapper.writeValueAsString(transfer);
        System.out.println(s);
    }

    /**
     * Date-->String
     */
    @Test
    public void test13() throws JsonProcessingException {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        mapper.setDateFormat(simpleDateFormat);

        Transaction transfer = new Transaction("transfer", date);
        String s = mapper.writeValueAsString(transfer);
        System.out.println(s);
    }

    /**
     * Json node 树模型
     */
    @Test
    public void test14() throws IOException {
        JsonNode jsonNode = mapper.readValue(json, JsonNode.class);
        JsonNode jsonNode2 = mapper.readTree(json);
        System.out.println(jsonNode);
    }


    /**
     * @throws IOException
     */
    @Test
    public void test15() throws IOException {
        JsonNode jsonNode = mapper.readValue(carJson, JsonNode.class);
        JsonNode brand = jsonNode.get("brand");
        System.out.println("brand  " + brand.asText());

        JsonNode doorsNode = jsonNode.get("doors");
        System.out.println("doors  " + doorsNode.asInt());

        JsonNode ownersNode = jsonNode.get("owners");
        JsonNode name = ownersNode.get(0);
        System.out.println("owners  " + name.asText());

        JsonNode nestedObject = jsonNode.get("nestedObject");
        JsonNode filed = nestedObject.get("filed");
        JsonNode value = nestedObject.get("value");
        System.out.println(filed.asText() + " " + value.asText());
    }

    /**
     * java对象-->json
     */
    @Test
    public void test16() {
        Car car = new Car();
        car.setBrand("sdf");
        car.setDoors(2);

        JsonNode jsonNode = mapper.valueToTree(car);
        System.out.println(jsonNode.get("brand").asText());
        System.out.println(jsonNode.get("doors").asText());
    }

    /**
     * json node-->java对象
     */
    @Test
    public void test17() throws IOException {
        JsonNode jsonNode = mapper.readValue(json, JsonNode.class);
        Car car = mapper.treeToValue(jsonNode, Car.class);
        System.out.println(car);
    }

    /**
     * json-->jsonNode
     */
    @Test
    public void test18() throws IOException {
        JsonNode tree = mapper.readTree(json);
        System.out.println(tree.get("brand").asText());
        System.out.println(tree.get("doors").asText());
    }


    /**
     * jsonNode-->json
     */
    @Test
    public void test19() throws IOException {
        JsonNode jsonNode = mapper.readTree(json);
        String s = mapper.writeValueAsString(jsonNode);
        System.out.println(s);
    }

    /**
     * 获取路径中的jsonNode字段
     */
    @Test
    public void test20() throws IOException {
        JsonNode jsonNode = mapper.readValue(jsonMap,JsonNode.class);
        JsonNode at = jsonNode.at("/identification/name");
        System.out.println(at.asText());
    }
}
