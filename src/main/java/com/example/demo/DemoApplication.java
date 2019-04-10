package com.example.demo;

import java.util.Arrays;

import com.example.demo.vo.Echo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@ServletComponentScan
public class DemoApplication {

	public static void main(String[] args) {
		// System.out.println("fuck you");
		SpringApplication.run(DemoApplication.class, args);
		// int[] arr = { 1, 2, 3, 4, 5 };
		// System.out.println(arr[0]);
		// change(arr);
		// System.out.println(arr[0]);
		// Echo s1 = new Echo(1, "小张");
		// Echo s2 = new Echo(2, "小李");
		// swap(s1, s2);
		// System.out.println("s1:" + s1.getContent() + System.identityHashCode(s1));
		// System.out.println("s2:" + s2.getContent() + System.identityHashCode(s2));
	}

	public static void change(int[] array) {
		// 将数组的第一个元素变为0
		array[0] = 0;
	}

	public static void swap(Echo x, Echo y) {
		Echo temp = x;
		x = y;
		y = temp;
		System.out.println("x:" + x.getContent() + System.identityHashCode(x));
		System.out.println("y:" + y.getContent() + System.identityHashCode(y));
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
