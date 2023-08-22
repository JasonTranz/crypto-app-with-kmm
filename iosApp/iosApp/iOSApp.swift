import SwiftUI
import SharedModule
import Firebase

@main
struct iOSApp: App {
    
    init() {
        HelperKt().doInitKoin()
        FirebaseApp.configure()
    }
    
	var body: some Scene {
		WindowGroup {
			HomeScreen()
		}
	}
}
