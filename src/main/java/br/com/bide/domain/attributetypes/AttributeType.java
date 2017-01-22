package br.com.bide.domain.attributetypes;

import br.com.bide.domain.types.Type;

public enum AttributeType implements Type {

	  STRING(1, "String"),
	  INTEGER(2, "Integer"),
	  ID(3, "Id"),
	  DOUBLE(4, "Double"),
	  DATE(5, "Date"),
	  OTHER(6, "Other");
	  
	  private Integer value;   
	  private String description;
	  
	  AttributeType(Integer value, String description)
	  {   
	     this.value = value;
	     this.description = description;
	  }   
	  
	  public static AttributeType getType(Integer value)
	  {
	    for(AttributeType type: AttributeType.values())
	    {
	      if (value.equals(type.getValue()))
	      {
	        return type;
	      }
	    }
	    return null;
	  }

	  public AttributeType[] getValues()
	  {
	    return AttributeType.values();
	  }

	public String getDescription() {
		return this.description;
	}

	public Integer getValue() {
		return this.value;
	}
	
	public void setValue(Integer value){
		this.value = value;
	}

}
