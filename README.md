# Dungeons & Dragons Character Manager

## Overview
A desktop application for creating, managing, and visualizing Dungeons & Dragons (5e-style) characters. The app focuses on clean UI design, strong data modeling, and game-rule–aware interactions such as equipment constraints and spell slot tracking.

I am building this project not only to further my skills as a developer and show them off but this app is something I will use in my weekly game of Dungeons & Dragons. I work on this app in my free time so there is a long list of features I am still working on. I will continue to update this README as updates come.

This is the first time I'm using JavaFX and it's an enjoyable experience for me. Not only has working on this helped satiate my drive to keep learning but also made me a better developer in my day job.

---

## Key Features
- **Character Sheet Management**
  – Centralized view of character stats, equipment, and spell resources
- **Drag-and-Drop Equipment System**
  - Slot-based equipment validation (armor, weapons, accessories)
  - Automatic replacement logic when equipping new items
  - Inventory updates in real time
- **Two-Handed Weapon Logic**
  - Enforces mutual exclusivity between weapon slots
  - Prevents invalid equipment states
- **Spell Slot UI**
  - Dynamic spell slot counters
  - UI updates tied to underlying character state
- **Extensible Data Models**
  - Clear separation between character data, equipment rules, and UI controllers

---

## Tech Stack
- **Language:** Java  
- **UI Framework:** JavaFX (FXML + Controllers)  
- **Architecture:** MVC-inspired separation (Models, Controllers, UI)  

---

## Architecture Highlights
- **FXML + Controller Pattern** – Declarative UI layout with strongly typed controller logic
- **State-Driven UI Updates** – UI components react to changes in character state rather than being rebuilt unnecessarily
- **Rule-Aware Domain Models** – Game rules (equipment slots, spell limits) enforced at the model/controller layer instead of the UI layer
- **Reusable UI Components** – Inventory items and slots designed for extensibility

---

## Why JavaFX?
This project intentionally uses JavaFX to demonstrate:
- Desktop UI development fundamentals transferable to other frameworks (React, Swing, Electron)
- Strong typing and compile-time safety for complex state interactions
- Clear separation of concerns in a medium-sized application

---

## Screenshots / Demo
<!--->TODO<--->

---

## Getting Started

### Prerequisites
- Java 17+
- JavaFX configured locally

### Running the App
1. Clone the repository
2. Open the project in your IDE
3. Run the main application class

---

## Future Enhancements
- Character persistence (save/load)
- Class-specific spell rules
- Feats and passive abilities
- Exportable character sheets
- Potential web-based port (React + backend API)

---

## Resume-Relevant Skills Demonstrated
- Object-oriented design and domain modeling
- UI state management
- Drag-and-drop interactions
- Rule validation and constraint enforcement
- Iterative debugging and feature expansion

---

## Author
**Jared Frank**  
Portfolio project demonstrating desktop application development and UI architecture
