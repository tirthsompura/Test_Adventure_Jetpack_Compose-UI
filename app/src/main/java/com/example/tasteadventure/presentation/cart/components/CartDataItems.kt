package com.example.tasteadventure.presentation.cart.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tasteadventure.R
import com.example.tasteadventure.domain.model.CartListDataModel
import com.example.tasteadventure.domain.model.PriceCartListDataModel
import com.example.tasteadventure.presentation.component.SpacerHorizontal
import com.example.tasteadventure.presentation.util.NormalText
import com.example.tasteadventure.ui.theme.bottomBarBGColor
import com.example.tasteadventure.ui.theme.fontMedium
import com.example.tasteadventure.ui.theme.fontSemiBold
import com.example.tasteadventure.ui.theme.lightBottomBarBGColor
import com.example.tasteadventure.ui.theme.menuBgColor
import com.example.tasteadventure.ui.theme.redColor

@Composable
fun cartListDataItem(
    cartDataList: CartListDataModel,
    onUpdateQuantityClicked: (Int) -> Unit,
) {
    Row(
        modifier = Modifier
            .padding(bottom = 10.dp)
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(20.dp))
            .background(menuBgColor)
            .height(130.dp)
            .padding(15.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .width(110.dp)
                .clip(shape = RoundedCornerShape(15.dp))
                .background(redColor),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = cartDataList.icon),
                contentDescription = "",
                contentScale = ContentScale.Crop
            )
        }
        SpacerHorizontal(width = 10.dp)
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(0.8f),
                verticalArrangement = Arrangement.SpaceAround,
                horizontalAlignment = Alignment.Start
            ) {
                NormalText(
                    label = cartDataList.name,
                    style = fontSemiBold.copy(
                        color = bottomBarBGColor,
                        fontSize = 25.sp
                    )
                )
                NormalText(
                    label = "${cartDataList.weight} g",
                    style = fontSemiBold.copy(
                        color = lightBottomBarBGColor,
                        fontSize = 14.sp
                    )
                )
                NormalText(
                    label = "$" + cartDataList.updatedPrice,
                    style = fontSemiBold.copy(
                        color = bottomBarBGColor,
                        fontSize = 16.sp
                    )
                )
            }
            SpacerHorizontal(width = 10.dp)
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(0.2f)
                    .clip(shape = RoundedCornerShape(10.dp))
                    .border(
                        width = 1.dp,
                        color = bottomBarBGColor,
                        shape = RoundedCornerShape(10.dp)
                    )
            ) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.SpaceEvenly,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_add_icon),
                        contentDescription = "",
                        colorFilter = ColorFilter.tint(bottomBarBGColor),
                        modifier = Modifier
                            .size(22.dp)
                            .clickable(
                                onClick = {
                                    onUpdateQuantityClicked(1)
                                }
                            )
                    )
                    NormalText(
                        label = cartDataList.quantity.toString(),
                        style = fontSemiBold.copy(
                            color = bottomBarBGColor,
                            fontSize = 16.sp,
                            lineHeight = 16.sp
                        )
                    )
                    Image(
                        painter = painterResource(id = R.drawable.ic_minus_icon),
                        contentDescription = "",
                        colorFilter = ColorFilter.tint(bottomBarBGColor),
                        modifier = Modifier
                            .size(22.dp)
                            .clickable(
                                onClick = {
                                    onUpdateQuantityClicked(-1)
                                }
                            )
                    )
                }
            }
        }
    }
}

@Composable
fun PriceDataItem(priceCartData: PriceCartListDataModel) {
    Row(
        modifier = Modifier.fillMaxWidth().padding(bottom = 15.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        NormalText(
            label = priceCartData.title,
            style = fontMedium.copy(color = lightBottomBarBGColor, fontSize = 18.sp),
            maxLine = 1,
            textAlign = TextAlign.Center,
            modifier = Modifier
        )
        NormalText(
            label = if (priceCartData.title == "Discount") "-$"+priceCartData.price else "$"+priceCartData.price,
            style = fontMedium.copy(color = bottomBarBGColor, fontSize = 18.sp),
            maxLine = 1,
            textAlign = TextAlign.Center,
            modifier = Modifier
        )
    }
}

@Composable
fun drawDashedStraightLine(){
    val pathEffect = PathEffect.dashPathEffect(floatArrayOf(25f, 25f), 0f)
    Canvas(Modifier.fillMaxWidth().height(1.dp)) {
        drawLine(
            color = bottomBarBGColor,
            start = Offset(0f, 0f),
            end = Offset(size.width, 0f),
            pathEffect = pathEffect
        )
    }
}

@Composable
fun totalPriceItem(){
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        NormalText(
            label = "Total",
            style = fontSemiBold.copy(color = bottomBarBGColor, fontSize = 20.sp),
            maxLine = 1,
            textAlign = TextAlign.Center,
            modifier = Modifier
        )
        NormalText(
            label = "$" + "125.20",
            style = fontSemiBold.copy(color = bottomBarBGColor, fontSize = 30.sp),
            maxLine = 1,
            textAlign = TextAlign.Center,
            modifier = Modifier
        )
    }
}