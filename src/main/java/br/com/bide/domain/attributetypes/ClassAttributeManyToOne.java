package br.com.bide.domain.attributetypes;


public class ClassAttributeManyToOne implements ClassAttributeType {

	private String packageName;
	private String className;

	@Override
	public String mappingDefinitionsFor(String fieldName) {
		StringBuilder sb = new StringBuilder();
		sb.append("  @ManyToOne\n");
		sb.append("  @JoinColumn(name=\""+fieldName+"\")\n");
		return sb.toString();
	}

	@Override
	public String importDefinitions() {
		StringBuilder sb = new StringBuilder();
		sb.append("import javax.persistence.ManyToOne;\n");
		sb.append("import javax.persistence.JoinColumn;\n");
		sb.append("import "+this.packageName+";\n");
		return sb.toString();
	}

	@Override
	public String className() {
		return this.className;
	}

	@Override
	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}
	
	@Override
	public void setClassName(String className) {
		this.className = className;
	}

}
