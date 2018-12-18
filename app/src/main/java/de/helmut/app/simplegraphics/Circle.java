package de.helmut.app.simplegraphics;

import android.graphics.Color;

public class Circle {
    Point mp;
    float radius;
    int farbe;
    String text;

    public Circle(Point mp, float radius, String text) {
        this.mp = mp;
        this.text = text;
        this.radius = radius;

        // Die Farbe wird zufällig generiert
        farbe = Color.rgb((float)Math.random(),(float)Math.random(),(float)Math.random());
    }
}
