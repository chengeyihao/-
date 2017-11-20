<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>

<link href="${pageContext.request.contextPath}/css/sys.css" type="text/css" rel="stylesheet" />
	<script>
		function onPostSelected(value) {
			var data = new FormData();
			data.append("post.department.depId", value);

			var xhr = new XMLHttpRequest();
			xhr.withCredentials = true;

			xhr.addEventListener("readystatechange", function () {
				if (this.readyState === 4) {
					console.log(this.responseText);

					// 对请求回来的数据进行解析
					json = eval("(" + this.responseText + ")");
					// 获取服务器的标签
					serverSelect = document.getElementById("posts");
					// 获取option标签
					optionEle = serverSelect.getElementsByTagName("option");
					// 获取option数量
					length = optionEle.length;
					// 使用循环清空所有option标签
					for (var i = 0; i < length; i++){
						serverSelect.removeChild(optionEle[0]);
					}
					serverSelect.innerHTML = "<option value='-1'>--请选择职务--</option>";
					// 将json数据插入到option中
					for (var j = 0; j < json.length; j++) {
						// 创建一个option标签
						option = document.createElement("option");
						// 设置value属性
						option.setAttribute("value", json[j].postId);
						// 设置文本信息
						text = document.createTextNode(json[j].postName);
						//  把文本信息添加到option中
						option.appendChild(text);
						// 把option标签添加到servers的select中
						serverSelect.appendChild(option);
					}
				}
			});

			xhr.open("POST", "/staff/findPostByDepId");
			xhr.send(data);
		}

		function createTD(text) {
			var td = document.createElement("td");
			td.setAttribute("align", "center")
			var textNode = document.createTextNode(text);
			td.appendChild(textNode);
			return td;
		}

		function createA(text1) {
			var td = document.createElement("td");
			td.setAttribute("align", "center");
			var a = document.createElement("a");
			a.setAttribute("href", "${pageContext.request.contextPath}findByStaffId.action?staffId="+text1);
			var textNode = document.createElement("img");
			textNode.setAttribute("src", "${pageContext.request.contextPath}/images/button/modify.gif")
			textNode.setAttribute("class", "img")
			a.appendChild(textNode);
			td.appendChild(a);
			return td;
		}

		function onStaffSelected() {
			var data = new FormData();
			data.append("post.department.depId", document.getElementById("department").value);
			data.append("post.postId", document.getElementById("posts").value);
			data.append("staffName", document.getElementById("staffName").value);

			var xhr = new XMLHttpRequest();
			xhr.withCredentials = true;

			xhr.addEventListener("readystatechange", function () {
				if (this.readyState === 4) {
					console.log(this.responseText);
					json = eval("(" + this.responseText + ")");

					serverSelect = document.getElementById("tb");
					optionEle = serverSelect.getElementsByTagName("tr");
					length = optionEle.length;
					for (var i = 0; i < length; i++){
						serverSelect.removeChild(optionEle[0]);
					}
					for (var j = 0; j < json.length; j++){
						var tr = document.createElement("tr");

						tr.appendChild(createTD(json[j].staffName));
						tr.appendChild(createTD(json[j].gender));
						tr.appendChild(createTD(json[j].onDutyDate));
						tr.appendChild(createTD(json[j].post.department.depName));
						tr.appendChild(createTD(json[j].post.postName));
						tr.appendChild(createA(json[j].staffId));
						serverSelect.appendChild(tr);

					}

				}
			});

			xhr.open("POST", "/staff/findSome");
			xhr.send(data);
		}
	</script>
</head>

<body >
 <table border="0" cellspacing="0" cellpadding="0" width="100%">
  <tr>
    <td class="topg"></td>
  </tr>
</table>

<table border="0" cellspacing="0" cellpadding="0"  class="wukuang"width="100%">
  <tr>
    <td width="1%"><img src="${pageContext.request.contextPath}/images/tleft.gif"/></td>
    <td width="39%" align="left">[员工管理]</td>
   
    <td width="57%"align="right">
    	<%--高级查询 --%>
		<a href="javascript:void(0)" onclick="onStaffSelected()"><img src="${pageContext.request.contextPath}/images/button/gaojichaxun.gif" /></a>
    	<%--员工注入 --%>
	  	<a href="/staff/addFindDept.action">
	  		<img src="${pageContext.request.contextPath}/images/button/tianjia.gif" />
	  	</a>
      
    </td>
    <td width="3%" align="right"><img src="${pageContext.request.contextPath}/images/tright.gif"/></td>
  </tr>
</table>

<!-- 查询条件：马上查询 -->
<form id="conditionFormId" action="${pageContext.request.contextPath}/staff/staffAction_findAll" method="post">
	<table width="88%" border="0" style="margin: 20px;" >
	  <tr>
	    <td width="80px">部门：</td>
	    <td width="200px">

	    	<%--<select name="crmPost.crmDepartment.depId" onchange="changePost(this)">--%>
			    <%--<option value="">--请选择部门--</option>--%>
			    <%--<option value="ee050687bd1a4455a153d7bbb7000001">教学部</option>--%>
			    <%--<option value="ee050687bd1a4455a153d7bbb7000002">咨询部</option>--%>
			<%--</select>--%>
			<select name="post.department.depId" onchange="onPostSelected(value)" id="department">
				<option value="-1">--请选择部门--</option>
				<s:iterator value="#StaffDept" var="dep">
					<option value="${dep.depId}">${dep.depName}</option>
				</s:iterator>
			</select>

	    </td>
	    <td width="80px" >职务：</td>
	    <td width="200px" >
	    	
	    	<select name="post.postId" id="posts">
			    <option value="-1">--请选择职务--</option>
			</select>

	    </td>
	    <td width="80px">姓名：</td>
	    <td width="200px" ><input type="text" name="staffName" size="12" id="staffName" value=""/></td>
	    <td ></td>
	  </tr>
	</table>
</form>


<table border="0" cellspacing="0" cellpadding="0" style="margin-top:5px;">
  <tr>
    <td ><img src="${pageContext.request.contextPath}/images/result.gif"/></td>
  </tr>
</table>

<table width="100%" border="1" >
	<thead>
  		<tr class="henglan" style="font-weight:bold;">
  		  <td width="10%" align="center">员工姓名</td>
  		  <td width="6%" align="center">性别</td>
  		  <td width="12%" align="center">入职时间</td>
  		  <td width="15%" align="center">所属部门</td>
  		  <td width="10%" align="center">职务</td>
  		  <td width="10%" align="center">编辑</td>
  		</tr>
	</thead>

	<tbody id="tb">
	<s:iterator var="staff" value="#pageBean.data">
		<tr class="<s:property value="#sl.even ? 'tabtd2':'table1'"/>">
			<td align="center">${staff.staffName}</td>
			<td align="center">${staff.gender}</td>
			<td align="center">${staff.onDutyDate}</td>
			<td align="center">${staff.post.department.depName}</td>
			<td align="center">${staff.post.postName}</td>
			<td width="7%" align="center">
				<a href="/staff/findByStaffId.action?staffId=${staff.staffId}
				&post.department.depId=${staff.post.department.depId}
				&post.postId=${staff.post.postId}&post.postName=${staff.post.postName}"><img
						src="${pageContext.request.contextPath}/images/button/modify.gif" class="img"/></a>
			</td>
		</tr>
	</s:iterator>
	</tbody>
</table>


 <table border="0" cellspacing="0" cellpadding="0" align="center">
	 <tr>
		 <td align="right">
			 <span>第<s:property value="#pageBean.pageNum"/>/<s:property value="#pageBean.totalPage"/>页</span>
			 <span>
        	<a href="/staff/findAll">[首页]</a>&nbsp;&nbsp;
            <a href="/staff/findAll?pageNum=${pageBean.pageNum-1}">[上一页]</a>&nbsp;&nbsp;
                <s:iterator begin="#pageBean.start" end="#pageBean.end" var="num">
					<s:if test="#num <= #pageBean.totalPage">
                            <a href="/staff/findAll?pageNum=${num}">
                            <s:property value="#num"/> </a>&nbsp;&nbsp;
					</s:if>
				</s:iterator>
            <a
					<c:choose>

						<c:when test="${pageBean.pageNum >= pageBean.totalPage}">href="#"</c:when>

						<c:otherwise>href="/staff/findAll?pageNum=${pageBean.pageNum + 1}"</c:otherwise>

					</c:choose>
			>[下一页]</a>&nbsp;&nbsp;
            <a href="/staff/findAll?pageNum=${pageBean.totalPage}">[尾页]</a>
        </span>
		 </td>
	 </tr>
 </table>
</body>
</html>
