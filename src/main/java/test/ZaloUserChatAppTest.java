/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import com.google.gson.Gson;

/**
 *
 * @author thaonv
 */
public class ZaloUserChatAppTest {

    private static final Gson GSON = new Gson();

    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder("abc");
        String str = buildKey(sb);
        System.out.println(sb);
        System.out.println(str);
    }

    public static String buildKey(StringBuilder sb) {
        sb.delete(0, sb.length());
        sb.append("123");
        return sb.toString();
    }

}
