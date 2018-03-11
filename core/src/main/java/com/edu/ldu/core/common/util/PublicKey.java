package com.edu.ldu.core.common.util;


import com.edu.ldu.core.common.constant.Constants;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.security.interfaces.RSAPublicKey;
import java.util.HashMap;
import java.util.Map;

/**
 * 获取公钥
 *
 * @author yanmengjie
 * 2018/3/6
 */
public class PublicKey {


    public static HashMap<String, String> getPublicKey(HttpServletRequest httpServletRequest) {
        HashMap<String, String> publicKeyMap = new HashMap<>(4);
        try {
            Map<String, Object> keyMap = SecurityUtil.getKeyMap();
            RSAPublicKey publicKey = (RSAPublicKey) keyMap.get(Constants.PUBLIC_KEY);
            publicKeyMap.put(Constants.PUBLIC_KEY, RSAUtil.encryptBASE64(publicKey.getEncoded()));
            publicKeyMap.put(Constants.RANDOM_STR, (String) keyMap.get(Constants.RANDOM_STR));
            //将密钥和随机字符串绑定到session
            HttpSession session = httpServletRequest.getSession();
            session.setAttribute(Constants.PRIVATE_KEY, keyMap.get(Constants.PRIVATE_KEY));
            session.setAttribute(Constants.RANDOM_STR, keyMap.get(Constants.RANDOM_STR));

        } catch (Exception e) {

        }

        return publicKeyMap;
    }

}