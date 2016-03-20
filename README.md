# RxBindroid [![Bintray](https://img.shields.io/bintray/v/pinemz/maven/rxbindroid.svg?style=flat-square)](https://bintray.com/pinemz/maven/rxbindroid/view) [![Bintray](https://img.shields.io/bintray/v/pinemz/maven/rxbindroid-kotlin.svg?style=flat-square)](https://bintray.com/pinemz/maven/rxbindroid-kotlin/view) [![Build Status](https://img.shields.io/travis/pine613/RxBindroid/master.svg?style=flat-square)](https://travis-ci.org/pine613/RxBindroid)
Bind Observable for Android Activity / Fragment / View Lifecycles

## Getting Started
Please type it in your build.gradle file.

```groovy
repositories {
    jcenter()
}

dependencies {
    compile 'moe.pine.rxbindroid:rxbindroid:0.1.0'
    compile 'moe.pine.rxbindroid:rxbindroid-kotlin:0.1.0' // for Kotlin
}
```

## Usage
### Java

```java
import moe.pine.rx.bindroid.RxBindroid;

final TextView view = (TextView)this.findViewById(R.id.text_view_hello);
Observable<String> observable = Observable.just("Hello");

// It will call `unsubscribe` automatically.
RxBindroid.bindView(view, observable).subscribe(new Action1<String>() {
	@Override
	public void call(String s) {
        // called by MainThread
		view.setText(s);
	}
});
```

### Kotlin

```kotlin
import moe.pine.rx.bindroid.bindView

val view = this.findViewById(R.id.text_view_hello) as TextView
val observable = Observable.just("Hello")

// It will call `unsubscribe` automatically.
observable.bindView(view).subscribe { view.text = it }
```

## Methods
### Java

- RxBindroid.bindActivity
- RxBindroid.bindFragment
- RxBindroid.bindView

### Kotlin

- Observable&lt;T&gt;.bindActivity
- Observable&lt;T&gt;.bindFragment
- Observable&lt;T&gt;.bindView

## Test

```
$ ./gradlew clean test
```

## Upload to Bintray

```
$ ./gradlew clean assemble bintrayUpload
```

## License
RxBindroid is based on [RxAndroid#v0.25.0](https://github.com/ReactiveX/RxAndroid/tree/v0.25.0).
Thank you.

```
Copyright 2015 The RxAndroid authors
Copyright 2016 Pine Mizune

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
