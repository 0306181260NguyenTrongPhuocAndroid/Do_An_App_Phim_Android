package com.example.giaodienchinh_2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class MainTrangDK_DN extends AppCompatActivity {
    private ViewPager pager;
    private TabLayout mTabLayout;
    private PagerAdapter adapter;
    TabItem firstItem, secondItem;
    private EditText Email;

    private EditText Pass;
    private EditText hoTen,sdt,date;
    private RadioButton radNam,radNu;

    public static final String TREMAIL="EMAIL";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_trang_d_k__d_n);
        ////initView();



    }
    private void initView() {

        pager = findViewById(R.id.viewPager);
        mTabLayout = findViewById(R.id.tabCha);

        firstItem = findViewById(R.id.tabDangNhap);
        secondItem = findViewById(R.id.tabDangKy);

        adapter = new PagerAdapterDN_DK(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT, mTabLayout.getTabCount());
        pager.setAdapter(adapter);

        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                pager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        pager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));
    }

    public void dangNhap(View view) {
        Email = (EditText) findViewById(R.id.txtEmail);
        Pass = (EditText) findViewById(R.id.txtMatKhau);
        String tenTK = "admin@gmail.com";
        String tenMK = "admin";
        String NULL = "";

        if(Email.getText().toString().equals(NULL)){
            Email.setHint("Email không bỏ trống");
            Email.setHintTextColor(getResources().getColor(R.color.nonselected_tab));
        }
        if(Pass.getText().toString().equals(NULL)){
            Pass.setHint("Mật khẩu không bỏ trống");
            Pass.setHintTextColor(getResources().getColor(R.color.nonselected_tab));
        }

        if (Email.getText().toString().equals(tenTK) && Pass.getText().toString().equals(tenMK)) {
            Toast.makeText(getApplicationContext(), "Thành công", Toast.LENGTH_LONG).show();

            String trEmail =Email.getText().toString().trim();
           Intent returnIntent =new Intent();
           returnIntent.putExtra(TREMAIL,trEmail);
            setResult(Activity.RESULT_OK,returnIntent);
            finish();

        } else {
            Toast.makeText(getApplicationContext(), "Thất bại", Toast.LENGTH_LONG).show();
        }
    }

    public void clicKDANGKY(View view) {
        hoTen = (EditText)findViewById(R.id.txt_hoTen);
        sdt = (EditText)findViewById(R.id.txt_Phone);
        Email = (EditText)findViewById(R.id.txt_Email);
        Pass = (EditText)findViewById(R.id.txt_Pass);
        date = (EditText)findViewById(R.id.txt_Date);
        radNam = (RadioButton)findViewById(R.id.rad_Nam);
        radNu = (RadioButton)findViewById(R.id.rad_Nu);

        String NULL = "";
        if(hoTen.getText().toString().equals(NULL)){
            //Toast.makeText(getApplicationContext(),"Họ tên kh đc bỏ trống",Toast.LENGTH_LONG).show();
            hoTen.setHint("Họ tên không bỏ trống");
            hoTen.setHintTextColor(getResources().getColor(R.color.nonselected_tab));
        }
        if(sdt.getText().toString().equals(NULL)){
            sdt.setHint("SĐT không bỏ trống");
            sdt.setHintTextColor(getResources().getColor(R.color.nonselected_tab));
        }
        if(Email.getText().toString().equals(NULL)){
           Email.setHint("Email không bỏ trống");
            Email.setHintTextColor(getResources().getColor(R.color.nonselected_tab));
        }
        if(Pass.getText().toString().equals(NULL)){
            Pass.setHint("Mật khẩu không bỏ trống");
            Pass.setHintTextColor(getResources().getColor(R.color.nonselected_tab));
        }
        if(date.getText().toString().equals(NULL)){
            date.setHint("Ngày sinh không bỏ trống");
            date.setHintTextColor(getResources().getColor(R.color.nonselected_tab));
        }
        else
        {
            Toast.makeText(getApplicationContext(),"Ok",Toast.LENGTH_LONG).show();
        }

    }
}