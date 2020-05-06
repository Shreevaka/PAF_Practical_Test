$(document).ready(function()
{
	//if ($("#alertSuccess").text().trim() == "") {
		$("#alertSuccess").hide();
	//}
	    $("#alertError").hide();
});

// SAVE ============================================
$(document).on("click", "#btnSave", function(event)
{
	
	// Clear alerts---------------------
	$("#alertSuccess").text("");
	$("#alertSuccess").hide();
	$("#alertError").text("");
	$("#alertError").hide();
	
	// Form validation-------------------
	var status = validateHospitalForm();
	if (status != true)
	{
		$("#alertError").text(status);
		$("#alertError").show();
		return;
	}
	
	// If valid------------------------
	var type = ($("#hidhosIDSave").val() == "") ? "POST" : "PUT";
	
	$.ajax(
	{
		url : "HospitalsAPI",
		type : type,
		data : $("#formHospital").serialize(),
		dataType : "text",
		complete : function(response, status)
		{
			onItemSaveComplete(response.responseText, status);
		}
	});
	
});

function onItemSaveComplete(response, status)
{
	if (status == "success")
	{
		var resultSet = JSON.parse(response);
		
		if (resultSet.status.trim() == "success")
		{
			$("#alertSuccess").text("Successfully saved.");
			$("#alertSuccess").show();
			
			$("#divItemsGrid").html(resultSet.data);
		}
		else if (resultSet.status.trim() == "error")
		{
			$("#alertError").text(resultSet.data);
			$("#alertError").show();
		}
	}
	else if (status == "error")
	{
		$("#alertError").text("Error while saving.");
		$("#alertError").show();
	}
	else
	{
		$("#alertError").text("Unknown error while saving..");
		$("#alertError").show();
	}
	$("#hidhosIDSave").val("");
	$("#formHospital")[0].reset();
		
}


// UPDATE==========================================
$(document).on("click",".btnUpdate",function(event)
{
	$("#hidhosIDSave").val($(this).closest("tr").find('#hidhosIDUpdate').val());
	$("#hosName").val($(this).closest("tr").find('td:eq(0)').text());
	$("#hosAddress").val($(this).closest("tr").find('td:eq(1)').text());
	$("#hosPhoneNo").val($(this).closest("tr").find('td:eq(2)').text());
	$("#hosEmail").val($(this).closest("tr").find('td:eq(3)').text());
	$("#hosNoOfRooms").val($(this).closest("tr").find('td:eq(4)').text());
});

//REMOVE==========================================
$(document).on("click","#btnRemove",function(event)
{
	$.ajax(
	{
		url : "HospitalsAPI",
		type : "DELETE",
		data : "hosID=" + $(this).data("hospitalid"),
		dataType : "text",
		complete : function(response, status)
		{
			onItemDeleteComplete(response.responseText, status);
		}
	});
});

function onItemDeleteComplete(response, status)
{
	if (status == "success")
	{
		var resultSet = JSON.parse(response);
		
		if (resultSet.status.trim() == "success")
		{
			$("#alertSuccess").text("Successfully deleted.");
			$("#alertSuccess").show();
			
			$("#divItemsGrid").html(resultSet.data);
		} else if (resultSet.status.trim() == "error")
		{
			$("#alertError").text(resultSet.data);
			$("#alertError").show();
		}
	}
	else if (status == "error")
	{
		$("#alertError").text("Error while deleting.");
		$("#alertError").show();
	}
	else
	{
		$("#alertError").text("Unknown error while deleting..");
		$("#alertError").show();
	}
}

// CLIENTMODEL=========================================================================
function validateHospitalForm() {
	// CODE
	if ($("#hosName").val().trim() == "") {
		return "Insert Hospital Name.";
	}
	// NAME
	if ($("#hosAddress").val().trim() == "") {
		return "Insert Hospital Address.";
	}
	// DESCRIPTION------------------------
	if ($("#hosPhoneNo").val().trim() == "") {
		return "Insert Hospital Phone No.";
	}
	// DESCRIPTION------------------------
	if ($("#hosEmail").val().trim() == "") {
		return "Insert Hospital Email.";
	}
	// DESCRIPTION------------------------
	if ($("#hosNoOfRooms").val().trim() == "") {
		return "Insert No Of Rooms.";
	}
	return true;
}