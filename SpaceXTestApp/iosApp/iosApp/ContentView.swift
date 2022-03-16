import SwiftUI
import shared

struct ContentView: View {
    @ObservedObject private(set) var viewModel: ViewModel

        var body: some View {
            NavigationView {
                listView()
                .navigationBarTitle("SpaceX Launches")
                .navigationBarItems(trailing:
                    Button("Reload") {
                        self.viewModel.loadLaunches(forceReload: true)
                })
            }
            .onAppear {
                viewModel.loadLaunches(forceReload: false)
            }
            .onDisappear {
                viewModel.clean()
            }
        }

        private func listView() -> AnyView {
            switch viewModel.launches {
                case .loading:
                    return AnyView(Text("Loading...").multilineTextAlignment(.center))
                
                case .result(let launches):
                    return AnyView(List(launches) { launch in
                        RocketLaunchRow(rocketLaunch: launch)
                    })
                
                case .error(let description):
                    return AnyView(Text(description).multilineTextAlignment(.center))
            }
        }
}


extension ContentView {
    enum LoadableLaunches {
        case loading
        case result([RocketLaunch])
        case error(String)
    }
        
    class ViewModel: ObservableObject {
        let sharedViewModel: MainScreenViewModel

        @Published var launches = LoadableLaunches.loading

        init(sharedViewModel: MainScreenViewModel) {
            self.sharedViewModel = sharedViewModel
        }

        func loadLaunches(forceReload: Bool) {
            self.launches = .loading
            
            let collectorInstance = Collector<MainScreenState>(callback: { state in
                switch state {
                    case is MainScreenState.Loading:
                        self.launches = .loading
                    
                    case is MainScreenState.Error:
                        self.launches = .error("")

                    case is MainScreenState.Content:
                        let content = state as! MainScreenState.Content
                        self.launches = .result(content.launches)
                    
                    default:
                        print("")
                }
            })
            
            sharedViewModel.state.collect(
                collector: collectorInstance,
                completionHandler: { complete, error in
                    if(error != nil) {
                        self.launches = .error(error?.localizedDescription ?? "error")
                    }
                }
            )
                        
            sharedViewModel.onEvent(event: MainScreenEvent.OnStart())
        }
        
        func clean() {
            sharedViewModel.clean()
        }
    }
}

extension RocketLaunch: Identifiable { }

