package com.kamal.tugassensor10120170;

/*
NIM     : 10120170
Nama    : Moch. Kamaludin Ichsan
Kelas   : IF5
 */

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.widget.Toast;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;

public class MainActivity extends AppCompatActivity {

    private MeowBottomNavigation meowBottomNavigation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        meowBottomNavigation = findViewById(R.id.meowBottom);

        // tambah item
        meowBottomNavigation.add(new MeowBottomNavigation.Model(1, R.drawable.baseline_profil));
        meowBottomNavigation.add(new MeowBottomNavigation.Model(2, R.drawable.baseline_lokasi));
        meowBottomNavigation.add(new MeowBottomNavigation.Model(3, R.drawable.baseline_makan));
        meowBottomNavigation.add(new MeowBottomNavigation.Model(4, R.drawable.baseline_info));

        meowBottomNavigation.setOnShowListener(new MeowBottomNavigation.ShowListener() {
            @Override
            public void onShowItem(MeowBottomNavigation.Model item) {
                Fragment fragment = null;

                switch (item.getId()){
                    case 1 :
                        fragment = new ProfilFragment();
                        break;
                    case 2 :
                        fragment = new LokasiFragment();
                        break;
                    case 3 :
                        fragment = new MakanFragment();
                        break;
                    case 4 :
                        fragment = new InfoFragment();
                        break;
                }

                LoadFragment(fragment);
            }
        });

        // set default
        meowBottomNavigation.show(1, true);

        meowBottomNavigation.setOnClickMenuListener(new MeowBottomNavigation.ClickListener() {
            @Override
            public void onClickItem(MeowBottomNavigation.Model item) {
                Toast.makeText(getApplicationContext(), "Kamu Menekan " + item.getId(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void LoadFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frame_layout,fragment)
                .commit();
    }
}