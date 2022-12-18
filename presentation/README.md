# Presentation Documentation

This is presentation document. `UI Components` (/presentation) package.

## View State

use ViewState to Avoid using many show() and hide() for views that has changing states. e.g. Screen my show loading until data loads.
Then data will be appear. 

At this condition use `ViewFlipper`. Each states will be ViewFlipper's children. General style to use ViewFlipper 
is : 

|Index|State|
|-----|-----|
|0|Success|
|1|Wait|
|2|Error|
|3|Placeholder|

E.g. We want to show data to use with TextView, Loading with progressbar , Failure with dialog and there is no place holder for
this screen. 

xml layout :

```xml
    <ViewFlipper
        android:id="@+id/flipper"
        android:layout_width="match_parent"
        android:layout_height="wrap_content">
        <!--success-->
        <TextView
            android:id="@+id/textView"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content" />
        <!-- loading-->
        <ProgressBar
            android:layout_width="wrap_content"
            android:layout_height="wrap_content" />
        <!--Error-->
        <View
            android:layout_width="wrap_content"
            android:layout_height="wrap_content" />
        <!--Placeholder-->
        <View
            android:layout_width="wrap_content"
            android:layout_height="wrap_content" />
    </ViewFlipper>
```

Sample data class : 
```kotlin
data class Sample(val resultString: String = "")
```

when is not suppose to use or to show any widgets on screen, we should fill that child with empty `View`.
ViewModel can should update state : 
```kotlin
 _viewState.value = SampleState(expectedData = ViewFlipState.Success(data = Sample()))
```

and at fragment can use it at `renderView` :
```kotlin
  state.expectedData?.let {
            if (it is ViewFlipState.Success) {
                textView.text = it.data.resultString
            }

            flipper.displayedChild = it.displayChild
        }

```
