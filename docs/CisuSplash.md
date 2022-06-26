## 1. Cisu Splash ✨

<p align="center">
<img src = "https://raw.githubusercontent.com/fahmirumagutawan/Cisu-Jetpack-Component/master/CisuSplash/ezgif-4-8193535522.gif" height = "512" >
</p>

-   ### Default Implementation
```kotlin
    val scope = rememberCoroutineScope()
    val splash = CisuSplash()
                    .(IMPLEMENT SOME COMMAND)
                    .(IMPLEMENT SOME COMMAND)
                    ...
    
    val mySplash = splash.build(myCoroutineScope)
```

-   ### Command Table

| No | Command | Function | Sample Parameter |
|--|--| --| --|
| 1 | `setBackground(color:Color)` | Used to set background of the main surface behind | `Color.Black` |
| 2 | `setLogo(logoId:Int)` | Used to change the logo into your own logo | `R.drawable.ic_explore`   |
| 3 | `setShadowIcon(iconId:Int)` | In default, shadow effect is using your logo that has tint set to some color. But in here, you able to change your shadow with vector freely | `R.drawable.ic_explore` |
| 4 | `setTints(listOfTint:List<Color>)` |  This function is used to set your shadow color. Shadow will automatically appear as much as this tint list size  |  `listOf(Color.Yellow, Color.Yellow, Color.Yellow)` |
| 5 | `setDefaultSize(size:Dp)` | This function is used to set the size of your logo, and all of your shadow before being animated | `40.dp` |
| 6 | `setZoomedSize(size:Dp)` | Actually our splash is working with animating all of the shadows. So, this function will set zoomed size of your shadow specifically | `128.dp` |
| 7 | `setShadowStill(isShadowStill:Boolean)` | In default, your shadow will not going anywhere after being animated. But you can set it to be disappeared after its finished its animation, by using this function |  `true` |
| 8 | `build(scope:CoroutineScope)` | This function should be called last. This function is used to return all of your customization before. Even if you were not customizing anything, you still have to call this function | `rememberCoroutineScope()` |
