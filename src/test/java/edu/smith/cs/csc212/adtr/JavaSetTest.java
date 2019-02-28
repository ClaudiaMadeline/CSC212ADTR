package edu.smith.cs.csc212.adtr;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import edu.smith.cs.csc212.adtr.real.JavaList;
import edu.smith.cs.csc212.adtr.real.JavaSet;

public class JavaSetTest 
{
	
	@Test
	public void testEmpty() 
	{
		SetADT<String> empty = new JavaSet<>();
		assertEquals(empty.size(), 0);
	}
	
	@Test
	public void testInsert()
	{
		SetADT<String> abc = new JavaSet<>();
		abc.insert("a");
		abc.insert("b");
		abc.insert("c");
		assertEquals(abc.size(), 3);
	}
	
	@Test
	public void testInsertRepeated()
	{
		// add "a" 3x and make sure size is 1!
		SetADT<String> abc = new JavaSet<>();
		abc.insert("a");
		abc.insert("a");
		abc.insert("a");
		assertEquals(abc.size(), 1);
	}
	
	@Test
	public void testContains()
	{
		SetADT<String> abc = new JavaSet<>();
		abc.insert("a");
		assertTrue(abc.contains("a"));
	}
	
	@Test
	public void testRemove()
	{
		SetADT<String> abc = new JavaSet<>();
		abc.insert("a");
		abc.remove("a");
		assertFalse(abc.contains("a"));
	}
	
	@Test
	public void testToList()
	{
		SetADT<String> abc = new JavaSet<>();
		abc.insert("a");
		abc.insert("b");
		abc.insert("c");
		ListADT<String> data = new JavaList<>();
		data.addBack("a");
		data.addBack("b");
		data.addBack("c");
		//ListADT<String> abcList = Arrays.asList("a", "b", "c");
		assertEquals(abc.toList().getIndex(0), data.getIndex(0));
		assertEquals(abc.toList().getIndex(1), data.getIndex(1));
		assertEquals(abc.toList().getIndex(2), data.getIndex(2));
	}
	
	@Test
	public void testToJava() 
	{
		SetADT<String> abc = new JavaSet<>();
		abc.insert("a");
		abc.insert("b");
		abc.insert("c");
		List<String> data = Arrays.asList("a", "b", "c");
		assertEquals(abc.toJava().size(), data.size());
	}
}
