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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author it354f715
 */
@Entity
@Table(name = "DECKS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Decks.findAll", query = "SELECT d FROM Decks d"),
    @NamedQuery(name = "Decks.findById", query = "SELECT d FROM Decks d WHERE d.id = :id"),
    @NamedQuery(name = "Decks.findByDeckname", query = "SELECT d FROM Decks d WHERE d.deckname = :deckname"),
    @NamedQuery(name = "Decks.findByUserid", query = "SELECT d FROM Decks d WHERE d.userid = :userid"),
    @NamedQuery(name = "Decks.findByClassid", query = "SELECT d FROM Decks d WHERE d.classid = :classid")})
public class Decks implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "DECKNAME")
    private String deckname;
    @Basic(optional = false)
    @NotNull
    @Column(name = "USERID")
    private int userid;
    @Column(name = "CLASSID")
    private Integer classid;

    public Decks() {
    }

    public Decks(Integer id) {
        this.id = id;
    }

    public Decks(Integer id, String deckname, int userid) {
        this.id = id;
        this.deckname = deckname;
        this.userid = userid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDeckname() {
        return deckname;
    }

    public void setDeckname(String deckname) {
        this.deckname = deckname;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public Integer getClassid() {
        return classid;
    }

    public void setClassid(Integer classid) {
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
        if (!(object instanceof Decks)) {
            return false;
        }
        Decks other = (Decks) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Decks[ id=" + id + " ]";
    }
    
}
