package de.dragonrex.new_engine.camera;

import org.joml.Matrix4f;
import org.joml.Vector3f;

public class Camera3D {
    private final Vector3f position = new Vector3f(0, 0, 3);

    private float yaw   = -90f; // schaut nach -Z
    private float pitch = 0f;

    private final Vector3f front = new Vector3f(0, 0, -1);
    private final Vector3f up    = new Vector3f(0, 1, 0);
    private final Vector3f right = new Vector3f(1, 0, 0);

    private final Matrix4f view = new Matrix4f();
    private final Matrix4f projection;

    public Camera3D(float fov, float aspect, float near, float far) {
        projection = new Matrix4f().perspective(fov, aspect, near, far);
        updateVectors();
        updateViewMatrix();
    }

    public void rotate(float dpitch, float dyaw, float droll) {
        pitch += dpitch;
        yaw   += dyaw;

        // Pitch begrenzen → kein Überschlagen
        pitch = Math.max(-89f, Math.min(89f, pitch));

        updateVectors();
        updateViewMatrix();
    }

    private void updateVectors() {
        front.x = (float) (Math.cos(Math.toRadians(yaw)) * Math.cos(Math.toRadians(pitch)));
        front.y = (float) Math.sin(Math.toRadians(pitch));
        front.z = (float) (Math.sin(Math.toRadians(yaw)) * Math.cos(Math.toRadians(pitch)));
        front.normalize();

        right.set(front).cross(up).normalize();
    }

    public void moveForward(float amount) {
        position.add(new Vector3f(front).mul(amount));
        updateViewMatrix();
    }

    public void moveBackward(float amount) {
        position.sub(new Vector3f(front).mul(amount));
        updateViewMatrix();
    }

    public void moveRight(float amount) {
        position.add(new Vector3f(right).mul(amount));
        updateViewMatrix();
    }

    public void moveLeft(float amount) {
        position.sub(new Vector3f(right).mul(amount));
        updateViewMatrix();
    }

    public void setPosition(float x, float y, float z) {
        position.set(x, y, z);
        updateViewMatrix();
    }
    private Vector3f getForward() {
        Vector3f forward = new Vector3f();

        forward.x = (float) Math.cos(Math.toRadians(yaw)) * (float) Math.cos(Math.toRadians(pitch));
        forward.y = (float) Math.sin(Math.toRadians(pitch));
        forward.z = (float) Math.sin(Math.toRadians(yaw)) * (float) Math.cos(Math.toRadians(pitch));

        return forward.normalize();
    }

    private void updateViewMatrix() {
        view.identity();
        view.lookAt(
                position,
                new Vector3f(position).add(front),
                up
        );
    }

    public Matrix4f getView() {
        return view;
    }

    public Matrix4f getProjection() {
        return projection;
    }

    public Vector3f getPosition() {
        return position;
    }
}