package com.cryptochain.mota.viewModel

import com.cryptochain.mota.common.AppConstant
import com.cryptochain.mota.db.SPref
import com.cryptochain.mota.db.SharePreferences
import com.rickclephas.kmm.viewmodel.KMMViewModel
import org.koin.core.component.KoinComponent

open class MenuKMMViewModel : KMMViewModel(), KoinComponent {

    open fun setProtectedState(context: SPref, isProtected: Boolean) {
        val spr = SharePreferences(context)
        spr.putBool(AppConstant.SharePreferenceKey.PROTECTED_STATE, isProtected)
    }

    open fun getProtectedState(context: SPref): Boolean {
        val spr = SharePreferences(context)
        return spr.getBool(AppConstant.SharePreferenceKey.PROTECTED_STATE)
    }
}