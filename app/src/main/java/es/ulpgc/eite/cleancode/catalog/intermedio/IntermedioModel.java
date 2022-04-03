package es.ulpgc.eite.cleancode.catalog.intermedio;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import es.ulpgc.eite.cleancode.catalog.app.IntermedioItem;


public class IntermedioModel implements IntermedioContract.Model {

    public static String TAG = IntermedioModel.class.getSimpleName();
    private final List<IntermedioItem> itemList = new ArrayList<>();
    private final int COUNT = 20;

    private String data;

    public IntermedioModel() {
        for (int index = 1; index <= COUNT; index++) {
            addProduct(createProduct(index));
        }
    }
    private void addProduct(IntermedioItem item) {
        itemList.add(item);
    }
    private IntermedioItem createProduct(int position) {
        String content = "Category " + position;

        return new IntermedioItem(
                position, content, fetchProductDetails(position)
        );

    }

    private String fetchProductDetails(int position) {
        String content = "Details about Product:  " + position;
        StringBuilder builder = new StringBuilder();
        builder.append(content);

        for (int index = 0; index < position; index++) {
            builder.append("\nMore details information here.");
        }

        return builder.toString();
     }


    @Override
    public List<IntermedioItem> fetchProductListData() {
        Log.e(TAG, "fetchProductListData()");
        return itemList;
    }


    @Override
    public String getStoredData() {
        // Log.e(TAG, "getStoredData()");
        return data;
    }

    @Override
    public void onRestartScreen(String data) {
        // Log.e(TAG, "onRestartScreen()");
    }

    @Override
    public void onDataFromNextScreen(String data) {
        // Log.e(TAG, "onDataFromNextScreen()");
    }

    @Override
    public void onDataFromPreviousScreen(String data) {
        // Log.e(TAG, "onDataFromPreviousScreen()");
    }
}
