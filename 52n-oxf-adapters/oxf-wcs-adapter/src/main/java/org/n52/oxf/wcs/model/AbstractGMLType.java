/**
 * ﻿Copyright (C) 2012
 * by 52 North Initiative for Geospatial Open Source Software GmbH
 *
 * Contact: Andreas Wytzisk
 * 52 North Initiative for Geospatial Open Source Software GmbH
 * Martin-Luther-King-Weg 24
 * 48155 Muenster, Germany
 * info@52north.org
 *
 * This program is free software; you can redistribute and/or modify it under
 * the terms of the GNU General Public License version 2 as published by the
 * Free Software Foundation.
 *
 * This program is distributed WITHOUT ANY WARRANTY; even without the implied
 * WARRANTY OF MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with
 * this program (see gnu-gpl v2.txt). If not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA 02111-1307, USA or
 * visit the Free Software Foundation web page, http://www.fsf.org.
 */
//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.0-b11-EA 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2005.06.25 at 02:38:11 CEST 
//


package org.n52.oxf.wcs.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(value = XmlAccessType.FIELD)
@XmlType(name = "AbstractGMLType", namespace = "http://www.opengis.net/gml")
public abstract class AbstractGMLType {

    @XmlElementRef(name = "metaDataProperty", namespace = "http://www.opengis.net/gml", type = JAXBElement.class)
    protected List<JAXBElement> metaDataProperty;
    @XmlElementRef(name = "description", namespace = "http://www.opengis.net/gml", type = JAXBElement.class)
    protected JAXBElement description;
    @XmlElementRef(name = "name", namespace = "http://www.opengis.net/gml", type = JAXBElement.class)
    protected List<JAXBElement> name;

    protected List<JAXBElement> _getMetaDataProperty() {
        if (metaDataProperty == null) {
            metaDataProperty = new ArrayList<JAXBElement>();
        }
        return metaDataProperty;
    }

    /**
     * Gets the value of the metaDataProperty property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the metaDataProperty property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMetaDataProperty().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link javax.xml.bind.JAXBElement<org.n52.oxf.wcsModel.version100.wcsCapabilities.MetadataLinkType>}
     * {@link javax.xml.bind.JAXBElement<org.n52.oxf.adapter.wcs.model.version100.gml.MetaDataPropertyType>}
     * 
     */
    public List<JAXBElement> getMetaDataProperty() {
        return this._getMetaDataProperty();
    }

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link javax.xml.bind.JAXBElement<java.lang.String>}
     *     {@link javax.xml.bind.JAXBElement<org.n52.oxf.adapter.wcs.model.version100.gml.StringOrRefType>}
     */
    public JAXBElement getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link javax.xml.bind.JAXBElement<java.lang.String>}
     *     {@link javax.xml.bind.JAXBElement<org.n52.oxf.adapter.wcs.model.version100.gml.StringOrRefType>}
     */
    public void setDescription(JAXBElement value) {
        this.description = value;
    }

    protected List<JAXBElement> _getName() {
        if (name == null) {
            name = new ArrayList<JAXBElement>();
        }
        return name;
    }

    /**
     * Multiple names may be provided.  These will often be distinguished by being assigned by different authorities, as indicated by the value of the codeSpace attribute.  In an instance document there will usually only be one name per authority.Gets the value of the name property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the name property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getName().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link javax.xml.bind.JAXBElement<java.lang.String>}
     * {@link javax.xml.bind.JAXBElement<org.n52.oxf.adapter.wcs.model.version100.gml.CodeType>}
     * 
     */
    public List<JAXBElement> getName() {
        return this._getName();
    }

}
