package fr.gagoi.pwal_graphics.textures;

public class Sprite {

	private int[] pixels;
	private int width;
	private String id;
	
	public Sprite(String id, int[] pixels, int width) {
		this.id = id;
		this.width = width;
		this.pixels = pixels;
	}
	
	public int getPixelAt(int x, int y){
		return this.pixels[x+y*width];
	}
	
	public String getId(){
		return this.id;
	}
}
