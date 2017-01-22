package br.com.bide.domain;

import br.com.bide.domain.attributetypes.ClassAttributeType;

public class ClassAttribute {

	private ClassAttributeType attributeType;
	private String fieldName;
	private String attributeName;

	public ClassAttributeType getAttributeType() {
		return this.attributeType;
	}
	
	public void setType(ClassAttributeType attributeType) {
		this.attributeType = attributeType;
	}

	public String getAttributeName() {
		return this.attributeName;
	}
	
	public void setAttributeName(String attributeName) {
		this.attributeName = attributeName;
	}

	public String getFieldName() {
		return this.fieldName;
	}
	
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getMappingDefinitions() {
		typeMustBeInstantiated();
		return this.attributeType.mappingDefinitionsFor(this.fieldName);
	}

	public String getClassName() {
		typeMustBeInstantiated();
		return this.attributeType.className();
	}
	
	public String getImportDefinitions() {
		typeMustBeInstantiated();
		return this.attributeType.importDefinitions();
	}
	
	private void typeMustBeInstantiated() {
		if (this.attributeType == null)
			throw new NullPointerException("AttributeType not found.");
	}

}
