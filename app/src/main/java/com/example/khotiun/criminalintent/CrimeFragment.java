package com.example.khotiun.criminalintent;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

/**
 * Created by hotun on 27.06.2017.
 */

public class CrimeFragment extends Fragment {
    private Crime mCrime;
    private EditText mTitleField;
    private Button mDateButton;
    private CheckBox mSolvedCheckBox;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mCrime = new Crime();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_crime, container, false);
        mTitleField = (EditText) v.findViewById(R.id.crime_title);
        mTitleField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence c, int start, int count, int after) {//метод вызывается до изменений, чтобы уведомить нас, что в строке s, начиная с позиции start вот-вот будут заменены count символов, новыми after символами. Изменение текста s в этом методе является ошибкой.

            }

            @Override
            public void onTextChanged(CharSequence c, int start, int before, int count) {//метод вызывается, чтобы уведомить нас, что в строке s, начиная с позиции start, только что заменены after символов, новыми count символами. Изменение текста s в этом методе является ошибкой.
                mCrime.setTitle(c.toString());
            }

            @Override
            public void afterTextChanged(Editable c) {//метод вызывается, чтобы уведомить нас, что где-то в строке s, текст был изменен. В этом методе можно вносить изменения в текст s, но будьте осторожны, чтобы не зациклиться, потому что любые изменения в s рекурсивно вызовут этот же метод.

            }
        });

        mDateButton = (Button) v.findViewById(R.id.crime_date);
        mDateButton.setText(mCrime.getDate().toString());//задать кнопке текущую дату
        mDateButton.setEnabled(false);//отключить возможность нажатия на кнопку

        mSolvedCheckBox = (CheckBox) v.findViewById(R.id.crime_solved);
        mSolvedCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                mCrime.setSolved(isChecked);
            }
        });
        return v;
    }
}
