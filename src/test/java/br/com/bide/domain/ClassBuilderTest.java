package br.com.bide.domain;

import org.junit.Assert;
import org.junit.Test;

import br.com.bide.domain.attributetypes.ClassAttributeDouble;
import br.com.bide.domain.attributetypes.ClassAttributeId;
import br.com.bide.domain.attributetypes.ClassAttributeInteger;
import br.com.bide.domain.attributetypes.ClassAttributeManyToOne;
import br.com.bide.domain.attributetypes.ClassAttributeString;
import br.com.bide.domain.attributetypes.ClassAttributeType;

public class ClassBuilderTest {
	
	@Test
	public void fromAClassBuilderWithAnAttributeListItWillGenerateAClassText(){
		EntityBuilder classBuilder = new EntityBuilder();
		classBuilder.setClassName("Produto");
		classBuilder.setClassPackage("br.com.erp.domain"); 
		classBuilder.setTableName("produtos");
		
		ClassAttribute ca = new ClassAttribute();
		ca.setAttributeName("descricao");
		ca.setFieldName("desc_prod");
		ca.setType(new ClassAttributeId());
		
		classBuilder.addAttribute(ca);
		
		StringBuilder expectedResult = new StringBuilder();
		expectedResult.append("package br.com.erp.domain;\n");
		expectedResult.append("\n");
		expectedResult.append("public class Produto{\n");
		expectedResult.append("\n");
		expectedResult.append("  @Column(name=\"desc_prod\")\n");
		expectedResult.append("  private String descricao;\n");
		expectedResult.append("\n");
		expectedResult.append("  public String getDescricao(){\n");
		expectedResult.append("    return this.descricao;\n");
		expectedResult.append("  }\n");
		expectedResult.append("\n");
		expectedResult.append("  public void setDescricao(String descricao){\n");
		expectedResult.append("    this.descricao = descricao;\n");
		expectedResult.append("  }\n");
		expectedResult.append("\n");
		expectedResult.append("}");
		
		Assert.assertEquals(expectedResult, classBuilder.buildClassText());
	}
	
	@Test
	public void ifThereAreTwoPropertiesMustThereBeTwoGettersAndSetters(){
		EntityBuilder classBuilder = new EntityBuilder();
		classBuilder.setClassName("Produto");
		classBuilder.setClassPackage("br.com.erp.domain"); 
		classBuilder.setTableName("produtos");
		
		ClassAttribute id = new ClassAttribute();
		id.setAttributeName("id");
		id.setFieldName("id_prod");
		id.setType(new ClassAttributeId());
		
		ClassAttribute codigo = new ClassAttribute();
		codigo.setAttributeName("codigo");
		codigo.setFieldName("desc_prod");
		codigo.setType(new ClassAttributeInteger());
		
		ClassAttribute desc = new ClassAttribute();
		desc.setAttributeName("descricao");
		desc.setFieldName("desc_prod");
		desc.setType(new ClassAttributeString());
		
		ClassAttribute preco = new ClassAttribute();
		preco.setAttributeName("preco");
		preco.setFieldName("preco_prod");
		preco.setType(new ClassAttributeDouble());
		
		ClassAttributeType categoriaType = new ClassAttributeManyToOne();
		categoriaType.setClassName("Categoria");
		categoriaType.setPackageName("br.com.erp.domain");
		ClassAttribute categoria = new ClassAttribute();
		categoria.setAttributeName("categoria");
		categoria.setFieldName("categoria_id");
		categoria.setType(categoriaType);
		
		classBuilder.addAttribute(id);
		classBuilder.addAttribute(codigo);
		classBuilder.addAttribute(desc);
		classBuilder.addAttribute(preco);
		classBuilder.addAttribute(categoria);
		
		StringBuilder expectedResult = new StringBuilder();
		expectedResult.append("package br.com.erp.domain;\n");
		expectedResult.append("\n");
		expectedResult.append("public class Produto{\n");
		expectedResult.append("\n");
		expectedResult.append("  @Column(name=\"desc_prod\")\n");
		expectedResult.append("  private String descricao;\n");
		expectedResult.append("\n");
		expectedResult.append("  public String getDescricao(){\n");
		expectedResult.append("    return this.descricao;\n");
		expectedResult.append("  }\n");
		expectedResult.append("\n");
		expectedResult.append("  public void setDescricao(String descricao){\n");
		expectedResult.append("    this.descricao = descricao;\n");
		expectedResult.append("  }\n");
		expectedResult.append("\n");
		expectedResult.append("}");
		
		System.out.println(classBuilder.buildClassText());
		Assert.assertEquals(expectedResult, classBuilder.buildClassText());
	}

}
