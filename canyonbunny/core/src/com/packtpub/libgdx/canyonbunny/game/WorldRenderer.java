/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.packtpub.libgdx.canyonbunny.game;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Disposable;

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
    
    public WorldRenderer(WorldController worldController) {}
    
    private void init() {}
    
    public void render() {}
    
    private void resize(int width, int height) {}

    @Override
    public void dispose() {
    }
    
}
