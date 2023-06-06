package umbjm.ft.inf.umbjm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    lateinit var toogle:ActionBarDrawerToggle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val drawerLayout:DrawerLayout = findViewById(R.id.drawer_layout)
        val navView:NavigationView = findViewById(R.id.nav_view)

        toogle = ActionBarDrawerToggle(this, drawerLayout, 0, 0)
        drawerLayout.addDrawerListener(toogle)
        toogle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Universitas Muhammadiyah Banjarmasin"

        replaceFragment(BerandaFragment(),"")

        navView.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.beranda -> replaceFragment(BerandaFragment(), it.title.toString())
                R.id.vdm -> replaceFragment(VisidanMisiFragment(), it.title.toString())
                R.id.pimpinan -> replaceFragment(PimpinanFragment(), it.title.toString())
                R.id.Identitas -> replaceFragment(IdentitasFragment(), it.title.toString())
                R.id.fakultas -> replaceFragment(FakultasFragment(), it.title.toString())
                R.id.akreditasi -> replaceFragment(AkreditasiFragment(), it.title.toString())
            }

            true
        }
    }

    private fun replaceFragment(fragment: Fragment, title:String) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout, fragment)
        fragmentTransaction.commit()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if(toogle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}