//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.04.01 at 11:21:42 PM BRT 
//


package com.cartorio.valkyria.wsdl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for pais complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="pais"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="cdpais" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/&gt;
 *         &lt;element name="denacionalidadefeminina" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="denacionalidademasc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="depais" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "pais", propOrder = {
    "cdpais",
    "denacionalidadefeminina",
    "denacionalidademasc",
    "depais"
})
public class Pais {

    protected Short cdpais;
    protected String denacionalidadefeminina;
    protected String denacionalidademasc;
    protected String depais;

    /**
     * Gets the value of the cdpais property.
     * 
     * @return
     *     possible object is
     *     {@link Short }
     *     
     */
    public Short getCdpais() {
        return cdpais;
    }

    /**
     * Sets the value of the cdpais property.
     * 
     * @param value
     *     allowed object is
     *     {@link Short }
     *     
     */
    public void setCdpais(Short value) {
        this.cdpais = value;
    }

    /**
     * Gets the value of the denacionalidadefeminina property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDenacionalidadefeminina() {
        return denacionalidadefeminina;
    }

    /**
     * Sets the value of the denacionalidadefeminina property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDenacionalidadefeminina(String value) {
        this.denacionalidadefeminina = value;
    }

    /**
     * Gets the value of the denacionalidademasc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDenacionalidademasc() {
        return denacionalidademasc;
    }

    /**
     * Sets the value of the denacionalidademasc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDenacionalidademasc(String value) {
        this.denacionalidademasc = value;
    }

    /**
     * Gets the value of the depais property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDepais() {
        return depais;
    }

    /**
     * Sets the value of the depais property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDepais(String value) {
        this.depais = value;
    }

}
