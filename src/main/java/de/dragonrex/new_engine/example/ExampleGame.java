package de.dragonrex.new_engine.example;

import de.dragonrex.new_engine.camera.Camera3D;
import de.dragonrex.new_engine.engine.Engine;
import de.dragonrex.new_engine.engine.GameObjectManager2D;
import de.dragonrex.new_engine.engine.GameObjectManager3D;
import de.dragonrex.new_engine.example.objects.Cube3D;
import de.dragonrex.new_engine.example.objects.CubeVertices;
import de.dragonrex.new_engine.example.objects.Triangle2D;
import de.dragonrex.new_engine.shader.Mesh;
import de.dragonrex.new_engine.shader.Shader;
import org.lwjgl.glfw.GLFW;

public class ExampleGame extends Engine {

    private CameraController3D controller;
    private MouseCameraController mouseCam;
    private Shader shader;
    private Mesh cubeMesh;
    private Mesh triangleMesh;

    public ExampleGame() {
        super(800, 600, "2D & 3D Engine");
    }

    @Override
    protected void initGame() {
        controller = new CameraController3D(camera3D, window);
        mouseCam = new MouseCameraController(camera3D);
        GLFW.glfwSetInputMode(window, GLFW.GLFW_CURSOR, GLFW.GLFW_CURSOR_DISABLED);
        shader = new Shader("vertex.glsl", "fragment.glsl");

        // 3D Cube
        cubeMesh = new Mesh(CubeVertices.CUBE_VERTICES); // siehe vorheriges Beispiel
        Cube3D cube = new Cube3D(0f, 0f, 0f, cubeMesh, shader);
        GameObjectManager3D.add(cube);

        // 2D Triangle
        float[] triangleVertices = {
                0f, 50f, 0f, 1f, 0f, 0f,
                50f, -50f, 0f, 0f, 1f, 0f,
                -50f, -50f, 0f, 0f, 0f, 1f
        };
        triangleMesh = new Mesh(triangleVertices);
        Triangle2D triangle = new Triangle2D(600, 100f, triangleMesh, shader);
        GameObjectManager2D.add(triangle);
    }

    @Override
    protected void update(float deltaTime) {
        controller.update(deltaTime);
        mouseCam.update();
        GameObjectManager3D.updateAll();
        GameObjectManager2D.updateAll();
    }

    @Override
    protected void render() {
        GameObjectManager3D.renderAll(camera3D.getProjection(), camera3D.getView());
        GameObjectManager2D.renderAll(camera2D.getProjection());
    }

    @Override
    protected void cleanupGame() {
        GameObjectManager3D.cleanupAll();
        GameObjectManager2D.cleanupAll();
        shader.cleanup();
    }

    void main() {
        new ExampleGame().start();
    }
}

