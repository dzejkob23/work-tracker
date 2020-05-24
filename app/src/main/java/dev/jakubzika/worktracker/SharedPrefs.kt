package dev.jakubzika.worktracker

import android.content.Context
import android.content.SharedPreferences
import dev.jakubzika.worktracker.di.PREFERENCES_FILE_KEY
import java.sql.Timestamp

private const val START_TIME_TAG = "START_TIME_TAG"

private inline fun SharedPreferences.edit(
    commit: Boolean = false,
    action: SharedPreferences.Editor.() -> Unit
) {
    val editor = edit()
    action(editor)
    if (commit) {
        editor.commit()
    } else {
        editor.apply()
    }
}

private val preferences: SharedPreferences
    get() = App.appContext.getSharedPreferences(PREFERENCES_FILE_KEY, Context.MODE_PRIVATE)

fun createTag(startTime: Timestamp) {
    preferences.edit {
        START_TIME_TAG to "ahoj" // TODO - is this code possible ??
    }
}