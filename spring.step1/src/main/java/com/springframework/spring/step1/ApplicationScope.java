package com.springframework.spring.step1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.springframework.spring.step1.scope.PersonDAO;

//@SpringBootApplication
@Configuration
@ComponentScan
public class ApplicationScope {
	
	private static Logger logger = LoggerFactory.getLogger(ApplicationScope.class);

	public static void main(String[] args) {
		// we can choose between two algorithm in here easily in this way
		/*	BinarySearchImpl binarySearchImple = new BinarySearchImpl(new QuickSortAlgorithm());
			BinarySearchImpl bubbleSortAlgorithm = new BinarySearchImpl(new BubbleSortAlgorithm());
			int result = binarySearchImple.binarySearch(new int []{12 ,4,6}, 3 );
		*/
		
		// but with using applicationContext , we can use getBean instead of above way but just BubbleSortAlgorithm and BinarySearchImpl has @Component
		try(AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationBasic.class)){  // for Spring Core without spring boot
			PersonDAO persDao =  context.getBean(PersonDAO.class);
			PersonDAO persDao2 =  context.getBean(PersonDAO.class);
			logger.info("{}" , persDao);
			logger.info("{}" , persDao2);
			
			logger.info("{}" , persDao.getJdbcConnection());
			logger.info("{}" , persDao2.getJdbcConnection());
			context.close();
		}
	}

}
