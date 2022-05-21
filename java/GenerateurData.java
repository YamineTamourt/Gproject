package root;

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
			String[] tabS = file.getPath().split("/");

			s.println(tabS[4] + "\t" + tabS[5] + "\t" + tabS[6] + "\t" + tabS[7]);
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
