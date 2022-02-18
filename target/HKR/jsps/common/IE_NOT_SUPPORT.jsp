<script type="text/javascript">
    var userAgent = navigator.userAgent; //取得浏览器的userAgent字符串
    var isIE = userAgent.indexOf("compatible") > -1 && userAgent.indexOf("MSIE") > -1; //判断是否IE<11浏览器
    var isEdge = userAgent.indexOf("Edge") > -1 && !isIE; //判断是否IE的Edge浏览器
    var isIE11 = userAgent.indexOf("Trident") > -1 || userAgent.indexOf("rv:11.0") > -1;
    if(isIE11){
        window.location = "<c:url value='/error/browser.jsp'/>";
    }
    if(isIE) {
        var reIE = new RegExp("MSIE (\\d+\\.\\d+);");
        reIE.test(userAgent);
        var fIEVersion = parseFloat(RegExp["$1"]);
        if(fIEVersion == 7 || fIEVersion == 8 || fIEVersion == 9 || fIEVersion == 10 || fIEVersion < 7) {
            window.location = "<%=request.getContextPath()%>/error/browser.jsp";
        }
    }
</script>