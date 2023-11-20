//MainActivity.kt
package com.example.aplicacion

import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

private lateinit var btnAccept: Button
private lateinit var text: TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnAccept = findViewById(R.id.btnAccept)
        text = findViewById(R.id.text)

        btnAccept.setOnClickListener{
            text.text = getString(R.string.button_clicked)
            text.visibility = View.INVISIBLE
            btnAccept.isEnabled = false
        }
    }

}

//strings.xml
<resources>
    <string name="app_name">6NM60_App</string>
    <string name="hello_text">Hola, Estas es la sesión 2!</string>
    <string name="accept_button">ACEPTAR</string>
    <string name="button_clicked">Haz dado click al botón!</string>
</resources>

//themes.xml
<resources xmlns:tools="http://schemas.android.com/tools">
    <!-- Base application theme. -->
    <style name="Base.Theme._6NM60_App" parent="Theme.Material3.DayNight.NoActionBar">
        <!-- Customize your light theme here. -->
        <!-- <item name="colorPrimary">@color/my_light_primary</item> -->
    </style>

    <style name="Theme._6NM60_App" parent="Base.Theme._6NM60_App" />
</resources>

//activity_main.xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
              xmlns:app="http://schemas.android.com/apk/res-auto"
              xmlns:tools="http://schemas.android.com/tools"
              android:layout_width="match_parent"
              android:gravity="center"
              android:layout_height="match_parent"
              android:orientation="vertical"
              android:background="@color/Blue"
              tools:context=".MainActivity">


    <!-- {COLOCA AQUI EL CONTENIDO DEL LAYOUT} -->

    <TextView
            android:id="@+id/text"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="@string/hello_text"
            android:textSize="14sp"
            android:textColor="@color/Gris"
            android:textStyle="bold" />

    <Button
            android:id="@+id/btnAccept"
            android:background="@color/mexicanPink"
            android:text="@string/accept_button"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:paddingVertical="8dp"
            android:paddingHorizontal="16dp"
            android:textcolor="@color/Gris"
            android:layout_marginTop="48dp"/>
</LinearLayout>

//colors.xml
<?xml version="1.0" encoding="utf-8"?>
<resources>
    <color name="black">#FF000000</color>
    <color name="white">#FFFFFFFF</color>
    <color name="mexicanPink">#E4007C</color>
    <color name="Gris">#9c9c9c</color>
    <color name="Blue">#81d8d0</color>
</resources>
