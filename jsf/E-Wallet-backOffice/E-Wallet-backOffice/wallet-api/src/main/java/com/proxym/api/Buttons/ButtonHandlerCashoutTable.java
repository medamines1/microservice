package com.proxym.api.Buttons;


import com.proxym.api.ReqNResp.ResponseModel;
import com.proxym.api.controller.LoginController;
import com.proxym.api.models.CashInDto;
import com.proxym.api.models.CashOutDto;
import com.proxym.api.services.cashOutService;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import java.util.Arrays;

@ManagedBean(name = "ButtonHandlerCashoutTable")
public class ButtonHandlerCashoutTable {

    private MenuModel model;

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);


    private cashOutService cashOutService = new cashOutService();

    @PostConstruct
    public void init() {
        model = new DefaultMenuModel();

        //First submenu
        DefaultSubMenu firstSubmenu = new DefaultSubMenu("Dynamic Submenu");

        DefaultMenuItem item = new DefaultMenuItem("External");
        item.setUrl("http://www.primefaces.org");
        item.setIcon("pi pi-home");
        firstSubmenu.addElement(item);

        model.addElement(firstSubmenu);

        //Second submenu
        DefaultSubMenu secondSubmenu = new DefaultSubMenu("Dynamic Actions");

        item = new DefaultMenuItem("Save");
        item.setIcon("pi pi-save");
        item.setCommand("#{buttonView.save}");
        item.setUpdate("messages");
        secondSubmenu.addElement(item);

        item = new DefaultMenuItem("Delete");
        item.setIcon("pi pi-times");
        item.setCommand("#{buttonView.delete}");
        item.setAjax(false);
        secondSubmenu.addElement(item);

        model.addElement(secondSubmenu);
    }

    public MenuModel getModel() {
        return model;
    }

    public void save() {
        addMessage("Data saved");
    }

    public void update() {
        addMessage("Data updated");
    }

    public void delete() {
        addMessage("Data deleted");
    }

    public void perform(CashOutDto cashOutDto,String action) {

        switch (action){
            case  "perform" :
                addMessage("job Performed : " + cashOutService.perform(cashOutDto,"completed"));

                break;
            case  "delete" :
                addMessage("job Performed : " + cashOutService.perform(cashOutDto,"Rejected"));
                break;
        }

    }
    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

}
