package com.firstgame.pong;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Racket extends ApplicationAdapter {
	ShapeRenderer racket;

	//the racket will be moved by either keys or the mouse
	//this program simply shows the basics of movement in libgdx

	float posY ,posX ;

	@Override
	public void create() {
		racket = new ShapeRenderer();
	}

	@Override
	public void render() {

		//movement using mouse
		if(Gdx.input.isTouched()){
			posX = Gdx.input.getX();
			posY = Gdx.graphics.getHeight()-Gdx.input.getY();
		}
		//movement using keys (W,A,S,D)
		if(Gdx.input.isKeyPressed(Input.Keys.W)){
			posY++;
		}
		if(Gdx.input.isKeyPressed(Input.Keys.S)){
			posY--;
		}
		if(Gdx.input.isKeyPressed(Input.Keys.A)){
			posX--;
		}
		if(Gdx.input.isKeyPressed(Input.Keys.D)){
			posX++;
		}

		Gdx.gl.glClearColor(0,0,0,1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		racket.begin(ShapeRenderer.ShapeType.Filled);
		racket.setColor(1,1,1,1);
		racket.rect(posX,posY,20,80);
		racket.end();

	}

	@Override
	public void dispose() {
		racket.dispose();
	}
}