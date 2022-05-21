import java.io.PrintWriter;
import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileReader;



public class Video
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
