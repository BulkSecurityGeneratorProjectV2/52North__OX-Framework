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


package org.n52.oxf.wcs.capabilities;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;


/**
 * Java content class for InterpolationMethodType.
 *  <p>The following schema fragment specifies the expected content contained within this java content object.
 * <p>
 * <pre>
 * &lt;simpleType name="InterpolationMethodType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="nearest neighbor"/>
 *     &lt;enumeration value="bilinear"/>
 *     &lt;enumeration value="bicubic"/>
 *     &lt;enumeration value="lost area"/>
 *     &lt;enumeration value="barycentric"/>
 *     &lt;enumeration value="none"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlEnum(value = String.class)
public enum InterpolationMethodType {

    @XmlEnumValue(value = "lost area")
    LOST_AREA("lost area"),
    @XmlEnumValue(value = "bilinear")
    BILINEAR("bilinear"),
    @XmlEnumValue(value = "barycentric")
    BARYCENTRIC("barycentric"),
    @XmlEnumValue(value = "bicubic")
    BICUBIC("bicubic"),
    @XmlEnumValue(value = "nearest neighbor")
    NEAREST_NEIGHBOR("nearest neighbor"),
    @XmlEnumValue(value = "none")
    NONE("none");
    public final String value;

    InterpolationMethodType(String v) {
        value = v;
    }

}
