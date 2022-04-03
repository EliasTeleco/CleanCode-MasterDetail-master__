package es.ulpgc.eite.cleancode.catalog.intermedio;

//import android.support.v4.app.FragmentActivity;

import androidx.fragment.app.FragmentActivity;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.cleancode.catalog.R;
import es.ulpgc.eite.cleancode.catalog.app.CatalogMediator;

public class IntermedioScreen {

    public static void configure(IntermedioContract.View view) {
        WeakReference<FragmentActivity> context =
                new WeakReference<>((FragmentActivity) view);

        String data = context.get().getString(R.string.app_name);

        CatalogMediator mediator = CatalogMediator.getInstance();
        IntermedioContract.Presenter presenter = new IntermedioPresenter(mediator);
        IntermedioContract.Model model = new IntermedioModel();
        presenter.injectModel(model);
        presenter.injectView(new WeakReference<>(view));

        view.injectPresenter(presenter);

    }
}
