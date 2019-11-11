<#import "parts/common.ftl" as c>
<#import "parts/navin.ftl" as nin>
<@c.top></@c.top>
<@nin.navin></@nin.navin>
<table class="table table-hover table-dark">
    <thead>
    <tr>
        <th scope="col">№</th>
        <th scope="col">Сериный номер</th>
        <th scope="col">Модель</th>
        <th scope="col">Бренд</th>
        <th scope="col">Тип</th>
        <th scope="col">Удалить</th>
        <th scope="col">Редактировать</th>
    </tr>
    </thead>
    <tbody>
    <#list devices as device>
        <tr>
            <th scope="row">${device.id}</th>
            <td>${device.serial}</td>
            <td>${device.model.model}</td>
            <td>${device.brand.brand}</td>
            <td>${device.typeDevice.type}</td>
            <td><form method="post" action="/deleteDevice/${device.id}" enctype="multipart/form-data">
                    <button type="submit" class="btn btn-secondary">Удалить</button></form></td>

            <td><a class="btn btn-secondary mb-3"  data-toggle="collapse" href="#collapseExample${device.id}" role="button" aria-expanded="false" aria-controls="collapseExample${device.id}">
                    Редактировать
                </a>
                <div class="collapse" id="collapseExample${device.id}">
                    <div class="form-group mt-3">
                        <form method="post" action="/updateDevice/${device.id}" enctype="multipart/form-data">
                            <div class="form-group">
                                <div class="form-group">
                                    <input type="text" class="form-control mr-sm-4 col-md-4" name="deviceSerial" value="${device.serial}">
                                </div>

                                <div class="form-group">
                                <select class="form-control mr-sm-4 col-md-4" name="deviceModel"  >
                                    <#list models as m>
                                        <option value="${m.id}">${m.model}</option>
                                    </#list>
                                </select>
                                </div>

                                <div class="form-group">
                                    <select class="form-control mr-sm-4 col-md-4" name="deviceBrand"  >
                                        <#list brands as b>
                                            <option value="${b.id}">${b.brand}</option>
                                        </#list>
                                    </select>
                                </div>

                                <div class="form-group">
                                    <select class="form-control mr-sm-4 col-md-4" name="deviceType"  >
                                        <#list types as t>
                                            <option value="${t.id}">${t.type}</option>
                                        </#list>
                                    </select>
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
</html>