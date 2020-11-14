package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	Infiltrator infiltrator;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
		infiltrator = new Infiltrator(new TextureRegion(img));
		infiltrator.setPosition(50,100);
		infiltrator.setOrigin(0,0);
		infiltrator.setScale(0.5F,1.0F);
		infiltrator.setRotation(-10);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		infiltrator.act(Gdx.graphics.getDeltaTime());
		batch.begin();
		batch.draw(img, 0, 0);
		infiltrator.draw(batch, 1.0F);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
