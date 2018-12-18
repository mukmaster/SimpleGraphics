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
    ArrayList<Point> points = new ArrayList<Point>();

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
        // Zeichne Kreise um alle in der Point-Liste gespeicherten Punkte
        for (Point p : points) {
            canvas.drawCircle(p.mx,p.my, radius, myPaint);
        }
    }

    public boolean onTouch(View view, MotionEvent event) {

        // Die Koordinaten des Touch-Events holen und in einer Point-Instanz speichern
        Point point = new Point();
        point.mx = event.getX();
        point.my = event.getY();

        // Und dann noch die Point-Instanz der Point-Liste hinzufügen
        points.add(point);

        /* Die Zeichenfläche wird nur dann gezeichnet, wenn es notwendig ist. Der Aufruf von
           invalidate() teilt dem Android-System mit, dass dies der Fall ist.
        */
        invalidate();

        return true;
    }
}

