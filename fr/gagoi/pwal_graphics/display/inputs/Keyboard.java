package fr.gagoi.pwal_graphics.display.inputs;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keyboard implements KeyListener {

	public static boolean[] states = new boolean[65536];

	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	public void keyPressed(KeyEvent e) {
		states[e.getKeyCode()] = true;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		states[e.getKeyCode()] = false;
	}

}
