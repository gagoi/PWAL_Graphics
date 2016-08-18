package fr.gagoi.pwal_graphics.display.elements;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;
import java.util.ArrayList;

public class Button implements Render {

	private String text;
	private Color bgColor = Color.DARK_GRAY, fgColor = Color.LIGHT_GRAY;
	private Font font;
	private int x, y, width, height;
	private ArrayList<ActionListener> listeners = new ArrayList<>();

	public Button(String text, int x, int y, int width, int height) {
		this.text = text;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	public void setBackgroundColor(Color color) {
		this.bgColor = color;
	}

	public void setForegroundColor(Color color) {
		this.fgColor = color;
	}

	public void setFont(Font font) {
		this.font = font;
	}

	public boolean contains(Point point) {
		return new Polygon(new int[] { x, x + width, x + width, x }, new int[] { y, y, y + height, y + height }, 4).contains(point);
	}

	@Override
	public void render(Graphics g) {
		Color oldColor = g.getColor();
		Font oldFont = g.getFont();

		g.setFont(font);
		g.setColor(bgColor);
		g.fillRect(x, y, width, height);

		g.setColor(fgColor);
		g.drawString(text, (int) (x + (width - g.getFontMetrics().stringWidth(text)) / 2), (int) (y + (height + g.getFontMetrics().getHeight()) / 2));
		g.setColor(oldColor);
		g.setFont(oldFont);
	}

	public void addActionListener(ActionListener actionListener) {
		listeners.add(actionListener);
	}

	public void onClick() {
		for (ActionListener actionListener : listeners) {
			actionListener.actionPerformed();
		}
	}
}
