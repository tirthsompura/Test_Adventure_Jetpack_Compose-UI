package com.example.tasteadventure.presentation.profile

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.tasteadventure.R
import com.example.tasteadventure.domain.model.ProfileDiscountDataListModel
import com.example.tasteadventure.domain.model.ProfileMenuListModel
import com.example.tasteadventure.presentation.component.CommonTopBar
import com.example.tasteadventure.presentation.component.SpacerVertical
import com.example.tasteadventure.presentation.component.drawBottomSheetLine
import com.example.tasteadventure.presentation.profile.component.discountDataItem
import com.example.tasteadventure.presentation.profile.component.profileMenuItemTile
import com.example.tasteadventure.presentation.util.NormalText
import com.example.tasteadventure.presentation.util.allscreensroot.MyProfileScreens
import com.example.tasteadventure.ui.theme.bgColor
import com.example.tasteadventure.ui.theme.bottomBarBGColor
import com.example.tasteadventure.ui.theme.fontMedium
import com.example.tasteadventure.ui.theme.lightBottomBarBGColor
import com.example.tasteadventure.ui.theme.menuBgColor
import com.example.tasteadventure.ui.theme.whiteColor

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MyProfileScreen(
    navController: NavHostController,
    viewModel: ProfileViewModel = hiltViewModel(),
) {
    val profileMenuDataClassList = viewModel.getProfileMenuDataClassList()
    val profileDiscountDataList = viewModel.getProfileDiscountDataList()

    Scaffold(
        containerColor = bgColor,
        topBar = {
            CommonTopBar(
                isBothIconShow = true,
                firstIconClick = {},
                secondIconClick = {
                    navigateToCartScreen(navController)
                }
            )
        },
        content = {
            ProfileBody(viewModel, profileMenuDataClassList, profileDiscountDataList)
        }
    )
}

@Composable
fun ProfileBody(
        viewModel: ProfileViewModel,
    profileMenuDataClassList: ArrayList<ProfileMenuListModel>,
    profileDiscountDataList: ArrayList<ProfileDiscountDataListModel>,
) {
    Column(
        modifier = Modifier
            .padding(top = 80.dp)
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .padding(bottom = 50.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                Box(
                    modifier = Modifier
                        .offset(y = (-20).dp)
                        .size(110.dp)
                        .clip(shape = CircleShape)
                        .background(menuBgColor),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.user_image),
                        contentDescription = "",
                        contentScale = ContentScale.Crop
                    )
                }
            }
            NormalText(
                label = "Tirth Sompura",
                style = fontMedium.copy(color = bottomBarBGColor, fontSize = 25.sp),
                maxLine = 1,
                textAlign = TextAlign.Center
            )
            SpacerVertical(height = 5.dp)
            NormalText(
                label = "@hello_sompura",
                style = fontMedium.copy(color = lightBottomBarBGColor, fontSize = 15.sp),
                maxLine = 1,
                textAlign = TextAlign.Center
            )

            Box(
                modifier = Modifier
                    .padding(top = 30.dp)
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .clip(
                        shape = RoundedCornerShape(topEnd = 40.dp, topStart = 40.dp)
                    )
                    .background(bottomBarBGColor)
            ) {
                Column(
                    modifier = Modifier
                        .padding(top = 20.dp)
                        .fillMaxSize()
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        LazyVerticalGrid(
                            modifier = Modifier
                                .padding(15.dp)
                                .fillMaxWidth(),
                            columns = GridCells.Fixed(3),
                            content = {
                                items(profileDiscountDataList.size) { index ->
                                    val discountDataItem = profileDiscountDataList[index]
                                    discountDataItem(discountDataItem)
                                }
                            }
                        )
                    }
                }
                Box(
                    modifier = Modifier
                        .padding(top = 100.dp)
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .clip(
                            shape = RoundedCornerShape(topEnd = 40.dp, topStart = 40.dp)
                        )
                        .background(bgColor)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                    ) {
                        drawBottomSheetLine()
                        LazyVerticalGrid(
                            modifier = Modifier
                                .padding(15.dp)
                                .fillMaxWidth(),
                            columns = GridCells.Fixed(2),
                            content = {
                                items(profileMenuDataClassList.size) { index ->
                                    val indexMenuItem = profileMenuDataClassList[index]
                                    profileMenuItemTile(indexMenuItem, onItemClick = {

                                    })
                                }
                                items(1) {
                                    Box(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .height(30.dp)
                                    ) {

                                    }
                                }
                            }
                        )
                    }
                }
            }
        }
    }
}

fun navigateToCartScreen(navController: NavController) {
    navController.navigate(MyProfileScreens.CartScreenScreen.route)
}