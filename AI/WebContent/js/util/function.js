/**
 * Author : SD
 * This JS file providing utility function.
 */

/**
 * This function is used to convert Array into a string.
 * 
 * @param content
 *            is the array containing String
 * @returns {String}
 */
function stringArrayToStr(content) {
	var str = '';
	if (content != undefined && content.length != undefined) {
		for (var i = 0; i < content.length; i++) {
			str = str + content[i];
		}
		return str;
	}
	return str;
}

/**
 * This function convert an array into object
 * 
 * @param facetArray
 * @returns {Array}
 */
function facetArrayToObj(facetArray) {
	var facetList = [];
	for (var i = 0; i < facetArray.length; i = i + 2) {
		var facet = {};
		facet.name = facetArray[i];
		facet.val = facetArray[i + 1];
		facetList.push(facet);
	}
	return facetList;
}

/**
 * This function is used to push item into array. If that item is already in
 * array then it will remove from the array.
 * 
 * @param array
 * @param item
 * @returns
 */
function arrayUtil(array, item) {
	if (array.length == 0) {
		array.push(item);
		return array;
	}
	for (var i = 0; i < array.length; i++) {
		if (array[i] == item) {
			array.splice(i, 1);
			return array;
		}
	}
	array.push(item);
	return array;
}

function createFilterQuery(type, facetList) {
	var str = type + ":(";
	if (facetList == undefined || facetList.length == 0)
		return '';
	if (facetList.length == 1) {
		str = str + '"' + facetList[0] + '")';
		return str;
	}
	for (var i = 0; i < facetList.length; i++) {
		str = str + '"' + facetList[i] + '"';
		if (i <= facetList.length - 2)
			str = str + " OR ";
	}
	str = str + ")";
	return str;
}

function removeDuplicates() {
	var x = x.suggest.myFileSuggester["in"].suggestions;
	if (x != undefined && x.length != 0) {
		for (var i = 0; i < x.length - 1; i++) {
			for (var j = i + 1; j < x.length; j++) {
				if(x[i].term.equals(x[j].term)){
					x.splice(j,1);
				}
			}
		}
	}
}
