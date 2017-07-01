package com.example.khotiun.criminalintent;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

/**
 * Created by hotun on 30.06.2017.
 */

public abstract class SingleFragmentActivity extends FragmentActivity{

    protected abstract Fragment createFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fragment_container);//если фрагмент находится в списке, нпример когда происходит поворот устройства

        if (fragment == null){//если фрагмент отсутствует
            fragment = createFragment();//создание фрагмента
            fm.beginTransaction().add(R.id.fragment_container, fragment).commit();//начало транзакции и добавление фрагмента в список FragmentManager
        }

    }
}
