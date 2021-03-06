package com.zuma.smssender.util;

import com.zuma.smssender.config.Config;
import com.zuma.smssender.enums.PhoneOperatorEnum;
import com.zuma.smssender.enums.error.ErrorEnum;
import com.zuma.smssender.exception.SmsSenderException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

/**
 * author:Administrator
 * datetime:2017/11/8 0008 13:36
 * 手机号工具类
 */
@Slf4j
public class PhoneUtil {
    /**
     * 根据手机号判断其运营商
     */
    public static PhoneOperatorEnum[] getPhoneOperator(String... phones){
        //返回数组
        PhoneOperatorEnum[] result = new PhoneOperatorEnum[phones.length];
        for (int i=0 ;i < phones.length; i++){
            // 责任链模式...
            //如果匹配
            result[i] = RegexpUtil.yidongMatch(phones[i]) ? PhoneOperatorEnum.YIDONG :
                    RegexpUtil.liantongMatch(phones[i]) ? PhoneOperatorEnum.LIANTONG :
                            RegexpUtil.dianxinMatch(phones[i]) ? PhoneOperatorEnum.DIANXIN :
                                    PhoneOperatorEnum.UNKNOWN;
            //如果运营商未知
            if(result[i].equals(PhoneOperatorEnum.UNKNOWN)){
                log.error("【根据手机号判断运营商】运营商未知。phone={}",phones[i]);
                throw new SmsSenderException(ErrorEnum.PHONE_UNKNOWN);
            }
        }
        return result;
    }

    /**
     * 提取手机号中某个运营商的所有号码
     */
    public static String getPhonesByOperator(String phone,PhoneOperatorEnum phoneOperatorEnum) {
        //切割为数组
        String[] phones = StringUtils.split(phone, Config.PHONES_SEPARATOR);
        //获取每个手机号对应的运营商数组--这样方法复用只是写的方便，效率稍低
        PhoneOperatorEnum[] phoneOperators = getPhoneOperator(phones);
        //返回
        StringBuilder result = new StringBuilder();
        //循环运营商数组
        for (int i = 0; i < phoneOperators.length; i++) {
            //如果该手机运营商和指定的相同，加入返回值
            if(phoneOperators[i].equals(phoneOperatorEnum)){
                result.append(phones[i]).append(Config.PHONES_SEPARATOR);
            }
        }
        //去除最后一个逗号
        result = result.delete(result.length()-1, result.length());
        return result.toString();
    }
}
