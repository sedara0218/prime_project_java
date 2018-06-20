/*
Author: Siddhartha Edara
University: Wisconsin-Madison
*/
import java.io.*;
import java.util.*;

public class programEfficiency_EDARA_INT
{
	private static void printLines (String name, InputStream ins) throws Exception 
	{
		String line = null;
		BufferedReader br = new BufferedReader(new InputStreamReader(ins));
		while ((line = br.readLine()) != null)
			System.out.println(name + " " + line);
	}
	private static int runProcess (String command) throws Exception
	{
		String cmd;
		if (command.contains("javac"))
			cmd = "Compilation";
		else
			cmd = "RunTime";

		Process pro = Runtime.getRuntime().exec(command);
		printLines(cmd + " Output: ", pro.getInputStream());
		printLines(cmd + " Error: ", pro.getErrorStream());
    	pro.waitFor();
    	return pro.exitValue();
	}
	public static void main(String[] args) throws Exception
	{
		int i;
		try {
			i = runProcess("javac Sieve_EDARA_INTEGER.java");
			if (i != 0)
				System.exit(0);

			System.out.println("N = 19");
			i = runProcess("java Sieve_EDARA_INTEGER 1");
			if (i != 0)
				System.exit(0);

			System.out.println("N = 61");
			i = runProcess("java Sieve_EDARA_INTEGER 2");
			if (i != 0)
				System.exit(0);

			System.out.println("N = 181");
			i = runProcess("java Sieve_EDARA_INTEGER 3");
			if (i != 0)
				System.exit(0);

			System.out.println("N = 547");
			i = runProcess("java Sieve_EDARA_INTEGER 4");
			if (i != 0)
				System.exit(0);

			System.out.println("N = 1637");
			i = runProcess("java Sieve_EDARA_INTEGER 5");
			if (i != 0)
				System.exit(0);

			System.out.println("N = 4909");
			i = runProcess("java Sieve_EDARA_INTEGER 6");
			if (i != 0)
				System.exit(0);

			System.out.println("N = 14731");
			i = runProcess("java Sieve_EDARA_INTEGER 7");
			if (i != 0)
				System.exit(0);

			System.out.println("N = 44189");
			i = runProcess("java Sieve_EDARA_INTEGER 8");
			if (i != 0)
				System.exit(0);

			System.out.println("N = 132547");
			i = runProcess("java Sieve_EDARA_INTEGER 9");
			if (i != 0)
				System.exit(0);

			System.out.println("N = 397643");
			i = runProcess("java Sieve_EDARA_INTEGER 10");
			if (i != 0)
				System.exit(0);

			System.out.println("N = 1192937");
			i = runProcess("java Sieve_EDARA_INTEGER 11");
			if (i != 0)
				System.exit(0);

			System.out.println("N = 3578807");
			i = runProcess("java Sieve_EDARA_INTEGER 12");
			if (i != 0)
				System.exit(0);

			System.out.println("N = 10736413");
			i = runProcess("java Sieve_EDARA_INTEGER 13");
			if (i != 0)
				System.exit(0);

			System.out.println("Done!");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
