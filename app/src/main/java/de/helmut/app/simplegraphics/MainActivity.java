package de.helmut.app.simplegraphics;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

/**
 * Dies ist die (gewohnte) Startactivity-Klasse. Im Gegensatz zu den bisherigen Beispielen
 * wird hier kein XML-Layout aus den Ressourcen benötigt. Stattdessen wird das Fenster der
 * Activity auf Fullscreen gesetzt und ein eine Instanz der (selbstprogrammierten) Klasse
 * DrawView als Inhalt festgelegt.
 */
public class MainActivity extends AppCompatActivity {

    DrawView drawView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Den Anzeigebereich auf Fullscreen setzen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        // Das Layout wird durch ein DrawView-Objekt festgelegt (siehe DrawView.java)
        drawView = new DrawView(this);
        setContentView(drawView);
        drawView.requestFocus();
    }
}