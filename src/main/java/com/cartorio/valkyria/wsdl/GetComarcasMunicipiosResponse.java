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
 * <p>Java class for getComarcasMunicipiosResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getComarcasMunicipiosResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="comarcasmunicipios" type="{http://www.tjsc.jus.br/selo}comarcaMunicipio" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getComarcasMunicipiosResponse", propOrder = {
    "comarcasmunicipios"
})
public class GetComarcasMunicipiosResponse {

    protected List<ComarcaMunicipio> comarcasmunicipios;

    /**
     * Gets the value of the comarcasmunicipios property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the comarcasmunicipios property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getComarcasmunicipios().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ComarcaMunicipio }
     * 
     * 
     */
    public List<ComarcaMunicipio> getComarcasmunicipios() {
        if (comarcasmunicipios == null) {
            comarcasmunicipios = new ArrayList<ComarcaMunicipio>();
        }
        return this.comarcasmunicipios;
    }

}
