$(document).ready(function() {
	// Load data from local json
	$.getJSON("authors.json", function(data) {
		// DataTables initialization
		var table = $('#authors').DataTable({
			"data": data.author,
			"columns": [
				{
					"data": "name",
					"render": function(data, type, row, meta){
          	if(type === 'display'){
            	data = '<a class="link" href="author.html">' + data + '</a>';
            }
            return data;
        	}
				}
			]
		});
	});
});
