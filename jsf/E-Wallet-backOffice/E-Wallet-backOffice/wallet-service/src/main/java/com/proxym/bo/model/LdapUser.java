package com.proxym.bo.model;

public class LdapUser /*implements Serializable*/{

    private String userName;
    private String password;
    private RoleModel role;

    public LdapUser() {}

    public LdapUser(String userName, String password, RoleModel role) {
        this.userName = userName;
        this.password = password;
        this.role = role;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public RoleModel getRole() {
        return role;
    }

    public void setRole(RoleModel role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LdapUser)) return false;

        LdapUser ldapUser = (LdapUser) o;

        if (userName != null ? !userName.equals(ldapUser.userName) : ldapUser.userName != null) return false;
        if (password != null ? !password.equals(ldapUser.password) : ldapUser.password != null) return false;
        return role != null ? role.equals(ldapUser.role) : ldapUser.role == null;

    }

    @Override
    public int hashCode() {
        int result = userName != null ? userName.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (role != null ? role.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "LdapUser{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }
}
