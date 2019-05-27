$(document).ready(function() {
	// Load data from local json
	$.getJSON("papers.json", function(data) {
	// Table column filters
    $('#papers thead tr').clone(true).appendTo( '#papers thead' );
    $('#papers thead tr:eq(1) th').each( function (i) {
        var title = $(this).text();
        $(this).html( '<input type="text" placeholder="Search '+title+'" />' );
        $( 'input', this ).on( 'keyup change', function () {
            if ( table.column(i).search() !== this.value ) {
                table
                    .column(i)
                    .search( this.value )
                    .draw();
            }
        } );
    } );
		// DataTables initialization
		var table = $('#papers').DataTable({
			"data": data.papers,
			"columns": [
      	{
					"data": "title",
					"render": function(data, type, row, meta){
						data = '<a class="link" href="' + row.ee + '">' + data + '</a>';
            return data;
         	}
				},
				{
					"data": "authors",
					"render": function(data, type, row, meta){
						if(type === 'display'){
							data = '<a class="link" href="author.html">' + data + '</a>';
						}
						return data;
					}
				},
      	{ "data": "year" },
      	{ "data": "mdate" }
      ],
			"orderCellsTop": true,
      "fixedHeader": true
		});
	});
});
