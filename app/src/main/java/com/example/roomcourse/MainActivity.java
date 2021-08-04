package com.example.roomcourse;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;

import com.example.roomcourse.databinding.ActivityMainBinding;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this));
        setContentView(binding.getRoot());

        binding.btnSave.setOnClickListener(v -> {
            User user = new User();
            user.setUserName(binding.editName.getText().toString());
            user.setUserAge(Integer.parseInt(binding.editAge.getText().toString()));
            user.setUserCity(binding.editCity.getText().toString());

            App.getInstance()
                    .getDatabase()
                    .userDao()
                    .insertUser(user);
        });

        binding.btnUpdate.setOnClickListener(v -> {
            User user = new User();
            user.setId(1);
            user.setUserName(binding.editName.getText().toString());
            user.setUserAge(Integer.parseInt(binding.editAge.getText().toString()));
            user.setUserCity(binding.editCity.getText().toString());

            App.getInstance()
                    .getDatabase()
                    .userDao()
                    .updateUser(user);
        });

        binding.btnDelete.setOnClickListener(v -> {
            User user = new User();
            user.setId(Integer.parseInt(binding.editId.getText().toString()));

            App.getInstance()
                    .getDatabase()
                    .userDao()
                    .deleteUser(user);
        });

        binding.textResult.setMovementMethod(new ScrollingMovementMethod());

        binding.btnFindUser.setOnClickListener(v -> {

            List<User> users = App.getInstance()
                    .getDatabase()
                    .userDao()
                    .getUsersByAge(Integer.parseInt(binding.editAge.getText().toString()));

            if (users != null) {
                StringBuilder sb = new StringBuilder();

                for (User user : users) {
                    sb.append(user.toString()).append("\n\n");
                }

                binding.textResult.setText(sb);
            } else {
                binding.textResult.setText("Пользователи с такими данными не существуют");
            }

//            User user = App.getInstance()
//                    .getDatabase()
//                    .userDao()
//                    .getUserById(Long.parseLong(binding.editId.getText().toString()));
//
//            if (user != null) {
//                binding.textResult.setText(user.toString());
//            } else {
//                binding.textResult.setText("Пользователь с таким id не существует");
//            }

        });



    }
}