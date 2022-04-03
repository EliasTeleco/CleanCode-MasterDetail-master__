package es.ulpgc.eite.cleancode.catalog.intermedio;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.cleancode.catalog.app.CatalogMediator;
import es.ulpgc.eite.cleancode.catalog.app.IntermedioItem;

public class IntermedioPresenter implements IntermedioContract.Presenter {

    public static String TAG = IntermedioPresenter.class.getSimpleName();

    private WeakReference<IntermedioContract.View> view;
    private IntermedioState state;
    private IntermedioContract.Model model;
    private CatalogMediator mediator;

    public IntermedioPresenter(CatalogMediator mediator) {
        this.mediator = mediator;
        state = mediator.getIntermedioState();
    }

    @Override
    public void fetchIntermedioData() {
        state.id = model.fetchProductListData();
        view.get().onDataUpdated(state);

    }

    @Override
    public void selectProductListData(IntermedioItem item) {
        passDataToNextScreen(item);
        view.get().navigateToNextScreen();
    }

    private void passDataToNextScreen(IntermedioItem item){
        mediator.setIntermedio(item);
   }

    @Override
    public void injectView(WeakReference<IntermedioContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(IntermedioContract.Model model) {
        this.model = model;
    }


}
