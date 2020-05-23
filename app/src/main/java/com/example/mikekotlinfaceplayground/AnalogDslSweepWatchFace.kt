package com.example.mikekotlinfaceplayground

import android.graphics.Color

import com.example.mikekotlinfaceplayground.models.AnalogSweeping
import com.example.mikekotlinfaceplayground.servic.analogSweeping 

class AnalogDslSweepWatchFace : MyWatchFace() {

    override fun getWatchFaceStyle(): AnalogSweeping {
        return analogSweeping {
	    watchTicIncrement {
		ticInterval = 1
	    }
	    watchHandColors {
		hourHand = Color.GREEN
		minuteHand = Color.GREEN
		secondHand = Color.GREEN
	    }
	    watchHandDimensions {
		hourHandRadiusRatio = 5.0f
		minuteHandRadiusRatio = 5.0f
		secondHandRadiusRatio = 5.0f
		hourHandWidth = 5.0f
		minuteHandWidth = 5.0f
		secondHandWidth = 5.0f
		innerCircleRadius = 10.0f
		innerCircleToArmsDistance = 10.0f
	    }
	    watchBackgroundImage {
		backgroundImageResource = R.drawable.underwater
	    }
	}
    }
}
