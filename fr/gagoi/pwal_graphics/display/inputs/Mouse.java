package fr.gagoi.pwal_graphics.display.inputs;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import fr.gagoi.pwal_graphics.display.Window;
import fr.gagoi.pwal_graphics.display.elements.Button;
import fr.gagoi.pwal_graphics.display.elements.Render;
import fr.gagoi.pwal_graphics.display.elements.Render_Scaled;

public class Mouse implements MouseListener, MouseWheelListener, MouseMotionListener {

	private boolean debug;
	
	@Override
	public void mouseDragged(MouseEvent e) {}

	@Override
	public void mouseMoved(MouseEvent e) {}

	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {}

	@Override
	public void mouseClicked(MouseEvent e) {}

	@Override
	public void mousePressed(MouseEvent e) {
		if(debug) System.out.println(e);
		for (Render render : Window.getScreen().getElementsToRender())
			if (render instanceof Button) {
				Button b = (Button) render;
				if (b.contains(e.getPoint())) {
					b.onClick();
					return;
				}
			}
		for (Render_Scaled render : Window.getScreen().getElementsToRenderScaled())
			if (render instanceof Button) {
				Button b = (Button) render;
				if (b.contains(e.getPoint())) {
					b.onClick();
					return;
				}
			}
	}

	@Override
	public void mouseReleased(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}

	public void toggleDebug() {
		debug = !debug;
	}

}
