package com.example.tasteadventure.presentation.profile

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.lifecycle.ViewModel
import com.example.tasteadventure.R
import com.example.tasteadventure.domain.model.ProfileDiscountDataListModel
import com.example.tasteadventure.domain.model.ProfileMenuListModel
import com.example.tasteadventure.util.SessionManagerClass
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    val sessionManagerClass: SessionManagerClass,
) : ViewModel() {

    @Composable
    fun getProfileMenuDataClassList(): ArrayList<ProfileMenuListModel> {
        val profileMenuDataClassList = ArrayList<ProfileMenuListModel>()

        profileMenuDataClassList.add(
            ProfileMenuListModel(
                name = "HISTORY",
                icon = R.drawable.ic_notepade,
                isMenuUpdate = false,
                isMenuUpdateData = 0
            )
        )
        profileMenuDataClassList.add(
            ProfileMenuListModel(
                name = "FAVORITE",
                icon = R.drawable.ic_heart,
                isMenuUpdate = true,
                isMenuUpdateData = 4
            )
        )
        profileMenuDataClassList.add(
            ProfileMenuListModel(
                name = "OFFER",
                icon = R.drawable.ic_ticket,
                isMenuUpdate = true,
                isMenuUpdateData = 3
            )
        )
        profileMenuDataClassList.add(
            ProfileMenuListModel(
                name = "PAYMENT",
                icon = R.drawable.ic_card,
                isMenuUpdate = false,
                isMenuUpdateData = 0
            )
        )
        return profileMenuDataClassList
    }

    @Composable
    fun getProfileDiscountDataList(): ArrayList<ProfileDiscountDataListModel> {
        val profileDiscountDataList = ArrayList<ProfileDiscountDataListModel>()

        profileDiscountDataList.add(
            ProfileDiscountDataListModel(
                discount = "30%",
                name = "DISCOUNT",
            )
        )
        profileDiscountDataList.add(
            ProfileDiscountDataListModel(
                discount = "$26",
                name = "BONUSES",
            )
        )
        profileDiscountDataList.add(
            ProfileDiscountDataListModel(
                discount = "$140",
                name = "DEPOSIT",
            )
        )

        return profileDiscountDataList
    }
}