package com.harshalbhakta.testkotlinreflectionandroid

import android.os.Bundle
import android.util.Log
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.harshalbhakta.testkotlinreflectionandroid.models.Admin
import com.harshalbhakta.testkotlinreflectionandroid.models.BaseUser
import com.harshalbhakta.testkotlinreflectionandroid.models.Student
import kotlin.reflect.KClass
import kotlin.reflect.full.createInstance

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))

        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

        testKotlinReflection()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    fun testKotlinReflection() {
        var u1 = Student()
        print(u1.name)

        var a1 = Admin()
        print(a1.name)

        val mapping = mapOf("Student" to Student::class, "Admin" to Admin::class)

        for ((key, value) in mapping) {
            val callingClass = value as KClass<*>
            val instance = callingClass.createInstance() as BaseUser
            Log.d("KOTLIN", instance.userType.toString())
        }
    }
}