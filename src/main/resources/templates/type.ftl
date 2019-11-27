<#import "parts/common.ftl" as c>
<#import "parts/navty.ftl" as nty>

<@c.top></@c.top>
<@nty.navty></@nty.navty>
<table class="table table-hover table-dark">
    <thead>
    <tr>
        <th scope="col">№</th>
        <th scope="col">Тип</th>
        <th scope="col">Удалить</th>
        <th scope="col">Редактировать</th>
    </tr>
    </thead>
    <tbody>
    <#list type as types>
        <tr>
            <th scope="row">${types.id}</th>
            <td>${types.type}</td>

            <td><form method="post" action="/deleteType/${types.id}" enctype="multipart/form-data">
                    <button type="submit" class="btn btn-secondary">Удалить</button></form></td>

            <td><a class="btn btn-secondary mb-3"  data-toggle="collapse" href="#collapseExample${types.id}" role="button" aria-expanded="false" aria-controls="collapseExample${types.id}">
                    Редактировать
                </a>
                <div class="collapse" id="collapseExample${types.id}">
                    <div class="form-group mt-3">
                        <form method="post" action="/updateType/${types.id}" enctype="multipart/form-data">
                            <div class="form-group">
                                <input type="text" class="form-control" name="type" value="${types.type}">
                            </div>
                            <div class="form-group">
                                <button type="submit" class="btn btn-secondary">Сохранить</button>
                            </div>
                        </form>
                    </div>
                </div></td>
        </tr>
    </#list>
    </tbody>
</table>
</body>
</html>