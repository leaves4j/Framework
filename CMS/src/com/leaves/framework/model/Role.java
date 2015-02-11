package com.leaves.framework.model;

import org.hibernate.engine.spi.CascadeStyle;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by jiangq on 2014/12/31.
 */
@Entity
@Table(name = "sys_role", schema = "", catalog = "FleaMarket")
public class Role implements Serializable {
    private long id;
    private String code;
    private String name;
    private String description;
    private Set<User> users;
    private Set<Function> functions;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Code")
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Basic
    @Column(name = "Name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "Description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)
    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    @ManyToMany(cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinTable(name = "sys_role_function",
            joinColumns = {
                    @JoinColumn(name = "roleId", referencedColumnName = "id"),
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "functionId", referencedColumnName = "id")
            })
    public Set<Function> getFunctions() {
        return functions;
    }

    public void setFunctions(Set<Function> functions) {
        this.functions = functions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Role role = (Role) o;

        if (id != role.id) return false;
        if (code != null ? !code.equals(role.code) : role.code != null) return false;
        if (description != null ? !description.equals(role.description) : role.description != null) return false;
        if (functions != null ? !functions.equals(role.functions) : role.functions != null) return false;
        if (name != null ? !name.equals(role.name) : role.name != null) return false;
        if (users != null ? !users.equals(role.users) : role.users != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (code != null ? code.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (users != null ? users.hashCode() : 0);
        result = 31 * result + (functions != null ? functions.hashCode() : 0);
        return result;
    }


}
