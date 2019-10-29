<#import "parts/common.ftl" as c>
<#import "parts/navbr.ftl" as nbr>

<@c.top></@c.top>
<@nbr.navbr></@nbr.navbr>
<table class="table table-hover table-dark">
    <thead>
    <tr>
        <th scope="col">№</th>
        <th scope="col">Бренд</th>
        <th scope="col">Удалить</th>
        <th scope="col">Редактировать</th>
    </tr>
    </thead>
    <tbody>
    <#list brands as brand>
    <tr>
        <th scope="row">${brand.id}</th>
        <td>${brand.brand}</td>

        <td><form method="post" action="/delete/${brand.id}" enctype="multipart/form-data">
                <button type="submit" class="btn btn-secondary">Удалить</button></form></td>

        <td><a class="btn btn-secondary mb-3"  data-toggle="collapse" href="#collapseExample${brand.id}" role="button" aria-expanded="false" aria-controls="collapseExample${brand.id}">
                Редактировать
            </a>
            <div class="collapse" id="collapseExample${brand.id}">
                <div class="form-group mt-3">
                    <form method="post" action="/update/${brand.id}" enctype="multipart/form-data">
                        <div class="form-group">
                            <input type="text" class="form-control" name="brand" value="${brand.brand}">
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