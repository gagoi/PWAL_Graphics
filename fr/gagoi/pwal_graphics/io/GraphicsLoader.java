package fr.gagoi.pwal_graphics.io;

import java.util.ArrayList;
import java.util.Iterator;

import fr.gagoi.pwal_graphics.textures.SpritesSheet;

public class GraphicsLoader implements Runnable {

	private ArrayList<SpritesSheet> sheets = new ArrayList<>();
	private String name;

	private Thread t;

	public GraphicsLoader(String name) {
		this.name = name;
		t = new Thread(this, name);
	}
	
	public void add(SpritesSheet sheet){
		this.sheets.add(sheet);
	}	
	
	public void load(){
		t.start();
	}

	@Override
	public void run() {
		System.out.println("Loader : " + this.name);
		System.out.println("Start loading sheets...");
		long time = System.currentTimeMillis();
		
		for (Iterator<SpritesSheet> iterator = sheets.iterator(); iterator.hasNext();) {
			SpritesSheet spritesSheet = iterator.next();
			spritesSheet.load();
			long timeSpend = time - System.currentTimeMillis();
			System.out.println("  - " + spritesSheet.getId() + " : done in " + timeSpend + " ("
					+ (int) ((sheets.indexOf(spritesSheet) / sheets.size()) * 100) + "%)");
		}
		
	}

}
