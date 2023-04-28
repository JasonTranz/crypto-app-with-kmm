//
//  MarketCoinListViewModel.swift
//  iosApp
//
//  Created by Huu Tran on 03/04/2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import Foundation
import SharedModule

class CoinListViewModel: SharedModule.CoinListKMMViewModel {

    override func getCoinList(perPage: Int32, page: Int32) async throws {
        try await super.getCoinList(perPage: 100, page: 1)
    }
}