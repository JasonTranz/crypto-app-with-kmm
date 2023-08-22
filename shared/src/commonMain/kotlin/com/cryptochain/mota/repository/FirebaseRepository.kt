package com.cryptochain.mota.repository

import com.cryptochain.mota.entity.CoinGeckoResponse
import com.cryptochain.mota.model.Coin
import dev.gitlive.firebase.Firebase
import dev.gitlive.firebase.firestore.firestore

class FirebaseRepository {

    suspend fun getListFromFirebase(): List<CoinGeckoResponse> {
        val documents = Firebase.firestore.collection("crypto_coin").get()
        val coins: MutableList<CoinGeckoResponse> = mutableListOf()
        for (document in documents.documents) {
            coins.add(
                CoinGeckoResponse(
                    id = document.id,
                    name = document.get<String?>("name"),
                    currentPrice = document.get<Double?>("price"),
                    symbol = document.get<String?>("symbol"),
                    image = document.get<String?>("image"),
                    priceChangePercentage24h = document.get<Double?>("priceChangePercentage24h"),
                    marketCapRank = document.get<Int?>("rank")
                )
            )
        }

        return coins.sortedBy { it.marketCapRank }
    }

    suspend fun setListCoinToFirebase(coins: List<Coin>) {
        val data: HashMap<String, Any?> = hashMapOf()
        coins.forEachIndexed { index, coin ->
            data["rank"] = index
            data["name"] = coin.name
            data["symbol"] = coin.symbol
            data["price"] = coin.price
            data["image"] = coin.image
            data["priceChangePercentage24h"] = coin.priceChangePercentage24h
            Firebase.firestore.collection("crypto_coin").document(coin.id).set(data)
        }
    }
}