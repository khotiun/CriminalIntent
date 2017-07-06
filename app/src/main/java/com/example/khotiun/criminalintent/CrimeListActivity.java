package com.example.khotiun.criminalintent;

import android.support.v4.app.Fragment;

/**
 * Created by hotun on 30.06.2017.
 */

public class CrimeListActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return new CrimeListFragment();//создаем фрагмент и добавление его в контейнер
    }
}
