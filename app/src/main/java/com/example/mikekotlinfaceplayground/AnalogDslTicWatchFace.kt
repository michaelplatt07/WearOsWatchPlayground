package com.example.mikekotlinfaceplayground

import android.graphics.Color

import com.example.mikekotlinfaceplayground.models.AnalogStyle
import com.example.mikekotlinfaceplayground.servic.analogStyle

class AnalogDslTicWatchFace : MyWatchFace() {

    override fun getWatchFaceStyle(): AnalogStyle {
        return analogStyle {

	    watchTicIncrement {
		ticInterval = 1000
	    }

	    watchHandColors {
		hourHand = Color.BLUE
		minuteHand = Color.BLUE
		secondHand = Color.BLUE
	    }

	    watchHandDimensions {
		hourHandRadiusRatio = 10.0f
		minuteHandRadiusRatio = 10.0f
		secondHandRadiusRatio = 10.0f
		hourHandWidth = 10.0f
		minuteHandWidth = 10.0f
		secondHandWidth = 10.0f
		innerCircleRadius = 30.0f
		innerCircleToArmsDistance = 30.0f
	    }
	    
	    watchImages {
		backgroundImageResource = R.drawable.skyline
		secondHandImageResource = R.drawable.customhand
		secondHandImageResource = R.drawable.centerwreathscaled
	    }
	    
	}
    }
}
