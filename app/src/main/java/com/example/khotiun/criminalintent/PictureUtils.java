package com.example.khotiun.criminalintent;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;

/**
 * Created by hotun on 13.07.2017.
 */

public class PictureUtils {
    public static Bitmap getScaledBitmap(String path, Activity activity) {
        //Метод проверяет размер экрана и уменьшает изображение до этого размера.
        // Виджет ImageView, в который загружается изображение, всегда меньше размера экрана,
        // так что эта оценка весьма консервативна.
        Point size = new Point();
        activity.getWindowManager().getDefaultDisplay().getSize(size);

        return getScaledBitmap(path, size.x, size.y);
    }

    public static Bitmap getScaledBitmap(String path, int destWidth,
                                         int destHeight){
        // Чтение размеров изображения на диске
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(path, options);

        float srcWidth = options.outWidth;//реальные размеры изображения
        float srcHeight = options.outHeight;

        // Вычисление степени масштабирования
        int inSampleSize = 1;
        //Ключевой параметр inSampleSize определяет величину «образца» для каждого пиксела исходного изображения:
        // образец с размером 1 содержит один горизонтальный пиксел для каждого горизонтального пиксела исходного файла,
        // а образец с размером 2 содержит один горизонтальный пиксел для каждых двух горизонтальных пикселов исходного файла.
        // Таким образом, если значение inSampleSize равно 2, количество пикселов в изображении составляет четверть от количества пикселов оригинала.
        if (srcHeight > destHeight || srcWidth > destWidth) {
            if (srcWidth > srcHeight) {
                inSampleSize = Math.round(srcHeight / destHeight);
            } else {
                inSampleSize = Math.round(srcWidth / destWidth);
            }
        }

        options = new BitmapFactory.Options();
        options.inSampleSize = inSampleSize;

        // Чтение данных и создание итогового изображения
        return BitmapFactory.decodeFile(path, options);

    }
}
