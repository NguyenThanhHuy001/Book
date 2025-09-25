<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Đăng ký tài khoản</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
        }
        .register-container {
            width: 400px;
            margin: 50px auto;
            background: #fff;
            padding: 30px 40px;
            border-radius: 10px;
            box-shadow: 0 0 15px rgba(0,0,0,0.2);
        }
        .register-container h2 {
            text-align: center;
            margin-bottom: 25px;
            color: #333;
        }
        .register-container label {
            font-weight: bold;
            margin-top: 10px;
            display: block;
        }
        .register-container input, 
        .register-container select {
            width: 100%;
            padding: 10px;
            margin-top: 5px;
            border-radius: 5px;
            border: 1px solid #ccc;
            box-sizing: border-box;
        }
        .register-container button {
            width: 100%;
            padding: 12px;
            margin-top: 20px;
            border: none;
            border-radius: 5px;
            background-color: #4CAF50;
            color: white;
            font-size: 16px;
            cursor: pointer;
        }
        .register-container button:hover {
            background-color: #45a049;
        }
        .alert {
            color: red;
            text-align: center;
            margin-bottom: 15px;
        }
    </style>
</head>
<body>
    <div class="register-container">
        <h2>Đăng ký tài khoản</h2>
        <c:if test="${alert != null}">
            <div class="alert">${alert}</div>
        </c:if>

        <form action="register" method="post">
            <label for="email">Email</label>
            <input type="text" name="email" placeholder="Email" id="email">

            <label for="username">Username</label>
            <input type="text" name="username" placeholder="Username" id="username">

            <label for="fullname">Fullname</label>
            <input type="text" name="fullname" placeholder="Fullname" id="fullname">

            <label for="password">Password</label>
            <input type="password" name="password" placeholder="Password" id="password">

            <label for="confirmPassword">Confirm Password</label>
            <input type="password" name="confirmPassword" placeholder="Confirm Password" id="confirmPassword">

            <label for="phone">Phone</label>
            <input type="text" name="phone" placeholder="Phone" id="phone">

            <label for="roleId">Role</label>
            <select name="roleId" id="roleid">
                <option value="2">Khách hàng</option>
                <option value ="1">Nhân Viên</option>
            </select>
            <button type="submit">Đăng ký</button>
        </form>
    </div>
</body>
</html>
