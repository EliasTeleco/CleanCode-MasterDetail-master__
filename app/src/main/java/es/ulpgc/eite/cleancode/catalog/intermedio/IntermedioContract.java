package es.ulpgc.eite.cleancode.catalog.intermedio;

import java.lang.ref.WeakReference;
import java.util.List;

import es.ulpgc.eite.cleancode.catalog.app.IntermedioItem;

public interface IntermedioContract {

    interface View {
        void injectPresenter(Presenter presenter);

        void onDataUpdated(IntermedioViewModel viewModel);

        void navigateToNextScreen();
    }

    interface Presenter {
        void injectView(WeakReference<View> view);

        void injectModel(Model model);

        void fetchIntermedioData();

        void selectProductListData(IntermedioItem item);

    }

    interface Model {
        String getStoredData();

        void onDataFromNextScreen(String data);

        void onRestartScreen(String data);

        void onDataFromPreviousScreen(String data);

        List<IntermedioItem> fetchProductListData();
    }

}
