<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>员工表</title>
    <link rel="stylesheet" href="/bootstrap4/css/bootstrap.min.css">
    <script src="/js/jquery-3.4.1.min.js"></script>
    <script>
        $(function () {
            $(".deleteemp").click(function () {
                var id = $(this).data('id')
                location.href = '/delete?id=' + id;
            })
            $(".updateemp").click(function () {
                var id = $(this).data('id')
                console.log(id);
                location.href = '/updateServlet?id=' + id;
            })

        })
    </script>
</head>
<body>
<div class="container">
    <table class="table">
        <thead class="thead-dark">
        <tr>
            <th scope="col">姓名</th>
            <th scope="col">年龄</th>
            <th scope="col">性别</th>
            <th scope="col">工资</th>
            <th scope="col">部门</th>
            <th scope="col">操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${empList}" var="emp">
            <td>${emp.name}</td>
            <td>${emp.age}</td>
            <td>${emp.sex}</td>
            <td>${emp.salary}</td>
            <td>${emp.dept.deptName}</td>
            <td>
                <button type="button" class="btn btn-secondary  updateemp" data-toggle="modal" data-target="#update"
                        data-id="${emp.empId}">
                    点我修改
                </button>
                <button type="button" class="btn btn-secondary  deleteemp" data-id="${emp.empId}">点我删除</button>
            </td>

            </tr>
        </c:forEach>
        <tr>


        </tbody>
    </table>
</div>
<div class="btn-toolbar container" role="toolbar" aria-label="Toolbar with button groups">
    <div class="btn-group mr-2" role="group" aria-label="First group">
        <button type="button" class="btn btn-secondary " data-toggle="modal" data-target="#Add">点我添加</button>
        <button type="button" class="btn btn-secondary " data-toggle="modal" data-target="#find">点我查找</button>
    </div>
</div>


<%--添--%>
<div class="col-3">

    <div class="modal fade" id="Add" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="">添加员工</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <form action="add" method="get">
                    <div class="modal-body">
                        <div class="col-6 ">
                            <input type="text" class="form-control" aria-describedby="emailHelp" placeholder="员工姓名"
                                   name="name">
                            <input type="text" class="form-control" aria-describedby="emailHelp" placeholder="年龄"
                                   name="age">
                            <div style="display: flex">
                                <div class="custom-control custom-radio ">
                                    <input type="radio" id="customRadio1" name="sex" value="男" checked
                                           class="custom-control-input">
                                    <label class="custom-control-label" for="customRadio1">男</label>
                                </div>
                                <div class="custom-control custom-radio">
                                    <input type="radio" id="customRadio2" name="sex" value="女"
                                           class="custom-control-input">
                                    <label class="custom-control-label" for="customRadio2">女</label>
                                </div>
                            </div>
                            <input type="text" class="form-control" aria-describedby="emailHelp" placeholder="工资"
                                   name="salary">
                            <select class="custom-select" name="deptId">
                                <c:forEach items="${deptList}" var="dept">
                                    <option value="${dept.deptId}">${dept.deptName}</option>
                                </c:forEach>
                            </select>

                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">取消</button>
                        <button type="submit" class="btn btn-primary">添加</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<div class="col-3">
    <div class="modal fade" id="find" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
         aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="">按员工查找</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <form action="find">
                    <div class="modal-body">
                        <input type="text" class="form-control" aria-describedby="emailHelp" placeholder="员工姓名"
                               name="findname">
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">取消</button>
                        <button type="submit" class="btn btn-primary">查找</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<%--修改员工--%>
<div class="col-3">
    <div class="modal fade" id="update" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
         aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="">修改员工信息</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <form action="update">
                    <div class="modal-body">
                        <div class="col-6 ">
                            <input type="text" class="form-control" aria-describedby="emailHelp" value="${emp.name}"
                                   name="updatename">
                            <input type="number" class="form-control" aria-describedby="emailHelp" value="${emp.age}"
                                   name="updateage">
                            <div style="display: flex">
                                <div class="custom-control custom-radio ">

                                    <input type="radio" id="customRadio" name="updatesex" value="男"
                                           class="custom-control-input"
                                    <c:if test="${emp.sex =='男'}"> checked</c:if>
                                    >
                                    <label class="custom-control-label" for="customRadio">男</label>
                                </div>
                                <div class="custom-control custom-radio">
                                    <input type="radio" id="customRadio3" name="updatesex" value="女"
                                           class="custom-control-input"
                                    <c:if test="${emp.sex =='女'}"> checked</c:if>>
                                    <label class="custom-control-label" for="customRadio3">女</label>
                                </div>
                            </div>
                            <input type="text" class="form-control" aria-describedby="emailHelp" value="${emp.salary}"
                                   name="updatesalary">
                            <select class="custom-select" name="updatedeptId">
                                <c:forEach items="${deptList}" var="dept">
                                    <c:if test="${ dept.deptId ==emp.deptId }">
                                        <option value="${dept.deptId}" selected>${dept.deptName}</option>
                                    </c:if>
                                    <c:if test="${dept.deptId !=emp.deptId}">
                                        <option value="${dept.deptId}">${dept.deptName}</option>
                                    </c:if>
                                </c:forEach>

                            </select>

                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">取消</button>
                        <input type="hidden" name="id" value="${emp.empId}">
                        <button type="submit" class="btn btn-primary">修改</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<%--删除--%>
<%--<div class="col-3">--%>

    <%--<div class="modal fade" id="delete" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"--%>
         <%--aria-hidden="true">--%>
        <%--<div class="modal-dialog" role="document">--%>
            <%--<div class="modal-content">--%>
                <%--<div class="modal-header">--%>
                    <%--<h5 class="modal-title" id="exampleModalLabel">按员工姓名删除</h5>--%>
                    <%--<button type="button" class="close" data-dismiss="modal" aria-label="Close">--%>
                        <%--<span aria-hidden="true">&times;</span>--%>
                    <%--</button>--%>
                <%--</div>--%>
                <%--<form action="delete">--%>
                    <%--<div class="modal-body">--%>


                        <%--<input type="text" class="form-control" aria-describedby="emailHelp" placeholder="员工姓名"--%>
                               <%--name="deletename">--%>


                    <%--</div>--%>
                    <%--<div class="modal-footer">--%>
                        <%--<button type="button" class="btn btn-secondary" data-dismiss="modal">取消</button>--%>
                        <%--<button type="submit" class="btn btn-primary">删除</button>--%>
                    <%--</div>--%>
                <%--</form>--%>
            <%--</div>--%>
        <%--</div>--%>
    <%--</div>--%>
<%--</div>--%>
<%--查找--%>



<script src="/bootstrap4/js/bootstrap.min.js"></script>
</body>
</html>
