package com.packtpub.libgdx.canyonbunny;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.packtpub.libgdx.canyonbunny.game.WorldController;
import com.packtpub.libgdx.canyonbunny.game.WorldRenderer;

public class CanyonBunnyMain implements ApplicationListener {
    private static final String TAG = CanyonBunnyMain.class.getName();
    
    private WorldController worldController;
    private WorldRenderer worldRenderer;

    @Override
    public void create() {
        // Set Libgdx log level to DEBUG
        Gdx.app.setLogLevel(Application.LOG_DEBUG);
        // Initialize controller and renderer
        worldController = new WorldController();
        worldRenderer = new WorldRenderer(worldController);
    }

    @Override
    public void render() {
    }
    
    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void dispose() {
    }
}
