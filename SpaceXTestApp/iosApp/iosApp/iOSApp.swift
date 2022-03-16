import SwiftUI
import shared

@main
struct iOSApp: App {
    let sharedViewModel = MainScreenViewModel(databaseDriverFactory: DatabaseDriverFactory())
    
    var body: some Scene {
        WindowGroup {
            ContentView(viewModel: .init(sharedViewModel: sharedViewModel))
        }
    }
}
