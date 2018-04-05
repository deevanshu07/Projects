/**
 * 
 */
app.controller('ArticleViewController',function($scope,solrstorage,$log,$http,$routeParams){
	$log.info('Article view controller is working');
	$log.info($routeParams.ID);
});
