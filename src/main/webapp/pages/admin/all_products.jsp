<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<fmt:setLocale value="${sessionScope.currentLocale}" scope="session"/>
<fmt:setBundle basename="${sessionScope.currentBundle}"/>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="/styles/error.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    <title><fmt:message key="title.all_products"/></title>
</head>

<form action="${pageContext.request.contextPath}/controller?command=change_language&lang=${sessionScope.currentLocale}"
      method="post">
    <input type="hidden" name="current_url" value="${pageContext.request.requestURL}"/>
    <input type="submit" value="${sessionScope.secondLocale}" class="lang"/>
</form>





<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel" ><fmt:message key="header.add_product"/></h5>


                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form action="${pageContext.request.contextPath}/controller?command=addition_product" method="post">
                    <c:if test="${requestScope.productNameError!=null}">
                        <div class="error"><fmt:message key="error.product_name"/></div>
                    </c:if>
                    <c:if test="${requestScope.productDoseError!=null}">
                        <div class="error"><fmt:message key="error.product_waight"/></div>
                    </c:if>
                    <c:if test="${requestScope.productGroupError!=null}">
                        <div class="error"><fmt:message key="error.product_group"/></div>
                    </c:if>
                    <c:if test="${requestScope.productPriceError!=null}">
                        <div class="error"><fmt:message key="error.product_price"/></div>
                    </c:if>
                    <c:if test="${requestScope.productInstructionError!=null}">
                        <div class="error"><fmt:message key="error.product_instruction"/></div>
                    </c:if>
                    <div class="form-group">
                        <label class="field" for="name"><fmt:message key="label.name"/></label><br>
                        <input type="text" name="name" class="form-control" id="name" required value="${requestScope.mapData.get("name")}"
                               placeholder="<fmt:message key="placeholder.product_name"/>"/><br>
                    </div>
                    <div class="form-group">
                        <label class="field" for="waight"><fmt:message key="label.waight"/></label><br>
                        <input type="text" name="dose" class="form-control" id="waight" required value="${requestScope.mapData.get("dose")}"
                               placeholder="<fmt:message key="placeholder.product_waight"/>"/><br>
                    </div>
                    <div class="form-group">
                        <label class="field" for="group"><fmt:message key="label.group"/></label><br>
                        <input type="text" name="group" class="form-control" id="group" required value="${requestScope.mapData.get("group")}"
                               placeholder="<fmt:message key="placeholder.product_group"/>"/><br>
                    </div>

                    <div class="form-group">
                        <label class="field" for="price"><fmt:message key="label.price"/></label><br>
                        <input type="text" name="price" class="form-control" id="price" required value="${requestScope.mapData.get("price")}"
                               placeholder="<fmt:message key="placeholder.product_price"/>"/><br>
                    </div>
                    <div class="form-group">
                        <label class="field" for="TextareaForInstruction"><fmt:message key="label.instruction"/></label><br>
                        <textarea name="instruction" class="form-control" id="TextareaForInstruction" rows="3" required></textarea><br><br>
                    </div>
                    <input type="submit" class="btn btn-primary"value="<fmt:message key="button.input_product"/>" class="button_product_update">
                </form>


            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>


<h1><center><fmt:message key="header.list_all_products"/></center></h1>
<h2><fmt:message key="header.add_new_product_in_form"/></h2>


<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal">
    <fmt:message key="modal.buttun_add_product"/>
</button>
<%--<form action="${pageContext.request.contextPath}/controller?command=addition_product" method="post">--%>
<%--    <c:if test="${requestScope.productNameError!=null}">--%>
<%--        <div class="error"><fmt:message key="error.product_name"/></div>--%>
<%--    </c:if>--%>
<%--    <c:if test="${requestScope.productDoseError!=null}">--%>
<%--        <div class="error"><fmt:message key="error.product_waight"/></div>--%>
<%--    </c:if>--%>
<%--    <c:if test="${requestScope.productGroupError!=null}">--%>
<%--        <div class="error"><fmt:message key="error.product_group"/></div>--%>
<%--    </c:if>--%>
<%--    <c:if test="${requestScope.productPriceError!=null}">--%>
<%--        <div class="error"><fmt:message key="error.product_price"/></div>--%>
<%--    </c:if>--%>
<%--    <c:if test="${requestScope.productInstructionError!=null}">--%>
<%--        <div class="error"><fmt:message key="error.product_instruction"/></div>--%>
<%--    </c:if>--%>
<%--    <label class="field"><fmt:message key="label.name"/></label><br>--%>
<%--    <input type="text" name="name" value="${requestScope.mapData.get("name")}"--%>
<%--           placeholder="<fmt:message key="placeholder.product_name"/>"/><br>--%>
<%--    <label class="field"><fmt:message key="label.waight"/></label><br>--%>
<%--    <input type="text" name="dose" value="${requestScope.mapData.get("dose")}"--%>
<%--           placeholder="<fmt:message key="placeholder.product_waight"/>"/><br>--%>
<%--    <label class="field"><fmt:message key="label.group"/></><br>--%>
<%--    <input type="text" name="group" value="${requestScope.mapData.get("group")}"--%>
<%--           placeholder="<fmt:message key="placeholder.product_group"/>"/><br>--%>
<%--    <label class="field"><fmt:message key="label.price"/></label><br>--%>
<%--    <input type="text" name="price" value="${requestScope.mapData.get("price")}"--%>
<%--           placeholder="<fmt:message key="placeholder.product_price"/>"/><br>--%>
<%--    <label class="field"><fmt:message key="label.instruction"/></label><br>--%>
<%--    <textarea name="instruction" class="input_instruction"></textarea><br><br>--%>
<%--    <input type="submit" value="<fmt:message key="button.input_product"/>" class="button_product_update">--%>
<%--</form>--%>
<br>
<label><fmt:message key="msg.click_on_parameter"/></label><br>
<label><fmt:message key="msg.click_on_id_if_need_change_picture"/></label><br>

<c:if test="${sessionScope.previousProducts.size() > 0}">
    <a href="${pageContext.request.contextPath}/controller?command=all_products&count_back=true&current_page=${sessionScope.currentPage}"
       style="color: #800000"><fmt:message key="link.previous_products"/> </a>
</c:if>
<c:if test="${sessionScope.nextProducts.size() > 0}">
    <a href="${pageContext.request.contextPath}/controller?command=all_products&count_forward=true&current_page=${sessionScope.currentPage}"
       style="color: #800000"><fmt:message key="link.next_products"/></a>
</c:if><br>

<h1><fmt:message key="header.all_products"/></h1>
<c:choose>
    <c:when test="${sessionScope.currentProducts.size()>0}">

        <table class="table">
            <thead class="thead-inverse">
                <th><fmt:message key="column.table.id"/></th>
                <th><fmt:message key="column.table_name"/></th>
                <th><fmt:message key="column.table_waight"/></th>
                <th><fmt:message key="column.table_group"/></th>
                <th><fmt:message key="column.table_price"/></th>
                <th><fmt:message key="column.table_instruction"/></th>
            </thead>

            <c:forEach items="${sessionScope.currentProducts}" var="product">
            <tbody>
                <tr>
                    <th scope="row">
                        <a href="${pageContext.request.contextPath}/controller?command=addition_picture_page&product_id=${product.productId}">${product.productId}</a>
                    </th>
                    <td>
                        <a href="${pageContext.request.contextPath}/controller?command=updating_product_name_page&product_id=${product.productId}">${product.name}</a>
                    </td>
                    <td>
                        <a href="${pageContext.request.contextPath}/controller?command=updating_product_dose_page&product_id=${product.productId}">${product.dose}</a>
                    </td>
                    <td>
                        <a href="${pageContext.request.contextPath}/controller?command=updating_product_group_page&product_id=${product.productId}">${product.group}</a>
                    </td>
                    <td>
                        <a href="${pageContext.request.contextPath}/controller?command=updating_product_price_page&product_id=${product.productId}">${product.price}</a>

                    </td>
                    <td>
                        <a href="${pageContext.request.contextPath}/controller?command=updating_product_instruction_page&product_id=${product.productId}">${product.instruction}</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:when>
</c:choose>

<c:if test="${sessionScope.previousProducts.size() > 0}">
    <a href="${pageContext.request.contextPath}/controller?command=all_products&count_back=true&current_page=${sessionScope.currentPage}"
       style="color: #800000"><fmt:message key="link.previous_products"/> </a>
</c:if>
<c:if test="${sessionScope.nextProducts.size() > 0}">
    <a href="${pageContext.request.contextPath}/controller?command=all_products&count_forward=true&current_page=${sessionScope.currentPage}"
       style="color: #800000"><fmt:message key="link.next_products"/></a>
</c:if><br>

<a href="${pageContext.request.contextPath}/controller?command=main_admin" class="common_link"><fmt:message
        key="link.admin_main"/></a><br>
<a href="${pageContext.request.contextPath}/controller?command=logout" class="common_link"><fmt:message
        key="link.logout"/></a>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>