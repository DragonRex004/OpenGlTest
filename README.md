# NexoEngine

**NexoEngine** ist eine modulare, in Java geschriebene 3D-Game-Engine auf Basis von **LWJGL / OpenGL**.  
Der Fokus liegt auf **klarer Architektur**, **sauberer Trennung von Verantwortlichkeiten** und **Erweiterbarkeit** – ideal für Experimente, Engine-Entwicklung und Spiele wie einen Minecraft-ähnlichen Voxel-Ansatz.

---

## ✨ Features (aktueller Stand)

### Core
- Szenen-System (`Scene`, `SceneManager`)
- GameObject / Component-Architektur
- Transform-System (Position, Rotation, Scale)
- Saubere Trennung von Core & Systemen

### Window & Input
- GLFW Window Management
- Windowed / Borderless Fullscreen
- Resize-fähiger Viewport
- Keyboard- & Mouse-Input
- Maus-Look (FPS-Style)

### Rendering
- OpenGL Renderer (LWJGL)
- RenderQueue / RenderSystem
- Shader-System + ShaderLibrary
- Material-System (Color, Lighting)
- Directional Light (Sonne)
- CameraComponent + CameraSystem
- Backface Culling + Depth Testing

### Primitive Renderer
- CubeRenderer
- SphereRenderer
- CapsuleRenderer
- Zentrale `MeshFactory` mit Mesh-Caching

### Test & Debug
- Separates Testbed-Modul
- Primitive-Rendering zum Engine-Test
- Debug-freundliche Architektur

---

## 🧠 Architektur-Prinzipien

- **engine-core** kennt kein Rendering und kein Window
- **engine-runtime** orchestriert alles (Main Loop)
- **Rendering & Window** sind klar getrennte Systeme
- Keine zyklischen Modul-Abhängigkeiten
- OpenGL-Code nur im Rendering-Modul

> Core = *Was existiert*  
> Runtime = *Was passiert*  
> Rendering = *Wie es gezeichnet wird*

---

## 🎮 Kamera & Steuerung

- Maus steuert Yaw & Pitch (FPS-Stil)
- Bewegung relativ zur Blickrichtung:
  - **W / S** → vor / zurück
  - **A / D** → links / rechts
  - **Space / Shift** → hoch / runter
- Bewegung unabhängig von Pitch (kein ungewolltes Fliegen)

---

## 🚀 Starten (Testbed)

1. Repository klonen
2. Projekt als **Multi-Module-Maven-Projekt** öffnen
3. `engine-testbed` TestBed Main starten

---

## 🛠️ Geplante Features

- Texture Rendering
- OBJ / GLTF Model Loading
- Collider-System (Box, Sphere, Capsule)
- Raycasting
- UI-System (Button, Label, Slider)
- Physics & Gravity
- Voxel Lighting (Minecraft-Style)
- Greedy Meshing
- Editor / Debug Gizmos

---

## 📌 Status

> **Aktiv in Entwicklung**  
> Architektur ist stabil, Features werden iterativ ergänzt.

---

## 📜 Lizenz

MIT License (oder nach Bedarf anpassen)

---

## 👤 Autor

Entwickelt von **Nexoscript**  
(Engine- & Rendering-Experimente, Java, OpenGL)

---
