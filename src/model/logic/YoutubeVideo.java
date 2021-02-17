package model.logic;

public class YoutubeVideo implements Comparable<YoutubeVideo>{

	private String id;
	private String trendingDate;
	private int likes;
	private String title;

	public YoutubeVideo(String pId, String pTrendingDate, int pLikes, String pTitle)
	{
		id =pId;
		trendingDate = pTrendingDate;
		likes = pLikes;
		title = pTitle;
	}

	public int compareTo(YoutubeVideo video)
	{
		//SimpleDateFormat thisFecha = new SimpleDateFormat("YY.dd.mm").parse(trendingDate);
		//SimpleDateFormat otraFecha = new SimpleDateFormat("YY.dd.mm").parse(video.darTrDate);
		// return thisFecha - otraFecha
		return likes - video.darLikes();
	}

	public String darId()
	{
		return id;
	}

	public int darLikes()
	{
		return likes;
	}

	public String darTitle()
	{
		return title;
	}

	public String darPresentacion()
	{
		return "titulo: " + title + " - Numero de likes: " + likes + " - Fecha de tendencia: " + trendingDate;
	}
}
