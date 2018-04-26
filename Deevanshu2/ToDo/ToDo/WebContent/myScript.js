//set flag to check whether user is adding note first time or not
var flag = 0;
var arr = [];
var i = 0;
function addLi() {
	// if it is first time create button
	if (flag == 0) {
		var all = document.createElement("BUTTON");
		var buttonName = document.createTextNode("All");
		all.appendChild(buttonName);
		all.setAttribute("onclick", "showAll()");
		document.getElementById("all").appendChild(all);

		var active = document.createElement("BUTTON");
		var buttonName2 = document.createTextNode("Active");
		active.appendChild(buttonName2);
		document.getElementById("all").appendChild(active);
		active.setAttribute("onclick", "showActive()");

		var completed = document.createElement("BUTTON");
		var buttonName3 = document.createTextNode("Completed");
		completed.appendChild(buttonName3);
		document.getElementById("all").appendChild(completed);
		completed.setAttribute("onclick", "showCompleted()");
	}
	flag = flag + 1;
	var listele = document.getElementById("todo").value;
	// create a node as list element
	var node = document.createElement("LI");
	// create a text node
	var textnode = document.createTextNode(listele);
	// create button and checkbox

	var button = document.createElement("BUTTON");
	var chkbox = document.createElement("INPUT");
	chkbox.setAttribute("type", "checkbox");
	// set behavior of delete button when it is clicked
	// parent element of current node is passed as argument to delete function
	button.setAttribute("onclick", "deleteNode(this.parentElement)");
	// set behavior of checkbox when it is changed
	chkbox.setAttribute("onclick", "underline(this.parentElement)");
	var t = document.createTextNode("delete");
	button.appendChild(t);
	node.appendChild(textnode);
	// append both delete button and check box to the list element node
	node.appendChild(button);
	node.appendChild(chkbox);
	// add every element to an array for further processing
	arr[i] = node;

	document.getElementById("todoList").appendChild(arr[i]);
	i++;
	// reset value of the textfield
	document.getElementById("todo").value = "";
	document.getElementById("demo").innerHTML = document
			.getElementById("todoList").childNodes.length
			+ "Remaining";
	// dynamically remove 'remaing list' field
	if (document.getElementById("todoList").childNodes.length == 0)
		document.getElementById("demo").innerHTML = '';
}