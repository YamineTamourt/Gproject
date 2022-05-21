package .root;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;
import java.io.FileReader;
import java.nio.file.Files;


public class GenerateurHtml
{
	public static void main(String[] args)
	{
		PrintWriter pw = null;

		try
		{	
			pw = new PrintWriter ( new File ( "/var/www/html/index.html"), "utf-8" );
		}	
		catch (Exception e){e.printStackTrace();}

			// HTML
		pw.println ( "<!DOCTYPE html> " );
		pw.println ( "<html lang=\"fr\">" );

			// head
		pw.println ( "\t<head>" );
		pw.println ( "\t\t<meta charset=\"UTF-8\">" );
		pw.println ( "\t\t<link rel=\"stylesheet\" href=\"Style.css\" />" );
		pw.println ( "\t\t<title>Générateur page vidéo</title>" );
		pw.println ( "\t</head>" );

			// body
		pw.println ( "\t<body>" );

			// titre
		pw.println ( "\t\t<h1>Liste des vidéos</h1>" );

		ArrayList<Video> alVideo = Video.genererVideo();

		for (Video v : alVideo)
		{
			pw.println ( "\t\t<table>" );
				
			pw.println ( "\t\t\t<tr>" );

			pw.println ( "\t\t\t\t<td> " + v.getTitre() + " </td>" );

			pw.println ( "\t\t\t\t<td rowspan=\"7\"> <video> <source src=\"video" + v.getAuteur() + "/" + v.getDate() + "/" + v.getTitre() + "" + v.getFichier() + " type=\"video/mp4\"> </video> </td>" );
		
			pw.println ( "\t\t\t\t<td colspan=\"3\">" + v.getAuteur()  +"                       " + v.getDate() + " </td>" );

			pw.println ( "\t\t\t</tr>" );

			pw.println ( "\t\t</table>" );
		}

		
		

			// espacement avec le pied de page
		pw.println ( "\t\t<br style = \"line-height:100px;\">" );
			
			// pied de page avec prise en compte du singulier et pluriel
		pw.println ( "\t\t<footer>" );
		
		pw.println ( "\t\t\t<br> fait par moi en légende");
			
		pw.println ( "\t\t</footer>" );

		pw.println ( "\t</body>" );

		pw.println ( "</html>" );

		pw.close();
	}
}

class Video
{
	private String auteur;
	private String date;
	private String titre;
	private String fichier;

	public Video(String auteur, String date, String titre, String fichier)
	{
		this.auteur  = auteur;
		this.date    = date;
		this.titre   = titre;
		this.fichier = fichier;
	}

	public String getAuteur()
	{
		return this.auteur;
	}

	public String getDate()
	{
		return this.date;
	}

	public String getTitre()
	{
		return this.titre;
	}

	public String getFichier()
	{
		return this.fichier;
	}

	public static ArrayList<Video> genererVideo()
	{
		ArrayList<Video> alVideo = new ArrayList<Video>();

		try
		{
			Scanner sc = new Scanner ( new FileReader ( "video.data" ) );

			while ( sc.hasNextLine() )
			{
				String[] tabS = sc.nextLine().split("\t");

				alVideo.add( new Video(tabS[0], tabS[1], tabS[2], tabS[3]) );
			}
		}catch (Exception e){ e.printStackTrace(); }

		return alVideo;
	}
}

