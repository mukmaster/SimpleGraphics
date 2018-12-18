package de.helmut.app.simplegraphics;

/**
 * Ein Punkt ist ein sehr einfaches Objekt, das aus zwei float-Koordinaten besteht.
 * Auf getter-/setter-Methoden wird diesmal verzeichnet und daher sind die Datenfelder
 * ausnahmsweise mal public.
 */
public class Point {
    public float mx, my;

    @Override
    public String toString() {
        return mx + ", " + my;
    }
}
