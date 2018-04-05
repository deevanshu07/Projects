/**
 * 
 */
app.filter('range', function() {
	  return function(input, total,numFound,rows) {
	    total = parseInt(total);
	    if(numFound%rows == 0 )
	    	numFound = Math.floor(numFound/rows);
	    
	    else
	    	numFound = Math.floor(numFound/rows) + 1;
	  
	    for (var i=total; i<total+10; i++) {
	      input.push(i);
	      if(i == numFound)
	    	  break;
	    }

	    return input;
	  };
	});
app.filter('extractTitle',function($sce){
	return function(input,docId,title){
		
		if(input==undefined || input == '')
			return $sce.trustAsHtml(title);
		var highlight = input[docId];
		if(highlight == undefined || highlight.title == undefined)
			return $sce.trustAsHtml(title);
		return $sce.trustAsHtml(highlight.title[0]);
	};
});
app.filter('extractContent',function($sce){
	return function(input,docId,content){
		if(input==undefined || input == '')
			return $sce.trustAsHtml(stringArrayToStr(content).substring(0, 250));
		var highlight = input[docId];
		if(highlight == undefined || highlight.content == undefined)
			return $sce.trustAsHtml(stringArrayToStr(content).substring(0, 250));
		return $sce.trustAsHtml(highlight.content[0]);
	};
	
});

app.filter('isFacetChecked',function(){
	return function(facet,facetArray){
		if(facetArray == undefined || facetArray.length == 0)
			return false;
		else{
			for(var i=0;i<facetArray.length;i++){
				if(facetArray[i] == facet)
					return true;
			}
		}
		return false;
	};
});

app.filter('totalDocument',function(){
	return function(kbTypeFacet){
		var total = 0;
		if(kbTypeFacet == undefined || kbTypeFacet.lenth == 0)
			return total;
		for(var i = 0;i<kbTypeFacet.length;i++)
			total = total + kbTypeFacet[i].val;
		return total;
	};
});

app.filter('isUrl',function($log){
	
	return function(docId){
		var pattern = new RegExp("(FAQ|TN|TA|NOTF)[0-9]+");
		//$log.info("docId ="+docId+typeof docId);
		if(docId == '' || docId ==undefined)
			return false;
		
		if(pattern.test(docId))
			return true;
		else
			return false;
	};
});
app.filter('highlightPartOfText',function($log,$sce){
	
	return function(input,highlightText){
		if(input == '' || input == undefined)
			return;
		reg = new RegExp(highlightText, 'gi');
		
		//$log.info(highlightText+" "+input);
		input = input.replace(reg,function(match) { return '<b>'+match+'</b>';});
		//$log.info("Filter applied convert Highlight Part"+input);
		return $sce.trustAsHtml(input);
		
	};
});

app.filter('limitChar', function ($log,$sce) {
	 
    return function (content, length, tail) {
        if (isNaN(length))
         {
            length = 200;
         }
        if (tail === undefined)
            tail = "...";
 
        if (content.length <= length || content.length - tail.length <= length) {
            return content;
        }
        else {
            return $sce.trustAsHtml(String(content).substring(0, length-tail.length) + tail);
        }
    };
});