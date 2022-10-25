package com.cryptochain.mota.android.component

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.Dp
import com.intuit.sdp.R


@Composable
fun tinySpace(): Dp {
    return dimensionResource(id = R.dimen._4sdp)
}

@Composable
fun tinySpaceX(): Dp {
    return dimensionResource(id = R.dimen._6sdp)
}

@Composable
fun tinySpaceXS(): Dp {
    return dimensionResource(id = R.dimen._8sdp)
}

@Composable
fun smallSpace(): Dp {
    return dimensionResource(id = R.dimen._10sdp)
}

@Composable
fun smallSpaceX(): Dp {
    return dimensionResource(id = R.dimen._12sdp)
}

@Composable
fun smallSpaceXS(): Dp {
    return dimensionResource(id = R.dimen._14sdp)
}

@Composable
fun mediumSpace(): Dp {
    return dimensionResource(id = R.dimen._16sdp)
}