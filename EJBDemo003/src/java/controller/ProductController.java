package controller;

import entity.Product;
import util.JsfUtil;
import util.PaginationHelper;
import session.ProductFacade;

import java.io.Serializable;
import java.util.ResourceBundle;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;
import entity.*;
import java.util.List;
@Named("productController")
@SessionScoped
public class ProductController implements Serializable {

    @EJB
    private ProductFacade productFacade;
    private Product p = new Product();

    public Product getP() {
        return p;
    }

    public void setP(Product p) {
        this.p = p;
    }  
 

    public ProductController() {
    }
    
    public List<Product> findAll(){
        return this.productFacade.findAll();
    }
    public String insert(){
       this.productFacade.create(this.p);
       this.p = new Product();
        return "List";
    }
     public void delete(Product p){
       this.productFacade.remove(p);
    
    }
    public String edit(Product p){
        this.p=p;
        return "List";
    }
    public String edit(){
          this.productFacade.edit(this.p);
          return "List";
        
    }
    
   
   
}
