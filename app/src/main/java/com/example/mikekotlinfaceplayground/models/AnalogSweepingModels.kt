package com.example.mikekotlinfaceplayground.models

import androidx.annotation.DrawableRes

const val EMPTY_IMAGE_RESOURCE = 0

data class AnalogSweeping(
    val watchTicIncrement:WatchTicIncrement,
    val watchHandColors:WatchHandColors,
    val watchHandDimensions:WatchHandDimensions,
    val watchBackgroundImage:WatchBackgroundImage
)

data class WatchTicIncrement(
    val ticInterval:Int
)

data class WatchHandColors(
    val hourHand:Int,
    val minuteHand:Int,
    val secondHand:Int
)

data class WatchHandDimensions(
    val hourHandRadiusRatio:Float,
    val minuteHandRadiusRatio:Float,
    val secondHandRadiusRatio:Float,
    val hourHandWidth:Float,
    val minuteHandWidth:Float,
    val secondHandWidth:Float,
    val innerCircleRadius:Float,
    val innerCircleToArmsDistance:Float
)

data class WatchBackgroundImage(
    @DrawableRes val backgroundImageResource:Int
)
