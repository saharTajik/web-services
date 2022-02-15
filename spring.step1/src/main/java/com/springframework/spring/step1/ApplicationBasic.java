package com.springframework.spring.step1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.springframework.spring.step1.basic.BinarySearchImpl;

//@SpringBootApplication
@Configuration
@ComponentScan
public class ApplicationBasic {

	public static void main(String[] args) {
		// we can choose between two algorithm in here easily in this way
		/*	BinarySearchImpl binarySearchImple = new BinarySearchImpl(new QuickSortAlgorithm());
			BinarySearchImpl bubbleSortAlgorithm = new BinarySearchImpl(new BubbleSortAlgorithm());
			int result = binarySearchImple.binarySearch(new int []{12 ,4,6}, 3 );
		*/
		// but with using applicationContext , we can use getBean instead of above way but just BubbleSortAlgorithm and BinarySearchImpl has @Component 
		
		/*ApplicationContext context = SpringApplication.run(ApplicationBasic.class, args);*/  // for spring boot
		try(AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationBasic.class)){  // for Spring Core without spring boot
			BinarySearchImpl binarySearch =  context.getBean(BinarySearchImpl.class);
			
			System.out.print(binarySearch.binarySearch(new int []{12 ,4,6}, 3 ));
			System.out.print(binarySearch);
			context.close();
		}
	}

}
