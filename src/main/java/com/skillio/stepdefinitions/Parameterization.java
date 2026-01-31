package com.skillio.stepdefinitions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.skillio.utils.ExcelUtil;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Parameterization {

	int num1, num2, result = 0;
	String fruit;
	int qty;
	List<String> fruits;
	Map<String, List> fruitData;

	
	@Given("I have {byte} and {byte}")
	public void acceptTwoNumbers(byte x, byte y) {
		num1 = x;
		num2 = y;
	}

	@When("I add them")
	public void addNumbers() {
		result = num1 + num2;
	}

	@Then("print the result")
	public void printResult() {
		System.out.println("Result: " + result);
	}

	@Given("I have {string}")
	public void getFruit(String fruit) {
		this.fruit = fruit;
	}

	@Then("print the fruit name")
	public void printFruitName() {
		System.err.println("Fruit: " + fruit);
	}

	@Given("I have following fruits:")
	public void getListOfFruits(List<String> fruits) {
		this.fruits = fruits;
	}

	@Then("display the list")
	public void displayFruits() {
		System.out.println("========List of Fruits=======");
		for (String fruit : fruits) {
			System.out.println(fruit);
		}
	}

	@Given("I have following fruit data:")
	public void getFruitData(DataTable dt) {
		Map<String, List> fruitData = dt.asMap(String.class, List.class);
		this.fruitData = fruitData;
	}

	@Then("print the fruit data")
	public void printFruitData() {
		for (Entry<String, List> e : fruitData.entrySet()) {
			String fruitName = e.getKey();
			List list = e.getValue();
			System.out.print(fruitName+"\t");
			for (Object item : list) {
				System.out.print(item+"\t");
			}
			System.out.println();
			System.out.println("-----------------------");
		}
	}
	
	@Given("I have following fruite data from excel")
	public void getFruitDataFromExcel() {
		String filePath =  "/Users/avinashpingale/Documents/Daffodil25A/fruitdata.xlsx";
		Object[][] data = ExcelUtil.getDataStartingFromRow(filePath, "data", 1);
		fruitData = new HashMap<String, List>();
		for (Object[] row : data) {
			String fruitName = (String) row[1];
			List<Object> attributes = new ArrayList<>();
			for (int i = 1; i < row.length; i++) {
				attributes.add(row[i]);
			}
			fruitData.put(fruitName, attributes);	
		}
		
	}
	
	@Given("I have {string} and its {int}")
	public void getFruits(String fruitName, int qty) {
		fruit = fruitName;
		this.qty = qty;
		System.out.println("Hellooooooooo");
	}
	
	@Given("Read data from row {int} from excel")
	public void getRowData(int rowNum) {
		String baseDir = System.getProperty("user.dir");
		System.out.println("==========data from excel=============");
		String filePath = "/src/test/resources/TestData/fruitdata.xlsx";
		List data =ExcelUtil.getRowData(baseDir+filePath, "data", rowNum);
 		fruit = (String)data.get(1);
 		double quantityIndbl =  (double)data.get(2);
 		qty = (int)quantityIndbl;
	}
	@Then("print single fruit info")
	public void printSingleFruitInfo() {
		System.out.println("There are "+qty+" "+fruit+" in basket");
	}
}
