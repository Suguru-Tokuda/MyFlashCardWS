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
@Table(name = "CARDS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cards.findAll", query = "SELECT c FROM Cards c"),
    @NamedQuery(name = "Cards.findById", query = "SELECT c FROM Cards c WHERE c.id = :id"),
    @NamedQuery(name = "Cards.findByQuestion", query = "SELECT c FROM Cards c WHERE c.question = :question"),
    @NamedQuery(name = "Cards.findByAnswer", query = "SELECT c FROM Cards c WHERE c.answer = :answer"),
    @NamedQuery(name = "Cards.findByDeckid", query = "SELECT c FROM Cards c WHERE c.deckid = :deckid"),
    @NamedQuery(name = "Cards.findByPriority", query = "SELECT c FROM Cards c WHERE c.priority = :priority")})
public class Cards implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "QUESTION")
    private String question;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "ANSWER")
    private String answer;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DECKID")
    private int deckid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRIORITY")
    private int priority;

    public Cards() {
    }

    public Cards(Integer id) {
        this.id = id;
    }

    public Cards(Integer id, String question, String answer, int deckid, int priorty) {
        this.id = id;
        this.question = question;
        this.answer = answer;
        this.deckid = deckid;
        this.priority = priorty;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public int getDeckid() {
        return deckid;
    }

    public void setDeckid(int deckid) {
        this.deckid = deckid;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
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
        if (!(object instanceof Cards)) {
            return false;
        }
        Cards other = (Cards) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Cards[ id=" + id + " ]";
    }
    
}
