function InitPage(pageName) {
	$("#tt").tabs("add", {
		title : pageName,
		closable : false,
		href : "common/aboutus.html"
	});
}

/*
 * 初始化树
 */
function startTree() {
	$("#aa").tree({
		url : "MenuServlet?method=findAllTeacherMenu",
		enableDnd:true,
		formatter : function(node) {
			return "<a onclick='opentab(\"" + node.text + "\",\""  + node.url + "\")'>" + node.text + "</a>";
		}
	});

}

// 防止点击重复tab
function existsTab() {
	$("#aa").tree({
		onClick : function(node) {
			if (node.attributes) {
				open(node.text, node.url);
			}
		}
	});
}

/*
 * 单独打开tab节点
 */
function opentab(text,url){
	
	//如果当前打开的url为空，则是父节点，不用打开
	if(url == typeof(undefined)){
		return;
	}
	if ($("#tt").tabs("exists",text)) {
		$("#tt").tabs("select",text);
	}else{
		$("#tt").tabs("add",{
			title:text,
			href:url,
			closable:true,
		});
	}
}



/*
 * 打开tree节点
 * 
 */
function open(text, url) {
	if ($("#aa").tree("isLeaf", node.target)) {
		if ($("#tt").tabs("exists", node.text)) {
			$("#tt").tabs("select", node.text);
		} else {
			$("#tt").tabs("add", {
				title : node.text,
				closable : true
			});
		}
	}
}




$(document).ready(function() {
	
	$("#loading-mask").fadeOut();

	// 初始化首页面

	InitPage(pageName);

	// 初始化tree
	startTree();

	// 防止重复打开tab
	existsTab();

	// //tooltip的滑动显示
	// showTooltip();
	
});
