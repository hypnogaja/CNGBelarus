package com.ngapp.cngbelarus.ui.calc;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.ngapp.cngbelarus.R;

import java.util.HashMap;

public class PaybackCalcFragment extends Fragment {

    private CalcViewModel calcViewModel;

    private static final double[] fuelPrices = {0.70 /*CNG*/, 1.76 /*Diesel*/, 1.76 /*AI95*/, 1.66 /*AI92*/, 0.93 /*SUG*/};

    public PaybackCalcFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        calcViewModel =
                ViewModelProviders.of(this).get(CalcViewModel.class);
        View root = inflater.inflate(R.layout.fragment_payback_calc, container, false);

//        editCalcPaybackText1 = root.findViewById(R.id.editCalcPaybackText1);
//        editCalcPaybackText2 = root.findViewById(R.id.editCalcPaybackText2);
//        editCalcPaybackText3 = root.findViewById(R.id.editCalcPaybackText3);
//        editCalcPaybackText4 = root.findViewById(R.id.editCalcPaybackText4);
//        calculatePayback = root.findViewById(R.id.calculatePayback);
//        calcPaybackTextResult1 = root.findViewById(R.id.calcPaybackTextResult1);
//        calcPaybackTextResult2 = root.findViewById(R.id.calcPaybackTextResult2);
//
////        final double gasPrice/*RENT_GAS_PRICE*/ = (editCalcPaybackText1.getText() == null) ? 0 : Double.parseDouble(editCalcPaybackText1.getText().toString());
////        final double summ/*RENT_SUMM*/ = (editCalcPaybackText2.getText() == null) ? 0 : Double.parseDouble(editCalcPaybackText2.getText().toString());
////        final double path /*RENT_PATH*/ = (editCalcPaybackText3.getText() == null) ? 0 : Double.parseDouble(editCalcPaybackText3.getText().toString());
////        final double gasRate/*RENT_FUEL_RATE_GAS*/ = (editCalcPaybackText4.getText() == null) ? 0 : Double.parseDouble(editCalcPaybackText4.getText().toString());
//
//        try {
//            String gasPrice1/*RENT_GAS_PRICE*/ = editCalcPaybackText1.getText().toString();
//            String summ1/*RENT_SUMM*/ = editCalcPaybackText2.getText().toString();
//            String path1 /*RENT_PATH*/ = editCalcPaybackText3.getText().toString();
//            String gasRate1/*RENT_FUEL_RATE_GAS*/ = editCalcPaybackText4.getText().toString();
//
//
//            if (gasPrice1.isEmpty() || summ1.isEmpty() || path1.isEmpty() || gasRate1.isEmpty()) {
//                Toast.makeText(getActivity().getApplicationContext(), "Empty values", Toast.LENGTH_SHORT).show();
//            } else {
//                double gasPrice = Double.parseDouble(gasPrice1);
//                double summ = Double.parseDouble(summ1);
//                double path = Double.parseDouble(path1);
//                double gasRate = Double.parseDouble(gasRate1);
//
//                final String[] arNames = {"CNG", "Diesel", "AI95", "AI92", "SUG"};
//                double left = (gasRate * path * gasPrice / 100);
//                double right = (gasRate * path * fuelPrices[0] / 100);
//                final double RES_TIME = /*Double.parseDouble*/((summ / (left - right)) * 12);
//                final double RES_PATH = /*Double.parseDouble*/((summ * 100) / ((gasRate * gasPrice) - (gasRate * fuelPrices[0])));
//
//
////        textView.setText(Integer.toString(a + b));
//                calculatePayback.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        calcPaybackTextResult1.setText(Double.toString(RES_TIME));
//                        calcPaybackTextResult2.setText(Double.toString(RES_PATH));
//                    }
//                });
//            }
//        } catch (NumberFormatException e) {
//            // p did not contain a valid double
//        }
        return root;
    }

    public static void onClickCalculate(View view) {
        EditText editCalcPaybackText1;
        EditText editCalcPaybackText2;
        EditText editCalcPaybackText3;
        EditText editCalcPaybackText4;
        TextView calcPaybackTextResult1;
        TextView calcPaybackTextResult2;
        Button calculatePayback;
        editCalcPaybackText1 = view.findViewById(R.id.editCalcPaybackText1);
        editCalcPaybackText2 = view.findViewById(R.id.editCalcPaybackText2);
        editCalcPaybackText3 = view.findViewById(R.id.editCalcPaybackText3);
        editCalcPaybackText4 = view.findViewById(R.id.editCalcPaybackText4);
        calculatePayback = view.findViewById(R.id.calculatePayback);
        calcPaybackTextResult1 = view.findViewById(R.id.calcPaybackTextResult1);
        calcPaybackTextResult2 = view.findViewById(R.id.calcPaybackTextResult2);

//        final double gasPrice/*RENT_GAS_PRICE*/ = (editCalcPaybackText1.getText() == null) ? 0 : Double.parseDouble(editCalcPaybackText1.getText().toString());
//        final double summ/*RENT_SUMM*/ = (editCalcPaybackText2.getText() == null) ? 0 : Double.parseDouble(editCalcPaybackText2.getText().toString());
//        final double path /*RENT_PATH*/ = (editCalcPaybackText3.getText() == null) ? 0 : Double.parseDouble(editCalcPaybackText3.getText().toString());
//        final double gasRate/*RENT_FUEL_RATE_GAS*/ = (editCalcPaybackText4.getText() == null) ? 0 : Double.parseDouble(editCalcPaybackText4.getText().toString());

        String gasPrice1/*RENT_GAS_PRICE*/ = editCalcPaybackText1.getText().toString();
        String summ1/*RENT_SUMM*/ = editCalcPaybackText2.getText().toString();
        String path1 /*RENT_PATH*/ = editCalcPaybackText3.getText().toString();
        String gasRate1/*RENT_FUEL_RATE_GAS*/ = editCalcPaybackText4.getText().toString();


        if (gasPrice1.isEmpty() || summ1.isEmpty() || path1.isEmpty() || gasRate1.isEmpty()) {

        } else {
            double gasPrice = Double.parseDouble(gasPrice1);
            double summ = Double.parseDouble(summ1);
            double path = Double.parseDouble(path1);
            double gasRate = Double.parseDouble(gasRate1);

            final String[] arNames = {"CNG", "Diesel", "AI95", "AI92", "SUG"};
            HashMap<String,Double> values = new HashMap<>();
            values.put("CNG",0.7);
            double left = (gasRate * path * gasPrice / 100);
            double right = (gasRate * path * fuelPrices[0] / 100);
            final double RES_TIME = /*Double.parseDouble*/((summ / (left - right)) * 12);
            final double RES_PATH = /*Double.parseDouble*/((summ * 100) / ((gasRate * gasPrice) - (gasRate * fuelPrices[0])));


//        textView.setText(Integer.toString(a + b));

            calcPaybackTextResult1.setText(Double.toString(RES_TIME));
            calcPaybackTextResult2.setText(Double.toString(RES_PATH));

        }
    }
}
