package com.example.mikekotlinfaceplayground.servic

import android.graphics.Color

import com.example.mikekotlinfaceplayground.models.AnalogStyle
import com.example.mikekotlinfaceplayground.models.WatchHandColors
import com.example.mikekotlinfaceplayground.models.WatchHandDimensions
import com.example.mikekotlinfaceplayground.models.WatchTicIncrement
import com.example.mikekotlinfaceplayground.models.WatchImages

@DslMarker
annotation class WatchFaceStyleDSL

@WatchFaceStyleDSL
class WatchTicIncrementBuilder {
    private val attributesMap: MutableMap<String, Any?> = mutableMapOf(
	"ticInterval" to 1
    )

    var ticInterval:Int by attributesMap

    fun build(): WatchTicIncrement{
	return WatchTicIncrement(
	    ticInterval
	)
    }
}

@WatchFaceStyleDSL
class WatchHandColorsBuilder {
    private val attributesMap: MutableMap<String, Any?> = mutableMapOf(
	"hourHand" to Color.GREEN,
	"minuteHand" to Color.GREEN,
	"secondHand" to Color.GREEN
    )

    var hourHand:Int by attributesMap
    var minuteHand:Int by attributesMap
    var secondHand:Int by attributesMap

    fun build(): WatchHandColors{
	return WatchHandColors(
	    hourHand, minuteHand, secondHand
	)
    }
}

@WatchFaceStyleDSL
class WatchHandDimensionsBuilder {
    private val attributesMap: MutableMap<String, Any?> = mutableMapOf(
	"hourHandRadiusRatio" to 5.0f,
	"minuteHandRadiusRatio" to 5.0f,
	"secondHandRadiusRatio" to 5.0f,
	"hourHandWidth" to 5.0f,
	"minuteHandWidth" to 5.0f,
	"secondHandWidth" to 5.0f,
	"innerCircleRadius" to 10.0f,
	"innerCircleToArmsDistance" to 10.0f
    )

    var hourHandRadiusRatio:Float by attributesMap
    var minuteHandRadiusRatio:Float by attributesMap
    var secondHandRadiusRatio:Float by attributesMap
    var hourHandWidth:Float by attributesMap
    var minuteHandWidth:Float by attributesMap
    var secondHandWidth:Float by attributesMap
    var innerCircleRadius:Float by attributesMap
    var innerCircleToArmsDistance:Float by attributesMap

    fun build(): WatchHandDimensions {
	return WatchHandDimensions(
	    hourHandRadiusRatio,
	    minuteHandRadiusRatio,
	    secondHandRadiusRatio,
	    hourHandWidth,
	    minuteHandWidth,
	    secondHandWidth,
	    innerCircleRadius,
	    innerCircleToArmsDistance
	)
    }
}

@WatchFaceStyleDSL
class WatchImagesBuilder {
    private val attributesMap: MutableMap<String, Any?> = mutableMapOf(
        "backgroundImageResource" to 0, // TODO(map) This is a magic number for if an image isn't provided
	"secondHandImageResource" to 0,
	"centerCircleImageResource" to 0
    )

    var backgroundImageResource:Int by attributesMap
    var secondHandImageResource:Int by attributesMap
    var centerCircleImageResource:Int by attributesMap

    fun build(): WatchImages {
        return WatchImages(backgroundImageResource, secondHandImageResource, centerCircleImageResource)
    }
}

@WatchFaceStyleDSL
class AnalogStyleBuilder {

    private var watchTicIncrement: WatchTicIncrement? = null
    private var watchHandColors: WatchHandColors? = null
    private var watchHandDimensions: WatchHandDimensions? = null
    private var watchImages: WatchImages =
        WatchImagesBuilder().build()

    fun watchTicIncrement(setup: WatchTicIncrementBuilder.() -> Unit) {
	val watchTicIncrementBuilder = WatchTicIncrementBuilder()
        watchTicIncrementBuilder.setup()
        watchTicIncrement = watchTicIncrementBuilder.build()	
    }
    
    fun watchHandColors(setup: WatchHandColorsBuilder.() -> Unit) {
        val watchHandColorsBuilder = WatchHandColorsBuilder()
        watchHandColorsBuilder.setup()
        watchHandColors = watchHandColorsBuilder.build()
    }

    fun watchHandDimensions(setup: WatchHandDimensionsBuilder.() -> Unit) {
	val watchHandDimensionsBuilder = WatchHandDimensionsBuilder()
        watchHandDimensionsBuilder.setup()
        watchHandDimensions = watchHandDimensionsBuilder.build()
    }
    
    fun watchImages(setup: WatchImagesBuilder.() -> Unit) {
        val watchBagroundImageBuilder = WatchImagesBuilder()
        watchBagroundImageBuilder.setup()
        watchImages = watchBagroundImageBuilder.build()
    }


    fun build(): AnalogStyle {

	val watchTicIncrementArgument = watchTicIncrement ?:
	    throw IllegalStateException("Must define a tic interval")

	val watchHandColorsArgument = watchHandColors ?:
	    throw IllegalStateException("Must define a watchHandColors")

	val watchHandDimensionsArgument = watchHandDimensions ?:
	    throw IllegalStateException("Must define a watchHandDimensions")

        return AnalogStyle(
	    watchTicIncrementArgument, watchHandColorsArgument, watchHandDimensionsArgument, watchImages
        )
    }

    /**
     * This method shadows the [analogWatchFaceStyle] method when inside the scope
     * of a [AnalogWatchFaceStyleBuilder], so that watch faces can't be nested.
     */
    @Suppress("UNUSED_PARAMETER")
    @Deprecated(level = DeprecationLevel.ERROR, message = "WatchFaceStyles can't be nested.")
    fun analogWatchFaceStyle(param: () -> Unit = {}) {
    }
}

@WatchFaceStyleDSL
fun analogStyle (setup: AnalogStyleBuilder.() -> Unit): AnalogStyle {
    val analogStyleBuilder = AnalogStyleBuilder()
    analogStyleBuilder.setup()
    return analogStyleBuilder.build()
}
