package com.proxym.api.ManagedBean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.io.Serializable;


@ManagedBean
@RequestScoped
public class NavigationMenu  implements Serializable{

    private String name="/dash";

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
