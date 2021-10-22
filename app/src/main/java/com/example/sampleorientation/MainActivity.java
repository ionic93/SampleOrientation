package com.example.sampleorientation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String name;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showToast("onCreate 호출됨");

        editText = findViewById(R.id.editTextTextPersonName);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(v -> {
            name = editText.getText().toString(); //버튼 클릭시 사용자가 입력한 값을 저장
            showToast("입력된 값을 변수에 저장했습니다 : "+name);
        });

        if (savedInstanceState != null) { //이 화면이 초기화될때 name 변수의 값을 복원
            name = savedInstanceState.getString("name");
            showToast("값을 복원했습니다 : " +name);
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("name", name); //name 변수의 값 저장
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) { //가로방향, 세로방향인 상황을 알고 싶을때 사용
        super.onConfigurationChanged(newConfig);

        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            showToast("방향 : ORIENTATION_LANDSCAPE");
        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
            showToast("방향 : ORIENTATION_PORTRAIT");
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        showToast("onStart 호출됨");
    }
    @Override
    protected void onStop() {
        super.onStop();
        showToast("onStop 호출됨");
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        showToast("onDestroy 호출됨");
    }

    public void showToast(String data) {
        Toast.makeText(this, data, Toast.LENGTH_LONG).show();
    }
}