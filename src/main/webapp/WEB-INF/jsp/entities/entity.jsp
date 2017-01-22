<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<title>New Entity</title>
</head>
<body>

	<div id="content-cadastro">
		<div id="content-header">
			<h1>Entity</h1>
		</div>
		<div id="content-container">
	
		       <c:forEach var="error" items="${errors}">
			 		<div class="alert alert-danger">
						<a class="close" data-dismiss="alert" href="#" aria-hidden="true">&times;</a>
						<strong>Error!</strong> ${error.message}
			 		</div>
				</c:forEach>
				<div class="row">
					<div class="col-md-2 col-sm-3">
					</div>
					
					<div class="col-md-8 col-sm-9">
					    <form action="<c:url value='/classes/gerar'/>" method="post">
							<div class="portlet">
								<div class="portlet-header">
									<h3>
										<i class="fa fa-table"></i>
										Entity
									</h3>
								</div>
								<div class="portlet-content">
									
										
										<div class="form-group">
											<div class="row">	
												<div class="col-md-6">
													<label for="razao">Class Name</label> 
													<input type="text" class="form-control" name="generalBuilder.className" value="${generalBuilder.className}"></input>
												</div>
											</div>
											<div class="row">
												<div class="col-md-6">
													<label for="razao">Table Name</label> 
													<input type="text" class="form-control" name="generalBuilder.tableName" value="${generalBuilder.tableName}"></input>
												</div>
											</div>
											<div class="row">
												<div class="col-md-6">
													<label for="razao">Package Name</label> 
													<input type="text" class="form-control" name="generalBuilder.packageName" value="${generalBuilder.packageName}"></input>
												</div>
											</div>
										</div>
										
								</div>	
								<div class="portlet-header">
									<h3>
										<i class="fa fa-table"></i>
										Attributes
									</h3>
								</div>
								<div class="portlet-content">
									<div class="form-group" id="attribute-group">
										<%@include file="attributes.jsp" %>
									</div>
								</div>
							</div>		
						</form>
					</div>
				</div>
			</div>
		</div>
<script id="entry-template" type="text/x-handlebars-template">
  <div class="row attr-length">	
		<div class="col-md-3">
			<label for="razao">Attribute Name</label> 
			<input type="text" class="form-control" name="generalBuilder.attributes[{{index}}].attributeName"></input>
		</div>
		<div class="col-md-3">
			<label for="razao">Table Field Name</label> 
			<input type="text" class="form-control" name="generalBuilder.attributes[{{index}}].fieldName"></input>
		</div>
		<div class="col-md-3">
			<label for="razao">Type</label> 
			<select name='generalBuilder.attributes[{{index}}].type' class='form-control' id="selectAttribute-{{index}}">    
		         <option value='-1'>Attribute Types...</option>
		          <c:forEach var="attributeType" items="${attributeTypes}">
		         	<option value='${attributeType}'>
	                	${attributeType.description}
	                </option>   
		         </c:forEach>   
		    </select>
		</div>
		<div class="col-md-3" id="other-{{index}}">
			<label for="razao">Other Name</label> 
			<input type="text" class="form-control" name="generalBuilder.attributes[{{index}}].otherName"></input>
		</div>
	</div>
</script>
<content tag="local_script">
<script src="<c:url value='/resources/canvas-theme/js/plugins/handlebars.runtime-v4.0.5.js'/>"></script>
<script src="<c:url value='/resources/canvas-theme/js/plugins/handlebars-v4.0.5.js'/>"></script>
<script type="text/javascript">


function addAttribute(){
	var attrIndex = $(".attr-length").size();
	var source   = $("#entry-template").html();
	var template = Handlebars.compile(source);
	var context = {index: attrIndex};
	var html    = template(context);
	var attributeGroup = $('#attribute-group');
	attributeGroup.append(html);
	$("#other-"+attrIndex).hide();

	$("#selectAttribute-"+attrIndex).bind('change', function(self) {
		toggleOtherName(attrIndex);
	});
}

function toggleOtherName(index){
	var type = $('#selectAttribute-'+index).val();
	
	if (type === "OTHER"){
    	$("#other-"+index).show();
	}else{
		$("#other-"+index).hide();
	}
    	
}
</script>
</content>
</body>
</html>