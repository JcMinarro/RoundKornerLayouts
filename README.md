Round Korner Layouts [ ![Download](https://api.bintray.com/packages/jcminarro/maven/RoundKornerLayouts/images/download.svg) ](https://bintray.com/jcminarro/maven/RoundKornerLayouts/_latestVersion)
===============

Round Korner Layouts is an Android library create to build a layout with the round corners

Screenshots
-----------

![Demo Screenshot 1][1]

Usage
-----

To use Round Korner Layouts library and get your new UI working you only have to use the layout that fit better for you:

* ``RoundKornerFrameLayout`` if you need a ``FrameLayout``

```xml
<com.jcminarro.roundkornerlayout.RoundKornerFrameLayout
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_margin="8dp"
            app:corner_radius="16dp">
            
            [...]
</com.jcminarro.roundkornerlayout.RoundKornerFrameLayout>
```

* ``RoundKornerLinearLayout`` if you need a ``LinearLayout``

```xml
<com.jcminarro.roundkornerlayout.RoundKornerLinearLayout
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_margin="8dp"
            android:orientation="vertical"
            app:corner_radius="16dp">
            
            [...]
</com.jcminarro.roundkornerlayout.RoundKornerLinearLayout>
```

* ``RoundKornerRelativeLayout`` if you need a ``RelativeLayout``

```xml
<com.jcminarro.roundkornerlayout.RoundKornerRelativeLayout
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_margin="8dp"
            app:corner_radius="16dp">
            
            [...]
</com.jcminarro.roundkornerlayout.RoundKornerRelativeLayout>
```


Import RoundKornerLayouts dependency
--------------------------------

Declare it into your pom.xml

```xml
<dependency>
  <groupId>com.jcminarro</groupId>
  <artifactId>RoundKornerLayouts</artifactId>
  <version>0.2.0</version>
  <type>pom</type>
</dependency>
```


Or into your build.gradle

```groovy
dependencies {
    compile 'com.jcminarro:RoundKornerLayouts:0.2.0'
}
```


Do you want to contribute?
-------------------------------

Feel free to add any useful feature to the library, we will be glad to improve it with your help. I'd love to hear about your use case too, especially if it's not covered perfectly.

Developed By
------------

* Jc Miñarro  - <josecarlos.minarro@gmail.com>

<a href="https://twitter.com/el_joker333">
  <img alt="Follow me on Twitter" src="https://image.freepik.com/iconos-gratis/twitter-logo_318-40209.jpg" height="60" width="60"/>
</a>

License
-------

    Copyright 2017 Jc Miñarro

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.

[1]: ./art/screenshot1.png