<#import "parts/common.ftl" as c>
<#import "parts/navmo.ftl" as nmo>
<@c.top></@c.top>
<@nmo.navmo></@nmo.navmo>
<table class="table table-hover table-dark">
    <thead>
    <tr>
        <th scope="col">№</th>
        <th scope="col">Модель</th>
        <th scope="col">Удалить</th>
        <th scope="col">Редактировать</th>
    </tr>
    </thead>
    <tbody>
    <#list models as model>
    <tr>
        <th scope="row">${model.id}</th>
        <td>${model.model}</td>

        <td><form method="post" action="/deleteModel/${model.id}" enctype="multipart/form-data">
                <button type="submit" class="btn btn-secondary">Удалить</button></form></td>

        <td><a class="btn btn-secondary mb-3"  data-toggle="collapse" href="#collapseExample${model.id}" role="button" aria-expanded="false" aria-controls="collapseExample${model.id}">
                Редактировать
            </a>
            <div class="collapse" id="collapseExample${model.id}">
                <div class="form-group mt-3">
                    <form method="post" action="/updateModel/${model.id}" enctype="multipart/form-data">
                        <div class="form-group">
                            <input type="text" class="form-control" name="model" value="${model.model}">
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