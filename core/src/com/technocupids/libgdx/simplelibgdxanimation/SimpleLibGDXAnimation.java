package com.technocupids.libgdx.simplelibgdxanimation;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;

public class SimpleLibGDXAnimation extends ApplicationAdapter {
	SpriteBatch batch;
	TextureAtlas atlas;
	Animation highFiveAnim;
	Array<AtlasRegion> highFiveRegions;
	TextureRegion highFiveRegion;
	float deltaTimer;

	@Override
	public void create() {
		batch = new SpriteBatch();

		TextureAtlas atlas = new TextureAtlas("highFive.pack");

		for (Texture t : atlas.getTextures()) {
			t.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		}

		highFiveRegions = atlas.findRegions("highFive");
		highFiveAnim = new Animation(3f, highFiveRegions,
				Animation.PlayMode.LOOP);
	}

	@Override
	public void render() {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		deltaTimer += 0.16f;
		highFiveRegion = highFiveAnim.getKeyFrame(deltaTimer, false);

		batch.begin();
		batch.draw(highFiveRegion, 400-highFiveRegion.getRegionWidth()/2, 240-highFiveRegion.getRegionHeight()/2);
		batch.end();
	}
}
