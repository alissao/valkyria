//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.04.01 at 11:21:42 PM BRT 
//


package com.cartorio.valkyria.wsdl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getCartorioServentuariosResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getCartorioServentuariosResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="cartorioServentuarios" type="{http://www.tjsc.jus.br/selo}cartorioServentuario" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getCartorioServentuariosResponse", propOrder = {
    "cartorioServentuarios"
})
public class GetCartorioServentuariosResponse {

    protected List<CartorioServentuario> cartorioServentuarios;

    /**
     * Gets the value of the cartorioServentuarios property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the cartorioServentuarios property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCartorioServentuarios().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CartorioServentuario }
     * 
     * 
     */
    public List<CartorioServentuario> getCartorioServentuarios() {
        if (cartorioServentuarios == null) {
            cartorioServentuarios = new ArrayList<CartorioServentuario>();
        }
        return this.cartorioServentuarios;
    }

}
