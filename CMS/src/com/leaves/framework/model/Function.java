package com.leaves.framework.model;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by jiangq on 2014/12/31.
 */
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "sys_function", schema = "", catalog = "FleaMarket")
public class Function implements Serializable {
    private String id;
    private String code;
    private String name;
    private String path;
    private String uri;
    private String icon;
    private String number;
//    private Set<Role> roles;

    @Id
    @GeneratedValue(generator = "idGenerator")
    @GenericGenerator(name = "idGenerator", strategy = "uuid")
    @Column(name = "ID")
    public String getId() {
        return id;
    }

    public void setId(String id) {
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
    @Column(name = "Path")
    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Basic
    @Column(name = "URI")
    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    @Basic
    @Column(name = "Icon")
    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
    @Basic
    @Column(name = "Number")
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

//    @ManyToMany(mappedBy = "functions", fetch = FetchType.LAZY)
//    public Set<Role> getRoles() {
//        return roles;
//    }
//
//    public void setRoles(Set<Role> roles) {
//        this.roles = roles;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Function function = (Function) o;

        if (code != null ? !code.equals(function.code) : function.code != null) return false;
        if (icon != null ? !icon.equals(function.icon) : function.icon != null) return false;
        if (id != null ? !id.equals(function.id) : function.id != null) return false;
        if (name != null ? !name.equals(function.name) : function.name != null) return false;
        if (path != null ? !path.equals(function.path) : function.path != null) return false;
//        if (roles != null ? !roles.equals(function.roles) : function.roles != null) return false;
        if (uri != null ? !uri.equals(function.uri) : function.uri != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (code != null ? code.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (path != null ? path.hashCode() : 0);
        result = 31 * result + (uri != null ? uri.hashCode() : 0);
        result = 31 * result + (icon != null ? icon.hashCode() : 0);
//        result = 31 * result + (roles != null ? roles.hashCode() : 0);
        return result;
    }
}
