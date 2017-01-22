package br.com.bide.domain;

import java.util.ArrayList;
import java.util.List;

import br.com.caelum.vraptor.util.StringUtils;

public class EntityBuilder {

	private String className;
	private String packageName;
	private List<ClassAttribute> attributes = new ArrayList<ClassAttribute>();
	private String tableName;

	public void setClassName(String className) {
		this.className = className;
	}

	public String buildClassText() {
		
		StringBuilder sb = new StringBuilder();
		sb.append("package "+packageName+";\n");
		sb.append("\n");
		sb.append("import javax.persistence.Entity;\n");
		sb.append("import javax.persistence.Table;\n");
		
		sb.append(writeImports());
		
		sb.append("\n");
		sb.append("@Entity\n");
		sb.append("@Table(name=\""+this.tableName+"\")\n");
		sb.append("public class "+this.className+"{\n");
		sb.append("\n");
		
		sb.append(writeAttributes());
		sb.append(writeGettersAndSetters());
		
		sb.append("}");
		return sb.toString();
	}

	private String writeImports() {
		
		StringBuilder sb = new StringBuilder();
		for (ClassAttribute ca : this.attributes){
			sb.append(ca.getImportDefinitions());
		}
		
		return sb.toString();
	}

	private String writeGettersAndSetters() {
		StringBuilder sb = new StringBuilder();
		
		for (ClassAttribute ca : this.attributes){
			sb.append("  public "+ca.getClassName()+" get"+StringUtils.capitalize(ca.getAttributeName())+"(){\n");
			sb.append("    return this."+ca.getAttributeName()+";\n");
			sb.append("  }\n");
			sb.append("\n");
			sb.append("  public void set"+StringUtils.capitalize(ca.getAttributeName())+"("+ca.getAttributeType().className()+" "+ca.getAttributeName()+"){\n");
			sb.append("    this."+ca.getAttributeName()+" = "+ca.getAttributeName()+";\n");
			sb.append("  }\n");
			sb.append("\n");
		}
		
		return sb.toString();
	}

	private String writeAttributes() {
		StringBuilder sb = new StringBuilder();
		
		for (ClassAttribute ca : this.attributes){
			sb.append(ca.getMappingDefinitions());
			sb.append("  private "+ca.getClassName()+" "+ca.getAttributeName()+";\n");
			sb.append("\n");
		}
		
		return sb.toString();
	}

	public void addAttribute(ClassAttribute ca) {
		this.attributes.add(ca);
	}

	public void setClassPackage(String packageName) {
		this.packageName = packageName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
		
	}

}
