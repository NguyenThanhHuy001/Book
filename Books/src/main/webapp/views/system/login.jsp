<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<form action="${pageContext.request.contextPath}/system/login" method="post">
	<title>LOGIN</title>
	<h2>Login</h2>
	<c:if test="${alert != null}">
		<h3 class="alert alert-danger">${alert}</h3>
	</c:if>
	<section>
		<label class="input login-input">
			<div class="input-group">
				<span class="input-group-addon"><i class="fa fa-user"></i></span> <input
					type="text" placeholder="Username" name="Username">
			</div>
		</label> <label class="input login-input">
			<div class="input-group">
				<span class="input-group-addon"><i class="fa fa-key"></i></span> <input
					type="password" placeholder="Password" name="Password">
			</div>
		</label> <label class="input login-input">
			<div class="input-group">
				<span class="input-group-addon"><i class="fa fa-sign-in"></i></span>
				<input type="submit" value="Sign In">
			</div>
			<p>
				<a href="<c:url value="${pageContext.request.contextPath}/system/login" />">Đăng ký ngay</a>
			</p>
		</label>
	</section>
</form>