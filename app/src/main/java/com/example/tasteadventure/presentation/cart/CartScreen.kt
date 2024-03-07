package com.example.tasteadventure.presentation.cart

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.tasteadventure.R
import com.example.tasteadventure.presentation.cart.components.PriceDataItem
import com.example.tasteadventure.presentation.cart.components.cartListDataItem
import com.example.tasteadventure.presentation.cart.components.drawDashedStraightLine
import com.example.tasteadventure.presentation.cart.components.totalPriceItem
import com.example.tasteadventure.presentation.component.CommonTopBar
import com.example.tasteadventure.presentation.component.SpacerVertical
import com.example.tasteadventure.presentation.component.SwipeButton
import com.example.tasteadventure.presentation.util.NormalText
import com.example.tasteadventure.presentation.util.allscreensroot.MyProfileScreens
import com.example.tasteadventure.ui.theme.bgColor
import com.example.tasteadventure.ui.theme.bottomBarBGColor
import com.example.tasteadventure.ui.theme.fontSemiBold
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun CartScreen(navController: NavController, viewModel: CartViewModel = hiltViewModel()) {

    Scaffold(contentColor = bgColor, topBar = {
        CommonTopBar(
            firstIcon = painterResource(id = R.drawable.ic_back),
            isFirstIconWithText = true,
            firstIconClick = { navController.popBackStack() },
            isTitle = "Cart"
        ) {}
    }, content = {
        cartScreenBody(viewModel)
    }, bottomBar = {
        cartScreenBottomBar(navController)
    }
    )
}

@Composable
fun cartScreenBody(viewModel: CartViewModel) {
    val cartListData = viewModel.cartListState
    val priceCartListData = viewModel.priceCartListState

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(bgColor)
            .padding(top = 90.dp)
    ) {
        LazyColumn(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .fillMaxWidth()
        ) {
            itemsIndexed(cartListData) { index, item ->
                cartListDataItem(
                    item,
                    onUpdateQuantityClicked = {
                        viewModel.updateQuantity(index, it)
                    }
                )
            }
            items(1) {
                Column(
                    modifier = Modifier
                        .padding(top = 15.dp)
                        .fillMaxWidth()
                ) {
                    NormalText(
                        label = "Order Info",
                        style = fontSemiBold.copy(color = bottomBarBGColor, fontSize = 25.sp),
                        maxLine = 1,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                    )
                    SpacerVertical(height = 17.dp)
                    repeat(priceCartListData.size) { index ->
                        val priceCartData = priceCartListData[index]
                        PriceDataItem(priceCartData)
                    }
                    SpacerVertical(height = 20.dp)
                    drawDashedStraightLine()
                    SpacerVertical(height = 20.dp)
                    totalPriceItem()
                }
            }
        }
    }
}

@Composable
fun cartScreenBottomBar(navController: NavController) {
    val coroutineScope = rememberCoroutineScope()
    val (isComplete, setIsComplete) = remember {
        mutableStateOf(false)
    }
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp), contentAlignment = Alignment.Center
    ) {
        SwipeButton(text = "CHECKOUT", isComplete = isComplete) {
            coroutineScope.launch {
                delay(2000)
                setIsComplete(true)
                navigateToPaymentScreen(navController)
            }
        }
    }
}

fun navigateToPaymentScreen(navController: NavController) {
    navController.navigate(MyProfileScreens.PaymentScreen.route)
}
