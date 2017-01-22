<c:forEach var="attribute" items="${generalBuilder.attributes}" varStatus="idx">
	<div class="row attr-length" id="attribute-${idx.index}">	
		<div class="col-md-2">
			<label for="razao">Attribute Name</label> 
			<input type="text" class="form-control" name="generalBuilder.attributes[${idx.index}].attributeName" value="${attribute.attributeName}"></input>
		</div>
		<div class="col-md-2">
			<label for="razao">Table Field Name</label> 
			<input type="text" class="form-control" name="generalBuilder.attributes[${idx.index}].fieldName" value="${attribute.fieldName}"></input>
		</div>
		<div class="col-md-2">
			<label for="razao">Attribute Type</label> 
			<select name='generalBuilder.attributes[${idx.index}].type' class='form-control' id="referencia">    
		         <option value='-1'>Attribute Types...</option>
		          <c:forEach var="attributeType" items="${attributeTypes}">
		         	<option value='${attributeType}'>
	                	${attributeType.description}
	                </option>   
		         </c:forEach>   
		    </select>
		</div>
		<div class="col-md-2">
			<label for="razao">Nome Outro</label> 
			<input type="text" class="form-control" name="generalBuilder.attributes[${idx.index}].otherName" value="${attribute.otherName}"></input>
		</div>
	</div>
</c:forEach>
<div class="row">
  <div class="col-md-12">
	<div class="nav nav-pills pull-right">
	   <a data-toggle='modal' href='#movimentoModal' onclick="addAttribute();" id='novo-movimento' type='button' class='btn btn-tertiary'>
	     New Attribute
	   </a>
	</div>
  </div>
</div>