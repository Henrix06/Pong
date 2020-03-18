package com.firstgame.pong;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class BouncingBall extends ApplicationAdapter {
	ShapeRenderer ball;

	//animate the ball to move freely
	//variables for ball manipulation
	float ballY = 200,ballX = 100;
	float ySpeed = 120,xSpeed = 60;

	@Override
	public void create() {
		ball = new ShapeRenderer();
	}

	@Override
	public void render() {
		ballX += xSpeed* Gdx.graphics.getDeltaTime();
		ballY += ySpeed* Gdx.graphics.getDeltaTime();

		if(ballX<0||ballX>Gdx.graphics.getWidth()){
			xSpeed *= -1;
		}
		if (ballY<0||ballY>Gdx.graphics.getHeight()){
			ySpeed *= -1;
		}


		Gdx.gl.glClearColor(0,0,0,1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		ball.begin(ShapeRenderer.ShapeType.Filled);
		ball.setColor(0.5f,.1f,.1f,1);
		ball.circle(ballX,ballY,64);
		ball.end();

	}

	@Override
	public void dispose() {
		ball.dispose();
	}
}