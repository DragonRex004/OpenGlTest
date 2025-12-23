package de.dragonrex.new_engine.input;

import org.lwjgl.glfw.GLFW;

import java.util.HashSet;
import java.util.Set;

public class Mouse {

    private static double x, y;
    private static double lastX, lastY;
    private static double deltaX, deltaY;
    private static double scrollY;

    private static Set<Integer> pressedButtons = new HashSet<>();

    public static void init(long window) {

        GLFW.glfwSetCursorPosCallback(window, (w, xpos, ypos) -> {
            lastX = x;
            lastY = y;
            x = xpos;
            y = ypos;

            deltaX = x - lastX;
            deltaY = y - lastY;
        });

        GLFW.glfwSetMouseButtonCallback(window, (w, button, action, mods) -> {
            if (action == GLFW.GLFW_PRESS) pressedButtons.add(button);
            if (action == GLFW.GLFW_RELEASE) pressedButtons.remove(button);
        });

        GLFW.glfwSetScrollCallback(window, (w, xoffset, yoffset) -> {
            scrollY += yoffset;
        });
    }

    public static double getX() { return x; }
    public static double getY() { return y; }

    public static double getDeltaX() { return deltaX; }
    public static double getDeltaY() { return deltaY; }

    public static boolean isButtonDown(int button) {
        return pressedButtons.contains(button);
    }

    public static double consumeScrollY() {
        double value = scrollY;
        scrollY = 0;
        return value;
    }
}

