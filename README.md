

![Release](https://jitpack.io/v/fahmirumagutawan/Cisu-Jetpack-Component.svg)
# Welcome to Cisu Jetpack-Component
<p align="Center">
  <img src="https://cdn.freebiesupply.com/logos/large/2x/kotlin-1-logo-png-transparent.png" height="128"/>
  &nbsp
  &nbsp
  &nbsp
  &nbsp
  &nbsp
  <img src="https://miro.medium.com/max/1400/1*UpiyYV4onPs4emx-whdVHA.png" height="128"/>
  &nbsp
  &nbsp
  &nbsp
  &nbsp
  &nbsp
  <img src="https://tabris.com/wp-content/uploads/2021/06/jetpack-compose-icon_RGB.png" height="128"/>
<p align="center">Technologies we are using now</p>
</p>

`Cisu Jetpack-Component` is a library that can be used by Android (Jetpack Compose) Developer to made its developing easier. Right now we are targeting only Jetpack Compose, but not impossible if someday we release for other developing environment.

# Preparation
Before you able to accessing `Cisu`, you have to know that we are using `Jitpack` to make this library public. So you have to include Jitpack inside your project first.

### 1. Setup for Jitpack
-   For old version of gradle (before arctic fox update)
    
    Add this in your root  `build.gradle`  file (project scope) :
    
    ```gradle
    allprojects {
	    repositories {
		    ..
		    maven { url "https://jitpack.io" }
	    }
    }
    ```

-   For gradle version 7 or latest

    Add this in your root `setting.gradle` file :
    
    ```gradle
    dependencyResolutionManagement {
        repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
        repositories {
            ..
            maven { url 'https://jitpack.io' }
        }
    }
    
    ```
    
### 2. Setup Cisu to Your Dependency

-   After succesfully including Jitpack, right now you able to implement `Cisu` in your project.

    Add this to your `build.gradle` (app scope) :
    ```gradle
    dependencies {
        ..
        implementation 'com.github.fahmirumagutawan:Cisu-Jetpack-Component:$cisu_version'
    }
    ```
    > You can find `cisu_version` on Jitpack Badge above, or on our release tag.

# Documentation

### 1. [Cisu Splash Screen](https://github.com/fahmirumagutawan/Cisu-Jetpack-Component/blob/master/docs/CisuSplash.md) ✨
- Cisu Splash Screen is a composable to help you instantly make your own splash screen as easy as writing few lines of code.

### 2. [Cisu Surface With Bottom Navigation Bar](https://github.com/fahmirumagutawan/Cisu-Jetpack-Component/blob/master/docs/CisuSurface.md)
- Have you ever feeling that making page with bottom navigation bar is kind of frustating. So you have to try this function then. 

# Contact Me
If you want to discuss about business, or maybe have a critic and advice. Feel free to be messaged everytime-everywhere. 

-	#### 👨🏽‍💻 Email = `fahmigutawan@gmail.com`
-	#### 📸 [Instagram](https://www.instagram.com/fahmigutawan/)
-	#### 📚 [LinkedIn](https://www.linkedin.com/in/fahmi-noordin-rumagutawan-0b506521b/)
