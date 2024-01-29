package unit_3_recur_sort;

public class BianMode {

	public static void main(String[] args) {
		String [] list = {"a", "pet", "chased", "after", "my", "pet", "rabbit"};
		int [] len = new int[list.length];
		int [] amount = new int[list.length];
		int [] amount2 = new int[list.length];
		int count = 0;
		int len1, len2;
		int place = 0;
		int mode = 0;

		selectSort(list);

		// make len list
		for (int i = 0; i < list.length; i++) {
			len[i] = list[i].length();
			System.out.print(len[i] + " ");
		}

		// print out sorted list
		for (int i = 0; i < list.length; i++) {
			System.out.print(list[i] + " ");
		}

		System.out.print("\nModal length: ");

		// create length occurences list
		for (int i = 1; i < list.length; i++) {
			len1 = list[i].length();
			len2 = list[i-1].length();

			// at a diff number
			if (len1 != len2) {
				amount[place] = count + 1;
				count = 0;
				place += 1;
			}
			// same number
			if (len1 == len2) {
				count += 1;
			}
		}
		// adding last occurence
		amount[place] = count + 1;

		// copy to other list
		for (int i = 0; i < amount.length; i++) {
			amount2[i] = amount[i];
		}

		selectSortInt(amount);

		// find mode
		for (int i = 1; i < amount.length; i++) {
			len1 = amount[i];
			len2 = amount[i-1];

			// different number
			if (len1 != len2) {
				mode = i;
				break;
			}
			else {
				mode = amount.length;
			}
		}

		// print
		for (int j = 0; j < amount2.length; j++) {
			if (amount2[j] == mode) {
				System.out.print(len[j+1] + " ");
			}
			
		}
	
	}

	/**
	 * selection sort for strings by length from small to big
	 * @param list
	 * @return
	 */
	private static String [] selectSort(String [] list) {
		String temp;

		for (int i = 0; i < list.length; i++) {
			for (int j = 0; j < list.length; j++) {
				if (list[j].length() > list[i].length()) {
					temp = list[i];
					list[i] = list[j];
					list[j] = temp;
				}
			}
		}

		return list;
	}

	/**
	 * selection sort for ints from big to small
	 * @param num
	 * @return
	 */
	private static int [] selectSortInt(int [] num) {
		int temp;

		for (int i = 0; i < num.length; i++) {
			for (int j = 0; j < num.length; j++) {
				if (num[j] < num[i]) {
					temp = num[i];
					num[i] = num[j];
					num[j] = temp;
				}
			}
		}

		return num;
	}

}
