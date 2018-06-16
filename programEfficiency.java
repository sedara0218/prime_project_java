import java.io.*;
import java.util.*;

public class programEfficiency
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
			i = runProcess("javac Sieve_EDARA.java");
			if (i != 0)
				System.exit(0);
			i = runProcess("javac effPrimeCalc.java");
			if (i != 0)
				System.exit(0);

			System.out.println("N = 19");
			i = runProcess("java Sieve_EDARA 1");
			if (i != 0)
				System.exit(0);
			i = runProcess("java effPrimeCalc 19");
			if (i != 0)
				System.exit(0);
			System.out.println();

			System.out.println("N = 61");
			i = runProcess("java Sieve_EDARA 2");
			if (i != 0)
				System.exit(0);
			i = runProcess("java effPrimeCalc 61");
			if (i != 0)
				System.exit(0);
			System.out.println();

			System.out.println("N = 181");
			i = runProcess("java Sieve_EDARA 3");
			if (i != 0)
				System.exit(0);
			i = runProcess("java effPrimeCalc 181");
			if (i != 0)
				System.exit(0);
			System.out.println();

			System.out.println("N = 547");
			i = runProcess("java Sieve_EDARA 4");
			if (i != 0)
				System.exit(0);
			i = runProcess("java effPrimeCalc 547");
			if (i != 0)
				System.exit(0);
			System.out.println();

			System.out.println("N = 1637");
			i = runProcess("java Sieve_EDARA 5");
			if (i != 0)
				System.exit(0);
			i = runProcess("java effPrimeCalc 1637");
			if (i != 0)
				System.exit(0);
			System.out.println();

			System.out.println("N = 4909");
			i = runProcess("java Sieve_EDARA 6");
			if (i != 0)
				System.exit(0);
			i = runProcess("java effPrimeCalc 4909");
			if (i != 0)
				System.exit(0);
			System.out.println();

			System.out.println("N = 14731");
			i = runProcess("java Sieve_EDARA 7");
			if (i != 0)
				System.exit(0);
			i = runProcess("java effPrimeCalc 14731");
			if (i != 0)
				System.exit(0);
			System.out.println();

			System.out.println("N = 44189");
			i = runProcess("java Sieve_EDARA 8");
			if (i != 0)
				System.exit(0);
			i = runProcess("java effPrimeCalc 44189");
			if (i != 0)
				System.exit(0);
			System.out.println();

			System.out.println("N = 132547");
			i = runProcess("java Sieve_EDARA 9");
			if (i != 0)
				System.exit(0);
			i = runProcess("java effPrimeCalc 132547");
			if (i != 0)
				System.exit(0);
			System.out.println();

			System.out.println("N = 397643");
			i = runProcess("java Sieve_EDARA 10");
			if (i != 0)
				System.exit(0);
			i = runProcess("java effPrimeCalc 397643");
			if (i != 0)
				System.exit(0);	
			System.out.println();	

			System.out.println("N = 1192937");
			i = runProcess("java Sieve_EDARA 11");
			if (i != 0)
				System.exit(0);
			i = runProcess("java effPrimeCalc 1192937");
			if (i != 0)
				System.exit(0);
			System.out.println();

			System.out.println("N = 3578807");
			i = runProcess("java Sieve_EDARA 12");
			if (i != 0)
				System.exit(0);
			i = runProcess("java effPrimeCalc 3578807");
			if (i != 0)
				System.exit(0);
			System.out.println();

			System.out.println("N = 10736413");
			i = runProcess("java Sieve_EDARA 13");
			if (i != 0)
				System.exit(0);
			i = runProcess("java effPrimeCalc 10736413");
			if (i != 0)
				System.exit(0);
			System.out.println();

			System.out.println("Done!");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}