package com.example.tasteadventure.domain.model

data class ProfileMenuListModel(
    val name: String,
    val icon: Int,
    val isMenuUpdate: Boolean = false,
    val isMenuUpdateData: Int,
)