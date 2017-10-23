package com.realm.custom_annotations;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.lang.reflect.Method;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getAnnotations();
    }

    @Annotations(author = "Rajesh", designation = "Android developer",address = "Vizag")
    public void getAnnotations() {

        try {
            Method method = getClass().getMethod("getAnnotations");
            Annotations methodInfo = method.getAnnotation(Annotations.class);

            Log.e("MethodInfo", "<>><"+methodInfo.author());
            Log.e("MethodInfo", "<>><"+methodInfo.designation());
            Log.e("MethodInfo", "<>><"+methodInfo.address());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
