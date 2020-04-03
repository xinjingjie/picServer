package com.xinjingjie.picServer;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.xinjingjie.picServer.mapper")
public class PicServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(PicServerApplication.class, args);
	}

}
