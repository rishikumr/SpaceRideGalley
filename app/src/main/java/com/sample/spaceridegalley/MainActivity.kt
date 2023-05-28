package com.sample.spaceridegalley

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint

/**
 * This is our MainActivity class, This is the screen is launched at app start up.
 */
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        /* No need to write any code here, Launch & Navigation is handled via Jetpack Navigation Graph 'nav_graph.xml' */
    }
}
