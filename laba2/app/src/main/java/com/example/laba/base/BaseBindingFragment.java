package com.example.laba.base;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.IdRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;


/*
Базовый класс для реализации ViewBinding и DataBinding.
Данные библиотеки используються для упрощённой работы с view.

В дженнерик класса прописывается биндинг фрагмента/активности,
для того чтобы можно было создать ссылку на биндинг.

Для реализаци DataBinding понадобиться ссылка на layoutId,
для этого создаём абстрактную функцию которая будет возращать ссылку самого View


Данный класс (как и BaseBindingActivity) был реализован для сокращения кода.
Для той же реализации Binding'а необязательно теперь писать один и тот же код, для этого стоит использовать баззовый класс.

Функция showMessage является сокращённой версией Toast'а. Теперь можно просто вызывать этот метод из базового класса,
и определять в нём String либо строку из ресурс-файла (String.xml).
 */

public abstract class BaseBindingFragment<Binding extends ViewDataBinding> extends Fragment {

    protected Binding binding;

    @LayoutRes
    protected abstract int layoutId();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, layoutId(), container, false);
        return binding.getRoot();
    }

    protected static void popBackStack(View view){
        Navigation.findNavController(view).popBackStack();
    }

    protected static void navigate(@IdRes int id, View view){
        Navigation.findNavController(view).navigate(id);
    }

    @SuppressLint("ResourceType")
    protected static void showMessage(Context context, @IdRes int message){
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

    protected static void showMessage(Context context, String message){
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }
}
