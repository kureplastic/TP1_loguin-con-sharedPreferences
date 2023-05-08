package com.example.tp1loginusandshared;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.tp1loginusandshared.databinding.ActivityMainBinding;
import com.example.tp1loginusandshared.models.Persona;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private MainActivityViewModel vm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        vm = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(MainActivityViewModel.class);

        //listener para boton
        binding.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //tomar los datos y pasarlos al view model o al API CLIENT
                vm.login(binding.etEmail.getText().toString(),binding.etPassword.getText().toString());
            }
        });
        binding.btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //ir a otra vista
                Intent intent = new Intent(MainActivity.this,RegistroActivity.class);
                intent.putExtra("logueado",false);
                startActivity(intent);
            }
        });

        setContentView(binding.getRoot());
    }
}