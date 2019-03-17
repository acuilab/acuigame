package com.packtpub.libgdx.canyonbunny;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.packtpub.libgdx.canyonbunny.game.WorldController;
import com.packtpub.libgdx.canyonbunny.game.WorldRenderer;

public class CanyonBunnyMain implements ApplicationListener {
    private static final String TAG = CanyonBunnyMain.class.getName();
    
    private WorldController worldController;
    private WorldRenderer worldRenderer;
    
    private boolean paused;

    @Override
    public void create() {
        // Set Libgdx log level to DEBUG
        Gdx.app.setLogLevel(Application.LOG_DEBUG);
        // Initialize controller and renderer
        worldController = new WorldController();
        worldRenderer = new WorldRenderer(worldController);
        
        // Game world is active on start
        paused = false;
    }

    // 这里render()方法里的执行顺序是先更新再渲染，而不能先渲染再更新。后者会导致显示的
    // 游戏世界始终比它的实际状态慢一帧，这种改变非常微妙，甚至可能不被注意到。当然，这
    // 依赖于很多因素。如果是动作游戏，需要快速响应，那么这种改变造成的影响比慢节奏的卡
    // 牌游戏更大，因为卡牌游戏有足够的暂停来弥补时间差距，知道屏幕最终显示真实的游戏状态。
    @Override
    public void render() {
        // Do not update game world when paused.
        if(!paused) {
            // Update game world by the time that has passed since last rendered frame.
            // 虽然Gdx.graphics.getDeltaTime()是一个全局变量，这里仍然作为参数传进去
            worldController.update(Gdx.graphics.getDeltaTime());
        }
        
        // Sets the clear screen color to: Cornflower Blue
        Gdx.gl.glClearColor(0x64/255.0f, 0x95/255.0f, 0xed/255.0f, 0xff/255.0f);
        // Clears the screen
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        
        // Render game world to screen
        worldRenderer.render();
    }
    
    @Override
    public void resize(int width, int height) {
        worldRenderer.resize(width, height);
    }

    @Override
    public void pause() {
        paused = true;
    }

    @Override
    public void resume() {
        paused = false;
    }

    @Override
    public void dispose() {
        worldRenderer.dispose();
    }
}
