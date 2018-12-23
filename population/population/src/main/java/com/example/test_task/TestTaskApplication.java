package com.example.test_task;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class TestTaskApplication {

    public static void main(String[] args) {


        SpringApplication sa = new SpringApplication(TestTaskApplication.class);
        sa.setBannerMode(Banner.Mode.OFF);
        sa.setLogStartupInfo(false);

        ApplicationContext c = sa.run(args);
        MyController bean = c.getBean(MyController.class);
        bean.getCountries();
        bean.withoutCopy();
        bean.getAscByPopNumber();
        bean.createExcelFile();

    }

}

