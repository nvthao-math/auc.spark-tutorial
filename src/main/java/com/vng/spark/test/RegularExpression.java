/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vng.spark.test;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import org.json.JSONObject;

/**
 *
 * @author thaonv
 */
public class RegularExpression {


    public static void main(String[] args) {
        String str = "{\"RxPktStat\":[0.0088,0,0],\"RxLossPer\":[40,70,160],\"RTT\":[80,130,495],\"JBuf\":[0,0,0,0,0],\"Network\":[1,1,0],\"EWMA\":[],\"Codec\":[\"opus/16000/1\",\"40\"],\"AdQ\":[\"0\"],\"RTPIP\":[\"103.245.247.137:4433\"],\"ImproveStat\":[],\"RxTotalPkt\":792,\"TxTotalPkt\":531,\"CallToken\":1598667304,\"InitZrtpDuration\":50,\"LastEchoRating\":4.8409,\"RxFecPkt\":0,\"TxFecPkt\":0,\"RecoverFecPkt\":0,\"FecType\":3,\"ChangeZRTP\":[],\"EchoData\":[],\"WarningPopup\":0,\"DynamicQuality\":[[8,0]],\"p2p\":{\"enable\":1,\"time\":[679,0,0,0],\"ip\":\"\",\"type\":0,\"status\":4,\"renegoConfig\":5,\"renegotiate\":[]},\"CallType\":0,\"SoundDev\":\"100\"}";
        JSONObject a = new JSONObject(str);
        System.out.println(a.get("CallType"));
        GsonBuilder b = new GsonBuilder();
//        b.set
    }

}
