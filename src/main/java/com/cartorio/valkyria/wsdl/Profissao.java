//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.03.29 at 09:05:39 PM BRT 
//


package com.cartorio.valkyria.wsdl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for profissao complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="profissao"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="cdprofissao" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/&gt;
 *         &lt;element name="deprofissao" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "profissao", propOrder = {
    "cdprofissao",
    "deprofissao"
})
public class Profissao {

    protected Short cdprofissao;
    protected String deprofissao;

    /**
     * Gets the value of the cdprofissao property.
     * 
     * @return
     *     possible object is
     *     {@link Short }
     *     
     */
    public Short getCdprofissao() {
        return cdprofissao;
    }

    /**
     * Sets the value of the cdprofissao property.
     * 
     * @param value
     *     allowed object is
     *     {@link Short }
     *     
     */
    public void setCdprofissao(Short value) {
        this.cdprofissao = value;
    }

    /**
     * Gets the value of the deprofissao property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeprofissao() {
        return deprofissao;
    }

    /**
     * Sets the value of the deprofissao property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeprofissao(String value) {
        this.deprofissao = value;
    }

}