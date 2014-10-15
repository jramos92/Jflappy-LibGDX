package org.jrsoft.jflappy.screens;

import org.jrsoft.jflappy.Jflappy;
import org.jrsoft.jflappy.util.Constants;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;

public class GameWinScreen implements Screen{

	final Jflappy juego;
	

	OrthographicCamera camara;
	Texture fondo;
	Music sonidoGanar;
	
	public GameWinScreen(Jflappy juego) {
		super();
		this.juego = juego;
		camara = new OrthographicCamera();
		camara.setToOrtho(false, Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);
		fondo = new Texture(Gdx.files.internal("data/fondowin.png"));
		sonidoGanar = Gdx.audio.newMusic(Gdx.files.internal("data/winsong.mp3"));
	}

	@Override
	public void render(float delta) {
		
		Gdx.gl.glClearColor(0, 0.3f, 0.6f, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		camara.update();
		juego.spriteBatch.setProjectionMatrix(camara.combined);
	
		juego.spriteBatch.begin();
		juego.spriteBatch.draw(fondo, 0, 0, Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);
		juego.fuente.draw(juego.spriteBatch, "HAS GANADO", Constants.SCREEN_HEIGHT /2, 150);
		juego.fuente.draw(juego.spriteBatch, "Tu puntuación: " + juego.monedasRecojidas, Constants.SCREEN_HEIGHT/2, 130);
		juego.fuente.draw(juego.spriteBatch, "Si quieres jugar otra partida pulsa la tecla 'N'", Constants.SCREEN_HEIGHT/2, 110);
		juego.fuente.draw(juego.spriteBatch, "Pulsa 'ESCAPE' para SALIR", Constants.SCREEN_HEIGHT/2, 90);

		juego.spriteBatch.end();
		


		if (Gdx.input.isKeyPressed(Keys.N)) {
				
			juego.monedasRecojidas = 0;
			juego.setScreen(new GameScreen(juego));
		}
	
		
		else if (Gdx.input.isKeyPressed(Keys.ESCAPE)) {
			dispose();
			System.exit(0);
		}
	
		
	
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void show() {
		sonidoGanar.play();
		sonidoGanar.setLooping(true);
	}

	@Override
	public void hide() {
		sonidoGanar.stop();
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		juego.dispose();
	}
	
	
}
