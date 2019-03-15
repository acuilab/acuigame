package com.acuigame.mygdxgame;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;

public class MyGdxGame extends ApplicationAdapter {
    private OrthographicCamera camera;
    private SpriteBatch batch;
    private Texture texture;
    private Sprite sprite;
    
    private float rot;

    @Override
    public void create() {
        float w = Gdx.graphics.getWidth();
        float h = Gdx.graphics.getHeight();
        
        camera = new OrthographicCamera(1, h/w);
        batch = new SpriteBatch();
        
        texture = new Texture("badlogic.jpg");
        texture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        
        TextureRegion region = new TextureRegion(texture, 0, 0, 512, 275);
        
        sprite = new Sprite(region);
        sprite.setSize(0.9f, 0.9f * sprite.getHeight() / sprite.getWidth());
        sprite.setOrigin(sprite.getWidth()/2, sprite.getHeight()/2);
        sprite.setPosition(-sprite.getWidth()/2, -sprite.getHeight()/2);
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        final float degreesPerSecond = 10f;
        rot = (rot + Gdx.graphics.getDeltaTime() * degreesPerSecond) % 360;
        final float shakeAmplitudeInDegrees = 5.0f;
        float shake = MathUtils.sin(rot) * shakeAmplitudeInDegrees;
        sprite.setRotation(shake);
        sprite.draw(batch);
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        texture.dispose();
    }
}
