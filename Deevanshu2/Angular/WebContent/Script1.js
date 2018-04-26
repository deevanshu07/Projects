var x, para, node, elem, radioInput;
var checked = 0;
var elements = [];
var i=0;
function confirmInput() {

	
	if (checked == 0) {

		var allButton = document.createElement("button");
		var buttonText = document.createTextNode("All");
		allButton.setAttribute("class", "button");
		allButton.appendChild(buttonText);
		allButton.setAttribute("onclick","show1()");

		document.getElementById("myDIV1").appendChild(allButton);

		var activeButton = document.createElement("button");
		var buttonText1 = document.createTextNode("Active");
		activeButton.setAttribute("class", "button");
		activeButton.appendChild(buttonText1);
		activeButton.setAttribute("onclick","show2()");

		document.getElementById("myDIV1").appendChild(activeButton);

		var completedButton = document.createElement("button");
		var buttonText2 = document.createTextNode("Completed");
		completedButton.setAttribute("class", "button");
		completedButton.appendChild(buttonText2);
		completedButton.setAttribute("onclick","show3()");

		document.getElementById("myDIV1").appendChild(completedButton);

	}
	checked = checked + 1;
	x = document.getElementById("demo1").value;
	para = document.createElement("P");
	para.style.fontSize="25px";
	para.style.border = "solid 1px";
	para.style.width = "300px";
	para.style.height = "60px";
	para.style.textAlign = "center";

	node = document.createTextNode(x);

	/*para.setAttributeNodeNS(node3);
	para.setAttribute("onclick", "myFunction(this.childNodes)");*/
	
	/*para.setAttribute("onclick", "func2()");*/

	para.appendChild(node);
	elements[i]=para;
	
	document.getElementById("myDIV").appendChild(para);
	i++;

	/*var btn = document.createElement("button");
	btn.setAttribute("onclick", "deleRow(this.parentElement)");
	var node1 = document.createTextNode("delete");
	btn.appendChild(node1);
	para.appendChild(btn);
	document.getElementById("myDIV").appendChild(btn);*/

	elem = document.createElement("img");
	elem.setAttribute("onclick", "deleRow(this.parentElement)");
	elem.setAttribute("src", "trash.png");
	elem.setAttribute("height", "30");
	elem.setAttribute("width", "30");
	para.appendChild(elem);

	checkInput = document.createElement('input');
	checkInput.setAttribute('type', 'checkbox');

	checkInput.setAttribute("onclick", "lineOver(this.parentElement)");

	para.appendChild(checkInput);
	/*para.setAttribute("onclick", "func1()");*/

	document.getElementById("demo1").value = "";
	
	
	document.getElementById("myDIV2").innerHTML=
		document.getElementById("myDIV").childNodes.length+"Left";
	
	if (document.getElementById("myDIV").childNodes.length == 0)
		document.getElementById("myDIV1").innerHTML ="";
	
	/*if(document.getElementById("myDIV2").childNodes.length==0)
	{
		document.getElementById("myDIV2").innerHTML="";		
	}*/

}

function deleRow(obj) 
{

	/*var current = window.event.srcElement;
	current.parentElement.removeChild(current);
*/
	obj.remove();
	document.getElementById("myDIV2").innerHTML=
	document.getElementById("myDIV").childNodes.length+"Left";
	checked--;
	if (checked == 0) 
	{
		var all = document.getElementById("myDIV");
		all.remove();
		location.reload();
	}
	
	for ( var j = 0; j < elements.length; j++) 
	{
		if (obj == elements[j])
			elements.splice(j, 1);

	}
	
	
}

function lineOver(obj) 
{

	if (obj.childNodes[2].checked == true)
		obj.style.textDecoration = "line-through";
	else
		obj.style.textDecoration = "none";
}

function show1() 
{
	document.getElementById("myDIV").innerHTML="";
	for(var z=0;z<elements.length;z++)
	{
		document.getElementById("myDIV").appendChild(elements[z]);
	}

}

function show2() 
{
	document.getElementById("myDIV").innerHTML="";
	
	for(var y=0;y<elements.length;y++)
	{
		if(elements[y].childNodes[2].checked==false)
		{
			document.getElementById("myDIV").appendChild(elements[y]);
		}
	}

}

function show3() 
{
document.getElementById("myDIV").innerHTML="";
	
	for(var x=0;x<elements.length;x++)
	{
		if(elements[x].childNodes[2].checked==true)
		{
			document.getElementById("myDIV").appendChild(elements[x]);
		}
	}

}


