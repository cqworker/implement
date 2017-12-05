package com.test;

import com.approve.service.ApprovalService;
import com.approve.service.ApprovalServiceImpl;
import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONObject;

import java.util.List;

/**
 * Created by cq
 * date: 12/4 0004
 */
public class jsonPath {
    public static void main(String[]args) {
        String s = " { \"store\": {\n" +
                "   \"book\": [\n" +
                "    { \"category\": \"reference\",\n" +
                "      \"author\": \"Nigel Rees\",\n" +
                "      \"title\": \"Sayings of the Century\",\n" +
                "      \"price\": 8.95\n" +
                "    },\n" +
                "    { \"category\": \"fiction\",\n" +
                "      \"author\": \"Evelyn Waugh\",\n" +
                "      \"title\": \"Sword of Honour\",\n" +
                "      \"price\": 12.99\n" +
                "    },\n" +
                "    { \"category\": \"fiction\",\n" +
                "      \"author\": \"Herman Melville\",\n" +
                "      \"title\": \"Moby Dick\",\n" +
                "      \"isbn\": \"0-553-21311-3\",\n" +
                "      \"price\": 8.99\n" +
                "    },\n" +
                "    { \"category\": \"fiction\",\n" +
                "      \"author\": \"J. R. R. Tolkien\",\n" +
                "      \"title\": \"The Lord of the Rings\",\n" +
                "      \"isbn\": \"0-395-19395-8\",\n" +
                "      \"price\": 22.99\n" +
                "    }\n" +
                "  ],\n" +
                "    \"bicycle\": {\n" +
                "      \"color\": \"red\",\n" +
                "      \"price\": 19.95\n" +
                "    }\n" +
                "  }\n" +
                " }";
        String author = JsonPath.read(s, "$.store.book[0].author");
        System.out.println(author);

    }
}
