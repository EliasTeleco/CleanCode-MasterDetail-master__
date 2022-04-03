package es.ulpgc.eite.cleancode.catalog.app;

import es.ulpgc.eite.cleancode.catalog.intermedio.IntermedioState;
import es.ulpgc.eite.cleancode.catalog.product.ProductDetailState;
import es.ulpgc.eite.cleancode.catalog.products.ProductListState;

public class CatalogMediator {

  private ProductListState productListState = new ProductListState();
  private ProductDetailState productDetailState = new ProductDetailState();
  private IntermedioState intermedioState = new IntermedioState();
  private ProductItem product;
  private IntermedioItem intermedioItem;


  private static CatalogMediator INSTANCE;

  private CatalogMediator() {

  }

  public static void resetInstance() {
    INSTANCE = null;
  }


  public static CatalogMediator getInstance() {
    if(INSTANCE == null){
      INSTANCE = new CatalogMediator();
    }

    return INSTANCE;
  }


  public ProductListState getProductListState() {
    return productListState;
  }

  public ProductDetailState getProductDetailState() {
    return productDetailState;
  }

  public ProductItem getProduct() {
    ProductItem item = product;
    //product = null;
    return item;
  }
  public IntermedioItem getIntermedioItem(){
    IntermedioItem item = intermedioItem;
    return item;
  }

  public void setProduct(ProductItem item) {
    product = item;
  }


  public void setIntermedio(IntermedioItem item){
     intermedioItem=item;
  }

  public IntermedioState getIntermedioState() {
    return intermedioState;
  }



}
