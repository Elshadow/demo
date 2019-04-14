package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import com.example.demo.designpatterns.builderpattern.Meal;
import com.example.demo.designpatterns.builderpattern.MealBuilder;
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
		// System.out.println("meta number is " + findMetaNumber(9, 1));
		// List<String> list = new ArrayList<String>();
		// list.add("a");
		// list.add("b");
		// for (int i = 0; i < list.size(); i++) {
		// 	String str = (String) list.get(i);
		// 	System.out.println("output str " + str);
		// }
		// MealBuilder mBuilder = MealBuilder.getInstance();

		Meal vegMeal = MealBuilder.INSTANCE.prepareVegMeal();
		System.out.println("Veg Meal");
      	vegMeal.showItems();
		System.out.println("Total Cost: " + vegMeal.getCost());

		Meal nonVegMeal = MealBuilder.INSTANCE.prepareChickenMeal();
		System.out.println("\n\nChicken Meal");
		nonVegMeal.showItems();
		System.out.println("Total Cost: " + nonVegMeal.getCost());
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

	/**
	 * 假设初始水果初始数目为1个，每次操作后数目变为原来的2n+2个个数
	 * 递归返回执行特定次数后拥有的水果数目
	 * @param cnt 运算次数
	 * @param initValue 初始值
	 * @return 执行结果
	 */
	public static int findMetaNumber(int cnt, int initValue) {
		if (cnt == 0) {
			return initValue;
		} else {
			return findMetaNumber(cnt - 1, 2 * initValue + 2);
		}
	}

	/**
	 * 高效算法取字符串中第一次出现重复字符的字符
	 * @return 执行结果
	 */
	public static char findFirstMatchChar(String str) {
		if (str == null || str.isBlank()) {
			return '~';
		}
		// 遍历所有字符，存储至HashMap中
		HashMap<String, Boolean> map = new HashMap<>();
		char[] charArray = str.toCharArray();
		for (char c : charArray) {
			map.put(String.valueOf(c), true);
		}
		for (String key : map.keySet()) {
			int cnt = 0;
			for (char c : charArray) {
				if (String.valueOf(c).equals(key)) {
					cnt++;
					if (cnt == 2) return c;
				}
			}
		}
		return '~';
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
