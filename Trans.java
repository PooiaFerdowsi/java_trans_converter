import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class Trans
{
	public static void main(String args[]) throws
	 IOException , FileNotFoundException
	 {
		File fp = new File(args[0]+".java");
		Scanner r = new Scanner(fp);
		String src = "";
		while (r.hasNextLine()){
			src += r.nextLine()+"\n";
		}
		System.out.println(src);

		File fl = new File(args[0]+"Out.java");
		if(!(fl.createNewFile()))
		{
			System.out.println("an Error while create file");
			return;
		}
		
		// process language
		src = src.replace(args[0],args[0]+"Out");
		
		src = src.replace("$","public "); // needs an space after protected keyword
		
		src = src.replace("#","protected ");
		
		src = src.replace("`","private ");

		FileWriter write = new FileWriter(args[0]+"Out.java");
		write.write(src);
		write.close();
		System.out.println(src);
	}
}
