package org.jrsoft.jflappy.characters;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class Crow extends Character {

	public Crow(Vector2 position, float speed, Texture texture) {
		super(position, speed, texture);
	}

	@Override
	public void update(float dt) {
		move(new Vector2(-dt * speed, 0));
	}

}
