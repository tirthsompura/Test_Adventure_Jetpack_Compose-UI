package com.example.tasteadventure.presentation.payment

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.tasteadventure.R
import com.example.tasteadventure.presentation.component.CommonTopBar
import com.example.tasteadventure.presentation.component.SpacerVertical
import com.example.tasteadventure.presentation.util.NormalText
import com.example.tasteadventure.ui.theme.bgColor
import com.example.tasteadventure.ui.theme.bottomBarBGColor
import com.example.tasteadventure.ui.theme.darkCardColor
import com.example.tasteadventure.ui.theme.fontMedium
import com.example.tasteadventure.ui.theme.fontSemiBold
import com.example.tasteadventure.ui.theme.lightBottomBarBGColor
import com.example.tasteadventure.ui.theme.whiteColor

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun PaymentScreen(navController: NavController) {

    Scaffold(
        contentColor = bgColor,
        topBar = {
            CommonTopBar(
                isAllMenuShow = true,
                firstIcon = painterResource(id = R.drawable.ic_back),
                secondIcon = painterResource(id = R.drawable.ic_menu),
                isTitle = "Payment",
                firstIconClick = { /*TODO*/ },
                secondIconClick = { /*TODO*/ }
            )
        },
        content = { PaymentScreenBody() }
    )
}

@Composable
fun PaymentScreenBody() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(bgColor)
            .padding(top = 90.dp, start = 15.dp, end = 15.dp)
    ) {
        SpacerVertical(height = 30.dp)
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(shape = RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
                .background(darkCardColor)
                .padding(15.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 10.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_card_logo),
                    contentDescription = "",
                    modifier = Modifier.size(30.dp)
                )
                NormalText(
                    label = "* * * * 7492",
                    style = fontMedium.copy(color = bottomBarBGColor, fontSize = 18.sp),
                    maxLine = 1,
                    textAlign = TextAlign.Center,
                    modifier = Modifier,
                )
            }
        }
        Box(
            modifier = Modifier
                .offset(y = -20.dp)
                .fillMaxWidth()
                .height(170.dp)
                .clip(shape = RoundedCornerShape(30.dp))
                .background(bottomBarBGColor)
                .padding(15.dp)
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.SpaceAround,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_card_logo),
                        contentDescription = "",
                        modifier = Modifier.size(30.dp)
                    )
                    NormalText(
                        label = "* * * * 7492",
                        style = fontMedium.copy(color = whiteColor, fontSize = 18.sp),
                        maxLine = 1,
                        textAlign = TextAlign.Center,
                        modifier = Modifier,
                    )
                }

                NormalText(
                    label = "$20,384.98",
                    style = fontSemiBold.copy(color = whiteColor, fontSize = 25.sp),
                    maxLine = 1,
                    textAlign = TextAlign.Center,
                    modifier = Modifier,
                )

                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                    NormalText(
                        label = "Peter Walker",
                        style = fontMedium.copy(color = whiteColor, fontSize = 16.sp),
                        maxLine = 1,
                        textAlign = TextAlign.Center,
                        modifier = Modifier,
                    )
                    NormalText(
                        label = "08/26",
                        style = fontMedium.copy(color = lightBottomBarBGColor, fontSize = 14.sp),
                        maxLine = 1,
                        textAlign = TextAlign.Center,
                        modifier = Modifier,
                    )
                }
            }
        }
    }
}