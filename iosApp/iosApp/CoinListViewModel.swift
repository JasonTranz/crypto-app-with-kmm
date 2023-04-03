//
//  MarketCoinListViewModel.swift
//  iosApp
//
//  Created by Huu Tran on 03/04/2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import Foundation
import SharedModule

class CoinListViewModel: SharedModule.MarketCoinListViewModel {
    
    func apiCalling(){
        self.fetchMarketCoinList(perPage: 10, page: 1)
    }
    
//    @Published var coins: MarketCoinModelState
}
