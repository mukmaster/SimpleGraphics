package de.helmut.app.simplegraphics;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

/**
 * DrawView enthält die Zeichenfunktionalität und ist eine View-Subklasse.
 * Das Zeichnen wird durch Aufruf der Methode onDraw ausgelöst.
 */
public class DrawView extends View  {

    private static final String TAG = "DrawView";

    // Die Eigenschaften des gezeichneten Objekts werden in einem Paint-Objekt gespeichert
    private Paint myPaint;

    public DrawView(Context context) {
        super(context);
        setFocusable(true);
        setFocusableInTouchMode(true);

        // Eine Instanz von Paint erzeugen, Farbe auf Rot setzen, Antialiasing einschalten.
        myPaint = new Paint();
        myPaint.setColor(Color.RED);
        myPaint.setAntiAlias(true);
    }

    /* Die onDraw-Methode bekommt beim Aufruf vom Androidsystem eine Canvas-Instanz als
       Parameter mit, auf die schließlich Objekte gezeichnet werden können.
    */
    @Override
    public void onDraw(Canvas canvas) {
        // Zeichne ein Kreis mit x=300, y=500, radius=200 und den myPaint-Eigenschaften
        canvas.drawCircle(300, 500,200, myPaint);
    }
}

