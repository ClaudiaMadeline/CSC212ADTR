package edu.smith.cs.csc212.adtr;

import java.util.List;

import edu.smith.cs.csc212.adtr.real.JavaMap;
import edu.smith.cs.csc212.adtr.real.JavaSet;

public class Challenges {

	// The union of two sets is the set of elements that either contains.
	public static SetADT<Integer> union(SetADT<Integer> left, SetADT<Integer> right) 
	{
		SetADT<Integer> output = new JavaSet<>();
		ListADT<Integer> leftList = left.toList();
		ListADT<Integer> rightList = right.toList();
		for(int i=0; i<left.size(); i++)
		{
			output.insert(leftList.getIndex(i));
		}
		for(int i=0; i<right.size(); i++)
		{
			output.insert(rightList.getIndex(i));
		}
		return output;
	}
	
	// The intersection of two sets is the set of elements that both contain.
	public static SetADT<Integer> intersection(SetADT<Integer> left, SetADT<Integer> right) 
	{
		SetADT<Integer> output = new JavaSet<>();
		ListADT<Integer> leftList = left.toList();
		ListADT<Integer> rightList = right.toList();
		if(left.size()>=right.size())
		{
			for(int i=0; i<right.size(); i++)
			{
				if(left.contains(rightList.getIndex(i)))
				{
					output.insert(rightList.getIndex(i));
				}
			}
		}
		else
		{
			for(int i=0; i<left.size(); i++)
			{
				if(right.contains(leftList.getIndex(i)))
				{
					output.insert(leftList.getIndex(i));
				}
			}
		}
		return output;
	}
	
	// Count the words in the input list and put them in the map.
	public static MapADT<String, Integer> wordCount(ListADT<String> words) 
	{
		MapADT<String, Integer> output = new JavaMap<>();
		for(int i=0; i<words.size(); i++)
		{
			int count = 1;
			for(int j=0; j<output.getEntries().size(); j++)
			{
				if(words.getIndex(i).equals(output.getEntries().getIndex(j).getKey()))
				{
					count++;
					output.getEntries().getIndex(j).setValue(count);
				}
			}
			if(count == 1)
			{
				output.put(words.getIndex(i), count);
			}
		}
		return output;
	}
}
