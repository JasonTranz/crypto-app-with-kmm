import SwiftUI
import SharedModule
import KMMViewModelSwiftUI

struct ContentView: View {
    @StateViewModel var viewModel: MarketCoinListViewModel = CoinListViewModel()
    
    init() {
        viewModel.fetchMarketCoinList(perPage: 100, page: 1)
    }

    var body: some View {
        VStack {
            Text("Error msg: " + viewModel.marketCoinListViewModelState.errorMsg)
            Text("\(viewModel.marketCoinListViewModelState.coins.count)")
            if (viewModel.marketCoinListViewModelState.coins.isEmpty) {
                Text("Is Empty")
            } else {
                Text("Is Not Empty")
            }
        }
    }
}

