package com.wgh.spring.cloud.config.nacos.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
@RequestMapping("/config/test")
public class ConfigTestController {

    @Value("${test.native.config}")
    private String testNativeConfig;
    @Value("${test.nacos.config}")
    private String testNacosConfig;

    @Value("${test.nacos.common1.config}")
    private String testNacosCommon1Config;
    @Value("${test.nacos.common2.config}")
    private String testNacosCommon2Config;

    @Value("${test.native.encrypt.text}")
    private String testNativeEncryptText;

    @Value("${test.nacos.common1.config.encrypt.text}")
    private String testNacosCommon1ConfigEncryptText;
    
    @RequestMapping("/getTestNativeConfig")
    @ResponseBody
    public String getTestNativeConfig() {
        return testNativeConfig;
    }

    @RequestMapping("/getTestNacosConfig")
    @ResponseBody
    public String getTestNacosConfig() {
        return testNacosConfig;
    }

    @RequestMapping("/getTestNacosCommon1Config")
    @ResponseBody
    public String getTestNacosCommon1Config() {
        return testNacosCommon1Config;
    }

    @RequestMapping("/getTestNacosCommon2Config")
    @ResponseBody
    public String getTestNacosCommon2Config() {
        return testNacosCommon2Config;
    }

    @RequestMapping("/getTestNativeEncryptText")
    @ResponseBody
    public String getTestNativeEncryptText() {
        return testNativeEncryptText;
    }
    
    @RequestMapping("/getTestNacosCommon1ConfigEncryptText")
    @ResponseBody
    public String getTestNacosCommon1ConfigEncryptText() {
        return testNacosCommon1ConfigEncryptText;
    }

}
