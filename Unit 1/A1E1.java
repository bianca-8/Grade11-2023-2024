package unit_1_OOP;

import java.util.*;

/**
 * Program that randomly chooses to draw one of three cats using methods.
 * @author Bianca
 * @version Oct 6, 2023
 */

public class A1E1 {

	public static void main(String[] args) {
		basketball();
		
	}
	
	public static void basketball() {
		// Variables
		int num;
		
		// Random
		Random generator = new Random();
		
		num = generator.nextInt(3);
		
		if (num == 0) {
			System.out.print("         __oooo\n"
					+ "       //  /    o\n"
					+ "     / /  |      o\n"
					+ "    | /  |__     o\n"
					+ "   | |   __/    o\n"
					+ "   | |  /  oooo\n"
					+ "  | /  |  _______________________\n"
					+ " | |   | |_______________________|\n"
					+ "||    |___ \\__/\\_/\\_/\\/\\/\\/\\/\\/\\/\n"
					+ "||    |    \\ \\/\\/\\/\\/\\/\\/\\/\\/\\/\n"
					+ "||    \\     \\ \\/\\/\\/\\/\\/\\/\\/\\/\n"
					+ "| |    |    |  \\/\\/\\/\\/\\/\\/\\/\n"
					+ " | |    |   |   \\/\\/\\/\\/\\/\\/\n"
					+ "  | |    \\_/    |\\/\\/\\/\\/\\/|\n"
					+ "   \\ \\     \\__  |/\\/\\/\\/\\/\\|\n"
					+ "    |         \\\n"
					+ "   |           |\n"
					+ "   |           |\n"
					+ "   |           |\n"
					+ "   |           |\n"
					+ "    |          |\n"
					+ "    |         |\n"
					+ "     |________|\n"
					+ "     |________|\n"
					+ "    ||         |\n"
					+ "   | |          |\n"
					+ "  |  /          |\n"
					+ " |  /          /\n"
					+ " /\\|__________|\n"
					+ "|   /       /\n"
					+ "|  |       /\n"
					+ "| |       |\n"
					+ " \\ |      \\\n"
					+ "  \\ \\      \\\n"
					+ "    \\ \\     |\n"
					+ "      \\ \\    |\n"
					+ "        \\ \\  |_\n"
					+ "          \\\\_/ \\\n"
					+ "           |    |\n"
					+ "           |   /\n"
					+ "           |  |\n"
					+ "           |_/");
		}
		else if (num == 1) {
			System.out.print("                            __--__\n"
					+ "                           -   -___\\____________________\n"
					+ "                          |   ||________________________|\n"
					+ "                         |   |  | \\|\\|\\|\\|\\|\\|\\\\/\\/\\/\\/|\n"
					+ "                         |   | |  |  \\|\\|\\|\\/\\/\\/\\\\/\\/|\n"
					+ "                         |   / |  |     \\|\\|/\\/\\/\\/\\/\\|\n"
					+ "                         |  | |  |        \\/\\/\\/\\/\\/\\/|\n"
					+ "                         |  ||   |         \\/\\/\\/\\/\\/\\\\|\n"
					+ "                         |   |   |          \\/\\/\\/\\/\\/\\|\n"
					+ "                         |   |   |             \\______/\n"
					+ "                         |   |  |\n"
					+ "                        |    |_ |\n"
					+ "                       ||    | \\|\n"
					+ "                      | |    |  \\\n"
					+ "                      | |    |  <\n"
					+ "                      |/      |  >\n"
					+ "                      |       | /_\n"
					+ "                    _/|       | \\ \\\n"
					+ "                   /   |    /  \\/\\/\n"
					+ "                  |    |   |    \\\n"
					+ "                 |               |\n"
					+ "                 |               /\n"
					+ "                 |              |\n"
					+ "                 |             /\n"
					+ "                  |            |\n"
					+ "                  |           |\n"
					+ "                   |          |\n"
					+ "_________          |         |\n"
					+ "         \\         |         |             ___\n"
					+ "___       |        |________|          _==    =\n"
					+ "   \\  ____|        |_________|  _   __==        \\\n"
					+ "    \\/    |        |          == \\==             \\\n"
					+ "     \\     |       |               \\        _=    \\\n"
					+ "      |     |     | |               \\    _==  =    \\\n"
					+ "       |     |    |  \\_              \\__=      \\    \\\n"
					+ "        |     |  /     \\__          __\\         \\   \\\n"
					+ "        |      ||         \\______===             \\   \\\n"
					+ "         |     /\\           /                      |   \\\n"
					+ "         |    /  \\__      /                        \\__/\\_  _____\n"
					+ "          |          \\ /                          |      =     \\\n"
					+ "           \\         /                             |            |\n"
					+ "             \\_    _/                                \\___________/\n"
					+ "               ===");
		}
		else {
			System.out.print("            ________\n"
					+ "    o      |   __   |\n"
					+ "      \\_ O |  |__|  |\n"
					+ "   ____/ \\ |___WW___|\n"
					+ "   __/   /     ||\n"
					+ "               ||\n"
					+ "               ||\n"
					+ "_______________||________________");
		}
	}

}
