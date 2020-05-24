package dev.jakubzika.worktracker.extensions

import android.content.res.ColorStateList
import android.graphics.drawable.Drawable
import android.view.View
import androidx.annotation.ColorInt
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes

// Extensions for [View] class

var View.visible: Boolean
    set(value) {
        visibility = if (value) View.VISIBLE else View.GONE
    }
    get() = visibility == View.VISIBLE

@ColorInt
fun View.color(@ColorRes res: Int): Int {
    return context.color(res)
}

/**
 * Get color state list from resources
 */
fun View.colors(@ColorRes stateListRes: Int): ColorStateList? {
    return context.colors(stateListRes)
}

fun View.drawable(@DrawableRes res: Int): Drawable? {
    return context.drawable(res)
}

fun View.tintedDrawable(@DrawableRes drawableId: Int, @ColorRes colorId: Int): Drawable? {
    return context.tintedDrawable(drawableId, colorId)
}