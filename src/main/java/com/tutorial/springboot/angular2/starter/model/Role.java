package com.tutorial.springboot.angular2.starter.model;

import com.google.common.base.Objects;
import org.hibernate.validator.constraints.NotEmpty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Set;


@Entity
@Table(name = "ROLES")
public class Role implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NotNull
    @NotEmpty
    @Size(max = 50)
    @Column(name = "rolename", length = 50)
    private String rolename;


    @OneToMany
    @JoinTable(name = "user_roles",
            joinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")}
    )
    private Set<User> userRoles;

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    public Set<User> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(Set<User> userRoles) {
        this.userRoles = userRoles;
    }

    @Override
    public String toString() {
        return String.format("%s(id=%d, rolename='%s')",
                this.getClass().getSimpleName(),
                this.getId(), this.getRolename());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null)
            return false;

        if (o instanceof Role) {
            final Role other = (Role) o;
            return Objects.equal(getId(), other.getId())
                    && Objects.equal(getRolename(), other.getRolename());
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId(), getRolename());
    }
}
