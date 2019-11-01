package com.example.demo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

import com.example.demo.designpatterns.builderpattern.Meal;
import com.example.demo.designpatterns.builderpattern.MealBuilder;
import com.example.demo.threads.CallableThread;
import com.example.demo.threads.RunnableThread;
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
		int[] arr = { 1, 2, 3, 4, 5 };
		System.out.println(arr[0]);
		change(arr);
		System.out.println(arr[0]);
		Echo s1 = new Echo(1, "小张");
		Echo s2 = new Echo(2, "小李");
		swap(s1, s2);
		System.out.println("s1:" + s1.getContent() + System.identityHashCode(s1));
		System.out.println("s2:" + s2.getContent() + System.identityHashCode(s2));
		System.out.println("meta number is " + findMetaNumber(9, 1));
		List<String> list = new ArrayList<String>();
		list.add("a");
		list.add("b");
		for (int i = 0; i < list.size(); i++) {
			String str = (String) list.get(i);
			System.out.println("output str " + str);
		}
		// MealBuilder mBuilder = MealBuilder.getInstance();

		Meal vegMeal = MealBuilder.INSTANCE.prepareVegMeal();
		System.out.println("Veg Meal");
      	vegMeal.showItems();
		System.out.println("Total Cost: " + vegMeal.getCost());

		Meal nonVegMeal = MealBuilder.INSTANCE.prepareChickenMeal();
		System.out.println("\n\nChicken Meal");
		nonVegMeal.showItems();
		System.out.println("Total Cost: " + nonVegMeal.getCost());

		System.out.println(reverse("abc"));

		new Thread(() -> {
			LinkedList<String> linkList = new LinkedList<String>();
			linkList.add("element 1");
			linkList.add("element 2");
			System.out.println("this a new thread " + linkList.get(1));
		}, "CommonThread").start();

		RunnableThread runnableThread =  new RunnableThread();
		new Thread(runnableThread, "RunnableThread1").start();

		CallableThread callableThread = new CallableThread();
		FutureTask<String> task = new FutureTask<>(callableThread);
		new Thread(task, "CallableThread").start();

		System.out.println("current thread is " + Thread.currentThread().getName());

		System.out.println("1 has repeat value " + hasRepeatValue(new int[]{1, 2, 3, 4}));

		System.out.println("2 has repeat value " + hasRepeatValue(new int[]{1, 2, 3, 1}));

		// 线程池方式创建线程
		int processorsCnt = Runtime.getRuntime().availableProcessors(); // 获取当前设备的处理器核心数
		final int THREAD_NUMBER = processorsCnt * 2;
		ExecutorService service = Executors.newFixedThreadPool(THREAD_NUMBER); // 潜规则开线程的数目为核心数的2倍
		for (int i = 0; i < THREAD_NUMBER; i++) {
			final int num = i;
			service.execute(new Runnable(){
				@Override
				public void run() {
					System.out.println("thread [" + num + "] which is created by thread pool");
				}
			});
		}

		Integer i1 = Integer.valueOf(1);
		Integer i2 = Integer.valueOf(1);
		Integer i3 = new Integer(1);
		Integer i4 = new Integer(2);
		Integer i5 = new Integer(2);
		System.out.println("1 dose two integer value equal " + (i1 == i2)); // true
		System.out.println("2 dose two integer value equal " + (i1 == i3)); // false
		System.out.println("3 dose two integer value equal " + (i4 == i5)); // false

		List<Integer> li = new ArrayList<Integer>();
		li.add(1);
		li.add(2);
		li.add(3);
		li.add(4);
		System.out.println("list tostring return " + li);

		try {
			System.out.println("fuck a");
			File f = new File("test.txt");
			System.out.println(f.getAbsolutePath() + " dose exist " + f.exists());
			FileReader fileReader = new FileReader("resources/test.txt");
			System.out.println("fuck b");
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			LinkedList<Integer> lines = new LinkedList<>();
			String currentLine;
			int lineNumber = 1;
			while ((currentLine = bufferedReader.readLine()) != null) {
				if ("abc".equals(currentLine)) {
					lines.add(Integer.valueOf(lineNumber));
				}
				lineNumber++;
			}
			bufferedReader.close();
			System.out.println("match key lines is " + lines.toString());
		} catch (FileNotFoundException ioe) {
			//TODO: handle file not found exception
			System.out.println("target file not found");
		} catch (IOException e) {
			//TODO: handle exception
			System.out.println("thoow io exception");
		}
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
		if (str == null || str.isEmpty()) {
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

	public static String reverse(String str) {
		StringBuffer sb = new StringBuffer();
		if (str != null && !str.isEmpty()) {
			char[] charArray = str.toCharArray();
			for (int i = charArray.length - 1; i >= 0; --i) {
				// System.out.println("char index " + i);
				sb.append(charArray[i]);
			}
		} else {
			return null;
		}
		return sb.toString();
	}

	/**
	 * 遍历HashMap的几种方式
	 */
	public static void traverseHashMap () {
		HashMap<String, Object> map = new HashMap<>();
		// 使用迭代器的方式是效率最高的
        Iterator<Map.Entry<String, Object>> entries = map.entrySet().iterator();
        while (entries.hasNext()) {
            Entry<String, Object> entry = entries.next();
            String key = entry.getKey();
            Object object = entry.getValue();
		}

		for (String key : map.keySet()) {
			map.get(key);
		}

        for (Entry<String, Object> entry : map.entrySet()) {
            entry.getKey();
            entry.getValue();
        }
	}

	public static boolean hasRepeatValue (int[] array) {
		Set<Integer> set = new HashSet<Integer>();
		for (int var : array) {
			set.add(Integer.valueOf(var));
		}
		if (set.size() != array.length) {
			return true;
		} else {
			return false;
		}
	}

	@Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {

            System.out.println("Let's inspect the beans provided by Spring Boot:");

            String[] beanNames = ctx.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            for (String beanName : beanNames) {
                System.out.println(beanName);
            }

        };
    }

}
