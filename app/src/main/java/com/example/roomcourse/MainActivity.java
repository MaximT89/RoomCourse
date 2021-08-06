package com.example.roomcourse;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.rxjava3.EmptyResultSetException;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;

import com.example.roomcourse.databinding.ActivityMainBinding;

import java.util.List;
import java.util.Objects;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.observers.DisposableCompletableObserver;
import io.reactivex.rxjava3.observers.DisposableSingleObserver;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @SuppressLint({"SetTextI18n", "CheckResult"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this));
        setContentView(binding.getRoot());
        binding.textResult.setMovementMethod(new ScrollingMovementMethod());

        binding.btnSave.setOnClickListener(v -> {
            User user = new User();
            user.setUserName(binding.editName.getText().toString());
            user.setUserAge(Integer.parseInt(binding.editAge.getText().toString()));
            user.setUserCity(binding.editCity.getText().toString());

            App.getInstance()
                    .getDatabase()
                    .userDao()
                    .insertUser(user)
                    .subscribeOn(Schedulers.io())
                    .subscribe(new DisposableCompletableObserver() {
                        @Override
                        public void onComplete() {

                        }

                        @Override
                        public void onError(@NonNull Throwable e) {

                        }
                    });
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
                    .updateUser(user)
                    .subscribeOn(Schedulers.io())
                    .subscribe(new DisposableCompletableObserver() {
                        @Override
                        public void onComplete() {

                        }

                        @Override
                        public void onError(@NonNull Throwable e) {

                        }
                    });
        });

        binding.btnDelete.setOnClickListener(v -> {
            User user = new User();
            user.setId(Integer.parseInt(binding.editId.getText().toString()));

            App.getInstance()
                    .getDatabase()
                    .userDao()
                    .deleteUser(user)
                    .subscribeOn(Schedulers.io())
                    .subscribe(new DisposableCompletableObserver() {
                        @Override
                        public void onComplete() {

                        }

                        @Override
                        public void onError(@NonNull Throwable e) {

                        }
                    });
        });

        binding.btnFindUser.setOnClickListener(v -> {

            App.getInstance()
                    .getDatabase()
                    .userDao()
                    .getUsersByAge(Integer.parseInt(binding.editAge.getText().toString()))
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new DisposableSingleObserver<List<User>>() {
                        @Override
                        public void onSuccess(@NonNull List<User> users) {

                            if(users.size() != 0){
                                StringBuilder sb = new StringBuilder();

                                for(User user : users){
                                    sb.append(user.toString()).append("\n\n");
                                }

                                binding.textResult.setText(sb);

                            } else {
                                binding.textResult.setText("Пользователей с таким возрастом не найдено");
                            }
                        }

                        @Override
                        public void onError(@NonNull Throwable e) {
                            e.printStackTrace();
                            binding.textResult.setText("Ошибка");
                        }
                    });


//            App.getInstance()
//                    .getDatabase()
//                    .userDao()
//                    .getUserById(Long.parseLong(binding.editId.getText().toString()))
//                    .subscribeOn(Schedulers.io())
//                    .observeOn(AndroidSchedulers.mainThread())
//                    .subscribe(new DisposableSingleObserver<User>() {
//                        @Override
//                        public void onSuccess(@NonNull User user) {
//                            binding.textResult.setText(user.toString());
//                        }
//
//                        @Override
//                        public void onError(@NonNull Throwable e) {
//                            e.printStackTrace();
//
//                            if (e instanceof EmptyResultSetException)
//                                binding.textResult.setText("Пользователи не найдены");
//                            else
//                                binding.textResult.setText("Ошибка");
//                        }
//                    });


        });

    }
}