package com.cryptochain.mota.android.feature.menu

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Switch
import androidx.compose.material.SwitchDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.cryptochain.mota.android.component.RegularText
import com.cryptochain.mota.db.SPref
import com.cryptochain.mota.viewModel.MenuViewModel

@Composable
fun MenuScreen(
    menuViewModel: MenuViewModel
) {
    val context = LocalContext.current
    val protectedState = remember { mutableStateOf(false) }

    LaunchedEffect(true) {
        protectedState.value = menuViewModel.getProtectedState(context as SPref)
    }

    fun onSwitchProtectedState(isChecked: Boolean) {
        protectedState.value = isChecked
        menuViewModel.setProtectedState(context = context as SPref, isProtected = isChecked)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
    ) {
        ToggleButton(
            title = "Protected device",
            checked = protectedState.value,
            onSwitched = { onSwitchProtectedState(it) }
        )
    }
}

@Composable
fun ToggleButton(
    modifier: Modifier = Modifier,
    title: String = "",
    checked: Boolean = false,
    onSwitched: (Boolean) -> Unit,
) {
    Box(
        modifier = modifier.fillMaxWidth(),
    ) {
        RegularText(
            modifier = Modifier
                .align(Alignment.CenterStart)
                .padding(end = 10.dp),
            content = title
        )
        Switch(
            modifier = Modifier.align(Alignment.CenterEnd),
            checked = checked,
            onCheckedChange = { onSwitched.invoke(!checked) },
            colors = SwitchDefaults.colors(
                uncheckedThumbColor = Color.Gray,
                checkedThumbColor = Color.Red,
            )
        )
    }
}