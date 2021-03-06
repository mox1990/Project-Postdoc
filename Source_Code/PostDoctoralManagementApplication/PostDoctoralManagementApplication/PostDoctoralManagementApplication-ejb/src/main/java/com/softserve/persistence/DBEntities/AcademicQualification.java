/*
 * This file is copyrighted to the authors stated below.
 * Any duplication or modifications or usage of the file's contents               
 * that is not approved by the stated authors is prohibited.
 */

package com.softserve.persistence.DBEntities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author SoftServe Group [ Mathys Ellis (12019837) Kgothatso Phatedi Alfred
 * Ngako (12236731) Tokologo Machaba (12078027) ]
 */
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@id")
@Entity
@Table(name = "academic_qualification")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AcademicQualification.findAll", query = "SELECT a FROM AcademicQualification a"),
    @NamedQuery(name = "AcademicQualification.findByQualificationID", query = "SELECT a FROM AcademicQualification a WHERE a.qualificationID = :qualificationID"),
    @NamedQuery(name = "AcademicQualification.findByName", query = "SELECT a FROM AcademicQualification a WHERE a.name = :name"),
    @NamedQuery(name = "AcademicQualification.findByFieldOfStudy", query = "SELECT a FROM AcademicQualification a WHERE a.fieldOfStudy = :fieldOfStudy"),
    @NamedQuery(name = "AcademicQualification.findByInstitution", query = "SELECT a FROM AcademicQualification a WHERE a.institution = :institution"),
    @NamedQuery(name = "AcademicQualification.findByYearObtained", query = "SELECT a FROM AcademicQualification a WHERE a.yearObtained = :yearObtained"),
    @NamedQuery(name = "AcademicQualification.findByDistinctions", query = "SELECT a FROM AcademicQualification a WHERE a.distinctions = :distinctions")})
public class AcademicQualification implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "_qualificationID")
    private Long qualificationID;
    @Size(max = 100)
    @Column(name = "_name")
    private String name;
    @Size(max = 100)
    @Column(name = "_fieldOfStudy")
    private String fieldOfStudy;
    @Size(max = 100)
    @Column(name = "_institution")
    private String institution;
    @Column(name = "_yearObtained")
    @Temporal(TemporalType.DATE)
    private Date yearObtained;
    @Column(name = "_distinctions")
    private Short distinctions;
    @JoinColumn(name = "_cv", referencedColumnName = "_cvID")
    @ManyToOne(optional = false)
    private Cv cv;

    public AcademicQualification() {
    }

    public AcademicQualification(Long qualificationID) {
        this.qualificationID = qualificationID;
    }

    public Long getQualificationID() {
        return qualificationID;
    }

    public void setQualificationID(Long qualificationID) {
        this.qualificationID = qualificationID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFieldOfStudy() {
        return fieldOfStudy;
    }

    public void setFieldOfStudy(String fieldOfStudy) {
        this.fieldOfStudy = fieldOfStudy;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public Date getYearObtained() {
        return yearObtained;
    }

    public void setYearObtained(Date yearObtained) {
        this.yearObtained = yearObtained;
    }

    public Short getDistinctions() {
        return distinctions;
    }

    public void setDistinctions(Short distinctions) {
        this.distinctions = distinctions;
    }

    public Cv getCv() {
        return cv;
    }

    public void setCv(Cv cv) {
        this.cv = cv;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (qualificationID != null ? qualificationID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AcademicQualification)) {
            return false;
        }
        AcademicQualification other = (AcademicQualification) object;
        if ((this.qualificationID == null && other.qualificationID != null) || (this.qualificationID != null && !this.qualificationID.equals(other.qualificationID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.softserve.DBEntities.AcademicQualification[ qualificationID=" + qualificationID + " ]";
    }
    
}
