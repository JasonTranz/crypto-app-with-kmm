//
//  MarketCoinListViewModel.swift
//  iosApp
//
//  Created by Huu Tran on 03/04/2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import Foundation
import SwiftUI
import SharedModule

class CoinListViewModel: SharedModule.MarketCoinListViewModel {
        
    override func getCoinList() async throws -> [Coin] {
        var coins = [Coin]()
        do {
            coins = try await self.fetchMarketCoinList(perPage: 100, page: 1)
        } catch {
            coins = [Coin]()
        }
        
        return coins
    }
}
