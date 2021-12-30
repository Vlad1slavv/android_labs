package com.example.laba.base;

import android.os.Bundle;

import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

/*
Базовый класс для реализации ViewBinding и DataBinding.
Данные библиотеки используються для упрощённой работы с view.

В дженнерик класса прописывается биндинг фрагмента/активности,
для того чтобы можно было создать ссылку на биндинг.

Для реализаци DataBinding понадобиться ссылка на layoutId,
для этого создаём абстрактную функцию которая будет возращать ссылку самого View

 */


public abstract class BaseBindingActivity<Binding extends ViewDataBinding> extends AppCompatActivity {

    protected Binding binding;

    @LayoutRes
    protected abstract int layoutId();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, layoutId());
        setContentView(binding.getRoot());
    }
}
