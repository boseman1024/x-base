package com.axisx.xureport2;

import com.bstek.ureport.console.UReportServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:ureport-console-context.xml")
public class XUreport2Application {

    public static void main(String[] args) {
        SpringApplication.run(XUreport2Application.class, args);
    }

    @Bean
    public ServletRegistrationBean ureportServlet(){
        return new ServletRegistrationBean(new UReportServlet(),"/ureport/*");
    }
}
