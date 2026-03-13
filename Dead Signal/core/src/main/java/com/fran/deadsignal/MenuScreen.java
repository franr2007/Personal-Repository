package com.fran.deadsignal;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.utils.ScreenUtils;

/**
 * First screen of the application. Displayed after the application is created.
 */
public class MenuScreen implements Screen {
    // atributos
    private SpriteBatch batch;
    private BitmapFont titulo;
    private BitmapFont btnNewGame;
    private BitmapFont btnOptions;
    private BitmapFont btnExit;
    private float ancho;
    private float alto;
    private float margen;
    private GlyphLayout anchoElem;
    private FreeTypeFontGenerator generator;
    private FreeTypeFontGenerator.FreeTypeFontParameter parametros;

    // constructor
    @Override
    public void show() {
        batch = new SpriteBatch();

        titulo = new BitmapFont();
        titulo.getData().setScale(10f); // tamaño de la fuente del txt del titulo

        btnNewGame = new BitmapFont();
        btnNewGame.getData().setScale(3f); // tamaño de la fuente del txt del btn

        btnOptions = new BitmapFont();
        btnOptions.getData().setScale(3f); // tamaño de la fuente del txt del btn

        btnExit = new BitmapFont();
        btnExit.getData().setScale(3f); // tamaño de la fuente del txt del btn

        ancho = Gdx.graphics.getWidth();
        alto = Gdx.graphics.getHeight();
        margen = 100f;

        anchoElem = new GlyphLayout();
    }

    // getters y setter

    // metodos
    @Override
    public void render(float delta) {
        ScreenUtils.clear(0.1f, 0.1f, 0.1f, 1f);

        batch.begin();
        anchoElem.setText(titulo, "Dead Signal"); // calcula lo que va a ocupar el titulo segun el texto
        titulo.draw(batch, "Dead Signal", (ancho - anchoElem.width) / 2f, alto - 100f);

        anchoElem.setText(btnNewGame, "New Game"); // calcula lo que va a ocupar el btn segun el texto
        btnNewGame.draw(batch, "New Game", (ancho - anchoElem.width) / 2f, alto / 2f);

        anchoElem.setText(btnOptions, "Options"); // calcula lo que va a ocupar el btn segun el texto
        btnOptions.draw(batch, "Options", (ancho - anchoElem.width) / 2f, (alto / 2f) - margen);

        anchoElem.setText(btnExit, "Exit"); // calcula lo que va a ocupar el btn segun el texto
        btnExit.draw(batch, "Exit", (ancho - anchoElem.width) / 2f, (alto / 2f) - (margen + margen));

        batch.end();
    }

    @Override
    public void resize(int width, int height) {
        // If the window is minimized on a desktop (LWJGL3) platform, width and height
        // are 0, which causes problems.
        // In that case, we don't resize anything, and wait for the window to be a
        // normal size before updating.
        if (width <= 0 || height <= 0)
            return;

        // Resize your screen here. The parameters represent the new window size.
    }

    @Override
    public void pause() {
        // Invoked when your application is paused.
    }

    @Override
    public void resume() {
        // Invoked when your application is resumed after pause.
    }

    @Override
    public void hide() {
        // This method is called when another screen replaces this one.
    }

    @Override
    public void dispose() {
        // Destroy screen's assets here.
    }
}