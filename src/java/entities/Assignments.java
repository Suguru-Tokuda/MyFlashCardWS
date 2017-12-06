/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author it354f715
 */
@Entity
@Table(name = "ASSIGNMENTS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Assignments.findAll", query = "SELECT a FROM Assignments a"),
    @NamedQuery(name = "Assignments.findById", query = "SELECT a FROM Assignments a WHERE a.id = :id"),
    @NamedQuery(name = "Assignments.findByDeckid", query = "SELECT a FROM Assignments a WHERE a.deckid = :deckid"),
    @NamedQuery(name = "Assignments.findByClassid", query = "SELECT a FROM Assignments a WHERE a.classid = :classid")})
public class Assignments implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DECKID")
    private int deckid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CLASSID")
    private int classid;

    public Assignments() {
    }

    public Assignments(Integer id) {
        this.id = id;
    }

    public Assignments(Integer id, int deckid, int classid) {
        this.id = id;
        this.deckid = deckid;
        this.classid = classid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getDeckid() {
        return deckid;
    }

    public void setDeckid(int deckid) {
        this.deckid = deckid;
    }

    public int getClassid() {
        return classid;
    }

    public void setClassid(int classid) {
        this.classid = classid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Assignments)) {
            return false;
        }
        Assignments other = (Assignments) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Assignments[ id=" + id + " ]";
    }
    
}
