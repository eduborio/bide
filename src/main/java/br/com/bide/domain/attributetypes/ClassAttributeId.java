package br.com.bide.domain.attributetypes;


public class ClassAttributeId implements ClassAttributeType {


	@Override
	public String mappingDefinitionsFor(String fieldName) {
		StringBuilder sb = new StringBuilder();
		sb.append("  @Id\n");
		sb.append("  @GeneratedValue(strategy = GenerationType.IDENTITY)\n");
		return sb.toString();
	}

	@Override
	public String className() {
		return "Long";
	}

	@Override
	public String importDefinitions() {
		StringBuilder sb = new StringBuilder();
		sb.append("import javax.persistence.GeneratedValue;\n");
		sb.append("import javax.persistence.GenerationType;\n");
		sb.append("import javax.persistence.Id;\n");
		return sb.toString();
	}

	@Override
	public void setPackageName(String packageName) {
		// do not needed
	}

	@Override
	public void setClassName(String className) {
		// do not needed
	}

}
