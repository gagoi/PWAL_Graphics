package fr.gagoi.pwal_graphics.display;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;

public class Window extends JFrame {
	private static final long serialVersionUID = -1843473186658016548L;

	private static Screen screen;

	public Window(String title, int width, int height, float scale) {
		this.setTitle(title);
		this.setSize((int) (width * scale), (int) (height * scale));
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	public void setScreen(Screen screen) {
		if (Window.screen != null) this.getContentPane().remove(Window.screen);
		Window.screen = screen;
		this.getContentPane().add(Window.screen);
		Window.screen.requestFocus();
	}

	public static Screen getScreen() {
		return screen;
	}
	
	public void addCustomFont(String path){
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		try {
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File(path)));
		} catch (FontFormatException | IOException e) {
			e.printStackTrace();
		}
	}
}
