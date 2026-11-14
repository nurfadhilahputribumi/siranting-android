# SIRANTING – Android Application

SIRANTING is an Android application developed to support maternal and child health monitoring through data input, risk assessment, and educational information.

## Overview

This project is the Android version of SIRANTING, developed using Kotlin and Jetpack Compose. It provides an interface for users to access health-related features, submit maternal and child data, and view assessment results.

## Key Features

- **User Authentication** – Login, registration, and password recovery.
- **Dashboard** – Main application interface and navigation.
- **Pregnancy Monitoring** – Forms for entering pregnancy-related information.
- **Child Monitoring** – Data input and records for toddlers.
- **Lactation Information** – Lactation-related data input.
- **Risk Assessment** – Assessment logic implemented through a scoring engine.
- **Health Education** – Educational content related to maternal and child health.
- **Admin Features** – Administrative interface and supporting components.
- **Multi-language Support** – Language selection and localization support.

## Technology Stack

| Category | Technology |
|---|---|
| Programming Language | Kotlin |
| UI Framework | Jetpack Compose |
| IDE | Android Studio |
| Backend Services | Firebase |
| Build System | Gradle |
| Version Control | Git & GitHub |

## Project Structure

```text
app/
├── src/main/
│   ├── java/com/siranting/siranting/
│   │   ├── components/
│   │   ├── firebase/
│   │   ├── models/
│   │   ├── navigation/
│   │   ├── screens/
│   │   ├── ui/theme/
│   │   ├── utils/
│   │   ├── viewmodel/
│   │   └── MainActivity.kt
│   └── res/
├── build.gradle.kts
└── proguard-rules.pro

gradle/
build.gradle.kts
settings.gradle.kts
```

## Getting Started

### Prerequisites

- Android Studio
- Android SDK
- JDK compatible with the project's Gradle configuration
- Firebase project configuration

### Installation

1. Clone this repository:

   ```bash
   git clone https://github.com/nurfadhilahputribumi/siranting-android.git
   ```

2. Open the project in Android Studio.

3. Configure Firebase by placing your own `google-services.json` file inside the `app/` directory.

4. Sync the project with Gradle.

5. Build and run the application on an Android device or emulator.

## Firebase Configuration

The `google-services.json` file is intentionally excluded from this public repository.

To run the application, configure your own Firebase project and add the corresponding configuration file to:

```text
app/google-services.json
```

Do not commit private credentials, signing keys, or sensitive configuration files.

## Repository

GitHub: https://github.com/nurfadhilahputribumi/siranting-android

---

**SIRANTING – Android Application**  
Developed with Kotlin and Jetpack Compose.
