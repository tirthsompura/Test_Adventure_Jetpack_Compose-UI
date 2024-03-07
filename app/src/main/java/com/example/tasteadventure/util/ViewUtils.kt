package com.example.tasteadventure.util

import android.content.Context
import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Density

fun showToast(context: Context, message:String){
    Toast.makeText(context,message, Toast.LENGTH_LONG ).show()
}

fun getStringResourceByName(string: String, context: Context): String {
    val packageName: String = context.packageName
    val resId: Int = context.resources.getIdentifier(string, "string", packageName)
    return context.getString(resId)
}

@Composable
fun getDensity():Density{
    return Density(
        LocalDensity.current.density,
        fontScale = 0.95f,
    )
}

fun getPriceRangeError(context: Context, startRange:String,endRange:String) :String{

    return "Please enter price range between "+ startRange.toDouble().toInt().toString() +" - "+ endRange.toDouble().toInt().toString() +"."
}