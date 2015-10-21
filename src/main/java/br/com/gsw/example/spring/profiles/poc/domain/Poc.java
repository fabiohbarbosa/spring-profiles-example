package br.com.gsw.example.spring.profiles.poc.domain;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement(name = "poc")
@XmlAccessorType(XmlAccessType.FIELD)
@Entity(name = "poc")
@SequenceGenerator(sequenceName = "POC_SEQUENCE", name = "POC_SEQUENCE", initialValue = 1, allocationSize = 1)
public class Poc implements Serializable {

    @Id
    @GeneratedValue(generator = "POC_SEQUENCE", strategy = GenerationType.SEQUENCE)
    @XmlElement
    private Long id;

    @XmlElement
    private String name;

    public Poc() {

    }

    public Poc(final String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}