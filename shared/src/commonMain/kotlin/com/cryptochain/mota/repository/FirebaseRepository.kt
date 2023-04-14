package com.cryptochain.mota.repository

import com.cryptochain.mota.entity.CoinGeckoResponse

class FirebaseRepository {
    suspend fun getListFromFirebase(): List<CoinGeckoResponse> {

//        val reponse = getFirebaseInstance()
//            .collection("Users")
//            .suspendGet()
//
//        val list = parseFirebaseUserList(reponse.documents_)
        return emptyList()
    }
}