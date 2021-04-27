
var time;
function time() {
	time = new Date().format("yyyy-MM-dd HH:mm:ss.SS");
	$("#time").text(time);
}
setInterval("time()", 100);
