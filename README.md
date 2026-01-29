# 🏎️ BeamNG.drive RemotePro (Ultra Edition)

[![Android](https://img.shields.io/badge/Android-Target%2034-green.svg)](https://developer.android.com/about/versions/14)
[![License](https://img.shields.io/badge/License-MIT-blue.svg)](LICENSE)
[![Status](https://img.shields.io/badge/Status-Ultra%20Responsive-orange.svg)](#features)

A high-performance, pro-tuned evolution of the official BeamNG.drive Remote Control. This version is built for the most immersive driving experience possible, featuring advanced physics-based haptics and zero-lag sensor fusion.

---

## 📜 The Heritage
This project has a long history of evolution:
1.  **The Original (2016):** Created by **BeamNG GmbH** as a simple controller. Later abandoned.
2.  **The Modernization:** Forked by a community developer to update the codebase to AndroidX and modern SDKs.
3.  **The Pro Edition (Current):** Further forked and heavily overhauled by **ThaYTOfficial**. This version introduced the **Complementary Filter** steering, **Tiered Crash Haptics**, and the **Ultra-Low Latency HUD**.

---

## 🚀 The Tech: Why RemotePro?

The biggest change in the **Pro Edition** is the move away from standard Android "Rotation Vector" sensors. We implemented a custom **Physics-Based Sensor Fusion** system.

### 🧪 Sensor Comparison
| Feature | Standard Apps | **RemotePro (Fusion)** |
| :--- | :--- | :--- |
| **Logic** | Accelerometer Only (Tilt) | **Complementary Filter (Gyro + Accel)** |
| **Response** | 50ms - 100ms Latency | **< 10ms Latency (Near Instant)** |
| **Stability** | Jittery & sensitive to small bumps | **Butter-smooth and precise** |
| **Centering** | Slow "rubber-band" effect | **Instant, physics-driven snap-back** |

> [!IMPORTANT]
> By fusing the high-speed **Gyroscope** (for rotation) with the stable **Accelerometer** (for gravity reference), RemotePro delivers a steering experience that feels like a real sim-racing wheel, not a phone tilt.

---

## 🌟 Pro Features

### 🎮 Pro-Grade Steering
*   **Sensor Fusion (Complementary Filter):** Combines raw Gyroscope and Accelerometer data to eliminate the "floaty" feeling of standard filters.
*   **Zero Drift:** Perfect centering and instant response.
*   **Landscape Normalization:** Automatically recalibrates steering baseline for 90° and 270° device rotations.
*   **360° Mode:** Optional full-circle steering support for drifting.

### 💥 Advanced Haptic Engine
*   **Tiered Crash Detection:** Feel the difference between a minor scrape (light buzz), a medium shunt (sharp pulse), and a severe collision (long heavy rumble).
*   **Simulated Brake Feel:** Low-intensity vibration when slamming brakes (>85%) to simulate ABS and tire stress.
*   **Stall Shudder:** Physical vibration warning when the engine is struggling at low RPMs.
*   **Mechanical Gear Clicks:** Crisp haptic pulses for every gear shift.

### 📊 Low-Latency Pro Dashboard
*   **120ms Refresh Rate:** Animation duration reduced by 400% for near-instant visual feedback.
*   **Arc-Perfect Scaling:** Indicators (Fuel, Temp, RPM, Speed) are precisely calibrated to their visual arcs to prevent overflow.
*   **Smart HUD:** 
    - Support for **10+ Gears**.
    - **MPH / KMH** quick toggle.
    - Operating temperature centering (Normal is centered).
    - IP Address auto-discovery on the welcome screen.

---

## 🛠️ How to Setup

### 1. Network Prep
- Ensure your phone and PC are on the **same Wi-Fi network**.
- Open RemotePro—it will display your **Device IP** (e.g., `192.168.1.15`).

### 2. BeamNG.drive Configuration
1. Go to **Settings > Gameplay**.
2. Scroll to **OutGauge Support**.
3. **Enable OutGauge**: ✅
4. **IP**: Enter the IP displayed on your phone's welcome screen.
5. **Port**: `4445` (default).

---

## 📡 Technical Documentation (OutGauge Protocol)

| Offset | Type | Name | Description |
| :--- | :--- | :--- | :--- |
| 0-3 | unsigned | `time` | Timestamp (ms) |
| 10 | char | `gear` | R:0, N:1, 1st:2... |
| 12-15 | float | `speed` | Velocity in m/s |
| 16-19 | float | `rpm` | Engine RPM |
| 24-27 | float | `engTemp` | Temperature in Celsius |
| 28-31 | float | `fuel` | Tank capacity (0.0 to 1.0) |
| 44-47 | unsigned | `showLights` | Active dashboard lights (ABS, Fullbeam, etc) |
| 48-51 | float | `throttle` | 0.0 to 1.0 |
| 52-55 | float | `brake` | 0.0 to 1.0 |

---

## 📜 Credits & License
- Original App (2016) by **BeamNG GmbH**.
- Heritage Modernization by the **umutsevimcann**.
- Pro Tuning & Expansion by **ThaYTOfficial**.
- Licensed under the **MIT License**.

