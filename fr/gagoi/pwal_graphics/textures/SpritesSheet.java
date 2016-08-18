package fr.gagoi.pwal_graphics.textures;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class SpritesSheet {

	private String id;
	private BufferedImage img;
	private int width, height;
	private int[] pixels;
	private ArrayList<Sprite> sprites;

	public SpritesSheet(String id, String path) throws IOException {
		this.id = id;
		this.sprites = new ArrayList<>();
		this.img = ImageIO.read(new File(path));
	}

	public void addSprite(String id, int x, int y, int width, int height) {
		sprites.add(getSpriteAt(id, x, y, width, height));
	}

	public Sprite getSpriteAt(String id, int x, int y, int width, int height) {
		int[] img = new int[width * height];
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				img[j + i * width] = this.pixels[(y + i) * this.width + x + j];
			}
		}
		return new Sprite(id, pixels, width);
	}

	public void load() {
		this.width = img.getWidth();
		this.height = img.getHeight();
		this.pixels = new int[width * height];
		img.getRGB(0, 0, width, height, pixels, 0, width);
	}

	public String getId() {
		return this.id;
	}
}
