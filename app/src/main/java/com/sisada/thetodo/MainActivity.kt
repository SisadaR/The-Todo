package com.sisada.thetodo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.core.view.GravityCompat
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.sisada.thetodo.databinding.ActivityMainBinding
import com.sisada.thetodo.ui.LoginActivity

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setupNavDrawer()
    }


    private fun setupNavDrawer() {
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true);
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_baseline_menu_24)

        binding.navViewTaskActivity.setNavigationItemSelectedListener {
            it.isChecked = true;
            when(it.itemId){
                R.id.nav_menu_logout -> {
                    logout()
                }
            }

            true
        }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return when (item.itemId) {
            android.R.id.home -> {
                binding.drawerLayout.openDrawer(GravityCompat.START)
                true
            }
            else ->  super.onOptionsItemSelected(item)
        }

    }

    private fun logout(){
        Firebase.auth.signOut()
        startActivity(Intent(this,LoginActivity::class.java))
        finish()
    }
}