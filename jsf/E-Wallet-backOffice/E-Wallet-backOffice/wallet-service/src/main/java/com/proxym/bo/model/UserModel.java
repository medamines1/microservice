package com.proxym.bo.model;

import com.elm.commons.utilities.response.enumerations.UserBoStatusEnum;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserModel {

    private  String id;
    private String userName;
    private String password;
    private boolean enabled;
    private String firstname;
    private String lastname;
    private String email;
    private UserBoStatusEnum status;
    private Date lastConnected;
    private Date createdOn;

    private List<AuthorityModel> autorities = new ArrayList<>();


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserModel)) return false;

        UserModel user = (UserModel) o;

        if (enabled != user.enabled) return false;
        if (userName != null ? !userName.equals(user.userName) : user.userName != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        return autorities != null ? autorities.equals(user.autorities) : user.autorities == null;

    }

    @Override
    public int hashCode() {
        int result = userName != null ? userName.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (enabled ? 1 : 0);
        result = 31 * result + (autorities != null ? autorities.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "UserModel [userName=" + userName + ", password=" + password + ", enabled=" + enabled + ", firstname="
                + firstname + ", lastname=" + lastname + ", email=" + email + ", autorities=" + autorities + "]";
    }


}