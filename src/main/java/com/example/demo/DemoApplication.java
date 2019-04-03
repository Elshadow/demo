package com.example.demo;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		// System.out.println("fuck you");
		SpringApplication.run(DemoApplication.class, args);
		// int[] arr = { 1, 2, 3, 4, 5 };
		// System.out.println(arr[0]);
		// change(arr);
		// System.out.println(arr[0]);
	}

	public static void change(int[] array) {
		// 将数组的第一个元素变为0
		array[0] = 0;
	}

	// @Bean
    // public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
    //     return args -> {

    //         System.out.println("Let's inspect the beans provided by Spring Boot:");

    //         String[] beanNames = ctx.getBeanDefinitionNames();
    //         Arrays.sort(beanNames);
    //         for (String beanName : beanNames) {
    //             System.out.println(beanName);
    //         }

    //     };
    // }

}
