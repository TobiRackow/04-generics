package de.fhro.inf.prg3.a04.tests;

import de.fhro.inf.prg3.a04.collections.SimpleFilter;
import de.fhro.inf.prg3.a04.collections.SimpleList;
import de.fhro.inf.prg3.a04.collections.SimpleListImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author Peter Kurfer
 * Created on 10/6/17.
 */
public class SimpleListTests {

	private final Logger logger = LogManager.getLogger();
	private SimpleList<Integer> testList;

	@BeforeEach
	void setup(){
		testList = new SimpleListImpl<>();

		testList.add(1);
		testList.add(2);
		testList.add(3);
		testList.add(4);
		testList.add(5);
	}

	@Test
	void testAddElements(){
		logger.info("Testing if adding and iterating elements is implemented correctly");
		int counter = 0;
		for(Object o : testList){
			counter++;
		}
		assertEquals(5, counter);
	}

	@Test
	void testSize(){
		logger.info("Testing if size() method is implemented correctly");
		assertEquals(5, testList.size());
	}

	@Test
	void testFilterAnonymousClass(){
		logger.info("Testing the filter possibilities by filtering for all elements greater 2");
		SimpleList<Integer> result = testList.filter(new SimpleFilter<Integer>() {
			@Override
			public boolean include(Integer item) {
				return item > 2;
			}
		});

		for(Integer o : result){
			assertTrue(o > 2);
		}
	}

	@Test
	void testFilterLambda(){
		logger.info("Testing the filter possibilities by filtering for all elements which are dividable by 2");
		SimpleList<Integer> result = testList.filter(o -> (o) % 2 == 0);
		for(Integer o : result){
			assertTrue(o % 2 == 0);
		}
	}
}