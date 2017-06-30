package com.example.khotiun.criminalintent;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class CrimeActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crime);
        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fragment_container);//если фрагмент находится в списке, нпример когда происходит поворот устройства

        if (fragment == null){//если фрагмент отсутствует
            fragment = new CrimeFragment();//создание фрагмента
            fm.beginTransaction().add(R.id.fragment_container, fragment).commit();//начало транзакции и добавление фрагмента в список FragmentManager
        }

    }
}
