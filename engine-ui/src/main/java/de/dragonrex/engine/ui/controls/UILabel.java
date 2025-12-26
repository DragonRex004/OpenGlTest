package de.dragonrex.engine.ui.controls;

import de.dragonrex.engine.ui.UIElement;
import de.dragonrex.engine.ui.rendering.UIRenderer;
import org.joml.Vector4f;

public class UILabel extends UIElement {

    private String text;
    private Vector4f color = new Vector4f(1, 1, 1, 1);

    public UILabel(float x, float y, String text) {
        this.transform.x = x;
        this.transform.y = y;
        this.text = text;
    }

    @Override
    public void update(float dt) {
        // nichts
    }

    @Override
    public void render() {
        /*
        UIRenderer.drawText(
                text,
                transform.x,
                transform.y,
                color
        );
         */
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setColor(Vector4f color) {
        this.color = color;
    }
}


