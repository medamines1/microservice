package com.proxym.api.Buttons;


import com.proxym.api.models.CashInDto;

import com.proxym.api.services.cashInService;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

@ManagedBean(name = "ButtonHandlerCashInTable")
public class ButtonHandlerCashInTable {

        private MenuModel model;

        @Autowired
        private  cashInService  cashinService;


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

        public void perform(CashInDto cashInDto,String action) {

            switch (action){
                case  "perform" :
                    addMessage("job Performeded : " + cashinService.perform(cashInDto,"completed"));

                    break;
                case  "delete" :
                    addMessage("job Performeded : " + cashinService.perform(cashInDto,"Rejected"));
                    break;
            }

        }


        public void addMessage(String summary) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }

}
