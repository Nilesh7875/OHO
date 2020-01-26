package com.example.testoho;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TimePicker;

import java.text.DateFormat;
import java.util.Calendar;

public class AddFragment extends Fragment implements  DatePickerDialog.OnDateSetListener,TimePickerDialog.OnTimeSetListener{
    private EditText dateTime;
    private Spinner spinner;
    private  String myspinnercontent[]={"Car","Motor Cycle","Auto Rickshaw"};
    int yearText,monthText,date,hrs,min;

    @RequiresApi(api = Build.VERSION_CODES.N)
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_add,container,false);
        spinner=(Spinner) view.findViewById(R.id.vehichleTypeInput);
        dateTime=view.findViewById(R.id.JourneyTimeInput);

        DatePickerDialog datePickerDialog=new DatePickerDialog(getContext(), this,Calendar.getInstance().get(Calendar.YEAR)
                ,Calendar.getInstance().get(Calendar.MONTH),Calendar.getInstance().get(Calendar.DATE));
        datePickerDialog.show();

        ArrayAdapter<String> myAdapter=new ArrayAdapter<String>(getContext(),android.R.layout.simple_list_item_1,myspinnercontent);
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(myAdapter);

        return view;
    }


    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        yearText=year;
        monthText=month;
        date=dayOfMonth;

        TimePickerDialog timePickerDialog=new TimePickerDialog(getContext(),this,Calendar.getInstance().get(Calendar.HOUR),Calendar.getInstance().get(Calendar.MINUTE),
                false);
        timePickerDialog.show();

    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        hrs=hourOfDay;
        min=minute;

        dateTime.setText(date+"/"+monthText+"/"+yearText+"\t"+hrs+":"+min);
    }
}
