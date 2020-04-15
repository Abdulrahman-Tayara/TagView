# Android TagView-Library
Simple library to represent the data like tags

# Gradle dependency 
Add this dependency in your module's build.gradle file:
```
dependencies {
    implementation 'com.github.Abdulrahman-Tayara:TagView:v1.0'
}
```
Add repository to your app's build.gradle file :
```
allprojects {
    repositories {
      ...
      maven { url 'https://jitpack.io' }
    }
}
```

# Example

<b>Screenshot<b>

![Screen 1](https://github.com/Abdulrahman-Tayara/TagView-Library/blob/master/flexlistlayout/screenshots/IMG_20200415_173456.jpg)

In XML
```xml
<com.tayara.taglayout.TagLayout
        android:id="@+id/tag_view"
        android:layout_width="match_parent"
        android:layout_height="300dp"
        app:tag_close_button_enable="true"
        app:tag_close_button_image="@drawable/ic_close_24px"
        app:tag_textSize="8dp" />
```

In Java
```Java
TagLayout tagView = findViewById(R.id.tag_view);
tagView.addTag("Sunday");
tagView.addTag("Monday");
tagView.addTag("Tuesday");
tagView.addTag("Wednesday");
tagView.addTag("Thursday");
tagView.addTag("Friday");
tagView.addTag("Saturday");
```
Available Attributes :

* tag_background
* tag_textColor
* tag_margin
* tag_text_button_space (To determine the space between the text and the close button)
* tag_left_padding
* tag_right_padding
* tag_top_padding
* tag_bottom_padding

Available methods :

* addTag(text: String)
* addTags(list: List<String>)
* clearTags()
* removeTag(position: int)
* setOnTagClickListener
* setOnCloseButtonClickListener
