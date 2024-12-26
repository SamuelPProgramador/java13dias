<%@ include file="comunes/cabecero.jsp"%>
<%@ include file="comunes/navegacion.jsp"%>


<div class="container">
    <div class="text-center" style="margin: 30px">
        <h3>Sistema de Empleados</h3>
    </div>
    <div class="container">
        <table class="table table-striped table-hover table-bordered align-middle">
            <thead class="table-dark text-center">
            <tr>
                <th scope="col">Id</th>
                <th scope="col">Nombre</th>
                <th scope="col">Departamento</th>
                <th scope="col">Sueldo</th>
                <th scope="col"></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="empleado" items="${empleados}">
                <tr>
                    <th scope="row">${empleado.idEmpleado}</th>
                    <td>${empleado.nombreEmpleado}</td>
                    <td>${empleado.departamento}</td>
                    <td>
                        <fmt:setLocale value="es_DO" />
                        <fmt:formatNumber type="currency" value="${empleado.sueldo}" />
                    </td>

                    <td class="text-center">
                        <c:set var="urlEditar">
                            <c:url value="${application.contextPath}/editar">
                                <c:param name="idEmpleado"
                                         value="${empleado.idEmpleado}"/>
                            </c:url>
                        </c:set>

                        <a href="${urlEditar}"
                           class="btn btn-warning btn-sm me-3 bi bi-person-fill-up">
                           Editar
                        </a>

                        <c:set var="urlEliminar">
                            <c:url value="${application.contexPath}/eliminar">
                                <c:param name="idEmpleado"
                                         value="${empleado.idEmpleado}"/>
                            </c:url>
                        </c:set>
                        <a href="${urlEliminar}"
                           class="btn btn-danger btn-sm me-3 bi bi-person-dash" >
                           Eliminar
                        </a>
                    </td>
                </tr>
            </c:forEach>

            </tbody>
        </table>
    </div>
</div>

<%@ include file="comunes/pies-pagina.jsp"%>