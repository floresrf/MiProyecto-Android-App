package com.example.miproyecto

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class Principal : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_principal)

        // Configuración del contenedor raíz para EdgeToEdge
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // 1. Vincular componentes del XML
        val tabLayout: TabLayout = findViewById(R.id.tabLayout)
        val viewPager: ViewPager2 = findViewById(R.id.viewPager)
        val btnregresar: Button = findViewById(R.id.btnRegresar)

        // 2. Configurar el adaptador del ViewPager2
        val adapter = ViewPagerAdapter(this)
        viewPager.adapter = adapter

        // 3. Configurar el Mediador con el .attach() al final (OBLIGATORIO)
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            when (position) {
                0 -> tab.text = "Inicio"
                1 -> tab.text = "Ventas"
                2 -> tab.text = "Compras"
            }
        }.attach()

        // 4. Configurar acción del botón Salir
        btnregresar.setOnClickListener {
            finish()
        }
    }
}