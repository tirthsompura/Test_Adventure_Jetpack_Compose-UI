package com.example.tasteadventure.presentation.intro

import androidx.lifecycle.ViewModel

import com.example.tasteadventure.R
import com.example.tasteadventure.domain.model.IntroPageDataClass
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class IntroScreenViewModel @Inject constructor(
) : ViewModel() {

    fun getIntroPageDataClassList(): ArrayList<IntroPageDataClass> {
        val introPageDataClassList = ArrayList<IntroPageDataClass>()

        introPageDataClassList.add(
            IntroPageDataClass(
                label = "Explore Culinary Delights",
                description = "It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing.",
                imageId = R.drawable.ic_intro_img
            )
        )
        introPageDataClassList.add(
            IntroPageDataClass(
                label = "Tailored to Your Tastes",
                description = "It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing.",
                imageId = R.drawable.ic_intro_img2
            )
        )
        introPageDataClassList.add(
            IntroPageDataClass(
                label = "Step-by_Step guidance",
                description = "It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing.",
                imageId = R.drawable.ic_intro_img3
            )
        )
        return introPageDataClassList
    }
}