
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
	- #### After that, you can call `Cisu Surface` like a normal composable, and then put your `listOfMenu` as parameter
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
- ### Parameter Table of `Cisu Surface`
	
	| No |Parameter Name | Data Type | Explanation | Default Value |
	|--|--|--|--|--|
	| 1 | `bottomMenuHeight` | `Dp` | This parameter set your bottom navigation menu height. To be clear, height to be set here is not your icon height, but the surface of bottom navigation menu | `64.dp`  |
	| 2 | `bottomMenuColor` | `Color` | Set you bottom navigation menu color | `Color.White` |
	| 3 | `bottomMenuIconPadding` | `Dp` | To make this clear, padding to be set is between `Icon` and `Icon Shadow` | `16.dp` |
	| 4 | `bottomMenuItemDefaultColor` | `Color` | Set the icon color when the state is `unselected (false)` | `Color.Black` |
	| 5 | `bottomMenuItemClickedColor` | `Color` | Set the icon color when the state is `selected (true)` | `Color.Gray` |
	| 6 | `bottomMenuItemHeightDefault` | `Dp` | Set the icon height when the state is `unselected (false)` | `24.dp` |
	| 7 | `bottomMenuItemHeightClicked` | `Dp` | Set the icon height when the state is `selected (true)` | `48.dp` |
	| 8 | `listOfBottomMenuItem` | `List<CisuSurfaceBottomItem>` | If you want to make this surface has bottom navigation menu, then you should call this parameter. (Sample code above) | `null` |
	| 9 | `content` | `() -> @Composable Unit` | As I mentioned before, this surface is kind of similar with regular surface. So you can implement any composable | No Default |

- ### Parameter Table of `Cisu Surface Bottom Item`
	| No | Parameter Name | Data Type | Explanation |
	|--|--|--|--|
	| 1 | `IconId` | `Int` | This parameter is used to set each of your bottom menu item |
	| 2 | `state` | `MutableState<Boolean>` | We recommend you to use `remember` to make sure no bugs happen, or you can just declare you state from `ViewModel` instead |
	| 3 | `onClick` | `() -> Unit` | To set action for each of your bottom navigation item |
- ### Some Things to be Known
	- Inside `content`, you can implement any composable, similar as regular Surface.
	- Inside `CisuSurfaceItem`, I recommend you to declare `state` separately (not directly inside instantiation). The purpose is to make your `state` accessible from other places, so you can set your item state manually. 
