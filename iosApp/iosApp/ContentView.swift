import SwiftUI
import SharedModule
import KMMViewModelSwiftUI

struct ContentView: View {
    @StateViewModel var viewModel: MarketCoinListViewModel = CoinListViewModel()
    @State var coins: [Coin] = [Coin]()

    var body: some View {
        VStack() {
            GeometryReader { geo in
                HStack(alignment: .top) {
                    Text("#")
                        .frame(width: geo.size.width * 0.07)
                    Text("Coin")
                        .frame(width: geo.size.width * 0.43)
                    Text("Price")
                        .frame(width: geo.size.width * 0.3, alignment: .trailing)
                    Text("24h")
                        .frame(width: geo.size.width * 0.2)
                }.frame(maxWidth: .infinity).fixedSize()
            }.frame(maxWidth: .infinity).frame(height: 20)
                .padding(.trailing, 16).padding(.leading, 16)
            
            ScrollView {
                LazyVStack {
                    ForEach(coins.indices, id: \.self) { index in
                        CoinItem(coin: coins[index], index: index)
                    }
                }
            }.frame(maxWidth: .infinity, maxHeight: .infinity)
        }.onAppear{
            Task {
                coins = try await self.viewModel.getCoinList()
            }
        }
    }
}

struct CoinItem: View {
    @State var coin: Coin

    var index: Int
    var percentageColor: Color {
        if (coin.priceChangePercentage24h > 0) {
            return Color.green
        } else {
            return Color.red
        }
    }
    
    var body: some View {
        GeometryReader { geo in
            HStack(alignment: .center) {
                Text(String(index + 1))
                    .frame(width: geo.size.width * 0.07)
                
                HStack {
                    AsyncImage(
                        url: URL(string: coin.image)!,
                        placeholder: { Text("Loading ...") },
                        image: { Image(uiImage: $0).resizable() }
                    ).frame(maxWidth: 30, maxHeight: 30)
                        .padding(.trailing, 12)
                    
                    VStack(alignment: .leading) {
                        Text(coin.name)
                            .font(Font.headline.weight(.bold))
                            .frame(maxWidth: .infinity, alignment: .leading)
                            .lineLimit(1)
                        Text(coin.symbol)
                            .font(Font.headline.weight(.light))
                            .frame(maxWidth: .infinity, alignment: .leading)
                    }
                }.frame(width: geo.size.width * 0.43)
                
                Text(String(coin.price))
                    .frame(width: geo.size.width * 0.3, alignment: .trailing)
                
                Text(String(format: "%.01f", coin.priceChangePercentage24h) + "%")
                    .frame(width: geo.size.width * 0.2)
                    .font(.system(size: 12))
                    .foregroundColor(percentageColor)
                
            }.frame(maxWidth: .infinity).fixedSize()
        }.frame(maxWidth: .infinity).frame(height: 25)
            .padding(.trailing, 16)
            .padding(.leading, 16)
            .padding(.bottom, 14)
            .padding(.top, 14)
    }
}
