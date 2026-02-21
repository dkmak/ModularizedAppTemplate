# Modularized App

## App

### How to Run Application

### Design Overview
#### General Project Structure (Multi-Modular)
Multi-modular project setup enforces separation of concerns, improves build times, and helps reusability.
- Modules have distinct responsibilities
- Gradle can build modules in parallel, changes to one module will only recompile that specific module the modules that it depend on it
- Reusable - modules can easily be reused to create new screens and features 

```
app -
    main
        - MainActivity 
core - Core components shared by all features
    common-ui - shared UI components, elements, themes, colors, resources, strings some navigation components
        - res (drawables, themes)
    data 
    database
    model
    navigation
    network - manages the remote data fetching and provides the API client to the data layer
feature
    

gradle
    libs.versions - manage libraries, versions
build.gradle
settings.gradle    
```

#### App Architecture


#### Libraries and Tools
- UI: Jetpack Compose, Compose Navigation, Coil
- Dependency Injection: Dagger Hilt
- Local Database: Room
- Networking: Retrofit (and OkHTTP by extension), Kotlinx.Serialization for serializing JSON
- Coroutines for asynchronous tasks
- Testing: Junit, `kotlinx-coroutines-test`, `mockk`

#### Things of Note


#### Potential Improvements
