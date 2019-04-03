<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

        <table align='center' border='1' cellspacing='0'>
            <tr>
                <td>countryCode</td>
                <td>language</td>
                <td>percentage</td>
            </tr>
            <c:forEach items="${cl}" var="s" varStatus="st">
                <tr>
                    <td>${s.countryCode}</td>
                    <td>${s.language}</td>
                    <td>${s.percentage}</td>
                </tr>
            </c:forEach>
        </table>