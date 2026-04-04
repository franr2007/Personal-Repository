package com.fran.deadsignal;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Cursor;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.ScreenUtils;

/**
 * First screen of the application. Displayed after the application is created.
 */
public class MenuScreen implements Screen {
    // atributos
    private SpriteBatch batch;
    private BitmapFont titulo;
    private BitmapFont btnNewGame;
    private float btnNewGameX, btnNewGameY;
    private float btnNewGameAncho, btnNewGameAlto;
    private Rectangle btnBoundsNg;
    private BitmapFont btnOptions;
    private float btnOptionsX, btnOptionsY;
    private float btnOptionsAncho, btnOptionsAlto;
    private Rectangle btnBoundsOp;
    private BitmapFont btnExit;
    private float btnExitX, btnExitY;
    private float btnExitAncho, btnExitAlto;
    private Rectangle btnBoundsEx;
    private float ancho;
    private float alto;
    private float margen;
    private GlyphLayout anchoElem;
    private FreeTypeFontGenerator generator;
    private FreeTypeFontGenerator.FreeTypeFontParameter parametros;
    private OrthographicCamera camera;
    private Vector3 touchPoint;

    // constructor
    @Override
    public void show() {
        batch = new SpriteBatch();

        ancho = Gdx.graphics.getWidth();
        alto = Gdx.graphics.getHeight();
        margen = 100f;
        anchoElem = new GlyphLayout();

        generator = new FreeTypeFontGenerator(Gdx.files.internal("RubikWetPaint-Regular.ttf"));
        parametros = new FreeTypeFontGenerator.FreeTypeFontParameter();

        // titulo
        parametros.size = 100;
        titulo = generator.generateFont(parametros); // tamaño de la fuente del txt del titulo
        anchoElem.setText(titulo, "Dead Signal"); // calcula lo que va a ocupar el titulo segun el texto

        // btnNewGame
        parametros.size = 40; // tamaño de la letra
        btnNewGame = generator.generateFont(parametros); // tamaño de la fuente del txt del btn
        anchoElem.setText(btnNewGame, "New Game"); // calcula lo que va a ocupar el btn segun el texto
        btnNewGameX = (ancho - anchoElem.width) / 2f; // coge la posicion x del boton
        btnNewGameY = alto / 2f; // coge la posicion y del boton
        btnNewGameAncho = anchoElem.width; // coge el ancho del boton
        btnNewGameAlto = anchoElem.height; // coge el alto del boton

        // btnOptions
        btnOptions = generator.generateFont(parametros); // tamaño de la fuente del txt del btn
        anchoElem.setText(btnOptions, "Options"); // calcula lo que va a ocupar el btn segun el texto
        btnOptionsX = (ancho - anchoElem.width) / 2f; // coge la posicion x del boton
        btnOptionsY = (alto / 2f) - margen; // coge la posicion y del boton
        btnOptionsAncho = anchoElem.width; // coge el ancho del boton
        btnOptionsAlto = anchoElem.height; // coge el alto del boton

        // btnExit
        btnExit = generator.generateFont(parametros); // tamaño de la fuente del txt del btn
        anchoElem.setText(btnExit, "Exit"); // calcula lo que va a ocupar el btn segun el texto
        btnExitX = (ancho - anchoElem.width) / 2f; // coge la posicion x del boton
        btnExitY = (alto / 2f) - (margen + margen); // coge la posicion y del boton
        btnExitAncho = anchoElem.width; // coge el ancho del boton
        btnExitAlto = anchoElem.height; // coge el alto del boton

        btnBoundsNg = crearBounds(btnNewGameX, btnNewGameY, btnNewGameAncho, btnNewGameAlto);
        btnBoundsOp = crearBounds(btnOptionsX, btnOptionsY, btnOptionsAncho, btnOptionsAlto);
        btnBoundsEx = crearBounds(btnExitX, btnExitY, btnExitAncho, btnExitAlto);

        camera = new OrthographicCamera();
        camera.setToOrtho(false, ancho, alto); // Ajusta a tu resolución

        // Vector3 guarda el punto donde se ha clickado en coordenadas de pantalla
        touchPoint = new Vector3();

        generator.dispose();
    }

    // getters y setter

    // metodos
    @Override
    public void render(float delta) {
        ScreenUtils.clear(0.1f, 0.1f, 0.1f, 1f);

        // actualiza la camara
        camera.update();
        batch.setProjectionMatrix(camera.combined); // esto hace que el batch use la camara

        // se le asigna la posicion del raton (X, Y) y Z = 0 porque es 2D
        touchPoint.set(Gdx.input.getX(), Gdx.input.getY(), 0);

        // convierte las coordenadas de pantalla a coordenadas del mundo del juego
        // esto arregla el Y invertido automaticamente
        camera.unproject(touchPoint);

        batch.begin();

        // Aqui se dibuja los textos
        anchoElem.setText(titulo, "Dead Signal");
        titulo.draw(batch, "Dead Signal", (ancho - anchoElem.width) / 2f, alto - 100f);

        anchoElem.setText(btnNewGame, "New Game");
        btnNewGame.draw(batch, "New Game", (ancho - anchoElem.width) / 2f, alto / 2f);

        anchoElem.setText(btnOptions, "Options");
        btnOptions.draw(batch, "Options", (ancho - anchoElem.width) / 2f, (alto / 2f) - margen);

        anchoElem.setText(btnExit, "Exit");
        btnExit.draw(batch, "Exit", (ancho - anchoElem.width) / 2f, (alto / 2f) - (margen + margen));

        if (btnBoundsNg.contains(touchPoint.x, touchPoint.y) ||
                btnBoundsOp.contains(touchPoint.x, touchPoint.y) ||
                btnBoundsEx.contains(touchPoint.x, touchPoint.y)) {
            Gdx.graphics.setSystemCursor(Cursor.SystemCursor.Hand);
        } else {
            Gdx.graphics.setSystemCursor(Cursor.SystemCursor.Arrow);
        }

        if (Gdx.input.justTouched()) {// Detecta si se ha clickado en la pantalla

            // Usamos contains para verificar si el clic está dentro del rectángulo
            if (btnBoundsNg.contains(touchPoint.x, touchPoint.y)) {
                ((Game) Gdx.app.getApplicationListener()).setScreen(new panelJuego());
            }

            if (btnBoundsOp.contains(touchPoint.x, touchPoint.y)) {

            }

            if (btnBoundsEx.contains(touchPoint.x, touchPoint.y)) {
                Gdx.app.exit();
            }
        }

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

    private Rectangle crearBounds(float x, float y, float ancho, float alto) {
        return new Rectangle(x, y - alto, ancho, alto);
    }
}