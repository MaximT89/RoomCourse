package com.example.roomcourse;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;

import com.example.roomcourse.databinding.ActivityMainBinding;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private AppDatabase db;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this));
        setContentView(binding.getRoot());
        initView();

        binding.btnResult.setOnClickListener(v -> {
            StringBuilder stringBuilder = new StringBuilder();

            User user = new User();
            user.mUserName = binding.editName.getText().toString();
            user.mUserAge = Integer.parseInt(binding.editAge.getText().toString());
            user.mUserCity = binding.editCity.getText().toString();

            List<User> userList = db.userDao().insertAndGetAllUsers(user);

            for (int i = 0; i < userList.size(); i++) {
                stringBuilder.append(userList.get(i)).append("\n\n");
            }

            binding.textResult.setText(stringBuilder);
        });
    }

    private void initView() {
        db = App.getInstance().getDatabase();
    }
}