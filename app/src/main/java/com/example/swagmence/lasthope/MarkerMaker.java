package com.example.swagmence.lasthope;

import android.location.Address;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MarkerMaker {

    double[][] markers = new double[][]{};

    public void make_marker(int titles){
        switch(titles){
            case 5:
                markers = new double[][]{{-11.816860, -51.138395}};
                break;
            case 4:
                markers = new double[][]{{51.247765, 10.342216}, {43.118382, 12.268806}};
                break;
            case 2:
                markers = new double[][]{{-35.120322, -65.320501}, {-32.631581, -56.075056}};
                break;
            case 1:
                markers = new double[][]{{46.597077, 2.262969}, {54.293668, -2.061234}, {40.518893, -3.840231}};
                break;
        }
    }
}
