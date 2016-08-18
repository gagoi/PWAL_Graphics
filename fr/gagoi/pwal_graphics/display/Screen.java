package fr.gagoi.pwal_graphics.display;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import fr.gagoi.pwal_graphics.display.elements.Render;
import fr.gagoi.pwal_graphics.display.elements.Render_Scaled;
import fr.gagoi.pwal_graphics.display.inputs.Keyboard;
import fr.gagoi.pwal_graphics.display.inputs.Mouse;

public class Screen extends Canvas{
	private static final long serialVersionUID = 2185319340763496194L;

	private ArrayList<Render> elementsToRender = new ArrayList<>();
	private ArrayList<Render_Scaled> elementsToRenderScaled = new ArrayList<>();

	private int width, height;
	private float scale;

	protected static final Mouse MOUSE = new Mouse();
	protected static final Keyboard KEYBOARD = new Keyboard();
	
	private BufferStrategy bufferStrategy;

	public Screen(int width, int height, float scale) {
		this.width = width;
		this.height = height;
		this.scale = scale;
		this.setBackground(Color.BLACK);
		this.setIgnoreRepaint(true);
		this.addMouseListener(MOUSE);
		this.addMouseMotionListener(MOUSE);
		this.addMouseWheelListener(MOUSE);
		this.addKeyListener(KEYBOARD);
	}

	public void render(Graphics g) {
		BufferedImage img_game = getGraphicsConfiguration().createCompatibleImage(width, height);
		BufferedImage img_hud = getGraphicsConfiguration().createCompatibleImage((int) (width * scale), (int) (height * scale));

		Graphics g1 = img_game.getGraphics();
		for (Render_Scaled render : elementsToRenderScaled)
			render.render_scaled(g1);

		Graphics g2 = img_hud.getGraphics();
		g2.drawImage(img_game, 0, 0, (int) (width * scale), (int) (height * scale), null);
		for (Render render : elementsToRender)
			render.render(g2);

		g.drawImage(img_hud, 0, 0, null);
	}

	public void render() {
		if(bufferStrategy == null) {
			createBufferStrategy(2);
			bufferStrategy = getBufferStrategy();
			return;
		}
		Graphics g = bufferStrategy.getDrawGraphics();
		g.clearRect(0, 0, WIDTH, HEIGHT);
		render(g);
		bufferStrategy.show();
		g.dispose();
	}

	public void addScaledElement(Render_Scaled render) {
		elementsToRenderScaled.add(render);
	}

	public void addElement(Render render) {
		elementsToRender.add(render);
	}
	
	public void removeElementScaled(Render_Scaled render){
		elementsToRenderScaled.remove(render);
	}
	
	public void removeElement(Render render){
		elementsToRender.remove(render);
	}

	public ArrayList<Render_Scaled> getElementsToRenderScaled() {
		return elementsToRenderScaled;
	}
	public ArrayList<Render> getElementsToRender() {
		return elementsToRender;
	}

}
