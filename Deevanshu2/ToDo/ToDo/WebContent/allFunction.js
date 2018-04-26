//function to delete node
function deleteNode(obj) 
{
	// remove the parent node
	obj.remove();
	document.getElementById("demo").innerHTML = document
			.getElementById("todoList").childNodes.length
			+ "Remaining";
	if (document.getElementById("todoList").childNodes.length == 0)
		document.getElementById("demo").innerHTML = '';
	flag--;
	// if no node is remaining delete all three buttons
	if (flag == 0) 
	{
		var all = document.getElementById("all");
		all.remove();
		location.reload();
	}
	// delete the same node from the array also
	for ( var j = 0; j < arr.length; j++) 
	{
		if (obj == arr[j])
			arr.splice(j, 1);

	}
}
// function to show all nodes
function showAll() 
{
	document.getElementById("todoList").innerHTML = '';
	// show all nodes in list
	for ( var j = 0; j < arr.length; j++) {

		document.getElementById("todoList").appendChild(arr[j]);
	}

}
// function to show active nodes
function showActive() {
	document.getElementById("todoList").innerHTML = '';

	for ( var j = 0; j < arr.length; j++) {
		// check whether the checkbox is checked or not
		if ((arr[j].childNodes[2].checked) == false)
			document.getElementById("todoList").appendChild(arr[j]);
	}
}
// function to show completed nodes
function showCompleted() {
	document.getElementById("todoList").innerHTML = '';

	for ( var j = 0; j < arr.length; j++) {
		// show nodes whose checkbox is checked
		if ((arr[j].childNodes[2].checked) == true)
			document.getElementById("todoList").appendChild(arr[j]);
	}
}
// function to change style of text after completion
function underline(obj) {
	// create a line throgh node if it is checked else remove it
	if (obj.childNodes[2].checked == true)
		obj.style.textDecoration = "line-through";
	else
		obj.style.textDecoration = "none";
}