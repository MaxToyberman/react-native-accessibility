
import { NativeModules, AccessibilityInfo, findNodeHandle, Platform, UIManager } from 'react-native';

const { RNAccessibility } = NativeModules;

const FOCUS_ON_VIEW = 8;

const announceForAccessibility = Platform.select({android: RNAccessibility.announce , ios:AccessibilityInfo.announceForAccessibility});

module.exports = {
    announceForAccessibility,
    focusOnView(ref) {
        if(!ref || !reactTag) {
            console.warn("reactTag is null")
            return
        }
        const reactTag = findNodeHandle(ref)
 
        Platform.OS === 'android' ? UIManager.sendAccessibilityEvent(
            reactTag,
            FOCUS_ON_VIEW
        ) : AccessibilityInfo.setAccessibilityFocus(reactTag)
    }
}