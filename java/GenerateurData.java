package var.www.html;

import java.io.File;
import java.io.PrintWriter;

public class GenerateurData
{

	private void arbre(File file, PrintWriter s)
	{
		if (file.isDirectory())
		{
			File[] enfant = file.listFiles();

			for (File e : enfant)
			{
				this.arbre(e, s);
			}
		}
		else
		{
			System.out.println(file.getPath());
			
			String[] tabS = file.getPath().split("/");

			s.println(tabS[1] + "\t" + tabS[2] + "\t" + tabS[3] + "\t" + tabS[4]);
		}


	}

	public static void main(String[] args)
	{
		GenerateurData ex = new GenerateurData();

		File dir = new File("/var/www/html/video");

		String s = "";

		PrintWriter pw = null;

		try
		{
			pw = new PrintWriter ( new File ( "video.data"), "utf-8" );
		} catch (Exception e) {e.printStackTrace();}

		ex.arbre(dir, pw);

		pw.close();
	}
}
