## 2. Cisu Surface
<p align="center">
<img src = "https://raw.githubusercontent.com/fahmirumagutawan/Cisu-Jetpack-Component/master/docs/CisuSurface_Preview.gif" height = "512" >
<p align="center">Cisu Surface is a composable that has similarity use with regular Surface. The different is Cisu Surface also accommodate  Bottom Navigation Bar with simpler way.</p>
</p>

-	### Default Implementation
	- #### Instantiate your list of bottom menu item
	```kotlin
	var listOfMenu = listOf(  
		CisuSurfaceBottomItem(  
			iconId = R.drawable.ic_circle,  
			state = remember{ mutableStateOf(true)},/**We set here to true, */
			onClick = {/**DO SMTH*/}		/**to set default item to be selected first*/  
		),  
		CisuSurfaceBottomItem(  
			iconId = R.drawable.ic_circle,  
			state = remember{ mutableStateOf(false)},  
			onClick = {/**DO SMTH*/}
		),CisuSurfaceBottomItem(  
			iconId = R.drawable.ic_circle,  
			state = remember{ mutableStateOf(false)},  
			onClick = {/**DO SMTH*/}
		)  
	)
	```
	- #### After that, you can call `Cisu Surface` like normal composable, and then put your `listOfMenu` as parameter
	```kotlin
		CisuSurface(  
		    bottomMenuColor = Color(0xFFA7BDFF),  
			listOfBottomMenuItem = listOfMenu,
			/**STILL LOT OF PARAMETER THAT YOU CAN IMPLEMENT HERE*/
		) {  
			/**You can place any composable inside this block.*/
			/**But we are very recommend you to use Navigation instead.*/  
		}
	```  
- ### Some Things to be Known
	- Inside `content`, you can implement any composable, similar as regular Surface.
	- Inside `CisuSurfaceItem`, I recommend you to declare `state` separately (not directly inside instantiation). The purpose is to make your `state` accessible from other places, so you can set your item state manually. 
