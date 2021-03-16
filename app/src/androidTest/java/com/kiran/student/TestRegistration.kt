package com.kiran.student

import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.closeSoftKeyboard
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kiran.student.ui.LoginActivity
import com.kiran.student.ui.RegisterActivity
import org.junit.Rule
import org.junit.Test

class TestRegistration {

    @get:Rule
    val testRule = ActivityScenarioRule(RegisterActivity::class.java)

    @Test
    fun testLoginUI() {
        Espresso.onView(ViewMatchers.withId(R.id.etFname))
            .perform(ViewActions.typeText("kiran"))
        Espresso.onView(ViewMatchers.withId(R.id.etLname))
            .perform(ViewActions.typeText("rana"))
        Espresso.onView(ViewMatchers.withId(R.id.etUsername))
            .perform(ViewActions.typeText("kiran456"))
        Espresso.onView(ViewMatchers.withId(R.id.etPassword))
            .perform(ViewActions.typeText("password"))
        Espresso.onView(ViewMatchers.withId(R.id.etConfirmPassword))
            .perform(ViewActions.typeText("password"))

        closeSoftKeyboard()
        Espresso.onView(ViewMatchers.withId(R.id.btnAddUser))
            .perform(ViewActions.click())

//        Espresso.onView(ViewMatchers.withId(R.id.tvUsername))
//            .check(ViewAssertions.matches(ViewMatchers.withText("Welcome Kiran1")))
    }
}