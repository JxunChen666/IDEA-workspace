package com.eb.test;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;



@ServletComponentScan
@MapperScan({"com.eb.test.MapperDao","com.eb.test.utilMapperDao"})
@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);	
	}
	
	/**
     * 
    * @Title: serverEndpointExporter  
    * @Description: 检测服务类实现
    * @return ServerEndpointExporter 
    * @throws
     */
    @Bean
    public ServerEndpointExporter serverEndpointExporter (){
        return new ServerEndpointExporter();
    }
}
