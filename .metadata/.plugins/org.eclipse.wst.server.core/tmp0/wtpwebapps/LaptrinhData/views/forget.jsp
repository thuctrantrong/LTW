<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<form action="/LaptrinhData/forget" method="post">
		<h2>Quên mật khẩu</h2>
		<c:if test="${alert !=null}">
			<h3 class="alert alertdanger">${alert}</h3>
		</c:if>
		<section>
			<label class="input login-input">
				<div class="input-group">
					<span class="input-group-addon"><i class="fafa-user"></i></span>
				</div>
			</label>
		</section>
		<section>
			<input type="text" placeholder="Tài khoản" name="username"
				class="form-control"> 
			<input type="text" placeholder="Mật khẩu mới" name="password" class="form-control">
			<input type="text"	placeholder="Nhập lại mật khẩu" name="npassword" class="form-control">
		</section>

		<section>
			<button type="submit">Confirm</button>			
		</section>
	</form>
</body>
</html>