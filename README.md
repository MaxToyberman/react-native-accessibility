
# react-native-accessibility

## Getting started

`$ npm install react-native-accessibility --save`

### Mostly automatic installation

`$ react-native link react-native-accessibility`

### Manual installation


#### iOS

1. In XCode, in the project navigator, right click `Libraries` ➜ `Add Files to [your project's name]`
2. Go to `node_modules` ➜ `react-native-accessibility` and add `RNReactNativeAccessibility.xcodeproj`
3. In XCode, in the project navigator, select your project. Add `libRNReactNativeAccessibility.a` to your project's `Build Phases` ➜ `Link Binary With Libraries`
4. Run your project (`Cmd+R`)<

#### Android

1. Open up `android/app/src/main/java/[...]/MainActivity.java`
  - Add `import com.reactlibrary.RNReactNativeAccessibilityPackage;` to the imports at the top of the file
  - Add `new RNReactNativeAccessibilityPackage()` to the list returned by the `getPackages()` method
2. Append the following lines to `android/settings.gradle`:
  	```
  	include ':react-native-accessibility'
  	project(':react-native-accessibility').projectDir = new File(rootProject.projectDir, 	'../node_modules/react-native-accessibility/android')
  	```
3. Insert the following lines inside the dependencies block in `android/app/build.gradle`:
  	```
      compile project(':react-native-accessibility')
  	```

## Usage
```javascript
import { announceForAccessibility, focusOnView } from 'react-native-accessibility';

announceForAccessibility('type some message here')
focusOnView(this.refs.someRef) // to focus on a View pass a ref to the view 
```
  