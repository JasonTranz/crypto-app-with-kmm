package com.cryptochain.mota.repository

import com.cryptochain.mota.model.CoinResponse

class FirebaseRepository {
    suspend fun getListFromFirebase(): List<CoinResponse> {

//        val reponse = getFirebaseInstance()
//            .collection("Users")
//            .suspendGet()
//
//        val list = parseFirebaseUserList(reponse.documents_)
        return emptyList()
    }
}