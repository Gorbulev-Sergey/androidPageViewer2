package com.example.androidpageviewer2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintsChangedListener;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager2 pager = findViewById(R.id.pager);
        pager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                switch (position) {
                    case 0:
                        setTitle("Первый фрагмент");
                        break;
                    case 1:
                        setTitle("Второй фрагмент");
                        break;
                }
            }
        });
        MyAdapter adapter = new MyAdapter(getSupportFragmentManager(), getLifecycle());
        adapter.addFragment(new FirstFragment());
        adapter.addFragment(new SecondFragment());
        pager.setAdapter(adapter);

        TabLayout tabLayout = findViewById(R.id.tabs);
        TabLayoutMediator mediator = new TabLayoutMediator(tabLayout, pager, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                switch (position) {
                    case 0:
                        tab.setText("Первый фрагмент");
                        break;
                    case 1:
                        tab.setText("Второй фрагмент");
                        break;
                }
            }
        });
        mediator.attach();
    }
}