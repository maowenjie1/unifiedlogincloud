package com.zuma.smssender.controller;

import com.zuma.smssender.dto.ResultDTO;
import com.zuma.smssender.form.SendSmsForm;
import com.zuma.smssender.service.SmsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * author:Administrator
 * datetime:2017/11/8 0008 09:49
 */
@RestController
@RequestMapping("/")
@Slf4j
public class ApiController extends BaseController{

    @Autowired
    private SmsService smsService;

    @PostMapping("/sendSms")
    public ResultDTO<?> sendSms(@Valid SendSmsForm sendSmsForm, BindingResult bindingResult){
        //参数基本校验
        isValid(bindingResult,log,"【API发送短信接口】参数校验失败.form={}",sendSmsForm);

        smsService.sendSms(sendSmsForm);
        return null;
    }

}