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

import java.util.ArrayList;

/**
 * DrawView enthält die Zeichenfunktionalität und ist eine View-Subklasse.
 * Das Zeichnen wird durch Aufruf der Methode onDraw ausgelöst.
 */
public class DrawView extends View implements OnTouchListener {

    private static final String TAG = "DrawView";

    // Die gewählten Punkte werden in einer ArrayList aufgezeichnet
    ArrayList<Circle> circles = new ArrayList<Circle>();

    // Die Eigenschaften des gezeichneten Objekts werden in einem Paint-Objekt gespeichert
    private Paint myPaint;

    // Die geometrischen Eigenschaften des Kreisobjekts
    private float mx = 300;
    private float my = 500;
    private float radius = 50;

    public DrawView(Context context) {
        super(context);
        setFocusable(true);
        setFocusableInTouchMode(true);

        // Dieses Instanz stellt auch den Eventhandler für das OnTouch-Event bereit (s.u.)
        this.setOnTouchListener(this);

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
        // Zeichne alle in der Circle-Liste gespeicherten Kreise
        for (Circle c : circles) {
            myPaint.setColor(c.farbe);
            canvas.drawCircle(c.mp.mx, c.mp.my, c.radius, myPaint);
        }
    }

    public boolean onTouch(View view, MotionEvent event) {

        // Die Koordinaten des Touch-Events holen und in einer Point-Instanz speichern
        Point point = new Point();
        point.mx = event.getX();
        point.my = event.getY();

        // Eine neue Circle-Instanz anlegen und in der Liste circles speichern
        Circle circle = new Circle(point, 100, "");
        circles.add(circle);
        invalidate();

        return true;
    }
}

