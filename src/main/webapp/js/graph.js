// Define nodes variables
var i;
var j;

// Variable for the sigma graphs
// Graph with all the clusters
var graphCluster;
		
// Graph with the single clusterGraph
var singleGraphCluster;
		
		
// Log the path of the site
console.log(window.location.pathname);

// Build the first graph
$.getJSON("/winniest-team-project-1.00/html/community_graph.json", function ( data ) {

  graphCluster = new sigma({
	graph: data,
		renderer: {
		container: document.getElementById('graph'),
		type: 'canvas'
	},
	settings: {
		minNodeSize: 1,
		maxNodeSize: 40,
		enableCamera: false, // disable moving around the graph
		zommingRatio: 1, // disable zoom
	}
  });

  graphCluster.bind("clickNode", function (e) {
	
	// Get node iformations
	var curNode = e.data.node;
	
	// Node ids range from 0 to 7
	var nodeID = curNode.id*1 + 1.0;
	
	// Remove graph and add the new one
	$('#graph').remove(); 
	
	// very bad stuff to be done in a better way!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	$('#graph-container').html('<div id="graph"><style>#graph {position: relative;}</style><canvas width="0" height="600"></canvas></div>'); 

	// Display new cluster
	console.log("community_"+ nodeID +".json");
	$.getJSON("/winniest-team-project-1.00/html/community_"+ nodeID +".json", function ( data ) {

		singleGraphCluster = new sigma({
		graph: data,
			renderer: {
			container: document.getElementById('graph'),
			type: 'canvas'
		},
		settings: {
			minNodeSize: 1,
			maxNodeSize: 20,
			enableCamera: false, // disable moving around the graph
			zommingRatio: 1, // disable zoom
			drawLabels: false, // do not show labels (only on hover)
		}
		});
		
		singleGraphCluster.bind("clickNode", function(e){
			
			// Get informations about the node
			var node = e.data.node; 
			var id = node.id;
			
			// Log result
			console.log("Node ID:" + node.id);
			
			if (window.location.pathname == "/winniest-team-project-1.00/"){
				window.location = "html/author.html";
			}
			else {
				window.location = "author.html";
			}
		});
  });
  });
});

// Load the json with the graph that we want to display
/*$.getJSON("/winniest-team-project-1.00/html/comm4.json", function ( data ) {

  s = new sigma({
    graph: data,
    renderer: {
      container: document.getElementById('graph-container'),
      type: 'canvas'
    },
    settings: {
     minNodeSize: 1,
     maxNodeSize: 40,
    }
  });

  s.bind("clickNode", function () {
  	if (window.location.pathname == "/winniest-team-project-1.00/"){
  		window.location = "html/author.html";
  	}
  	else {
    	window.location = "author.html";
    }
  });
});*/
