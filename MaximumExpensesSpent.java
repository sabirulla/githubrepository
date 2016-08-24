package org.sabi.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

/**
 * Get maximum expenses spend by Person
 * using Hashmap
 * @author SABIRULLA
 *
 */
public class MaximumExpensesSpent {

	public static void main(String args[]){

		List<Person> employeeList = new ArrayList<Person>();


		Person person = new Person();
		person.setId(101);
		person.setExpenses(500);

		Person person1 = new Person();
		person1.setId(102);
		person1.setExpenses(200);

		Person person2 = new Person();
		person2.setId(103);
		person2.setExpenses(1000);

		Person person3 = new Person();
		person3.setId(101);
		person3.setExpenses(800);

		Person person4 = new Person();
		person4.setId(300);
		person4.setExpenses(300);

		employeeList.add(person);
		employeeList.add(person1);
		employeeList.add(person2);
		employeeList.add(person3);
		employeeList.add(person4);

		findMaxExpenses(employeeList);
	}

	public static void findMaxExpenses(List<Person> employeeList)
	{
		HashMap<Integer, Integer> employeeExpensesMap = new HashMap<Integer, Integer>();
		for(Person person:employeeList)
		{
			if(employeeExpensesMap.containsKey(person.getId()))
			{
				Integer expensesAmount = person.getExpenses();
				Integer previousExpenses = employeeExpensesMap.get(person.getId());
				Integer totalExpensesAmount = expensesAmount+previousExpenses;
				employeeExpensesMap.put(person.getId(), totalExpensesAmount);
			}else{
				employeeExpensesMap.put(person.getId(), person.getExpenses());
			}
		}
		System.out.println("employeeExpensesMap:::"+employeeExpensesMap);
		int maxValueInMap=(Collections.max(employeeExpensesMap.values())); 
		for (Entry<Integer, Integer> entry : employeeExpensesMap.entrySet()) {  // Itrate through hashmap
			if (entry.getValue()==maxValueInMap) {
				System.out.println("PesonID "+entry.getKey()+" Max Expenses "+entry.getValue());     // Print the key with max value
			}
		}
	}
}
class Person{

	private int id;
	private int expenses;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getExpenses() {
		return expenses;
	}
	public void setExpenses(int expenses) {
		this.expenses = expenses;
	}





}