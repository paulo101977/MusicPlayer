package br.com.xpg.narutosenjuu.musicplayer;

public class Music {
	
	private int id;
	private String name;
	private String url;
	
	public final static String _ID = "id";
	public final static String NAME = "name";
	public final static String URL = "url";
	
	public Music(int id , String name , String url)
	{
		this.setId(id);
		this.setName(name);
		this.setUrl(url);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
