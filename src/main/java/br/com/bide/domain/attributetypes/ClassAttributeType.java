package br.com.bide.domain.attributetypes;

public interface ClassAttributeType {
	public String mappingDefinitionsFor(String fieldName);
	public String importDefinitions();
	public String className();
    public void setPackageName(String packageName);	
    public void setClassName(String className);
}
