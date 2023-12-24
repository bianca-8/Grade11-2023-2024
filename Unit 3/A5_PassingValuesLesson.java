package unit_3_recur_sort;

/**
 * Program that shows passing by value and reference.
 * @version Dec 11, 2023 
 */

public class A5_PassingValuesLesson {

	/**
	 * Pass in primitive variable (Passing by value)
	 * @param num - number
	 * @return number + 10
	 */
	public static int doSomething(int num) {
		num = num + 10;
		return num;
	}
	
	/**
	 * Pass in reference variable (Passing by reference)
	 * @param num - number
	 * @return number + 10
	 */
	public static A5_MyInteger doSomething(A5_MyInteger num) {
		num.setValue(num.getValue() + 10);
		return num;
	}
	
	public static void main(String[] args) {
		int temp = 5;
		A5_MyInteger temp2 = new A5_MyInteger(5);
		
		// pass in primitive variable
		System.out.println(doSomething(temp));
		System.out.println(temp);
		
		// pass in reference variable
		System.out.println(doSomething(temp2).getValue());
		System.out.println(temp2.getValue());
	}

}
