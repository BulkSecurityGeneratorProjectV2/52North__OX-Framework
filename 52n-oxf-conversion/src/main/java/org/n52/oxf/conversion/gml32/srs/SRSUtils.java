/*
 * ﻿Copyright (C) 2012-2017 52°North Initiative for Geospatial Open Source
 * Software GmbH
 *
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU General Public License version 2 as published by the Free
 * Software Foundation.
 *
 * If the program is linked with libraries which are licensed under one of the
 * following licenses, the combination of the program with the linked library is
 * not considered a "derivative work" of the program:
 *
 *     - Apache License, version 2.0
 *     - Apache Software License, version 1.0
 *     - GNU Lesser General Public License, version 3
 *     - Mozilla Public License, versions 1.0, 1.1 and 2.0
 *     - Common Development and Distribution License (CDDL), version 1.0
 *
 * Therefore the distribution of the program linked with libraries licensed under
 * the aforementioned licenses, is permitted by the copyright holders if the
 * distribution is compliant with both the GNU General Public License version 2
 * and the aforementioned licenses.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A
 * PARTICULAR PURPOSE. See the GNU General Public License for more details.
 */
package org.n52.oxf.conversion.gml32.srs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SRSUtils {
	
	private static final Logger logger = LoggerFactory.getLogger(SRSUtils.class);
	public static final String DEFAULT_SRS = "urn:ogc:def:crs:EPSG::4326";
	private static Map<String, AxisOrder> mapping;

	static {
		mapping = new HashMap<String, AxisOrder>();
		try {
			loadMappings();
		} catch (IOException e) {
			logger.warn(e.getMessage(), e);
		}
	}
	
	public static AxisOrder resolveAxisOrder(String srsName) {
		return srsName != null ? mapping.get(srsName) : mapping.get(DEFAULT_SRS);
	}

	private static void loadMappings() throws IOException {
		InputStream is = SRSUtils.class.getResourceAsStream("axisOrder.mapping");
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		
		while (br.ready()) {
			addMapping(br.readLine());
		}
		
		br.close();
	}

	private static void addMapping(String mappingLine) {
		String[] kvp = mappingLine.split("=");
		if (kvp != null && kvp.length == 2) {
			mapping.put(kvp[0].trim(), parseAxisOrder(kvp[1].trim()));
		}
	}

	private static AxisOrder parseAxisOrder(String axisString) {
		if (axisString.equals("AxisOrder.LongLat")) {
			return AxisOrder.LongLat;
		} else {
			return AxisOrder.LatLong;
		}
	}
}
