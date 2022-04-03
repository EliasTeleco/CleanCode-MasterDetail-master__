package es.ulpgc.eite.cleancode.catalog.intermedio;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import es.ulpgc.eite.cleancode.catalog.R;
import es.ulpgc.eite.cleancode.catalog.app.IntermedioItem;
import es.ulpgc.eite.cleancode.catalog.products.ProductListActivity;


public class IntermedioActivity
        extends AppCompatActivity implements IntermedioContract.View {

    public static String TAG = IntermedioActivity.class.getSimpleName();

    private IntermedioContract.Presenter presenter;

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intermedio);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(getString(R.string.intermedio_title));
        }

        listView = findViewById(R.id.product_list);
        IntermedioScreen.configure(this);
        presenter.fetchIntermedioData();

    }




    @Override
    public void onDataUpdated(IntermedioViewModel viewModel) {
        Log.e(TAG, "onDataUpdated()");
        // deal with the data
        listView.setAdapter(new IntermedioAdapter(
                        this, viewModel.id, new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        IntermedioItem item = (IntermedioItem) view.getTag();
                        presenter.selectProductListData(item);
                    }
                })
        );
    }


    @Override
    public void navigateToNextScreen() {
        Intent intent = new Intent(this, ProductListActivity.class);
        startActivity(intent);
    }

    @Override
    public void injectPresenter(IntermedioContract.Presenter presenter) {
        this.presenter = presenter;
    }
}
