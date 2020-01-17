package com.ngapp.cngbelarus.ui.calc;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.ngapp.cngbelarus.R;

public class MileageCalcFragment extends Fragment implements View.OnClickListener {

    private CalcViewModel calcViewModel;
    private ImageButton chooseCar;
    private ImageButton chooseVan;
    private ImageButton chooseTruck;
    private Button calculateMileage;
    private EditText getChargeAmount;
    private TextView resultMileageCalc;
    private int cartype;
    private double total;
    private double summ;
    private static final double[] fuelPrices = {0.70 /*CNG*/, 1.76 /*Diesel*/, 1.76 /*AI95*/, 1.66 /*AI92*/, 0.93 /*SUG*/};

    public MileageCalcFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        calcViewModel =
                ViewModelProviders.of(this).get(CalcViewModel.class);
        View root = inflater.inflate(R.layout.fragment_mileage_calc, container, false);

        chooseCar = root.findViewById(R.id.chooseCar);
        chooseVan = root.findViewById(R.id.chooseVan);
        chooseTruck = root.findViewById(R.id.chooseTruck);
        getChargeAmount = root.findViewById(R.id.getChargeAmount);
        resultMileageCalc = root.findViewById(R.id.resultMileageCalc);

        chooseCar.setOnClickListener(this);
        chooseVan.setOnClickListener(this);
        chooseTruck.setOnClickListener(this);


//        chooseCar.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                // do something
//            }
//        });
//
//        chooseVan.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                // do something
//            }
//        });
//
//        chooseTruck.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                // do something
//            }
//        });
        calculateMileage = root.findViewById(R.id.calculateMileage);
        calculateMileage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultMileageCalc.setText(Double.toString(total + 100));

                Toast.makeText(getActivity().getApplicationContext(), "Cho", Toast.LENGTH_SHORT).show();
            }
        });

        return root;
    }


    @Override
    public void onClick(View view) {
        switch (cartype) {
            case R.id.chooseCar:
                chooseCar.getBackground().setAlpha(100);
                chooseVan.setBackgroundResource(R.drawable.imageview_red_border);
                final double[] carFuelRates = {8.7 /*CNG*/, 5.7 /*Diesel*/, 8.1 /*AI95*/, 8.1 /*AI92*/, 10.4 /*SUG*/};
                if (getChargeAmount.getText() == null) {
                    summ = Double.parseDouble(getChargeAmount.getText().toString());
                } else {
                    Toast.makeText(getActivity().getApplicationContext(), "The planned amount of fuel should be the number", Toast.LENGTH_LONG).show();
                }
                for (int i = 0; i <= 5; i++) {
                    double[] resArray = new double[5];
                    resArray[i] = ((summ * 100) / (carFuelRates[i] * fuelPrices[i]));
                    total = total + ((summ * 100) / (carFuelRates[i] * fuelPrices[i]));
                }
                break;
            case R.id.chooseVan:
                chooseVan.getBackground().setAlpha(100);
                chooseVan.setBackgroundResource(R.drawable.imageview_red_border);
                final double[] vanFuelRates = {18 /*CNG*/, 11.5 /*Diesel*/, 16 /*AI95*/, 16 /*AI92*/, 19.2 /*SUG*/};
                if (getChargeAmount.getText() == null) {
                    summ = Double.parseDouble(getChargeAmount.getText().toString());
                } else {
                    Toast.makeText(getActivity().getApplicationContext(), "The planned amount of fuel should be the number", Toast.LENGTH_LONG).show();
                }
                for (int i = 0; i <= 5; i++) {
                    double[] resArray = new double[5];
                    resArray[i] = ((summ * 100) / (vanFuelRates[i] * fuelPrices[i]));
                    total = total + ((summ * 100) / (vanFuelRates[i] * fuelPrices[i]));
                }
                break;
            case R.id.chooseTruck:
                chooseTruck.getBackground().setAlpha(100);
                chooseVan.setBackgroundResource(R.drawable.imageview_red_border);
                final double[] truckFuelRates = {32 /*CNG*/, 25 /*Diesel*/, 31 /*AI95*/, 31 /*AI92*/, 42 /*SUG*/};
                if (getChargeAmount.getText() == null) {
                    summ = Double.parseDouble(getChargeAmount.getText().toString());
                } else {
                    Toast.makeText(getActivity().getApplicationContext(), "The planned amount of fuel should be the number", Toast.LENGTH_LONG).show();
                }
                for (int i = 0; i <= 5; i++) {
                    double[] resArray = new double[5];
                    resArray[i] = ((summ * 100) / (truckFuelRates[i] * fuelPrices[i]));
                    total = total + ((summ * 100) / (truckFuelRates[i] * fuelPrices[i]));
                }
                break;
            default:
                Toast.makeText(getActivity().getApplicationContext(), "Choose car type", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
