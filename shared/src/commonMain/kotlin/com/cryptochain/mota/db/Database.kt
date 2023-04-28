package com.cryptochain.mota.db

import db.CoinLocal
import db.MotaDatabase

class Database(databaseDriverFactory: DriverFactory) {
    private val database = MotaDatabase(databaseDriverFactory.createDriver())
    private val dbQuery = database.motaDatabaseQueries

    internal fun addCoins(coins: List<CoinLocal>) {
        dbQuery.transaction {
            coins.forEach { coin ->
                insertCoin(coin)
            }
        }
    }

    private fun insertCoin(coin: CoinLocal) {
        dbQuery.transaction {
            dbQuery.insert(
                id = coin.id,
                symbol = coin.symbol,
                name = coin.name,
                price = coin.price,
                imageUrl = coin.imageUrl,
                priceChangePercentage24h = coin.priceChangePercentage24h
            )
        }
    }

    internal fun getCoins(): List<CoinLocal> {
        return dbQuery.getAll().executeAsList()
    }

    internal fun clearDatabase() {
        dbQuery.transaction {
            dbQuery.deleteAll()
        }
    }
}