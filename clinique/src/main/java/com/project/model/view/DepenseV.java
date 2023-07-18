package com.project.model.view;


import com.project.database.annotation.Column;
import com.project.database.annotation.Table;
import com.project.database.object.Entity;
import java.util.Date;

/**
 *
 * @author mamit
 */
@Table("v_depense")
public class DepenseV extends Entity{
    @Column(pk=true,autoComplete = true)
    Integer id;
    
    @Column
    Integer idType;
    
    @Column
    String libelle;
    
    @Column
    Integer prix;

    @Column
    Date dateDepense;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdType() {
        return idType;
    }

    public void setIdType(Integer idType) {
        this.idType = idType;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Integer getPrix() {
        return prix;
    }

    public void setPrix(Integer prix) {
        this.prix = prix;
    }

    public Date getDateDepense() {
        return dateDepense;
    }

    public void setDateDepense(Date dateDepense) {
        this.dateDepense = dateDepense;
    }

    public DepenseV() {
    }

    public DepenseV(Integer id) {
        this.id = id;
    }

}
    
