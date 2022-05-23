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
			pw = new PrintWriter ( new File ( "index.html"), "utf-8" );
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
		
		pw.println ( "\t\t<br>" );

		ArrayList<Video> alVideo = Video.genererVideo();

		for (Video v : alVideo)
		{
			pw.println ( "\t\t<table>" );
				
			pw.println ( "\t\t\t<tr>" );

			pw.println ( "\t\t\t\t<td> " + v.getTitre() + " </td>" );
			
			pw.println ( "\t\t\t</tr>" );
			
			pw.println ( "\t\t\t<tr>" );

			pw.println ( "\t\t\t\t<td> <video width=\"500\" height=\"240\" controls> <source src=\"video/" + v.getFichier() + "\" type=\"video/mp4\"> </video> </td>" );
		
			pw.println ( "\t\t\t</tr>" );
			
			pw.println ( "\t\t\t<tr>" );
			
			pw.println ( "\t\t\t\t<td> Made by " + v.getAuteur()  +"                       " + v.getDate() + " </td>" );
			
			pw.println ( "\t\t\t</tr>" );
			
			pw.println ( "\t\t\t<tr>" );

			pw.println ( "\t\t\t</tr>" );
			
			pw.println ( "\t\t\t<tr>" );
			
			pw.println ( "\t\t\t\t<td>" + v.getDescription() + " </td>" );

			pw.println ( "\t\t\t</tr>" );

			pw.println ( "\t\t</table>" );
		}

		
		

			// espacement avec le pied de page
		pw.println ( "\t\t<br style = \"line-height:100px;\">" );
			
			// pied de page avec prise en compte du singulier et pluriel
		pw.println ( "\t\t<footer>" );
		
		pw.println ( "\t\t\t<br> Projet SaE 2.03");
			
		pw.println ( "\t\t</footer>" );

		pw.println ( "\t</body>" );

		pw.println ( "</html>" );

		pw.close();
	}
}

class Video
{
	private String date;
	private String titre;
	private String auteur;
	private String description;
	private String fichier;

	public Video(String date, String titre, String auteur, String description, String fichier)
	{
		this.date        = date;
		this.titre       = titre;
		this.description = description;
		this.auteur      = auteur;
		this.fichier     = fichier;
	}

	public String getDate()
	{
		return this.date;
	}

	public String getTitre()
	{
		return this.titre;
	}

	public String getAuteur()
	{
		return this.auteur;
	}

	public String getDescription()
	{
		return this.description;
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
				
				String date = tabS[0].substring(6, 8) + "/" + tabS[0].substring(4, 6) + "/" + tabS[0].substring(0, 4);

				alVideo.add( new Video(date, tabS[1], tabS[2], tabS[3], tabS[4]) );
			}
		}catch (Exception e){ e.printStackTrace(); }

		return alVideo;
	}
}
