package br.com.bide.domain.attributetypes;

public class ClassAttributeString implements ClassAttributeType {

	@Override
	public String mappingDefinitionsFor(String fieldName) {
		StringBuilder sb = new StringBuilder();
		sb.append("  @Column(name=\""+fieldName+"\")\n");
		return sb.toString();
	}

	@Override
	public String importDefinitions() {
		StringBuilder sb = new StringBuilder();
		sb.append("import javax.persistence.Column;\n");
		return sb.toString();
	}

	@Override
	public String className() {
		return "String";
	}

	@Override
	public void setPackageName(String packageName) {
		// do not need
	}
	
	@Override
	public void setClassName(String className) {
		// do not needed
	}

}
