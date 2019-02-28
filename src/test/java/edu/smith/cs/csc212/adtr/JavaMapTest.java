package edu.smith.cs.csc212.adtr;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import edu.smith.cs.csc212.adtr.real.JavaMap;

public class JavaMapTest 
{
	void assertIntEq(int x, int y)
	{
		assertEquals(x, y);
	}

	@Test
	public void testEmpty() 
	{
		MapADT<String, Integer> empty = new JavaMap<>();
		assertEquals(empty.size(), 0);
	}
	
	@Test
	public void testPut()
	{
		MapADT<String, Integer> abc = new JavaMap<>();
		abc.put("a", 1);
		abc.put("b", 2);
		abc.put("c", 3);
		assertEquals(abc.size(), 3);
	}
	
	@Test
	public void testPutRepeated()
	{
		MapADT<String, Integer> abc = new JavaMap<>();
		abc.put("a", 1);
		abc.put("a", 1);
		abc.put("a", 1);
		assertEquals(abc.size(), 1);
	}
	
	@Test
	public void testGet()
	{
		MapADT<String, Integer> abc = new JavaMap<>();
		abc.put("a", 1);
		assertIntEq(abc.get("a"), 1);
	}
	
	@Test
	public void testRemove()
	{
		MapADT<String, Integer> abc = new JavaMap<>();
		abc.put("a", 1);
		abc.remove("a");
		assertEquals(abc.size(), 0);
	}
	
	@Test
	public void testGetKeys()
	{
		MapADT<String, Integer> abc = new JavaMap<>();
		abc.put("a", 1);
		abc.put("b", 2);
		abc.put("c", 3);
		assertEquals(abc.size(), abc.getKeys().size());
	}
	
	@Test
	public void testGetEntries()
	{
		MapADT<String, Integer> abc = new JavaMap<>();
		abc.put("a", 1);
		abc.put("b", 2);
		abc.put("c", 3);
		assertEquals(abc.size(), abc.getEntries().size());
	}
	
	@Test
	public void testToJava() 
	{
		MapADT<String, Integer> abc = new JavaMap<>();
		abc.put("a", 1);
		abc.put("b", 2);
		abc.put("c", 3);
		List<String> abcList = Arrays.asList("a", "b", "c");
		assertEquals(abc.toJava().size(), abcList.size());
	}
}
