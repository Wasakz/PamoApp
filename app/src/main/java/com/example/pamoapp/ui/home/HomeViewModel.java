package com.example.pamoapp.ui.home;

import android.util.Log;
import android.view.View;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HomeViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public HomeViewModel() {
        mText = new MutableLiveData<>();
//        mText.setValue("Test");
    }

    public double calculateBMI(double height, double weight) {
        return weight/(Math.pow(height, 2));
    }

    public void clickCalc(View view) {
        Log.i("info", "Btn pressed");
    }

    public LiveData<String> getText() {
        return mText;
    }
}