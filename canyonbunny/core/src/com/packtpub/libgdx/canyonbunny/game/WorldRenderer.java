/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.packtpub.libgdx.canyonbunny.game;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Disposable;
import com.packtpub.libgdx.canyonbunny.util.Constants;

/**
 * 世界渲染器
 * @author admin
 */
public class WorldRenderer implements Disposable {
    // 正交摄像机
    private OrthographicCamera camera;
    private SpriteBatch batch;
    // 用于渲染被worldController管理的游戏对象
    private WorldController worldController;
    
    public WorldRenderer(WorldController worldController) {
        this.worldController = worldController;
        init();
    }
    
    private void init() {
        batch = new SpriteBatch();
        camera = new OrthographicCamera(Constants.VIEWPORT_WIDTH, Constants.VIEWPORT_HEIGHT);
        camera.position.set(Vector3.Zero);
        camera.update();
    }
    
    public void render() {
        renderTestObjects();
    }
    
    private void renderTestObjects() {
        worldController.cameraHelper.applyTo(camera);
        
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        for(Sprite sprite : worldController.testSprites) {
            sprite.draw(batch);
        }
        batch.end();
    }
    
    public void resize(int width, int height) {
        camera.viewportWidth = (Constants.VIEWPORT_HEIGHT / height) * width;
        camera.update();
    }

    @Override
    public void dispose() {
        batch.dispose();
    }
    
}
