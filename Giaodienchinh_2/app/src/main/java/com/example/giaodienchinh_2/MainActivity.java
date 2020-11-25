package com.example.giaodienchinh_2;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import static com.example.giaodienchinh_2.MainTrangDK_DN.TREMAIL;

public class MainActivity extends AppCompatActivity implements  NavigationView.OnNavigationItemSelectedListener {
    private static final int REQUEST = 10;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle toggle;
    NavigationView navigationView;

    ViewFlipper flipper;
    private ViewPager2 viewPager2;
    Button btndangchieu;
    Button btnsapchieu;

    Button selectDangChieu;
    Button selectSapChieu;

    private TextView EMAIL;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        selectDangChieu = findViewById(R.id.btn_dc);
        selectSapChieu = findViewById(R.id.btn_sc);


        viewPager2 = (ViewPager2) findViewById(R.id.viewPagerImageSlider);

        final List<dangchieu_AT> dangchieu_ats = new ArrayList<>();
        dangchieu_ats.add(new dangchieu_AT(R.drawable.matbet, "MẮT BIẾC", "Tình Cảm", R.drawable.ic_baseline_star_24, "8.9"));
        dangchieu_ats.add(new dangchieu_AT(R.drawable.rom, "RÒM", "Tâm Lý", R.drawable.ic_baseline_star_24, "7.9"));
        dangchieu_ats.add(new dangchieu_AT(R.drawable.trangmau, "TIỆC TRĂNG MÁU", "Tâm Lý, Tình Cảm, Hài", R.drawable.ic_baseline_star_24, "7.7"));
        dangchieu_ats.add(new dangchieu_AT(R.drawable.venom, "VENOM", "Hành Động, Viễn Tưởng", R.drawable.ic_baseline_star_24, "8.0"));
        dangchieu_ats.add(new dangchieu_AT(R.drawable.trangquynh, "TRẠNG QUỲNH", "Cổ Tích, Hài", R.drawable.ic_baseline_star_24, "8.5"));

        final List<dangchieu_AT> dangchieu_ats2 = new ArrayList<>();
        dangchieu_ats2.add(new dangchieu_AT(R.drawable.chimuoiba, "CHỊ MƯỜI BA", "Hài, Hành Động,", R.drawable.ic_baseline_star_24, "8.0"));
        dangchieu_ats2.add(new dangchieu_AT(R.drawable.chongngta, "CHỒNG NGƯỜI TA", "Tâm Lý", R.drawable.ic_baseline_star_24, "6.8"));
        dangchieu_ats2.add(new dangchieu_AT(R.drawable.kesanmo, "KẺ SĂN MỘ", "Hành Động, Phiêu Lưu", R.drawable.ic_baseline_star_24, "7.0"));
        dangchieu_ats2.add(new dangchieu_AT(R.drawable.traitimquaivat, "TRÁI TIM QUÁI VẬT", "Kinh Dị", R.drawable.ic_baseline_star_24, "9.3"));
        dangchieu_ats2.add(new dangchieu_AT(R.drawable.wonderwoman, "WONDER WOMAN", "Hành Động", R.drawable.ic_baseline_star_24, "8.9"));

        initslider1(dangchieu_ats);
        btndangchieu = (Button) findViewById(R.id.dangchieu);
        btnsapchieu = (Button) findViewById(R.id.sapchieu);

        btndangchieu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initslider1(dangchieu_ats);
                select(v);
            }
        });
        btnsapchieu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initslider1(dangchieu_ats2);
                select(v);
            }
        });

        int[] igmarray = {R.drawable.slide1, R.drawable.slide2, R.drawable.slide3, R.drawable.slide4};
        flipper = (ViewFlipper) findViewById(R.id.flipper);
        for (int i = 0; i < igmarray.length; i++) {
            showimg(igmarray[i]);
        }

        drawerLayout = findViewById(R.id.drawer);
        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.setDrawerIndicatorEnabled(true);
        toggle.syncState();



    }

    public void showimg(int img) {
        ImageView imageview = new ImageView(this);
        imageview.setBackgroundResource(img);
        flipper.addView(imageview);
        flipper.setFlipInterval(2700);
        flipper.setAutoStart(true);

        flipper.setInAnimation(this, android.R.anim.slide_in_left);
        flipper.setOutAnimation(this, android.R.anim.slide_out_right);

    }



    @SuppressLint("ResourceAsColor")
    public void select(View view) {

        switch (view.getId()) {
            case R.id.dangchieu: {
                selectDangChieu.setBackgroundResource(R.color.selected_tab);
                selectSapChieu.setBackgroundResource(R.color.nonselected_tab);
            }
            break;
            case R.id.sapchieu: {
                selectDangChieu.setBackgroundResource(R.color.nonselected_tab);
                selectSapChieu.setBackgroundResource(R.color.selected_tab);
            }
            break;
        }
    }

    public void initslider1(List<dangchieu_AT> dangchieus) {
        viewPager2 = (ViewPager2) findViewById(R.id.viewPagerImageSlider);
        viewPager2.setAdapter(new Adapterdangchieu(dangchieus, viewPager2));
        viewPager2.setClipToPadding(false);
        viewPager2.setClipChildren(false);
        viewPager2.setOffscreenPageLimit(5);
        viewPager2.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);

        CompositePageTransformer compositePageTransformer = new CompositePageTransformer();
        compositePageTransformer.addTransformer(new MarginPageTransformer(50));
        compositePageTransformer.addTransformer(new ViewPager2.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {
                float r = 1 - Math.abs(position);
                page.setScaleY(0.87f + r * 0.15f);
            }
        });
        viewPager2.setPageTransformer(compositePageTransformer);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {



        drawerLayout.closeDrawer(GravityCompat.START);
        if (item.getItemId() == R.id.menuDK_DN) {
            // Toast.makeText(this, "Btn is clicked.", Toast.LENGTH_SHORT).show();
            //getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new trangTabDN_DK()).commit();
            Intent chuyen = new Intent(getApplicationContext(),MainTrangDK_DN.class);
            startActivity(chuyen);
        }
        
       return false;

   }

    private  void nextActivity()
    {
        EMAIL=(TextView)findViewById(R.id.txt_Email);
        String strEmail= EMAIL.getText().toString().trim();
        //Intent TrEmail = getIntent();
        //String email =TrEmail.getStringExtra(MainTrangDK_DN.TREMAIL);
        //EMAIL.setText(email);
        Intent intent =new Intent(this,MainTrangDK_DN.class);
        intent.putExtra(TREMAIL,strEmail);
        startActivityForResult(intent,REQUEST);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(REQUEST==requestCode && requestCode== Activity.RESULT_OK)
        {
            EMAIL.setText(data.getStringExtra(TREMAIL));
        }
    }
}