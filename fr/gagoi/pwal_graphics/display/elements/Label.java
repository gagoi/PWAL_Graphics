package fr.gagoi.pwal_graphics.display.elements;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Label implements Render, Render_Scaled{

	private String text;
	private Color color;
	private Font font;
	private int x, y;

	public Label(String text, int x, int y) {
		this.text = text;
		this.x = x;
		this.y = y;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public void setFont(Font font) {
		this.font = font;
	}

	@Override
	public void render(Graphics g) {
		if (text != null && text != "") {
			Color oldColor = g.getColor();
			Font oldFont = g.getFont();
			if (color != null) g.setColor(color);
			if (font != null) g.setFont(font);
			g.drawString(text, x, y);
			g.setColor(oldColor);
			g.setFont(oldFont);
		}
	}

	@Override
	public void render_scaled(Graphics g) {
		if (text != null && text != "") {
			Color oldColor = g.getColor();
			Font oldFont = g.getFont();
			if (color != null) g.setColor(color);
			if (font != null) g.setFont(font);
			g.drawString(text, x, y);
			g.setColor(oldColor);
			g.setFont(oldFont);
		}	
	}
}
