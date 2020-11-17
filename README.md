# HalloweenLoader
This is a custom loader that you can use in your android project

# Build

Step 1. Add the JitPack repository to your build file

Add it in your root build.gradle at the end of repositories:

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
  
  Step 2. Add the dependency
  
	dependencies {
	        implementation 'com.github.alokverma:HalloweenLoader:Tag'
	}
  
   # How to use
  
         <com.akki.halloweenloader.HalloweenLoader
            android:id="@+id/loader"
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            app:halloween_loader_animation_duration="3000"
            app:halloween_loader_fifth_layer_color="#50305b"
            app:halloween_loader_fourth_layer_color="#7d1a4e"
            app:halloween_loader_inner_most_color="#fcf6a8"
            app:halloween_loader_radius="500"
            app:halloween_loader_second_layer_color="#f8c154"
            app:halloween_loader_stroke="10dp"
            app:halloween_loader_third_layer_color="#f37a51"
            app:layout_constraintBottom_toBottomOf="parent"
            app:layout_constraintLeft_toLeftOf="parent"
            app:layout_constraintRight_toRightOf="parent"
            app:layout_constraintTop_toTopOf="parent" />

You can pass layer's color, loader animation duration, radius and stroke according to your need.

you can call showProgress() method to display the loader and hideProgress() method to hide the loader.
	
	  val loader = findViewById<HalloweenLoader>(R.id.loader)
	  loader.showProgress()
	  loader.hideProgress()
	  
  
 # Demo 
  <p align="center">
  <img src="https://user-images.githubusercontent.com/7018540/99365949-efbdaa00-28dd-11eb-9a24-c7e99af26dc1.gif" width="350" title="HalloweenLoader">
  </p>
