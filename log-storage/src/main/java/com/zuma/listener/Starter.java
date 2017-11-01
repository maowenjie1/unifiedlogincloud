package com.zuma.listener;

import com.zuma.netty.LogServiceBootstrap;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * author:Administrator
 * datetime:2017/11/1 0001 09:24
 * 启动器，spring boot启动后执行
 */
@Component
@Order(1)
@Slf4j
public class Starter implements CommandLineRunner{


    @Override
    public void run(String... strings) throws Exception {
        LogServiceBootstrap.start();
    }
}