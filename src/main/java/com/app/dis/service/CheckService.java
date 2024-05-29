package com.app.dis.service;

import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Random;

@Service
public class CheckService {

//    인증번호 발송
    public String sendCertificationNumber(String phoneNumber){
        String apiKey = "";
        String apiSecret = "";
        String fromNumber = "";
        String code = "";

        Random random = new Random();

        for (int i = 0; i < 4; i++) {
            code += random.nextInt(10);
        }
        Message coolsms = new Message(apiKey, apiSecret);

        HashMap<String, String> params = new HashMap<>();
        params.put("to", phoneNumber);
        params.put("from", fromNumber);
        params.put("type", "sms");
        params.put("text", "[DIS] 인증번호 "+ code +" 를 입력하세요.");
        params.put("app_version", "test app 1.2"); // application name and version

        try {
            JSONObject obj = coolsms.send(params);
            System.out.println(obj.toString());
        } catch (CoolsmsException e) {
            System.out.println(e.getMessage());
            System.out.println(e.getCode());
        }
        return code;
    }
}
