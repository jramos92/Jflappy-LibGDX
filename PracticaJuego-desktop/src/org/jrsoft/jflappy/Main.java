package org.jrsoft.jflappy;

import org.jrsoft.jflappy.Jflappy;
import org.jrsoft.jflappy.util.Constants;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class Main {
	public static void main(String[] args) {
		

		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		cfg.title = "PracticaJuego";
		cfg.width = Constants.SCREEN_WIDTH;
		cfg.height = Constants.SCREEN_HEIGHT;
		cfg.useGL20 = true;
		
		new LwjglApplication(new Jflappy(), cfg);
	}
}
