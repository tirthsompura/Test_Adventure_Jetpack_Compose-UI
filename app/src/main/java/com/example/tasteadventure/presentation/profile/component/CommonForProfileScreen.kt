package com.example.tasteadventure.presentation.profile.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tasteadventure.domain.model.ProfileDiscountDataListModel
import com.example.tasteadventure.domain.model.ProfileMenuListModel
import com.example.tasteadventure.presentation.component.SpacerVertical
import com.example.tasteadventure.presentation.component.menuButtonWithBg
import com.example.tasteadventure.presentation.util.NormalText
import com.example.tasteadventure.ui.theme.bgColor
import com.example.tasteadventure.ui.theme.bottomBarBGColor
import com.example.tasteadventure.ui.theme.darkBgColor
import com.example.tasteadventure.ui.theme.darkOrangeColor
import com.example.tasteadventure.ui.theme.fontMedium
import com.example.tasteadventure.ui.theme.lightBottomBarBGColor
import com.example.tasteadventure.ui.theme.menuBgColor
import com.example.tasteadventure.ui.theme.whiteColor

@Composable
fun profileMenuItemTile(indexMenuItem: ProfileMenuListModel, onItemClick: () -> Unit) {
    val interactionSource = remember {
        MutableInteractionSource()
    }
    Card(
        shape = CardDefaults.shape,
        colors = CardDefaults.cardColors(menuBgColor),
        modifier = Modifier
            .padding(4.dp)
            .height(150.dp)
            .fillMaxWidth()
            .clickable(
                interactionSource = interactionSource,
                indication = null,
                onClick = {
                    onItemClick()
                }
            ),
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                menuButtonWithBg(
                    bgColor = darkBgColor,
                    icon = painterResource(id = indexMenuItem.icon)
                ) {}
                SpacerVertical(height = 5.dp)
                NormalText(
                    label = indexMenuItem.name,
                    style = fontMedium.copy(
                        color = bottomBarBGColor,
                        fontSize = 15.sp
                    ),
                    maxLine = 1,
                    textAlign = TextAlign.Center
                )
            }
            if (indexMenuItem.isMenuUpdate) {
                Box(
                    modifier = Modifier
                        .fillMaxSize(), contentAlignment = Alignment.Center
                ) {
                    Box(
                        modifier = Modifier
                            .size(18.dp)
                            .offset(y = (-30).dp, x = 17.dp)
                            .clip(shape = CircleShape)
                            .background(darkOrangeColor), contentAlignment = Alignment.Center
                    ) {
                        NormalText(
                            label = indexMenuItem.isMenuUpdateData.toString(),
                            style = fontMedium.copy(
                                color = bgColor,
                                fontSize = 10.sp
                            ),
                            maxLine = 1,
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun discountDataItem(discountDataItem: ProfileDiscountDataListModel) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        NormalText(
            label = discountDataItem.discount,
            style = fontMedium.copy(
                color = whiteColor,
                fontSize = 20.sp
            ),
            maxLine = 1,
            textAlign = TextAlign.Center
        )
        NormalText(
            label = discountDataItem.name,
            style = fontMedium.copy(
                color = lightBottomBarBGColor,
                fontSize = 15.sp
            ),
            maxLine = 1,
            textAlign = TextAlign.Center
        )
    }
}