# TagView-Library
Simple library to representing data like tags

# Gradle dependency 
Add this dependency in your module's build.gradle file:
```
dependencies {
    implementation 'com.github.Abdulrahman-Tayara:TagView-Library:1.0'
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

<b>Screenshots<b>

![Screen 1](https://github.com/Abdulrahman-Tayara/TagView-Library/blob/master/flexlistlayout/screenshots/IMG_20200415_173456.jpg)

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
