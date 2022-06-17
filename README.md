
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

## 1. Cisu Splash ✨
-   ### Default Implementation
```kotlin
    val splash = CisuSplash()
                    .(IMPLEMENT SOME COMMAND)
                    .(IMPLEMENT SOME COMMAND)
    
    val mySplash = splash.build(myCoroutineScope)
```

-   ### Command Table

| No | Command | Function | Sample Parameter |
|--|--| --| --|
| 1 | `setBackground(color:Color)` | Used to set background of the main surface behind your logo | `Color.Black` |
| 2 | `setLogo(logoId:Int)` | Used to change the logo to your own logo | `R.drawable.ic_explore`   |
| 3 | `setShadowIcon(iconId:Int)` | In default, shadow effect is using logo that has tint set to some color. But in here, you able to change your shadow vector freely | `R.drawable.ic_explore` |
| 4 | `setTints(listOfTint:List<Color>)` |  This function is used to set your shadow color. Shadow will automatically appear as much as this tint size  |  `listOf(Color.Yellow, Color.Yellow, Color.Yellow)` |
| 5 | `setDefaultSize(size:Dp)` | This function is used to set the size of your logo, and all of your shadow before being animated | `40.dp` |
| 6 | `setZoomedSize(size:Dp)` | Actually our splash is working with animating all of the shadows. So, this function will set zoomed size of your shadow specifically | `128.dp` |
| 7 | `setShadowStill(isShadowStill:Boolean)` | In default, your shadow will not going anywhere after animated. But u can set it to disappeared after its finished animated, by using this function |  `true` |
| 8 | `build(scope:CoroutineScope)` | This function should be called last. This function is used to return all of your customization before. Even if you were not customize anything, you still have to call this function | `rememberCoroutineScope()` |

# Contant Me
If you want to discuss about business, or maybe have a critic and advice. Feel free to be messaged everytime-everywhere. 

-	#### 👨🏽‍💻 Email = `fahmigutawan@gmail.com`
-	#### 📸 [Instagram](https://www.instagram.com/fahmigutawan/)
-	#### 📚 [LinkedIn](https://www.linkedin.com/in/fahmi-noordin-rumagutawan-0b506521b/)
