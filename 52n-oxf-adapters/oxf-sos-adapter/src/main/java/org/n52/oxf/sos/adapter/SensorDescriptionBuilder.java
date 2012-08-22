package org.n52.oxf.sos.adapter;

import java.util.HashMap;
import java.util.Map;

import net.opengis.sensorML.x101.IoComponentPropertyType;
import net.opengis.sensorML.x101.OutputsDocument.Outputs;
import net.opengis.sensorML.x101.OutputsDocument.Outputs.OutputList;
import net.opengis.sensorML.x101.PositionDocument.Position;
import net.opengis.sensorML.x101.SystemDocument;
import net.opengis.sensorML.x101.SystemType;
import net.opengis.swe.x101.CategoryDocument.Category;
import net.opengis.swe.x101.PositionType;
import net.opengis.swe.x101.QuantityDocument.Quantity;
import net.opengis.swe.x101.VectorPropertyType;
import net.opengis.swe.x101.VectorType;
import net.opengis.swe.x101.VectorType.Coordinate;

public class SensorDescriptionBuilder {
	
	private SystemDocument systemDocument = SystemDocument.Factory.newInstance();
	private SystemType system = SystemType.Factory.newInstance();
	
	private Map<String, String> parameters = new HashMap<String, String>();
	
	public SystemDocument createRegisterSensorDocument() {
    	system.setOutputs(createOutputsFromParameters());
    	systemDocument.addNewSystem().set(system);
		return systemDocument;
	}
	
	public void setSensorId(String sensorId) {
		system.setId(sensorId);
	}
	
	public void setPosition(String name, boolean positionFixed, double latitude, double longitude) {
		Position pos = Position.Factory.newInstance();
    	pos.setName(name);
    	PositionType posType = pos.addNewPosition();
    	posType.setFixed(new Boolean(positionFixed));
    	posType.setReferenceFrame("urn:ogc:crs:epsg:4326");
    	VectorPropertyType vecPropType =  posType.addNewLocation();
    	VectorType vecType = vecPropType.addNewVector();
    	Coordinate cordLatitude = vecType.addNewCoordinate();
    	cordLatitude.setName("latitude");
    	cordLatitude.addNewQuantity().setValue(new Double (latitude));
    	Coordinate cordLongitude = vecType.addNewCoordinate();
    	cordLongitude.setName("longitude");
    	cordLongitude.addNewQuantity().setValue(new Double (longitude));
    	system.setPosition(pos);
	}
	
	public void setSensorObservationType(String sensorObservationType) {
		parameters.put(ISOSRequestBuilder.REGISTER_SENSOR_OBSERVATION_TYPE, sensorObservationType);
	}
	
	public void setObservedProperty(String observedProperty) {
		parameters.put(ISOSRequestBuilder.REGISTER_SENSOR_OBSERVED_PROPERTY_PARAMETER, observedProperty);
	}
	
	public void setUnitOfMeasurement(String uom) {
		parameters.put(ISOSRequestBuilder.REGISTER_SENSOR_UOM_PARAMETER, uom);
	}
	
	public String getUnitOfMeasurement(String uom) {
		return parameters.get(ISOSRequestBuilder.REGISTER_SENSOR_UOM_PARAMETER);
	}
	
	private Outputs createOutputsFromParameters() {
		Outputs outputs = Outputs.Factory.newInstance();
    	OutputList outputList = outputs.addNewOutputList();
    	IoComponentPropertyType IoCompProp = outputList.addNewOutput();
    	
    	String obsType = ((String) parameters.get(ISOSRequestBuilder.REGISTER_SENSOR_OBSERVATION_TYPE));
    	
    	if (obsType.equals(ISOSRequestBuilder.REGISTER_SENSOR_OBSERVATION_TYPE_MEASUREMENT)){
    		Quantity quantity = IoCompProp.addNewQuantity();
    		quantity.setDefinition((String) parameters.get(ISOSRequestBuilder.REGISTER_SENSOR_OBSERVED_PROPERTY_PARAMETER));
    		quantity.addNewUom().setCode((String) parameters.get(ISOSRequestBuilder.REGISTER_SENSOR_UOM_PARAMETER));
    	} else if (obsType.equals(ISOSRequestBuilder.REGISTER_SENSOR_OBSERVATION_TYPE_CATEGORY)) {
    		Category category = IoCompProp.addNewCategory();
    		category.setDefinition((String) parameters.get(ISOSRequestBuilder.REGISTER_SENSOR_OBSERVED_PROPERTY_PARAMETER));
    		category.addNewCodeSpace();
    	}
    	return outputs;
	}

}