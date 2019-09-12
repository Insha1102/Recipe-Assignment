$(document).ready(function() {
    $('#example').DataTable( {
        responsive: true,
    	pageLength:1000,
        ajax: {
        	url:'/api/recipies/retrieveall',
        	dataSrc: ''
        },
        columns: [
        
            {
            	
             	data:'id'
            },
            {
            	
             	data:'name'
            },
            {
            	
             	data:'indicator'
            },
            {
            	
             	data:'servings'
            },
            {
            
             	data:'ingredients'
            },
            {
            	
             	data:'instructions'
            },
        	{
            	data:'image',
                mRender: function(data, type, row){
                	return '<img src="images/' + data + '" height="100px" width="120px"/>';
                	
                }
            },
            {
            	data:'id',
            	render: function(data, type, full, meta){
                	return '<a href="add.html?id='+data+'" class="btn btn-info btn-sm"><i class="fa fa-edit"></i>EDIT</a>'
                }
            },
            {
            	data:'id',
            	render: function(data, type, full, meta){
                	return '<a onclick="deleteRecipe('+data+')" class="btn btn-info btn-sm" style="color:white"><i class="fa fa-trash" style="color:white"></i>DELETE</a>';
                }
            }
        ]
    } );
} );

function deleteRecipe(id){
	$.ajax({url: "/delete/"+id,
		type : 'DELETE',
		success: function(result){
			location.reload();
	  }});
}
