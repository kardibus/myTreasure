<#import "parts/common.ftl" as c>
<#import "parts/navdat.ftl" as nud>

<@c.top></@c.top>
<@nud.navdat></@nud.navdat>
<table class="table table-hover table-dark">
    <thead>
    <tr>
        <th scope="col">№</th>
        <th scope="col">Дата приемки</th>
        <th scope="col">Дата выдачи</th>
        <th scope="col">Гарантия</th>
        <th scope="col">Количество дней</th>
        <th scope="col">Удалить</th>
        <th scope="col">Редактировать</th>
    </tr>
    </thead>
    <tbody>
    <#list datedevices as datedev>
        <tr>
            <th scope="row">${datedev.id}</th>
            <td>${datedev.dateOpen}</td>
            <td>${datedev.dateClose}</td>
            <td>${datedev.warranty}</td>
            <td>${datedev.numberDay}</td>
            <td><form method="post" action="/deleteDatedev/${datedev.id}" enctype="multipart/form-data">
                    <button type="submit" class="btn btn-secondary">Удалить</button></form></td>

            <td><a class="btn btn-secondary mb-3"  data-toggle="collapse" href="#collapseExample${datedev.id}" role="button" aria-expanded="false" aria-controls="collapseExample${datedev.id}">
                    Редактировать
                </a>
                <div class="collapse" id="collapseExample${datedev.id}">
                    <div class="form-group mt-3">
                        <form method="post" action="/updateDateDev/${datedev.id}" enctype="multipart/form-data">
                            <div class="form-group">
                                <div class="form-group">
                                    <input type="text" class="form-control mr-sm-4 col-md-4" name="dateOpen" value="${datedev.dateOpen}">
                                </div>
                                <div class="form-group">
                                    <input type="text" class="form-control mr-sm-4 col-md-4" name="dateClose" value="${datedev.dateClose}">
                                </div>
                                <div class="form-group">
                                    <input type="text" class="form-control mr-sm-4 col-md-4" name="warranty" value="${datedev.warranty}">
                                </div>
                                <div class="form-group">
                                    <input type="text" class="form-control mr-sm-4 col-md-4" name="numberDay" value="${datedev.numberDay}">
                                </div>

                                <div class="form-group">
                                    <button type="submit" class="btn btn-secondary">Сохранить</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div></td>
        </tr>
        </tr>
    </#list>
    </tbody>
</table>
</body>
<script src="js/js.js"></script>
</html>